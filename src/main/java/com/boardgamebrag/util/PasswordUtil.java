package com.boardgamebrag.util;

import java.util.Random;

import org.apache.commons.codec.binary.Base64;

public class PasswordUtil {
    
    public static String generateSalt() {
        byte[] saltValueBytes = new byte[8];
        new Random().nextBytes(saltValueBytes);
        return new String(Base64.encodeBase64(saltValueBytes));
    }
}
