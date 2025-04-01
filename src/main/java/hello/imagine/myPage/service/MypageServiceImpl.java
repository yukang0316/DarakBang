package hello.imagine.myPage.service;

import hello.imagine.community.model.Post;
import hello.imagine.community.repository.PostRepository;
import hello.imagine.login.model.Member;
import hello.imagine.login.repository.MemberRepository;
import hello.imagine.meeting.model.Meeting;
import hello.imagine.meeting.repository.MeetingRepository;
import hello.imagine.myPage.entity.Mypage;
import hello.imagine.myPage.entity.Mypage_Communitylist;
import hello.imagine.myPage.entity.Mypage_Meetinglist;
import hello.imagine.myPage.repository.MyPageRepository;
import hello.imagine.myPage.repository.Mypage_CommunitylistRepository;
import hello.imagine.myPage.repository.Mypage_MeetinglistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MypageServiceImpl implements MypageService{
    private final MyPageRepository myPageRepository;
    private final MeetingRepository meetingRepository;
    private final PostRepository postRepository;
    private final Mypage_MeetinglistRepository mypage_meetinglistRepository;
    private final Mypage_CommunitylistRepository mypage_communitylistRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public MypageServiceImpl(MyPageRepository myPageRepository, MeetingRepository meetingRepository, PostRepository postRepository, Mypage_MeetinglistRepository mypage_meetinglistRepository, Mypage_CommunitylistRepository mypage_communitylistRepository, MemberRepository memberRepository) {
        this.myPageRepository = myPageRepository;
        this.meetingRepository = meetingRepository;
        this.postRepository = postRepository;
        this.mypage_meetinglistRepository = mypage_meetinglistRepository;
        this.mypage_communitylistRepository = mypage_communitylistRepository;
        this.memberRepository = memberRepository;
    }


    @Override
    public Mypage getMypageByMemberId(Long memberId) {
        return null;
    }

    @Override
    public Mypage findByNickname(String nickname) {
        return null;
    }

    @Override
    public Mypage findByPoints(int points) {
        return null;
    }

    @Override
    public Mypage findByEmail(String email) {
        return null;
    }

    // 소모임 내역 조회
    @Override
    public List<Mypage_Meetinglist> getMyMeetings(Long memberId) {
        Member member = new Member(); // Member 객체를 가져오는 로직 추가 필요
        member.setMemberId(memberId);
        return mypage_meetinglistRepository.findAllMeetingsByMember(member);
    }

    // 소모임 탈퇴
    @Override
    public void leaveMeeting(Long meetingId, Long memberId) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new RuntimeException("모임을 찾을 수 없습니다"));

        // 여기서 멤버가 모임에 속해 있는지 확인 후 탈퇴 처리
        if (meeting.getMembers().stream().noneMatch(m -> m.getId().equals(memberId))) {
            throw new RuntimeException("회원이 모임에 속해 있지 않습니다");
        }

        // 멤버를 모임에서 제거하고 현재 인원을 감소시킴
        meeting.getMembers().removeIf(m -> m.getId().equals(memberId));
        meeting.setMemberCount(meeting.getMembers().size()); // 업데이트된 멤버 수 설정
        meetingRepository.save(meeting); // 모임 정보 저장
    }

    // 소모임 개설자에 의한 모집 공고 수정
    @Override
    public Meeting updateMeeting(Long meetingId, Meeting updatedMeeting, Long memberId) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new RuntimeException("모임을 찾을 수 없습니다"));

        if (!meeting.getLeader().getId().equals(memberId)) {
            throw new RuntimeException("회원이 소모임 개설자가 아닙니다");
        }

        meeting.setTitle(updatedMeeting.getTitle());
        meeting.setContent(updatedMeeting.getContent());
        meeting.setMaxMembers(updatedMeeting.getMaxMembers());

        return meetingRepository.save(meeting);
    }

    // 소모임 개설자에 의한 소모임 삭제
    @Override
    public void deleteMeeting(Long meetingId, Long memberId) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new RuntimeException("모임을 찾을 수 없습니다"));

        if (!meeting.getLeader().getId().equals(memberId)) {
            throw new RuntimeException("회원이 소모임 개설자가 아닙니다");
        }

        meetingRepository.delete(meeting);
    }

    // 커뮤니티 내역 조회
    @Override
    public List<Post> getWrittenPosts(Member member) {
        return mypage_communitylistRepository.findByMember(member)
                .map(Mypage_Communitylist::getWrittenPosts)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    @Override
    public List<Post> getLikedPosts(Member member) {
        return mypage_communitylistRepository.findByMember(member)
                .map(Mypage_Communitylist::getLikedPosts)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    // 마이페이지 저장 또는 업데이트
    @Override
    public Mypage save(Mypage mypage) {
        return myPageRepository.save(mypage);
    }

    @Override
    public Mypage createOrUpdateMypageFromMember(Member member) {
        return null;
    }

    @Override
    public void updateNickname(Long memberId, String newNickname) {

    }

    @Override
    public void updateEmail(Long memberId, String newEmail) {

    }

    @Override
    public void updateEmergencyContact(Long memberId, String newContact) {

    }

    @Override
    public void updateLikeNotificationSettings(Long memberId, boolean likeNotification) {

    }

}