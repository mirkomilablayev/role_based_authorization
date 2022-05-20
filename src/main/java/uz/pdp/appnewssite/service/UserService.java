package uz.pdp.appnewssite.service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import uz.pdp.appnewssite.dto.UserDto;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {
    public HttpEntity<?> add(UserDto userDto) {
        return null;
    }
}
