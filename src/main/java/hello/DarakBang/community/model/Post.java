package hello.DarakBang.community.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hello.DarakBang.login.model.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    private String title;
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "community_category_id")
    @JsonBackReference
    private CommunityCategory category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 좋아요 개수를 저장하는 필드
    private int likeCount = 0;

    // 좋아요를 누른 사용자의 ID를 저장하는 필드
    @ElementCollection
    private Set<String> likedBy = new HashSet<>();

}

