package IO_Exer;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * 1.利用File构造器，new 一个文件目录file
 * 1)在其中创建多个文件和目录
 * 2)编写方法，实现删除file中 指定文件的操作
 * 2.判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 *      String[] file=file.List();
 *      for(String s:list){
 *          if(s.endsWith(".jpg)){
 *              System.out.println(s);
 *          }
 *      }
 * 3.遍历指定目录所有文件名称，包括子文件目录中的文件。
 * 拓展1:并计算指定目录占用空间的大小.
 * 拓展2:删除指定文件目录及其下的所有文件
 * @author:superherozhang
 * @create:2022-03-16 10:59
 */
public class FileDemo {
    /*
    *  1.利用File构造器，new 一个文件目录file
     * 1)在其中创建多个文件和目录
     * 2)编写方法，实现删除file中 指定文件的操作
    * */
    @Test
    public void test1() throws IOException {
        File file=new File("C:\\Users\\张先森\\IdeaProjects\\io\\hello.txt");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File destFile=new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("创建成功！");
        }
        if(destFile.exists()){
            destFile.delete();
            System.out.println("删除成功！");
        }
    }
    /*
     * 3.遍历指定目录所有文件名称，包括子文件目录中的文件。
     * 拓展1:并计算指定目录占用空间的大小.
     * 拓展2:删除指定文件目录及其下的所有文件*/
    public static void main(String[] args){
       //递归：文件目录
        /** 打印出指定目录所有文件名称，包括子文件目录中的文件  **/

        //1.创建目录对象
        File file=new File("C:\\Users\\张先森\\IdeaProjects\\JavaSenior");

        //2.打印目录的子文件
        printSubFile(file);
    }
    //方式一：递归实现
    public static void printSubFile(File dir){
        //打印目录的子文件
        File[] subFiles=dir.listFiles();

        for(File f:subFiles){
            if(f.isDirectory()){//文件目录
                printSubFile(f);
            }else{//文件
                f.getAbsolutePath();
            }
        }
    }
    //方式二：循环实现
    //循环实现
    //列出file目录的下级内容，仅列出一级的话，使用File类的String[] list()比较简单
    public void listSubFiles(File file){
        if(file.isDirectory()){
            String[] list = file.list();
            for(String s:list){
                System.out.println(s);
            }
        }else{
            System.out.println(file);
        }
    }
    //列出file目录的下级，如果它的下级还是目录，接着列出下级的下级，依此类推。
    //建议使用File类的File[] listFiles()
    public void listAllFiles(File file){
        if(file.isFile()){
            System.out.println(file);
        }else{
            File[] all=file.listFiles();
            //如果arr[i]是文件，直接打印
            //如果arr[i]是目录，接着再获取它的下一级
            for(File f:all){
                listAllFiles(f);//递归调用：自己调用自己的函数
            }
        }
    }
}
