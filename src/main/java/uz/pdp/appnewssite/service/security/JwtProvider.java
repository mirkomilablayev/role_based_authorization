package uz.pdp.appnewssite.service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import uz.pdp.appnewssite.entity.UserRole;

import java.util.Date;
import java.util.Set;

@Component
public class JwtProvider {
    private static final long expire = 1000 * 60 * 60 * 12;
    private static final String key = "sasasfddsgfdhfghfgjhgjhgj";

    public String generateToken(String username, UserRole roles){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .claim("roles",roles.toString())
                .signWith(SignatureAlgorithm.HS512,key)
                .compact();
    }

    public String getUsername(String token){
       try{
           return Jwts
                   .parser()
                   .setSigningKey(key)
                   .parseClaimsJws(token)
                   .getBody()
                   .getSubject();
       }catch (Exception e){
           return null;
       }
    }


}
