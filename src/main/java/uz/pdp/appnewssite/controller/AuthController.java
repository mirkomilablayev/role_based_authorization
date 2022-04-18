package uz.pdp.appnewssite.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appnewssite.dto.RegisterDto;
import uz.pdp.appnewssite.service.AuthService;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/create")
    public HttpEntity<?> register(@Valid @RequestBody RegisterDto registerDto){
        return authService.registerUser(registerDto);
    }
}
