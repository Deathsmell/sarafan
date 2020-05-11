package by.deathsmell.sarafan.repo;

import by.deathsmell.sarafan.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Long> {

}
