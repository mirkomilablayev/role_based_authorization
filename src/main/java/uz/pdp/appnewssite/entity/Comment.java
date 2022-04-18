package uz.pdp.appnewssite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.appnewssite.entity.template.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comments")
public class Comment extends BaseEntity {


    @Column(columnDefinition = "text")
    private String text;

    @ManyToOne
    private Post post;
}
