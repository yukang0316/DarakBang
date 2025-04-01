package hello.DarakBang.login.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AffiliationId implements Serializable {

    private Long memberId;
    private Long meetingId;

    public AffiliationId() {
    }

    public AffiliationId(Long memberId, Long meetingId) {
        this.memberId = memberId;
        this.meetingId = meetingId;
    }

    // getter, setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AffiliationId)) return false;
        AffiliationId that = (AffiliationId) o;
        return Objects.equals(memberId, that.memberId) &&
                Objects.equals(meetingId, that.meetingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, meetingId);
    }
}
