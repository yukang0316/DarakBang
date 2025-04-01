package hello.imagine.login.model;

import hello.imagine.meeting.model.Meeting;
import jakarta.persistence.*;

@Entity
public class Affiliation {

    @EmbeddedId
    private AffiliationId id;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @MapsId("meetingId")
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    public Affiliation() {}

    public Affiliation(Member member, Meeting meeting) {
        this.member = member;
        this.meeting = meeting;
    }

    // getter, setter
}
