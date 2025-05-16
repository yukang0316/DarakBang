package hello.DarakBang.Counsel.service;

import hello.DarakBang.Counsel.model.Counsel;
import hello.DarakBang.Counsel.repository.CounselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounselService {
    @Autowired
    private CounselRepository counselRepository;

    public Counsel saveChat(String question, String answer) {
        Counsel chat = new Counsel();
        chat.setQuestion(question);
        chat.setAnswer(answer);
        return counselRepository.save(chat);
    }
}
