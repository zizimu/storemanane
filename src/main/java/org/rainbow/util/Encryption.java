package org.rainbow.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.alibaba.druid.util.Base64;
/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-05-02
 */

public class Encryption {

	private static Encryption instance;

	private Encryption() {

	}

	public static Encryption getInstance() {
		if (instance == null) {
			instance = new Encryption();
		}
		return instance;
	}

	public byte[] getMD5(String msg) {
		byte[] rs = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			rs = md.digest(msg.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public byte[] getSHA256(String msg) {
		byte[] rs = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			rs = md.digest(msg.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {// 1得到一位的进行补0操作
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}

	/**
	 *
	 * @Title: passwordEncry
	 * @Description: 取sha256的后16位+md5的后8位组成新的btye[],再转化为一个32位的Base64字符串存入数据库
	 * @param msg
	 * @return byte[]    返回类型
	 * @throws
	 */
	public byte[] passwordEncry(String msg) {
		byte[] rs= new byte[24];
		System.arraycopy(getSHA256(msg), 16, rs, 0, 16);
		System.arraycopy(getMD5(msg), 8, rs, 16, 8);
		return rs;
	}

	public String byte2BASE64(byte[] bytes) {
		return Base64.byteArrayToBase64(bytes);
	}
}
