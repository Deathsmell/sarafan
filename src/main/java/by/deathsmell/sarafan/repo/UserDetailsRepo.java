package by.deathsmell.sarafan.repo;

import by.deathsmell.sarafan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User,String> {

}
