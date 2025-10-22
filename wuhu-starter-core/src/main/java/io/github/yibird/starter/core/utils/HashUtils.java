package io.github.yibird.starter.core.utils;

import cn.hutool.core.util.HashUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description Hash算法工具类
 * @Author zchengfeng
 * @Datetime 2024/10/25 17:06
 */
public class HashUtils {

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    /**
     * 使用 MD5 算法生成哈希值
     *
     * @param input 输入的字符串
     * @return MD5摘要字符串
     */
    public static String generateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating MD5 hash", e);
        }
    }


    /**
     * 使用 SHA-1 算法生成哈希值
     *
     * @param input 输入的字符串
     * @return 生成的 SHA-1 哈希值
     */
    public static String generateSHA1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating SHA-1 hash", e);
        }
    }

    /**
     * 使用 SHA-256 算法生成哈希值
     *
     * @param input 输入的字符串
     * @return 生成的 SHA-256 哈希值
     */
    public static String generateSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating SHA-256 hash", e);
        }
    }

    /**
     * 使用 MurmurHash 生成哈希值,Google Guava提供了MurmurHash算法的实现
     *
     * @param input 输入的字符串
     * @return 生成的 MurmurHash 哈希值
     */
    public static long generateMurmurHash(String input) {
        return HashUtil.murmur64(input.getBytes(StandardCharsets.UTF_8));
    }
}
