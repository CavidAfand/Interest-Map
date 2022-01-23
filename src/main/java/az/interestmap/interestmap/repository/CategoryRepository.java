package az.interestmap.interestmap.repository;

import az.interestmap.interestmap.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
