package rocketseat.com.passin.dto.attendee;

import lombok.Getter;
import rocketseat.com.passin.repositories.AttendeeRepository;

import java.util.List;

public record AttendeeListResponseDTO (List<AttendeeDetails> attendees) { }
