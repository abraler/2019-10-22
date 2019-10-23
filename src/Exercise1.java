import java.io.*;

/*1.转换流
前面I/O流可以分为字节流和字符流，有时候字节流和字符流之间也需要之间进行转换，在JDK中提供了两个类
直接将实现字节流转换为字符流
InputStreamReader,他是Reader的子类，可以将字节输入流转换为字符输入流，方便直接读取字符
outputStreamReader，他是Writer的子类，可以将字节输出流转换为字符输出流，方便直接写入字符
下面的程序实现了字节流转换为字符流的拷贝
但是需要注意，转换流只支持对文本文件的拷贝，如果进行字节码文件时，就会有数据的丢失
这个文件下   副本.txt是文本文件的拷贝，文件正常拷贝
               副本.jpg是字节码文件的拷贝，文件出现问题



 */
public class Exercise1{
    public static void main(String[] args) throws Exception{
        //FileInputStream in=new FileInputStream("zrn.jpg");
        FileInputStream in=new FileInputStream("将进酒.txt");
        InputStreamReader ina=new InputStreamReader(in);//将字节输入流对象转为字符输入流对象
        BufferedReader str=new BufferedReader(ina);
        //FileOutputStream out=new FileOutputStream("副本.jpg");
        FileOutputStream out=new FileOutputStream("副本.txt");
        OutputStreamWriter outa=new OutputStreamWriter(out);
        BufferedWriter Str1=new BufferedWriter(outa);
        String p=null;
        while((p=str.readLine())!=null){
            Str1.write(p);
            Str1.newLine();
        }
        str.close();
        Str1.close();
    }
}
