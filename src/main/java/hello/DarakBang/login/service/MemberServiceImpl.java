package hello.DarakBang.login.service;

import hello.DarakBang.login.exception.CustomDuplicateException;
import hello.DarakBang.login.model.Member;
import hello.DarakBang.login.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// MemberServiceImpl.java
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void register(Member member) throws CustomDuplicateException {
        if (memberRepository.findById(member.getId()).isPresent()) {
            throw new CustomDuplicateException("아이디가 이미 존재합니다.");
        }
        if (memberRepository.findByEmail(member.getEmail()).isPresent()) {
            throw new CustomDuplicateException("이메일이 이미 존재합니다.");
        }
        if (memberRepository.findByNickname(member.getNickname()).isPresent()) {
            throw new CustomDuplicateException("닉네임이 이미 존재합니다.");
        }
        memberRepository.save(member);
    }

    @Override
    public boolean login(String id, String pw) {
        System.out.println("Attempting to login with id=" + id + " and pw=" + pw);
        return memberRepository.findById(id)
                .map(member -> {
                    System.out.println("Found member: " + member.getId());
                    return member.getPw().equals(pw);
                })
                .orElse(false);
    }

    @Override
    public Member findById(String id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Member findByNickname(String nickname) {
        return memberRepository.findByNickname(nickname).orElse(null);
    }

    @Override
    public void logout() {
        // 로그아웃 로직 구현
    }

}