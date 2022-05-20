package uz.pdp.appnewssite.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.appnewssite.dto.RoleDto;
import uz.pdp.appnewssite.entity.UserRole;
import uz.pdp.appnewssite.repository.UserRoleRepo;

import javax.transaction.Transactional;
import java.util.Optional;
@Transactional
@RequiredArgsConstructor
@Service
public class UserRoleService {
    private final UserRoleRepo userRoleRepo;

    public HttpEntity<?> addRole(RoleDto roleDto) {
        boolean b = userRoleRepo.existsByName(roleDto.getName());
        if (b)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("The User Role With "+roleDto.getName()+" Is Already Exist");

        UserRole userRole = new UserRole();
        userRole.setDescription(roleDto.getDescription());
        userRole.setName(roleDto.getName());
        userRole.setPermissions(roleDto.getPermissions());
        return ResponseEntity.status(HttpStatus.OK).body(userRoleRepo.save(userRole));
    }

    public HttpEntity<?> editRole(RoleDto roleDto, Long role_id) {
        return null;
    }
}
