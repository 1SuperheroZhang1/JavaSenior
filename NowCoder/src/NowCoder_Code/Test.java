package NowCoder_Code;

/**
 * @author superherozhang
 * @create 2022-03-24 17:36
 */
//public class Test {
//    public static void main(String[] args) {
//        Thread t = new Thread() {
//
//            public void run() {
//                my360DW();
//            }
//        };
//
//        t.run();
//        System.out.print("DW");
//
//    }
//
//    static void my360DW() {
//
//        System.out.print("360");
//
//    }
//}
//public class Test{
//    public static void main(String[] args){
//        Object o=new Object(){
//            public boolean equals(Object obj){
//                return true;
//            }
//        };
//        System.out.println(o.equals("Fred"));
//    }
//}
//public class Test {
//    static String x="1";
//    static int y=1;
//    public static void main(String args[]) {
////        static int z=2;//err - static不能修饰局部变量
//        System.out.println(x+y+z);
//    }
//}
//public class Test {
//    public static void main(String args[]) {
//        int i = 0;
//        i = i++ + i;
//        System.out.println("I =" +i);
//    }
//}
//public class Test{
//    public static void main(String[] args){
//        System.out.print(getNumber(0));
//        System.out.print(getNumber(1));
//        System.out.print(getNumber(2));
//        System.out.print(getNumber(4));
//    }
//
//    public static int getNumber(int num){
//        try{
//            int result = 2 / num;
//            return result;
//        }catch (Exception exception){
//            return 0;
//        }finally{
//            if(num == 0){
//                return -1;
//            }
//            if(num == 1){
//                return 1;
//            }
//        }
//    }
//}

//public class Test{
//    public static void main(String[] args) {
//        int a = 10;
//        System.out.println(a++ + a--);//21
//    }
//}

//public class Test {
//    public static void main(String args[]) {
//        String s = "祝你考出好成绩！";
//        System.out.println(s.length());//8
//    }
//}
//public class Test{
//    public static void main(String args[])throws InterruptedException{
//        Thread t=new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.print("2");
//            }
//        });
//        t.start();
//
//        t.join();
//        System.out.print("1");
//    }
//}
//public class Test
//{
//    public static void main(String[] args)
//    {
//        Integer n1 = new Integer(47);
//        Integer n2 = new Integer(47);
//        System.out.print(n1 == n2);//false
//        System.out.print(",");
//        System.out.println(n1 != n2);//true
//    }
//}
//class Base
//{
//    public void method()
//    {
//        System.out.println("Base");
//    }
//}
//class Son extends Base
//{
//    public void method()
//    {
//        System.out.println("Son");
//    }
//
//    public void methodB()
//    {
//        System.out.println("SonB");
//    }
//}
//public class Test
//{
//    public static void main(String[] args)
//    {
//        Base base = new Son();
//        base.method();
////        base.methodB();//err - Base类中没有methodB方法，编译不通过。
//    }
//}
//public class Test{
//    public static void main(String args[]) {
//        Thread t=new Thread(){
//            public void  run(){
//                dianping();
//
//            }
//        };
//        t.run();
//        System.out.print("dazhong");
//    }
//    static void dianping(){
//        System.out.print("dianping");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        String s1 = "HelloWorld";
//        String s2 = new String("HelloWorld");
//        if (s1 == s2) {
//            System.out.println("s1 == s2");
//        } else {
//            System.out.println("s1 != s2");
//        }
//        if (s1.equals(s2)) {
//            System.out.println("s1 equals s2");
//        } else {
//            System.out.println("s1 not equals s2");
//        }
//    }
//}
//public class Test{
//
//    float func1()
//    {
//    int i=1;
//    return;
//    }
//    float func2()
//    {
//    short i=2;
//    return i;
//    }
//    float func3()
//    {
//    long i=3;
//    return i;
//    }
//    float func4()
//    {
//    double i=4;
//    return i;
//    }
//}
//
//class Parent {
//
//    private int data;
//
//    public Parent(int d){ data = d; }
//
//}
//
//class Child extends Parent{
//
//    String name;
//
//    public Child(String s, int d){
//                super(d);
//                name = s;
//
//    }
//
//}
//
//public class Test{
//    public static void main(String[] args) {
//        Child child = new Child("John", 10);
//
//
//        System.out.println(child.);
//    }
//}

//public class Test{
//    static int arr[] = new int[5];
//    public static void main(String a[]){
//        System.out.println(arr[0]);//0
//    }
//
//}

