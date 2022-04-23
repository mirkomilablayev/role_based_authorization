package uz.pdp.appnewssite.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appnewssite.dto.LoginDto;
import uz.pdp.appnewssite.dto.RegisterDto;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.service.AuthService;
import uz.pdp.appnewssite.service.security.JwtProvider;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDto registerDto){
        String encodedPassword = passwordEncoder.encode(registerDto.getPassword());
        return authService.registerUser(registerDto,encodedPassword);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto loginDto){
        User user = null;
        try{
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            user =(User) authenticate.getPrincipal();
        }catch (AuthenticationException e){
            return new ResponseEntity<>("",HttpStatus.BAD_GATEWAY);
        }

        String token = jwtProvider.generateToken(user.getUsername(), user.getUserRole());
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
