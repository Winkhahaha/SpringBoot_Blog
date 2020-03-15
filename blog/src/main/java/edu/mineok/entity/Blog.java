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
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;                    // 主键id

    private String title;               // 标题
    private String content;             // 内容
    private String firstPicture;        // 首图
    private String flag;                // 标记
    private Integer views;              // 浏览次数
    private boolean appreciation;       // 赞赏是否开启
    private boolean shareStatement;     // 是否开启转载声明
    private boolean commentabled;       // 是否开启评论
    private boolean published;          // 是否发布还是保存为草稿
    private boolean recommend;          // 是否推荐
    @Temporal(TemporalType.TIMESTAMP)   // 指定生成时间的类型(日期+时间)
    private Date createTime;            // 创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;            // 更新时间

    // 构建实体类之间的关系
    // Blog 多对一 Type
    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();





    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