//public class Test{
//    private String name = "Person";
//    int age=0;
//}
//public class Child extends Test{
//    public String grade;
//    public static void main(String[] args){
//        Test p = new Child();
//        System.out.println(p.name);//err  java: 类Child是公共的, 应在名为 Child.java 的文件中声明
//    }
//}
//class DataObject implements Serializable {
//    private static int i=0;
//    private String word=" ";
//    public void setWord(String word){
//        this.word=word;
//    }
//    public void setI(int i){
//        Data0bject.i=i;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        DataObject object=new Data0bject();
//        object.setWord("123");
//        object.setI(2);
//    }
//    }
//public class Test{
//    public static void main(String[] args) {
//        System.out.println(val());
//    }
//
//    public static int val() {
//        int num = 5;
//        try {
//            num = num / 0;
//        } catch (Exception e) {
//            num = 10;
//        } finally {
//            num = 15;
//        }
//        return num;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Object o1 = true ? new Integer(1) : new Double(2.0);
//        Object o2;
//        if (true) {
//            o2 = new Integer(1);
//        } else {
//            o2 = new Double(2.0);
//        }
//        System.out.print(o1);//1.0
//        System.out.print(" ");
//        System.out.print(o2);//2
//    }
//}
//import java.util.Date;
//public class Test extends Date{
//    private static final long serialVersionUID = 1L;
//    private void test(){
//        System.out.println(super.getClass().getName());
//    }
//
//    public static void main(String[]args){
//        new Test().test();
//    }
//}
//class Supper{
//    public int get()
//    {
//        System.out.println("Supper");
//        return 5;
//    }
//}
//public class Test{
//    public int get()
//    {
//        System.out.println("Sub");
//        return new Integer("5");          }
//    public static void main(String args[]) {
//        new Supper().get();
//        new Test().get();          }
//}
//public class Test{
//    public static void main(String[] args) {
//        byte a1 = 2, a2 = 4, a3;
//        short s = 16;
////        a2 = s;//err
////        a3 = a1 * a2;//err
//
////        int i=0;
////        Integer j = new Integer(0);
////        System.out.println(i==j);//true
////        System.out.println(j.equals(i));//true
//
//        int a =100,b=50,c=a---b,d=a---b;
//        System.out.println(a);//98
//        System.out.println(b);//50
//        System.out.println(c);//50
//        System.out.println(d);//49
//    }
//}
//class Foo {
////    final int i;//Variable 'i' might not have been initialized
//    int j;
//    public void doSomething() {
//        System.out.println(++j + i);
//    }
//}
//
//public class Test{
//    public static void main(String[] args) {
//        Foo f=new Foo();
//        f.doSomething();
//    }
//}
//interface Com{
//    int M=200;
//    int f();
//}
//class ImpCom implements Com{
//     public int f(){
//         return 100+M;
//     }
////     int f()
////     {
////         return 100;
////     }
//}
//public class Test {
//    public static void main(String args[]) {
//        String s = "祝你考出好成绩！";
//        System.out.println(s.length());//8
//    }
//}
//public class Test{
//    public static void main(String args[]) {
//        //14 - 1110
//        //3  - 0011
//     // 14^3 - 1101
//        System.out.println(14^3);//13
//    }
//}
//public class Test{
//    String str=new String("tarena");
//    char[]ch={'a','b','c'};
//    public static void main(String args[]){
//        Test ex=new Test();
//        ex.change(ex.str,ex.ch);
//        System.out.print(ex.str+" and ");
//        System.out.print(ex.ch);
//    }
//    public void change(String str,char ch[]){
//        //引用类型变量，传递的是地址，属于引用传递。
//        str="test ok";
//        ch[0]='g';
//    }
//}
//public class Test{
//    public static void main(String[] args){
//        Double x=1.2;
//        long l = 1.2;//err
//        float f =  x/l;//err
//        System.out.println(f);
//    }
//}
//public class Test{
//    public static boolean isAdmin(String userId){
//        return userId.toLowerCase()=="admin";
//    }
//    public static void main(String[] args){
//        System.out.println(isAdmin("Admin"));//false
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        int Arry_a[] = new int[10];
//        System.out.println(Arry_a[10]);//ArrayIndexOutOfBoundsException
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Boolean flag = false;
//        if(flag = true){//"="为赋值运算符
//            System.out.println("true");//true
//        }else{
//
//            System.out.println("false");
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Integer integ =new Integer(9);
//        boolean b = integ  instanceof  Object;
//        System.out.println(b);//true
//        int x=20, y=5;
//        System.out.println(x+y +""+(x+y)+y);//25255
//
//    }
//}
//public class Test{
//    public static void main(String[] args){
//        String s;
////        System.out.println("s="+s);//s未被初始化
//    }
//}
//public class Test extends Thread{
//    public static void main(String argv[]){
//        Test b = new Test();
//        b.run();
//    }
//    public void start(){
//        for(int i=0;i<10;i++){
//            System.out.println("Value of i = "+i);//0~9
//        }
//    }
//}
//}
//public class Test {
//    long var;
//    public void MyClass(long param) { var = param; }//(1)
//    public static void main(String[] args) {
//        Test a, b;
//        a =new Test();//(2)
////        b =new Test(5);//(3)//err - 没有定义构造器
//        int x=1;
//        float y=2;
//        System.out.println(x / y);
//    }
//}
//public class Test{
//        public static void main(String [] args){
//            float f=42.0f;
//            float f1[]=new float[2];
//            float f2[]=new float[2];
//            float[] f3=f1;
//            long x=42;
//            f1[0]=42.0f;
//
//            System.out.println(f1 == f2);//false
//            System.out.println(x == f1[0]);//true
//            System.out.println(f1 == f3);//true
////            System.out.println(f2 == f1[1]);//err
//        }
//}
//public class Test{
//    public static void main(String args[]){
//        System.out.println(100%3);//1
//        System.out.println(100%3.0);//1.0
//    }
//}
//}
//public class Test{
//    public static void main(String[] args) {
//        byte b = (byte)129;
//        System.out.println(b);//-127
//        long test=012;
//        float f=-412;
////        int other=(int)false;//err
//        double d=0x12345678;
////        byte b1=128;//err
//    }
//}
//public class Test
//{
//    public int i;
//    static String s;
//    void method1(){}
//    static void method2(){}
//
//    public static void main(String[] args) {
//        Test t=new Test();
//        System.out.println(t.i);
//        t.method1();
//        Test.method2();
//    }
//}
//}
//public class Test{
//        public static void main ( String arg[] ) {
//            String x="fmn";
//            x.toUpperCase();
//            String y=x.replace('f','F');
//            y=y+"wxy";
//            System.out.println(y);//Fmnwxy
//        }
//}

