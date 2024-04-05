package rocketseat.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.domain.attendee.Attendee;
import rocketseat.com.passin.domain.checkin.Checkin;
import rocketseat.com.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import rocketseat.com.passin.repositories.CheckinRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {
    private final CheckinRepository checkinRepository;

    public void registerCheckIn(Attendee attendee){
        Checkin checkin = new Checkin();
        checkin.setAttendee(attendee);
        checkin.setCreatedAt(LocalDateTime.now());
        this.checkinRepository.save(checkin);
    }

    private void verifyCheckInExists(String attendeeId){
        Optional<Checkin> isCheckin = getCheckIn(attendeeId);
        if (isCheckin.isPresent()) throw new CheckInAlreadyExistsException("Attendee already checked in");
    }

    public Optional<Checkin> getCheckIn(String attendeeId){
        return this.checkinRepository.findByAttendeeId(attendeeId);
    }
}
