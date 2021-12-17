package com.github.w4o.manage.common.util;

import com.github.w4o.manage.common.config.TankConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author frank
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JwtUtils {

    private final TankConfig tankConfig;

    private static final String CLAIM_KEY_USERNAME = "sub";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(16);
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());

        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, tankConfig.getJwt().getExpire());
        Date expiresDate = nowTime.getTime();

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expiresDate)
                .signWith(SignatureAlgorithm.HS512, tankConfig.getJwt().getSecret())
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    public Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    public String refreshToken(String token) {
        Map<String, Object> claims = new HashMap<>(1);
        claims.put(CLAIM_KEY_USERNAME, getUsernameFromToken(token));

        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, tankConfig.getJwt().getExpire());
        Date expiresDate = nowTime.getTime();

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expiresDate)
                .signWith(SignatureAlgorithm.HS512, tankConfig.getJwt().getSecret())
                .compact();
    }

    private Claims getClaimsFromToken(String token) {
        String realToken = token.replace("Bearer ", "");
        return Jwts.parser()
                .setSigningKey(tankConfig.getJwt().getSecret())
                .parseClaimsJws(realToken)
                .getBody();
    }
}