//public class Test{
//    public boolean returnTest()
//    {
//        try
//        {
//            return true;
//        }
//        catch (Exception e)
//        {
//
//        }
//        finally
//        {
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        Test t=new Test();
//        boolean b = t.returnTest();
//        System.out.println(b);//false
//    }
//}
//public class Test
//{
//    private List names = new ArrayList();
//    public synchronized void add(String name)
//    {
//        names.add(name);
//    }
//    public synchronized void printAll() {
//        for (int i = 0; i < names.size(); i++)
//        {
//            System.out.print(names.get(i) + "");
//        }
//    }
//
//    public static void main(String[]args)
//    {
//        final Test sl = new Test();
//        for (int i = 0; i < 2; i++)
//        {
//            new Thread()
//            {
//                public void run()
//                {
//                    sl.add("A");
//                    sl.add("B");
//                    sl.add("C");
//                    sl.printAll();
//                }
//            } .start();
//        }
//    }
//}

//public class Test{
//    private static final String MESSAGE="taobao";
//    public static void main(String [] args) {
//        String a ="tao"+"bao";
//        String b="tao";
//        String c="bao";
//        System.out.println(a==MESSAGE);//true
//        System.out.println((b+c)==MESSAGE);//false
//    }
//}
//class A{
//    public final int a(){
//        return 1;
//    }
//    public final int a(int a){//final修饰的方法可以重载，不能被重写
//        return 0;
//    }
//}
//class Base {
//    Base() {
//        System.out.print("Base");
//    }
//}
//public class Test extends Base {
//    public static void main( String[] args ) {
//        new Test();
//        //调用父类无参的构造方法
//        new Base();
//    }
//}

//public class Test{
//    public static void main(String[] args) {
//        String s1=new String("xyz");
//        String s2=new String("xyz");
//        Boolean b1=s1.equals(s2);//true
//        Boolean b2=(s1==s2);//false
//        System .out.print(b1+ "" +b2);//true false
//    }
//}

//public class Test
//{
//    public void method()
//    {
//        try
//        {
//            System.out.println("进入到try块");
//        }
//        catch (Exception e)
//        {
//            System.out.println("异常发生了！");
//        }
//        finally
//        {
//            System.out.println("进入到finally块");
//        }
//        System.out.println("后续代码");
//    }
//    public static void main(String[] args)
//    {
//        Test test = new Test();
//        test.method();//进入到try块->进入到finally块->后续代码
//    }
//}

