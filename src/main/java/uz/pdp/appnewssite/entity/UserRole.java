package uz.pdp.appnewssite.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.appnewssite.entity.enums.Permission;
import uz.pdp.appnewssite.entity.template.BaseEntity;
import uz.pdp.appnewssite.entity.enums.RoleType;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_role")
public class UserRole extends BaseEntity {
    private String name;



    @ElementCollection
    private List<Permission> permissions;
}
