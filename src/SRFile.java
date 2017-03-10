import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by JvHuaxia on 2017/2/19.
 * 用于接收文件的Util类
 */
public class SRFile {
    public static void main(String[] args) throws Exception {
        if(args.length == 0)
        {
            printHelp();
        }else
        {
            if(args[0].equals("-R")||args.equals("-r"))
            {
                startRFileServer(Integer.parseInt(args[1]));
            }else if(args[0].equals("-S")||args.equals("-s"))
            {
                startSFileServer(args[1],Integer.parseInt( args[2]),args[3],args[4]);
            }
            else
            {
                printHelp();
            }

        }

    }

    private static void printHelp() {
        System.out.println("-Ｒ(-r)　为接受文件　参数为　[port] 例子 java SRFile -R 4000");
        System.out.println("-S(-s)　为发送文件　参数为　[host][port][要发送的文件路径][要存在服务器的路径] 例子 java SRFile -S 192.168.43.3 4000 C:\\文件 C:\\文件");
    }

    public  static void startSFileServer(String host,int port,String inFilePath,String outFilePath) throws  Exception
    {
        Socket client = new Socket(host,port);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(outFilePath);
        FileInputStream fis = new FileInputStream(new File(inFilePath));
        int readWhere = -1;
        byte[] buff = new byte[1024];
        while (-1 != (readWhere = fis.read(buff))) {
            dos.write(buff, 0, readWhere);
        }
        dos.close();
        client.close();
        System.out.println("已发送");
    }
    public static void startRFileServer(int port) throws Exception {
        new ServerClass().startRFileServer(port);
    }
}

class ServerClass {
    public void startRFileServer(int port) throws Exception {
        ServerSocket mServerSocket = new ServerSocket(port);
        while (true) {
            Socket client = mServerSocket.accept();
            new Thread(new SocketRecFile(client)).start();
        }
    }
}


class SocketRecFile implements Runnable {
    Socket client = null;

    public SocketRecFile(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String filePath = dis.readUTF();
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            int readWhere = -1;
            byte[] buff = new byte[1024];
            while (-1 != (readWhere = dis.read(buff))) {
                fos.write(buff, 0, readWhere);
            }
            fos.close();
            dis.close();
            client.close();
            System.out.println("已接收 储存在:"+filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
