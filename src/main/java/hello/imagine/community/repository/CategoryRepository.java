package hello.imagine.community.repository;

import hello.imagine.community.model.CommunityCategory;
import hello.imagine.community.model.CommunityCategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CommunityCategory, Long> {
    Optional<CommunityCategory> findByName(String name);
}
