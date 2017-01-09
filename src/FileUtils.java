import java.io.*;

/**
 * 字符串与文件相互转换工具
 *
 * @author leizhimin 2009-7-14 15:54:18
 */
public class FileUtils {

    /**
     * 读取文件为一个内存字符串,保持文件原有的换行格式
     *
     * @param file        文件对象
     * @param charset 文件字符集编码
     * @return 文件内容的字符串
     */
    public static String file2String(File file, String charset) throws IOException {
        StringBuffer sb = new StringBuffer();

            LineNumberReader reader = new LineNumberReader(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }

        return sb.toString();
    }

    /**
     * 将字符串存储为一个文件，当文件不存在时候，自动创建该文件，当文件已存在时候，重写文件的内容，特定情况下，还与操作系统的权限有关。
     *
     * @param text         字符串
     * @param distFile 存储的目标文件
     * @return 当存储正确无误时返回true，否则返回false
     */
    public static boolean string2File(String text, File distFile) throws IOException {
        if (!distFile.getParentFile().exists()) distFile.getParentFile().mkdirs();
        BufferedReader br = null;
        BufferedWriter bw = null;
        boolean flag = true;
            br = new BufferedReader(new StringReader(text));
            bw = new BufferedWriter(new FileWriter(distFile));
            char buf[] = new char[1024 * 64];         //字符缓冲区
            int len;
            while ((len = br.read(buf)) != -1) {
                bw.write(buf, 0, len);
            }
            bw.flush();
            br.close();
            bw.close();
        return flag;
    }
}
