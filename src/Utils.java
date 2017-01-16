
import java.security.MessageDigest;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;public class Utils
{
	/**
	 * 对字符串md5加密
	 *
	 * @param str
	 * @return
	 */
	public static String getMD5(String str) throws NoSuchAlgorithmException, NoSuchAlgorithmException
	{
		// 生成一个MD5加密计算摘要
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 计算md5函数
		md.update(str.getBytes());
		// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
		// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
		return new BigInteger(1, md.digest()).toString(16);
	}
	
	public static List<Integer> string2Numbers(String inString)
	{
		List<Integer> resultList = new ArrayList<Integer>();
		String regex = "\\d*";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(inString);

		while (m.find()) {
			if (!"".equals(m.group()))
			{
				resultList.add(Integer.parseInt( m.group()));
			}
		}
		return resultList;
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
}
