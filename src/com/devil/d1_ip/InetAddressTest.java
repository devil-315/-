package com.devil.d1_ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ClassName：InetAddressTest
 *
 * @author: Devil
 * @Date: 2024/11/18
 * @Description:
 * @version: 1.0
 */
public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        //1. 获取本机Ip地址对象
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println(ip1.getHostName());
        System.out.println(ip1.getHostAddress());

        //2.获取指定IP或这域名的IP地址对象
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());

        System.out.println(ip2.isReachable(6000));
    }
}
