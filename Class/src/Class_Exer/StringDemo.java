package Class_Exer;

/**
 * @author:superherozhang
 * @create:2022-03-10 8:54
 */
public class StringDemo {
    String str=new String("good");
    char[] ch={'t','e','s','t'};

    public void change(String str,char ch[]){
        str="tesk ok";
        ch[0]='b';
    }

    public static void main(String[] args) {
        StringDemo demo=new StringDemo();
        demo.change(demo.str,demo.ch);
        System.out.println(demo.str+"and");
        System.out.println(demo.ch);
    }
}

