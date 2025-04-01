package hello.imagine.login.model;

import hello.imagine.meeting.model.Meeting;
import hello.imagine.myPage.entity.Mypage;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(unique = true)
    private String id;
    private String pw;
    private String name;
    private String birthDate;
    private String email;
    private String nickname;
    @Column(name = "protector_phonenumber")
    private String protectorPhonenumber;

    @Setter
    @Getter
    @ManyToMany
    @JoinTable(
            name = "meeting_members",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "meeting_id")
    )
    private Set<Meeting> meetings = new HashSet<>();

    // Member.java
    @OneToMany(mappedBy = "member")
    private List<Affiliation> affiliations = new ArrayList<>();

    public Member(String name, String id, String birthDate, String pw, String email, String nickname, String protectorPhonenumber) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
        this.pw = pw;
        this.email = email;
        this.nickname = nickname;
        this.protectorPhonenumber = protectorPhonenumber;
    }

}