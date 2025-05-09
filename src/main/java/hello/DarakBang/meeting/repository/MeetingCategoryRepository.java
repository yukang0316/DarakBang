package hello.DarakBang.meeting.repository;

import hello.DarakBang.meeting.model.MeetingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeetingCategoryRepository extends JpaRepository<MeetingCategory, Long> {
    Optional<MeetingCategory> findByName(String name);

    List<MeetingCategory> findByParentCategory(MeetingCategory parentCategory);

    List<MeetingCategory> findByParentCategoryIsNull();

    boolean existsByNameAndParentCategory(String name, MeetingCategory parentCategory);


}