//public class Test{
//    public static void main(String[] args) {
////        int t1 = 2, t2 = 3, t3;
////        t3 = t1 < t2 ? t1 : (t2 + t1);
////        System.out.println(t3);//2
//
////        int b[][]={{1}, {2, 2}, {2, 2, 2}};
////        int sum = 0;
////
////        for(int i = 0; i < b.length; i++) {
////            for(int j = 0; j < b[i].length; j++) {
////                sum += b[i][j];
////            }
////        }
////        System.out.println(sum);//11
//
////        int x = 1 , y = 2 , z = 3;
////        y += z-- / ++x;
////        System.out.println(y);//3
//
//        double d=-5 + 1/4 + 2*-3 + 5.0;
//        System.out.println(d);//-6.0
//    }
//}

//public class Test {
//    public static void main(String[] args) {
//        System.out.println("return value of getValue(): " + getValue());//return value of getValue(): 5
//    }
//    public static int getValue() {
//        int i = 1;
//        try {
//            i = 4;
//        } finally{
//            i++;
//            return i;//5
//        }
//    }
//}

//class Test{
//    private static int x = 100;
//    public static void main(String args[ ]){
//        Test hs1 = new Test();
//        hs1.x++;
//        Test hs2 = new Test();
//        hs2.x++;
//        hs1=new Test();
//        hs1.x++;
//        Test.x--;
//        System.out.println( "x=" +x);//102
//    }
//}

//public class Test{
//    public static void main(String[] args) {
//        String a="My field1";
//        String b="My field1";
//        String c=new String("My field1");
//        String d=new String("My field1");
//
//        System.out.println(a == b);//true
//        System.out.println(a == c);//false
//        System.out.println(c = d);//My field1
//        System.out.println(a.equals(b));//true
//        System.out.println(a.equals(c));//true
//    }
//}

//public class Test{
//    public static void main(String args[]) {
//        Thread t = new Thread() {
//            public void run() {
//                pong();
//            }
//        };
//        t.run();
//        System.out.print("ping");
//    }
//    static void pong() {
//        System.out.print("pong");
//    }
//
//}


//public class Test {
//    public static void main(String[] args) {
//        Father a = new Father();
//        Father b = new Child();
//    }
//}
//class Father {
//    public Father() {
//        System.out.println("我是父类");
//    }
//}
//class Child extends Father {
//    public Child() {
//        System.out.println("我是子类");
//    }
//}

//public class Test{
//    public static void main(String[] args) {
//        int value;
//        value=2;
//        System.out.println(value);//2
//        System.out.println(value++);//2
//        System.out.println(value);//3
//    }
//}

//public class Test{
//    public static void main(String[] args) {
//        Thread[] ths=new Thread[3];
//        for (int i = 0; i < 3; i++) {
//            ths[i]=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int j = 0; j < 5; j++) {
//                        System.out.print(j);
//                    }
//                    System.out.println();
//                }
//            });
//        }
//        for(Thread th:ths){
//            th.start();
//        }
//    }
//}

//class A {
//    public int func1(int a, int b) {
//        return a - b;
//    }
//}
//class B extends A {
//    public int func1(int a, int b) {
//        return a + b;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        A a = new B();
//        B b = new B();//编译看左边，运行看右边
//        System.out.println("Result=" + a.func1(100, 50));//150
//        System.out.println("Result=" + b.func1(100, 50));//150
//    }
//}

//class B extends Object
//{
//    static
//    {
//        System.out.println("Load B");
//    }
//    public B()
//    {
//        System.out.println("Create B");
//    }
//}
//class A extends B
//{
//    static
//    {
//        System.out.println("Load A");
//    }
//    public A()
//    {
//        System.out.println("Create A");
//    }
//}
//
//public class Test
//{
//    public static void main(String[] args)
//    {
//        new A();
//        /*
//                代码执行顺序：父类静态代码块>子类静态代码块>父类构造方法>子类构造方法
//        *   Load B
//            Load A
//            Create B
//            Create A
//        * */
//    }
//}


//class Test{
//    static int x=10;
//    static {
//        x+=5;
//    }
//    public static void main(String args[ ]){
//        System.out.println("x="+x);//5
//    }
//    static { x/=3;}
//}

public class Test{
    public static void main(String[] args) {
        int x=20, y=30;
        boolean b;
        b = x > 50 && y > 60 || x > 50 && y < -60 || x < -50 && y > 60 || x < -50 && y < -60;
        System.out.println(b);//false
    }
}