package uz.pdp.appnewssite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appnewssite.entity.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByPassword(String password);
    Optional<User> findByUsername(String username);
}
