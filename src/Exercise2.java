import java.io.File;
import java.util.Arrays;

/*
   File类

   File类用于封装一个路径，可以是绝对路径，也可以是相对路径。
           内部封装的路径可以指向一个文件，也可以指向一个目录

 */
public class Exercise2 {
    public static void main(String[] args) {
        File file=new File("破晓.txt");
        System.out.println("文件名称"+file.getName());
        System.out.println("相对路径"+file.getPath());
        System.out.println("绝对路径"+file.getAbsolutePath());
        System.out.println(file.canRead()?"文件可读":"文件不可读");
        System.out.println(file.lastModified());
        System.out.println(file.length());
        System.out.println();

        //遍历指定位置下的目录
        File one=new File("F:\\Code");
        if(one.isDirectory()){
            String[] a=one.list();
            Arrays.stream(a)
                    .forEach(f-> System.out.println(f));
        }
        //遍历指定目录下.txt文件
        File two =new File("F:\\Code\\2019-10-21");
        if(two.isDirectory()){
            String []a=two.list(
                    ((dir, name) -> name.endsWith(".txt"))
            );
            Arrays.stream(a).forEach(f-> System.out.println(f));
        }
        //遍历指定目录下的文件
        File tools=new File("F:\\Code");
        long begin=System.currentTimeMillis();
        fileDir(tools);
        long end=System.currentTimeMillis();
        System.out.println("花费时间"+(end-begin)+"ms");


        //删除文件及目录
        File wj=new File("D:\\新建文件夹");
        delectDir(wj);

    }

    private static void delectDir(File wj) {
        File[]list=wj.listFiles();
        for(File files:list){
            if(files.isDirectory()){
                delectDir(files);
            }
            files.delete();
        }
        wj.delete();
    }

    private static void fileDir(File tools) {
        File[] list = tools.listFiles();
        for (File files : list) {
            if (files.isDirectory()) {
                fileDir(files);
            }
            //System.out.println(files);
        }
    }


}
