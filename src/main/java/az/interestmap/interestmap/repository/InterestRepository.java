package az.interestmap.interestmap.repository;

import az.interestmap.interestmap.entity.Category;
import az.interestmap.interestmap.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepository extends JpaRepository<Interest, Long> {

    List<Interest> getInterestsByCategory(Category category);

    Interest getInterestByInterestId(Long id);

}
