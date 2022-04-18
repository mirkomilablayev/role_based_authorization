package uz.pdp.appnewssite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appnewssite.entity.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole,Long> {
}
