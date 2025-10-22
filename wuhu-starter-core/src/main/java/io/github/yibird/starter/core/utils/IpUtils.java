//package com.fly.core.utils;
//
//import org.lionsoul.ip2region.xdb.Searcher;
//
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.regex.Pattern;
//
///**
// * @Description ip工具类
// * @Author zchengfeng
// * @Datetime 2024/1/17 13:52:58
// */
//public class IpUtils {
//
//    private static final String IP2REGION_DB_PATH = "src/main/resources/ip2region.xdb";
//    private static final Searcher searcher;
//
//    static {
//        try {
//            // 初始化 Searcher
//            searcher = Searcher.newWithFileOnly(IP2REGION_DB_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to load ip2region database", e);
//        }
//    }
//
//    /**
//     * 根据ip获取对应ip地址
//     *
//     * @param ip ip
//     * @return ip对应的地址(格式 : 国家 | 区域 | 省份 | 城市 | ISP)
//     */
//    public static String getAddr(String ip) {
//        if (!isValidIp(ip)) {
//            throw new IllegalArgumentException("Invalid IP address: " + ip);
//        }
//        try {
//            return searcher.search(ip);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to search IP address", e);
//        }
//    }
//
//    /**
//     * 判断ip是否是内网ip
//     *
//     * @param ip ip
//     * @return 布尔值
//     */
//    public static boolean isInnerIp(String ip) {
//        if (!isValidIp(ip)) {
//            throw new IllegalArgumentException("Invalid IP address: " + ip);
//        }
//        if (ip.startsWith("10.") || ip.startsWith("192.168.")) {
//            return true;
//        }
//
//        if (ip.startsWith("172.")) {
//            int secondOctet = Integer.parseInt(ip.split("\\.")[1]);
//            return secondOctet >= 16 && secondOctet <= 31;
//        }
//        return false;
//    }
//
//    /**
//     * 验证 IP 地址是否合法
//     *
//     * @param ip IP 地址
//     * @return 如果合法返回 true，否则返回 false
//     */
//    private static boolean isValidIp(String ip) {
//        if (ip == null || ip.isEmpty()) {
//            return false;
//        }
//        String ipRegex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
//        return Pattern.matches(ipRegex, ip);
//    }
//
//    /**
//     * 将 IP 地址转换为长整型
//     *
//     * @param ip IP 地址
//     * @return 长整型表示的 IP 地址
//     */
//    public static long ipToLong(String ip) {
//        if (!isValidIp(ip)) {
//            throw new IllegalArgumentException("Invalid IP address: " + ip);
//        }
//
//        String[] octets = ip.split("\\.");
//        return (Long.parseLong(octets[0]) << 24) +
//                (Long.parseLong(octets[1]) << 16) +
//                (Long.parseLong(octets[2]) << 8) +
//                Long.parseLong(octets[3]);
//    }
//
//    /**
//     * 将长整型转换为 IP 地址
//     *
//     * @param ip 长整型表示的 IP 地址
//     * @return 点分十进制表示的 IP 地址
//     */
//    public static String longToIp(long ip) {
//        return ((ip >> 24) & 0xFF) + "." +
//                ((ip >> 16) & 0xFF) + "." +
//                ((ip >> 8) & 0xFF) + "." +
//                (ip & 0xFF);
//    }
//
//    /**
//     * 获取本机的 IP 地址
//     *
//     * @return 本机的 IP 地址
//     */
//    public static String getLocalIp() {
//        try {
//            return InetAddress.getLocalHost().getHostAddress();
//        } catch (UnknownHostException e) {
//            throw new RuntimeException("Failed to get local IP address", e);
//        }
//    }
//
//    /**
//     * 获取本机的主机名
//     *
//     * @return 本机的主机名
//     */
//    public static String getLocalHostName() {
//        try {
//            return InetAddress.getLocalHost().getHostName();
//        } catch (UnknownHostException e) {
//            throw new RuntimeException("Failed to get local host name", e);
//        }
//    }
//
//    /**
//     * 判断 IP 地址是否是 IPv4
//     *
//     * @param ip IP 地址
//     * @return 如果是 IPv4 返回 true，否则返回 false
//     */
//    public static boolean isIPv4(String ip) {
//        return isValidIp(ip);
//    }
//
//    /**
//     * 判断 IP 地址是否是 IPv6
//     *
//     * @param ip IP 地址
//     * @return 如果是 IPv6 返回 true，否则返回 false
//     */
//    public static boolean isIPv6(String ip) {
//        if (ip == null || ip.isEmpty()) {
//            return false;
//        }
//        String ipv6Regex = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
//        return Pattern.matches(ipv6Regex, ip);
//    }
//}
