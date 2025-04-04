package hello.DarakBang.community.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private Long postId;    // 댓글이 달릴 게시글의 ID
    private String content; // 댓글 내용

    public CommentDTO() {
    }

    public CommentDTO(Long postId, String content) {
        this.postId = postId;
        this.content = content;
    }
}