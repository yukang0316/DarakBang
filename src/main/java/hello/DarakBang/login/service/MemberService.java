package hello.DarakBang.login.service;

import hello.DarakBang.login.exception.CustomDuplicateException;
import hello.DarakBang.login.model.Member;

// MemberService.java
public interface MemberService {
    void register(Member member) throws CustomDuplicateException;

    boolean login(String id, String pw);

    Member findById(String id);

    Member findByEmail(String email);

    Member findByNickname(String nickname);

    void logout();

}