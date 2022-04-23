package uz.pdp.appnewssite.config.annotation;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.exceptions.ForbiddenException;

@Component
@Aspect
public class CHeckPermissionExexcutor {

    @Before(value = "@annotation(checkPermission)")
    public void checkPermissionMyMethod(CheckPermission checkPermission){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean flag = false;
        for (GrantedAuthority authority : currentUser.getAuthorities()) {
            if (authority.getAuthority().equals(checkPermission.value())){
                flag = true;
                break;
            }
        }
        if (!flag)
            throw new ForbiddenException("You Don't Have Permission");
    }
}
