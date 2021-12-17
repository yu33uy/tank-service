package com.github.w4o.manage.controller;


import com.github.w4o.core.base.CommonResult;
import com.github.w4o.core.exception.CustomException;
import com.github.w4o.manage.common.ErrorCode;
import com.github.w4o.manage.common.cache.CaptchaCache;
import com.github.w4o.manage.common.config.TankConfig;
import com.github.w4o.manage.common.constant.Constant;
import com.github.w4o.manage.common.util.JwtUtils;
import com.github.w4o.manage.dto.param.LoginParam;
import com.github.w4o.manage.vo.LoginVO;
import com.github.w4o.manage.vo.UserInfoVO;
import com.github.w4o.manage.common.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.Date;

/**
 * @author frank
 */
@RestController
@RequestMapping()
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = {"用户授权"})
@Validated
@Slf4j
public class LoginController {

    private final JwtUtils jwtUtils;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final TankConfig tankConfig;

    @Value("${spring.profiles.active}")
    private String active;

    private boolean isDebug() {
        return Arrays.asList(new String[]{"dev", "stage"}).contains(active);
    }

    /**
     * 登陆
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登陆", notes = "获取jwt字符串(token)，使用token访问需要授权的接口")
    public CommonResult<LoginVO> login(@RequestBody LoginParam loginParam) {
        if (!isDebug()) {
            String code = CaptchaCache.TIMED_CACHE.get(loginParam.getCaptchaKey(), false);
            CaptchaCache.TIMED_CACHE.remove(loginParam.getCaptchaKey());
            if (StringUtils.isEmpty(code) || !StringUtils.equalsIgnoreCase(loginParam.getVerificationCode(), code)) {
                return CommonResult.error(ErrorCode.E1003);
            }
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginParam.getUsername(), loginParam.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        return CommonResult.success(LoginVO.builder().token(jwtUtils.generateToken(userDetails)).build());
    }

    /**
     * 用户信息
     */
    @GetMapping("/userInfo")
    public CommonResult<UserInfoVO> userInfo(Principal principal) {
        // TODO 测试用户信息
        UserInfoVO userInfoVO = UserInfoVO.builder()
                .avatar("https://dn-qiniu-avatar.qbox.me/avatar/")
                .username(principal.getName())
                .permissions(new String[]{"*"})
                .roles(new String[]{"*"})
                .build();
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("{}", userInfo.getUserId());

        return CommonResult.success(userInfoVO);
    }

    /**
     * 登出
     */
    @GetMapping("/logout")
    public CommonResult<?> logout() {
        return CommonResult.success();
    }


    /**
     * 刷新Token
     */
    @GetMapping("/refreshToken")
    public CommonResult<?> refreshToken(@RequestHeader(Constant.JWT_HEADER_NAME) String token) {
        Date expiration = jwtUtils.getExpirationDateFromToken(token);
        Date current = new Date();
        long diff = current.getTime() - expiration.getTime();
        if (Math.abs(diff) > tankConfig.getJwt().getExpire().longValue()) {
            throw new CustomException(ErrorCode.E401);
        }
        return CommonResult.success(LoginVO.builder().token(jwtUtils.refreshToken(token)).build());
    }
}
