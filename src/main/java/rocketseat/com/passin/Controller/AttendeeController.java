package rocketseat.com.passin.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rocketseat.com.passin.dto.attendee.AttendeeBadgeDTO;
import rocketseat.com.passin.dto.attendee.AttendeeBadgeResponseDTO;
import rocketseat.com.passin.dto.attendee.AttendeeRequestDTO;
import rocketseat.com.passin.services.AttendeesService;
import rocketseat.com.passin.services.CheckInService;

@RestController
@RequestMapping("/attendees")
@RequiredArgsConstructor
public class AttendeeController {
    private final AttendeesService attendeesService;
    private final CheckInService checkInService;

    @GetMapping("/{attendeeId}/badge")
    public ResponseEntity<AttendeeBadgeResponseDTO> getAttendeeBadge(@PathVariable String attendeeId, UriComponentsBuilder uriComponentsBuilder){
        AttendeeBadgeResponseDTO attendeeBadgeResponseDTO = this.attendeesService.getAttendeeBadge(attendeeId, uriComponentsBuilder);
        return  ResponseEntity.ok(attendeeBadgeResponseDTO);
    }

    @PostMapping("/{attendeeId}/check-in")
    public ResponseEntity<Object> registerCheckIn(@PathVariable String attendeeId, UriComponentsBuilder uriComponentsBuilder){
        this.attendeesService.checkInAttendee(attendeeId);

        var uri = uriComponentsBuilder.path("/{attendeeId}/check-in").buildAndExpand(attendeeId).toUri();

        return ResponseEntity.created(uri).build();
    }
}
