package hello.DarakBang.community.controller;

import hello.DarakBang.community.dto.CommentDTO;
import hello.DarakBang.community.model.Comment;
import hello.DarakBang.community.service.CommentService;
import hello.DarakBang.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO, @RequestHeader("Authorization") String token) {
        String userId = jwtUtil.extractUserId(token.substring(7)); // "Bearer " 제거 후, extractUserId 사용
        if (userId == null) {
            return ResponseEntity.status(401).build();
        }
        Comment comment = commentService.createComment(commentDTO);
        return ResponseEntity.ok(comment);
    }

    //게시글 아이디로 댓글 조회
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }

    //댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody CommentDTO commentDTO, @RequestHeader("Authorization") String token) {
        String userId = jwtUtil.extractUserId(token.substring(7));
        if (userId == null) {
            return ResponseEntity.status(401).build();
        }
        Comment updatedComment = commentService.updateComment(commentId, commentDTO);
        return ResponseEntity.ok(updatedComment);
    }

    //댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId, @RequestHeader("Authorization") String token) {
        String userId = jwtUtil.extractUserId(token.substring(7));
        if (userId == null) {
            return ResponseEntity.status(401).build();
        }
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}