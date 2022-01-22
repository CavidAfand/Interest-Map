package az.interestmap.interestmap.repository;

import az.interestmap.interestmap.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
