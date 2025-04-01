package hello.DarakBang.meeting.repository;

import hello.DarakBang.meeting.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    boolean existsByNameAndParentCategoryId(String name, Long parentCategoryId);

    List<Subcategory> findByParentCategoryId(Long parentCategoryId);

}
