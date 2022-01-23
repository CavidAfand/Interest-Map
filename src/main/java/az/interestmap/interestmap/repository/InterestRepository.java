package az.interestmap.interestmap.repository;

import az.interestmap.interestmap.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Long> {
}
