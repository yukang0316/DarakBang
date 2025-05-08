package hello.DarakBang.Pedometer.dto;

import hello.DarakBang.Pedometer.model.Pedometer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedometerDTO {

    private Long memberId;
    private Long steps;

    public PedometerDTO(){};

    public PedometerDTO(Long memberId, Long steps){
        this.memberId = memberId;
        this.steps = steps;
    }
}
