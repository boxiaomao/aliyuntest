import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Boxiaomao on 2017/7/27 0027.
 */
public class Md5 {
    /**利用MD5进行加密
 　　* @param str  待加密的字符串
 　　* @return  加密后的字符串
 　　* @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
 　　 * @throws UnsupportedEncodingException
 　　*/
public String EncoderByMd5(String str){
         //确定计算方法
    MessageDigest md5= null;
    try {
        md5 = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
    String newstr= null;
    try {
        newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    return newstr;
        }

    public static void main(String[] args) {
    Md5 md5=new Md5();
    String akb=md5.EncoderByMd5("19920825");
        String akb1=md5.EncoderByMd5("19920825");
        System.out.println(akb+"11111111111111"+akb1);
    }



}
