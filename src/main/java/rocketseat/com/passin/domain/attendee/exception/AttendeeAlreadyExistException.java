package rocketseat.com.passin.domain.attendee.exception;

public class AttendeeAlreadyExistException extends RuntimeException {
    public AttendeeAlreadyExistException (String messagem){
        super(messagem);
    }
}
