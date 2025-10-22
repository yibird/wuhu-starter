package io.github.yibird.starter.security.crypto.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/8/14 16:57
 */
public class AesGcm {
    // GCM 推荐 12字节IV，标签默认128位
    private static final int IV_LEN = 12;
    private static final int TAG_LEN_BIT = 128;
    private static final SecureRandom RNG = new SecureRandom();

    public static byte[] randomIV() {
        byte[] iv = new byte[IV_LEN];
        RNG.nextBytes(iv);
        return iv;
    }

    public static byte[] base64Decode(String b64) {
        return Base64.getDecoder().decode(b64);
    }

    public static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] encrypt(byte[] key, byte[] iv, byte[] plain) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            GCMParameterSpec spec = new GCMParameterSpec(TAG_LEN_BIT, iv);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, spec);
            return cipher.doFinal(plain);
        } catch (Exception e) {
            throw new IllegalStateException("AES-GCM encrypt error", e);
        }
    }

    public static byte[] decrypt(byte[] key, byte[] iv, byte[] cipherText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            GCMParameterSpec spec = new GCMParameterSpec(TAG_LEN_BIT, iv);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, spec);
            return cipher.doFinal(cipherText);
        } catch (Exception e) {
            throw new IllegalStateException("AES-GCM decrypt error", e);
        }
    }
}
