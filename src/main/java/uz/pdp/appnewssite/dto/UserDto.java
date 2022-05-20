package uz.pdp.appnewssite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String fullName;
    private String password;
    private String prePassword;
    private Long UserRoleId;
}
