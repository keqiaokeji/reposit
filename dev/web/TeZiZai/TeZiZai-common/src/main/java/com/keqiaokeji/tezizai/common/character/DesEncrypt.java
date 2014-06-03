package com.keqiaokeji.tezizai.common.character;

import com.keqiaokeji.tezizai.common.utils.CommonContexts;

import javax.crypto.Cipher;
import java.security.Key;

/**
 * DES加密和解密工具,可以对字符串进行加密和解密操作  。 
 * 
 * @author HAIKANG SONG
 * @time 2013-4-24下午1:25:05
 */
public class DesEncrypt {

	private final static String DES = "DES";
	
	/**
	 * 加密字符串
	 *
	 * @param content 需要加密的明文
	 * @param password 加密用的密码
	 * @return 加密后的密文
	 * @author HAIKANG SONG
	 * @time 2013-4-24下午1:28:40
	 */
	public static String encrypt(String content, String password){
		String passwordContent = null;
		try {
			Cipher cipher = getCipher(password, Cipher.ENCRYPT_MODE);
			byte[] contentByte = content.getBytes(CommonContexts.encode);
			byte[] encryptByte = cipher.doFinal(contentByte);
			int encryptLength = encryptByte.length;
			StringBuffer sb = new StringBuffer(encryptLength * 2);// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍   
			for (int i = 0; i < encryptLength; i++) {
				int intTmp = encryptByte[i];
				while (intTmp < 0) {// 把负数转换为正数   
					intTmp = intTmp + 256;
				}
				if (intTmp < 16) {// 小于0F的数需要在前面补0   
					sb.append("0");
				}
				sb.append(Integer.toString(intTmp, 16));
			}
			passwordContent = sb.toString();
		} catch (Exception e) {
            e.printStackTrace();
		}
		return passwordContent;
	}
	
	/**
	 * 解密字符串
	 *
	 * @param passwordContent 需要解密的密文
	 * @param password 解密的密码（和加密时的密码相同）
	 * @return 加密前的明文
	 * @author HAIKANG SONG
	 * @time 2013-4-24下午1:29:13
	 */
	public static String decrypt(String passwordContent, String password){
		String content = null;
		try {
			Cipher cipher = getCipher(password, Cipher.DECRYPT_MODE);
			byte[] contentByte = passwordContent.getBytes(CommonContexts.encode);
			int iLen = contentByte.length;
			byte[] arrOut = new byte[iLen / 2];// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2   
			for (int i = 0; i < iLen; i = i + 2) {
				String strTmp = new String(contentByte, i, 2);
				arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
			}
			byte[] decryptByte= cipher.doFinal(arrOut);
			content = new String(decryptByte);
		} catch (Exception e) {
            e.printStackTrace();
		}
		return content;
	}
	
	/**
	 * 获得加密工具类
	 *
	 * @param password 密码
	 * @param mode 类型（值为：Cipher.ENCRYPT_MODE或Cipher.DECRYPT_MODE）
	 * @return
	 * @throws Exception 
	 * @author HAIKANG SONG
	 * @time 2013-4-24下午2:27:49
	 */
	private static Cipher getCipher(String password, int mode) throws Exception{
		byte[] passwordByte =password.getBytes(CommonContexts.encode);
		byte[] arrB = new byte[8];// 创建一个空的8位字节数组（默认值为0）   
		for (int i = 0; i < passwordByte.length && i < arrB.length; i++) {// 将原始字节数组转换为8位   
			arrB[i] = passwordByte[i];
		}
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, DES);// 生成密钥   
		Cipher cipher = Cipher.getInstance(DES);
		cipher.init(mode, key);
		return cipher; 
	}
	

}
