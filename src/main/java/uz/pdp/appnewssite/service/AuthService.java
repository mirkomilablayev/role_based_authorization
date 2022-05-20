package uz.pdp.appnewssite.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.appnewssite.dto.LoginDto;
import uz.pdp.appnewssite.dto.RegisterDto;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.exceptions.ResourceNotFoundException;
import uz.pdp.appnewssite.repository.UserRepo;
import uz.pdp.appnewssite.repository.UserRoleRepo;
import uz.pdp.appnewssite.service.security.JwtProvider;
import uz.pdp.appnewssite.utils.AppConstants;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService implements UserDetailsService {

    private final UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;

    public HttpEntity<?> registerUser(RegisterDto registerDto,String encodedPasswprd){
        if (!registerDto.getPassword().equals(registerDto.getPrePassword()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Please Input Correct Password");
        Optional<User> userOptional = userRepo.findByUsername(registerDto.getUsername());
        if (userOptional.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This Username is Already Taken");
        User user = new User();
        user.setFullName(registerDto.getFullName());
        user.setUsername(registerDto.getUsername());
        user.setPassword(encodedPasswprd);
        user.setUserRole(userRoleRepo.findByName(AppConstants.user).orElseThrow(() -> new ResourceNotFoundException("","","")));
        user.setEnabled(true);
        return ResponseEntity.status(HttpStatus.OK).body(userRepo.save(user));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return   userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("","",""));
    }

}
