package uz.pdp.appnewssite.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.appnewssite.entity.template.BaseEntity;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "posts")
public class Post extends BaseEntity {




    @Column(columnDefinition = "text")
    private String title;
    @Column(columnDefinition = "text")
    private String text;
    @Column(columnDefinition = "text")
    private String url;

}
