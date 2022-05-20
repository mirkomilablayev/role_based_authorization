package uz.pdp.appnewssite.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appnewssite.config.annotation.CheckPermission;
import uz.pdp.appnewssite.dto.RoleDto;
import uz.pdp.appnewssite.service.UserRoleService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/role")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @CheckPermission(value = "ADD_ROLE")
    @PostMapping("/create")
    public HttpEntity<?> addRole(@RequestBody RoleDto roleDto){
        return userRoleService.addRole(roleDto);
    }


    @PutMapping("/edit/{role_id}")
    public HttpEntity<?> editRole(@RequestBody RoleDto roleDto,@PathVariable Long role_id){
        return userRoleService.editRole(roleDto,role_id);
    }
}
