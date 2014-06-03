package com.keqiaokeji.tezizai.common.character;

import com.keqiaokeji.tezizai.common.utils.CommonContexts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * MD5加密
 * 
 * @author HAIKANG SONG
 * @time 2013-4-24上午11:28:56
 */
public class MD5Encrypt {

	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	private static final String MD5 = "MD5";

	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param content
	 * @return 加密成功返回MD5字符串，否则返回null
	 * @author HAIKANG SONG
	 * @time 2013-4-24上午11:41:30
	 */
	public static String getMD5(String content) {
		String md5 = null;
		try {
			MessageDigest md = MessageDigest.getInstance(MD5);
			if (content!=null) {
				md.update(content.getBytes(CommonContexts.encode));
			}
			byte[] byteArray = md.digest();// MD5 的计算结果是一个 128 位的长整数，
			md5 = byteToMD5(byteArray);
		} catch (Exception e) {
            e.printStackTrace();
		}
		md5 = md5.toLowerCase();
		return md5;
	}

	/**
	 * 对指定路径的文件做MD5加密
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 加密成功返回MD5字符串，否则返回null
	 * @author HAIKANG SONG
	 * @time 2013-4-24上午11:42:02
	 */
	public static String getFileMD5(String filePath) {
		String md5 = null;
		File file = new File(filePath);
		if (file.exists()) {
			md5 = getFileMD5(file);
		} else {
            System.out.println("对文件（" + filePath + "）进行MD5加密时文件不存在！");
		}
		return md5;
	}

	/**
	 * 对指定文件做MD5加密
	 * 
	 * @param file
	 *            文件对象
	 * @return 加密成功返回MD5字符串，否则返回null
	 * @author HAIKANG SONG
	 * @time 2013-4-24下午1:20:48
	 */
	public static String getFileMD5(File file) {
		String md5 = null;
		if (!file.exists()) {
			return md5;
		}
		FileInputStream fin = null;
		try {
			MessageDigest md = MessageDigest.getInstance(MD5);
			fin = new FileInputStream(file);
			byte[] buffer = new byte[CommonContexts.fileBuffer];
			int length = -1;
			while ((length = fin.read(buffer)) != -1) {
				md.update(buffer, 0, length);
			}
			byte[] byteArray = md.digest();
			md5 = byteToMD5(byteArray);
		} catch (Exception e) {
            e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException ex) {
			}
		}
		return md5;
	}

	/**
	 * 将字节转换为MD5值（32位的16进制字符串）
	 * 
	 * @param byteArray
	 *            需要转换的字节
	 * @return MD5值
	 * @author HAIKANG SONG
	 * @time 2013-4-24下午1:14:12
	 */
	private static String byteToMD5(byte[] byteArray) {
		// 用字节表示就是 16 个字节
		char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
		// 所以表示成 16 进制需要 32 个字符
		int k = 0; // 表示转换结果中对应的字符位置
		for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
			// 转换成 16 进制字符的转换
			byte byte0 = byteArray[i]; // 取第 i 个字节
			str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
			// >>> 为逻辑右移，将符号位一起右移
			str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
		}
		return new String(str); // 换后的结果转换为字符串
	}

}
