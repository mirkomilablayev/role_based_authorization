package uz.pdp.appnewssite.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appnewssite.dto.RegisterDto;
import uz.pdp.appnewssite.dto.UserDto;
import uz.pdp.appnewssite.entity.User;
import uz.pdp.appnewssite.service.AuthService;
import uz.pdp.appnewssite.service.UserService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public HttpEntity<?> register(@RequestBody UserDto userDto){
        return userService.add(userDto);
    }
}
