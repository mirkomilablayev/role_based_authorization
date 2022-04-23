package uz.pdp.appnewssite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appnewssite.entity.UserRole;

import java.util.Optional;

public interface UserRoleRepo extends JpaRepository<UserRole,Long> {
    Optional<UserRole> findByName(String name);

    boolean existsByName(String name);
}
