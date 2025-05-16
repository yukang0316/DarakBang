package hello.DarakBang.Counsel.repository;

import hello.DarakBang.Counsel.model.Counsel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselRepository extends JpaRepository<Counsel, Long> {
}
