package uz.pdp.appnewssite.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.entity.UserRole;
import uz.pdp.appnewssite.entity.enums.Permission;
import uz.pdp.appnewssite.repository.UserRepo;
import uz.pdp.appnewssite.repository.UserRoleRepo;
import uz.pdp.appnewssite.utils.AppConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static uz.pdp.appnewssite.utils.AppConstants.*;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Override
    public void run(String... args){
        if (ddl.equals("create") || ddl.equals("create-drop")){

            Permission[] valuesList = Permission.values();
            UserRole admin1 = userRoleRepo.save(new UserRole(
                    AppConstants.admin, Arrays.asList(valuesList)
            ));

            UserRole user1 = userRoleRepo.save(new UserRole(
                    user,
                    Arrays.asList(
                            Permission.ADD_COMMENT,
                            Permission.DELETE_COMMENT,
                            Permission.EDIT_COMMENT
                    )
            ));

            User user2 = new User();
            user2.setFullName("user");
            user2.setUsername("user");
            user2.setPassword("user");
            user2.setUserRole(user1);
            user2.setEnabled(true);
            userRepo.save(user2);


            User user3 = new User();
            user3.setFullName("admin");
            user3.setUsername("admin");
            user3.setPassword("admin");
            user3.setUserRole(admin1);
            userRepo.save(user3);
        }
    }
}
