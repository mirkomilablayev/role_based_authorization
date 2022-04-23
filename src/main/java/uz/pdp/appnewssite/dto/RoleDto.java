package uz.pdp.appnewssite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.appnewssite.entity.enums.Permission;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private String name;
    private List<Permission> permissions;
    private String description;
}
