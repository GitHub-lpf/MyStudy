package lpf.study.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCopy {

    // 文件的简单拷贝
    public static void copy() throws Exception {

        FileInputStream in = new FileInputStream("d:/abc.txt");
        FileOutputStream out = new FileOutputStream("d:/abc1.txt");

        byte[] buf = new byte[1024];
        int len = -1;
        while((len = in.read(buf))!=-1){
            out.write(buf,0,len);
        }
        if(out!=null) out.close();
        if(in!=null) in.close();

    }

    public static void main(String[] args) throws Exception {
        copy();
    }

}
