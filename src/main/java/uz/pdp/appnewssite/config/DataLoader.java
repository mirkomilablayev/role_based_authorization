package uz.pdp.appnewssite.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.appnewssite.config.annotation.CheckPermission;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.entity.UserRole;
import uz.pdp.appnewssite.entity.enums.Permission;
import uz.pdp.appnewssite.repository.UserRepo;
import uz.pdp.appnewssite.repository.UserRoleRepo;
import uz.pdp.appnewssite.utils.AppConstants;

import java.util.Arrays;

import static uz.pdp.appnewssite.utils.AppConstants.user;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;


    @Override
    public void run(String... args){
        if (ddl.equals("create") || ddl.equals("create-drop")){

            Permission[] valuesList = Permission.values();
            //admin uchun  role
            UserRole admin1 = userRoleRepo.save(new UserRole(AppConstants.admin, Arrays.asList(valuesList),"asasaa"));

            // user uchun role
            UserRole user1 = userRoleRepo.save(new UserRole(user,Arrays.asList(Permission.ADD_COMMENT,Permission.DELETE_COMMENT,Permission.EDIT_COMMENT),"saas"));

            User user2 = new User();
            user2.setFullName("user");
            user2.setUsername("user");
            user2.setPassword(passwordEncoder.encode("user"));
            user2.setUserRole(user1);
            user2.setEnabled(true);
            userRepo.save(user2);


            User user3 = new User();
            user3.setFullName("admin");
            user3.setUsername("admin");
            user3.setEnabled(true);
            user3.setPassword(passwordEncoder.encode("admin"));
            user3.setUserRole(admin1);
            userRepo.save(user3);
        }
    }
}
