package hello.DarakBang.community.repository;

import hello.DarakBang.community.model.CommunityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CommunityCategory, Long> {
    Optional<CommunityCategory> findByName(String name);
}
