import java.util.*;
import com.google.gson.*;
import java.io.*;
import org.apache.commons.codec.*;
import java.util.regex.*;
import java.security.*;
import java.math.*;
import java.net.*;
import org.apache.commons.net.ftp.FTPClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Main
{

	public static void main(String[] args) throws Exception
	{
		OkHttpClient okHttpClient = new OkHttpClient();
	}

	private static void print99X()
	{
		int x = 9;
		int y = 1;
		for (int i = 1;i <= x;i++)
		{
			for (int j = 1; j <= y ;j++)
			{
				System.out.print(j + "×" + i + "＝" + i * j + " ");
			}
			System.out.println();
			y++;
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 对字符串md5加密
	 *
	 * @param str
	 * @return
	 */
	public static String getMD5(String str) throws NoSuchAlgorithmException
	{
		// 生成一个MD5加密计算摘要
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 计算md5函数
		md.update(str.getBytes());
		// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
		// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
		return new BigInteger(1, md.digest()).toString(16);
	}
}
