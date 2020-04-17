package lpf.study.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class InetAddressAndURLTest {


    public static void testInetAddress(){
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);// PC-20180429MDBK/192.168.2.2
            System.out.println(localHost.getHostName());//PC-20180429MDBK
            System.out.println(localHost.getHostAddress());//192.168.2.2

            InetAddress Name163 = InetAddress.getByName("www.163.com");
            System.out.println(Name163); //www.163.com/125.44.162.20

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void testURL(){
        InputStream in = null;
        FileOutputStream out =null;
        try {
            URL url = new URL("http://www.163.com");
            URLConnection connection = url.openConnection();
            in =  connection.getInputStream();
            out = new FileOutputStream("d:/163.html");
            byte[] buf = new byte[1024];
            int len =-1;
            while((len = in.read(buf))!=-1){
                out.write(buf,0,len);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out!=null)out.close();
                if(in!=null)in.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        testInetAddress();
        testURL();
    }

}
