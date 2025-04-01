package hello.DarakBang.login.repository;

import hello.DarakBang.login.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(String id);

    Optional<Member> findByEmail(String email);

    Optional<Member> findByNickname(String nickname);

}