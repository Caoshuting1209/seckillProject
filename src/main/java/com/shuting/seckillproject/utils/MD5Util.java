package com.shuting.seckillproject.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {
    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassToFromPass(String inputPass) {
        String str = salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(1);
        return md5(str);
    }

    public static String FromPassToDBPass(String fromPass, String salt) {
        String str = salt.charAt(0) + salt.charAt(2) + fromPass + salt.charAt(1);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String salt) {
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = FromPassToDBPass(fromPass, salt);
        return dbPass;
    }
}
