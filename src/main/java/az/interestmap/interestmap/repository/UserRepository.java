package az.interestmap.interestmap.repository;

import az.interestmap.interestmap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    long countByUsername(String username);

}
