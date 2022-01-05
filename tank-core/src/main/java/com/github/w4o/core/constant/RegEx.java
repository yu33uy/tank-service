package com.github.w4o.core.constant;

/**
 * @author frank
 * @date 2020/4/8
 */
public interface RegEx {
    /**
     * e-mail地址
     */
    String E_MAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    /**
     * 手机号
     * https://stackoverflow.com/questions/2113908/what-regular-expression-will-match-valid-international-phone-numbers
     */
    String PHONE_NUMBER = "\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$";
}
