package hello.imagine.myPage.entity;

import hello.imagine.login.model.Member;
import jakarta.persistence.*;

@Entity
public class Mypage {

    @Id
    @Column(name = "mypage_id")
    private Long mypageId; // 기본 키와 외래 키 둘 다 사용 가능

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @PrimaryKeyJoinColumn
    private Member member; // 기본 키와 외래 키 둘 다 사용 가능

    public Mypage() {
    }

    public Member getMemberId() {
        return member;
    }
    public void setMemberId(Member memberId) {
        this.member = memberId;
    }
}

