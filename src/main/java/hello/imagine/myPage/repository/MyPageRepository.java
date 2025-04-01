package hello.imagine.myPage.repository;

import hello.imagine.myPage.entity.Mypage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyPageRepository extends JpaRepository<Mypage, Long> {
    Optional<Mypage> findByMemberMemberId(Long memberId);
}
