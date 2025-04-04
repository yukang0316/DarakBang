package hello.DarakBang.Pedometer.repository;

import hello.DarakBang.Pedometer.model.Pedometer;
import hello.DarakBang.community.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedometerRepository extends JpaRepository<Pedometer, Long> {
    List<Pedometer> findByPedometerId(Long pedometerId);
}
