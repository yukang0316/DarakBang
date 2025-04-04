package hello.DarakBang.Pedometer.model;

import hello.DarakBang.login.model.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Pedometer {

    @Id
    @Column(name="pedometer_id")
    private Long pedometerId;

    private Long steps;

    private LocalDateTime recordDate;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public Pedometer(){
        this.recordDate = LocalDateTime.now();
    }
}
