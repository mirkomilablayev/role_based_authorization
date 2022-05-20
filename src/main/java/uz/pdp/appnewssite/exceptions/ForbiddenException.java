package uz.pdp.appnewssite.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
@AllArgsConstructor
@NoArgsConstructor
public class ForbiddenException extends RuntimeException{
    private String msg;
}
