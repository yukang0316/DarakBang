package hello.DarakBang.Pedometer.repository;

import hello.DarakBang.Pedometer.model.Pedometer;
import hello.DarakBang.login.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedometerRepository extends JpaRepository<Pedometer, Long> {

    // 특정 회원의 만보기 기록 조회
    List<Pedometer> findByMember(Member member);
}