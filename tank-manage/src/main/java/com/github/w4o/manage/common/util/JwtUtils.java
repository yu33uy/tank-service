package com.github.w4o.manage.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.github.w4o.core.exception.CustomException;
import com.github.w4o.manage.common.ErrorCode;
import com.github.w4o.manage.common.config.TankConfig;
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

        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, tankConfig.getJwt().getExpire());
        Date expiresDate = nowTime.getTime();

        Date iatDate = new Date();

        // header Map
        Map<String, Object> map = new HashMap<>(2);
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        return JWT.create()
                .withHeader(map)
                .withIssuedAt(iatDate)
                .withExpiresAt(expiresDate)
                .withClaim(CLAIM_KEY_USERNAME, userDetails.getUsername())
                .sign(Algorithm.HMAC256(tankConfig.getJwt().getSecret()));
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()));
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).get(CLAIM_KEY_USERNAME).asString();
    }


    private Map<String, Claim> getClaimsFromToken(String token) {
        String realToken = token.replace("Bearer ", "");

        DecodedJWT jwt;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(tankConfig.getJwt().getSecret())).build();
            jwt = verifier.verify(realToken);
        } catch (TokenExpiredException e) {
            throw new CustomException(ErrorCode.E402);
        } catch (Exception e) {
            // token 校验失败, 抛出Token验证非法异常
            throw new CustomException(ErrorCode.E401);
        }
        return jwt.getClaims();
    }
}
