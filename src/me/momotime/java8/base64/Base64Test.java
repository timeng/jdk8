/**
 * Copyright (c) 2014, http://momotime.me. All rights reserved.
 * @author momo.
 * @Time: 14-3-30 下午10:15
 */
package me.momotime.java8.base64;

import java.net.URL;
import java.util.Base64;

/**
 * Base64测试
 *
 * @author momo.
 */
public class Base64Test {
    public static void main(String args[]) {
        try {
            URL url = new URL("http://momotime.com");
            //编码
            Base64.Encoder urlEncoderec = Base64.getUrlEncoder();
            byte[] urlBytes = urlEncoderec.encode(url.toString().getBytes("UTF8"));
            System.out.println("url编码结果: " + new String(urlBytes, "UTF-8"));
            //解码
            Base64.Decoder urdc = Base64.getUrlDecoder();
            byte[] urdec = urdc.decode(urlBytes);
            System.out.println("url编码结果: " + new String(urdec, "UTF-8"));

            String str = "Base64Test class";
            Base64.Encoder enc = Base64.getEncoder();
            byte[] strenc = enc.encode(str.getBytes("UTF-8"));
            System.out.println("基本base64编码结果 : " + new String(strenc, "UTF-8"));
            //解码
            Base64.Decoder dec = Base64.getDecoder();
            byte[] strdec = dec.decode(strenc);
            System.out.println("基本base64解码结果 : " + new String(strdec, "UTF-8"));
        } catch (Exception e) {
            System.out.println("base64异常");
        }
    }
}
