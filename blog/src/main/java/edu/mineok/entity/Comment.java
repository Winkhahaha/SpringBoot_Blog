package edu.mineok.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;            // 昵称
    private String email;               // 邮箱
    private String content;             // 评论内容
    private String avatar;              // 头像
    @Temporal(TemporalType.TIMESTAMP)   // 指定生成时间的类型(日期+时间)
    private Date createTime;            // 创建时间

    // 构建实体类之间的关系
    @ManyToOne
    private Blog blog;

    // 实体类自关联关系
    // 主回复有多个子回复
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();

    @ManyToOne
    private Comment parentComment;


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
