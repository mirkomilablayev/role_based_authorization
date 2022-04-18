package uz.pdp.appnewssite.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.appnewssite.dto.RegisterDto;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.repository.UserRepo;
import uz.pdp.appnewssite.repository.UserRoleRepo;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;

    public HttpEntity<?> registerUser(RegisterDto registerDto){
        Optional<User> userOptional = userRepo.findByUsername(registerDto.getUsername());
        if (userOptional.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This Username is Already Taken");
        User user = new User();
        user.setFullName(registerDto.getFullName());
        user.setUsername(registerDto.getUsername());
        return null;
    }
}
