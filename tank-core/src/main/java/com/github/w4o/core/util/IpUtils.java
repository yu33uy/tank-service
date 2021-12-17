package com.github.w4o.core.util;

import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author frank
 * @date 2021/10/14
 */
public class IpUtils {

    private static final String UNKNOWN_REMOTE_ADDRESS = "unknown";
    private static final char MULTIPLE_IP_DELIMITER = ',';

    /**
     * 获取用户IP， 通过RequestContextHolder
     *
     * @return ip地址
     */
    public static String getIpAddress() {
        val requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return StringUtils.EMPTY;
        }
        val servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        val httpServletRequest = servletRequestAttributes.getRequest();
        return getIpAddress(httpServletRequest);
    }


    /**
     * 获取用户IP
     *
     * @param request HttpServletRequest
     * @return ip地址
     */
    public static String getIpAddress(HttpServletRequest request) {

        String ip = request.getHeader("cf-connecting-ip");
        if (ip == null || ip.length() == 0 || UNKNOWN_REMOTE_ADDRESS.equalsIgnoreCase(ip)) {
            ip = request.getHeader("incap-client-ip");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_REMOTE_ADDRESS.equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_REMOTE_ADDRESS.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_REMOTE_ADDRESS.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_REMOTE_ADDRESS.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (UNKNOWN_REMOTE_ADDRESS.equals(ip)) {
                //根据网卡取本机配置的IP
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException ignore) {
                }
                if (inetAddress != null) {
                    ip = inetAddress.getHostAddress();
                }
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.indexOf(MULTIPLE_IP_DELIMITER) > 0) {
            ip = ip.substring(0, ip.indexOf(","));
        }
        return ip;
    }
}
