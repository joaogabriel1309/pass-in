package rocketseat.com.passin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocketseat.com.passin.domain.event.Event;

@RestController
@RequestMapping("/events")
public interface EventRepository extends JpaRepository<Event, String> {
}
