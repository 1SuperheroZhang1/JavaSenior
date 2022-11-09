package NowCoder_Code;//public class HelloWorld {
//    public static void main(String[] args) {
//        System.out.println("Hello,World");
//    }
    //    public static void main(String[] args) {
//        Integer a = 1;
//        Integer b = 1;
//        Integer c = 500;
//        Integer d = 500;
//        System.out.print(a == b);//true
//        System.out.print(c == d);//false --->-128~127
//    }
//        public static void main(String[] args)
//        {
//            char myChar = 'g';
//            String myStr = Character.toString(myChar);
//            System.out.println("String is: "+myStr);//g
//            myStr = String.valueOf(myChar);
//            System.out.println("String is: "+myStr);//g
//        }
//        public static void main(String[] args) {
//            HelloWorld inc = new HelloWorld();
//            int i = 0;
//            inc.fermin(i);
//            i= i ++;
//            System.out.println(i);
//
//        }
//        void fermin(int i){
//            i++;
//        }
//
//    public int aMethod(){
//        static int i = 0;
//        i++;
//        return i;
//    }
//    public static void main(String args[]){
//        HelloWorld test = new HelloWorld();
//        test.aMethod();
//        int j = test.aMethod();
//        System.out.println(j);
//    }
//
//    }
//public class Test
//{
//    public static Test t1 = new Test();
//    {
//        System.out.println("blockA");
//    }
//    static
//    {
//        System.out.println("blockB");
//    }
//    public static void main(String[] args)
//    {
//        Test t2 = new Test();
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        int result = getValue(2);
//        System.out.println(result);
//    }
//    public static int getValue(int i) {
//        int result = 0;
//        switch (i) {
//            case 1:
//                result = result + i;
//            case 2:
//                result = result + i * 2;
//            case 3:
//                result = result + i * 3;
//        }
//        return result;
//    }
//}
//enum AccountType
//{
//    SAVING, FIXED, CURRENT;
//    private AccountType()
//    {
//        System.out.println("It is a account type");
//    }
//}
//class EnumOne
//{
//    public static void main(String[]args)
//    {
//        System.out.println(AccountType.FIXED);
//    }
//}
//class C {
//    C() {
//        System.out.print("C");
//    }
//}
//
//class A {
//    C c = new C();
//
//    A() {
//        this("A");
//        System.out.print("A");
//    }
//
//    A(String s) {
//        System.out.print(s);
//    }
//}
//
//class Test extends A {
//    Test() {
//        super("B");
//        System.out.print("B");
//    }
//
//    public static void main(String[] args) {
//        new Test();
//    }
//}
//class Value{
//    public int i=15;
//}
//public class Test{
//    public static void main(String argv[]){
//        Test t=new Test( );
//        t.first( );
//    }
//
//    public void first( ){
//        int i=5;
//        Value v=new Value( );
//        v.i=25;
//        second(v,i);
//        System.out.println(v.i);//20
//    }
//
//    public void second(Value v,int i){
//        i = 0;
//        v.i = 20;
//        Value val = new Value( );
//        v = val;
//        System.out.println(v.i+" "+i);//15 0
//    }
//}
//class A{
//    public A foo() {
//        return this;
//    }
//}
//class B extends A {
//    public A foo(){
//        return this;
//    }
//}
//class Test extends B {
//    public A foo(B b){
//        return b;
//    }
//
//}
//public class Test {
//    public static void main(String[] args) {
//        split(12);
//    }
//    public static int split(int number) {
//        if (number > 1) {
//            if (number % 2 != 0)
//                System.out.print(split((number + 1) / 2));
//            System.out.print(split(number / 2));
//        }
//        return number;
//    }
//}
//public class Test extends Thread{
//    @Override
//
//    public void run(){
//
//        try {
//
//            Thread.sleep(1000);
//
//        } catch (InterruptedException e){
//
//            e.printStackTrace();
//
//        }
//
//        System. out .print( "run" );
//
//    }
//
//    public static void main(String[] args){
//
//        Test test= new Test();
//
//        test.run();
//
//        System. out .print( "main" );
//
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        TreeSet<Integer> set = new TreeSet<Integer>();
//        TreeSet<Integer> subSet = new TreeSet<Integer>();
//        for(int i=606;i<613;i++){
//            if(i%2==0){
//                set.add(i);
//            }
//        }
//        subSet = (TreeSet)set.subSet(608,true,611,true);
//        set.add(609);
//        System.out.println(set+" "+subSet);
//    }
//}
//
//public class Test {
//    public static void main(String args[]) {
//        int x = -5;
//        int y = -12;
//        System.out.println(y % x);
//    }
//}
//public class Test{//1
//    public static void main(String[] args) {//2
//        System.out.println("value="+switchit(4));//3
//    }//4
//    public static int switchit(int x) {
//        int j=1;
//        switch (x) {
//            case 1:j++;
//            case 2:j++;
//            case 3:j++;
//            case 4:j++;
//            case 5:j++;
//            default:j++;
//        }
//        return j+x;
//    }
//}
//public class Test {
//    public static void main(String args[]) {
//        int i = -5;
//        i =  ++(i++);//err
//        System.out.println(i);
//    }
//}
//public class Test{
//    public static void main(String[] args){
//        new Test().go();
//    }
//    public void go(){
//        Runnable r=new Runnable(){
//            public void run(){
//                System.out.print("foo");
//            }
//        };
//        Thread t=new Thread(r);
//        t.start();
//    }
//}
//public class Test {
//    private String name = "abc";
//    public static void main(String[] args) {
//        Test test = new Test();
//        Test testB = new Test();
//        String result = test.equals(testB) + ",";
//        result += test.name.equals(testB.name) + ",";
//        result += test.name == testB.name;
//        System.out.println(result);
//    }
//}
//public class Test
//{
//    public static void main(String[] args) {
//        Test t=new Test();
//        t.test();
//    }
//    public void add(Byte b)
//    {
//        b = b++;
//    }
//    public void test()
//    {
//        Byte a = 127;
//        Byte b = 127;
//        add(++a);
//        System.out.print(a + " ");
//        add(b);
//        System.out.print(b + "");
//    }
//}
//public class Test{
//    private static int i=1;
//    public int getNext(){
//        return i++;
//    }
//    public static void main(String [] args){
//        Test test=new Test();
//        Test testObject=new Test();
//        test.getNext();
//        testObject.getNext();
//        System.out.println(testObject.getNext());
//    }
//}

//class Test1 {
//    public static void hello() {
//        System.out.println("hello");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        Test1 t=null;
//        t.hello();
//    }
//}

//class ThreadTest
//{
//    private int data;
//    int result = 0;
//    public void m()
//    {
//        result += 2;
//        data += 2;
//        System.out.print(result + "  " + data);
//    }
//}
//class ThreadExample extends Thread
//{
//    private ThreadTest mv;
//    public ThreadExample(ThreadTest mv)
//    {
//        this.mv = mv;
//    }
//    public void run()
//    {
//        synchronized(mv)
//        {
//            mv.m();
//        }
//    }
//}
//class  Test
//{
//    public static void main(String args[])
//    {
//        ThreadTest mv = new ThreadTest();
//        Thread t1 = new ThreadExample(mv);
//        Thread t2 = new ThreadExample(mv);
//        Thread t3 = new ThreadExample(mv);
//        t1.start();
//        t2.start();
//        t3.start();
//    }
//}

//public class Test{
//    public static synchronized void main(String[] a){
//        Thread t=new Thread(){
//            public void run(){Sogou();}
//        };
//        t.run();
//        System.out.print("Hello");
//    }
//    static synchronized void Sogou(){
//        System.out.print("Sogou");
//    }
//}



//public class Test{
//    static boolean Paddy;
//    public static void main(String args[]){
//        System.out.println(Paddy);
//    }
//}

//class Test{
//    public static void main(String[] args) {
//        Integer i = 42;
//        Long l = 42l;
//        Double d = 42.0;
//
////        System.out.println(i == l);
////        System.out.println(i == d);
////        System.out.println(l == d);
//        System.out.println(i.equals(d));//false
//        System.out.println(d.equals(l));//false
//        System.out.println(i.equals(l));//false
//        System.out.println(l.equals(42L));//true
//
//    }
//}
//class Car extends Vehicle
//{
//    public static void main (String[] args)
//    {
//        new  Car(). run();
//    }
//    private final void run()
//    {
//        System. out. println ("Car");
//    }
//}
//class Vehicle
//{
//    private final void run()
//    {
//        System. out. println("Vehicle");
//    }
//}
//public class Test{
//    String str = new String("good");
//    char[ ] ch = { 'a' , 'b' , 'c' };
//    public static void main(String args[]){
//        Test ex = new Test();
//        ex.change(ex.str,ex.ch);
//        System.out.print(ex.str + " and ");
//        System.out.print(ex.ch);
//    }
//    public void change(String str,char ch[ ]){
//        str = "test ok";
//        ch[0] = 'g';
//    }
//}
//public class Test {
//    class Super {
//
//        int flag = 1;
//
//        Super() {
//            test();
//        }
//
//        void test() {
//            System.out.println("Super.test() flag=" + flag);
//        }
//    }
//    class Sub extends Super {
//
//        Sub(int i) {
//            flag = i;
//            System.out.println("Sub.Sub()flag=" + flag);
//        }
//        void test() {
//            System.out.println("Sub.test()flag=" + flag);
//        }
//    }
//    public static void main(String[] args) {
//        new Test().new Sub(5);
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        StringBuffer s1=new StringBuffer(10);
//        s1.append("1234");
//        System.out.println(s1.length());//4
//        System.out.println(s1.capacity());//10
//    }
//}
//interface B{
//
//}
//public class Test{
//    static boolean out(char c){
//        System.out.print(c);
//        return true;
//    }
//    public static void main(String[] argv){
//        int i = 0;
//        for(out('A');out('B') && (i<2);out('C')){
//            i++;
//            out('D');
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        java.util.HashMap map=new java.util.HashMap();
//        map.put("name",null);
//        map.put("name","Jack");
//        System.out.println(map.size());// 1
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        int i = 3;
//        String result = new String();
//        switch (i) {
//            case 1:
//                result = result + "him ";
//            case 2:
//                result = result + "her ";
//            case 3:
//                result = result + "it ";
//            default:
//                result = result + "me ";
//        }
//        System.out.println(result);
//    }
//}
//public class Test {
//    //precondition:  x >=0
//    public void mystery (int x)
//    {
//        System.out.print(x % 10);
//
//        if ((x / 10) != 0)
//        {
//            mystery(x / 10);
//        }
//        System.out.print(x % 10);
//    }
//    public static void main(String[] args) {
//        Test t=new Test();
//        t.mystery(1234);
//    }
//}
//public class Test{
//    static int i;
//    public static void main(String argv[]){
//        System.out.println(i);
//    }
//}
//public class Test
//{
//    public static void main(String args[])
//    {
//        int a;
//        a = 6;
//        System.out.print(a);//6
//        System.out.print(a++);//6
//        System.out.print(a);//7
//    }
//}
//class BaseClass {
//    public BaseClass() {}
//
//    {
//        System.out.println("I’m BaseClass class");//③
//    }
//
//    static {
//        System.out.println("static BaseClass");//①
//    }
//}
//
//public class Test extends BaseClass {
//    public Test() {}
//
//    {
//        System.out.println("I’m Base class");//④
//    }
//
//    static {
//        System.out.println("static Base");//②
//    }
//
//    public static void main(String[] args) {
//        new Test();//①->②->③->④
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        try{//在try块中可以抛出异常
//            throw new RuntimeException("输入错误");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//}
//}
//public class Test {
//    public static void main(String[] args) {
//        String str = "hello world";
//
//        int strlen=str.length();
////        str=100;
////        str+='          a';
//        str=str+100;
//    }
//}
//public class Test extends HelloA
//{
//    public Test()
//    {
//    }
//    {
//        System.out.println("I’m B class");
//    }
//    static
//    {
//        System.out.println("static B");
//    }
//    public static void main(String[] args)
//    {
//        new Test();
//    }
//}
//class HelloA
//{
//    public HelloA()
//    {
//    }
//    {
//        System.out.println("I’m A class");
//    }
//    static
//    {
//        System.out.println("static A");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        double d1=-0.5;
//        System.out.println("Ceil d1="+Math.ceil(d1));
//        System.out.println("floor d1="+Math.floor(d1));
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        String a = new String("myString");
//        String b = "myString";
//        String c = "my" + "String";
//        String d = c;
//        System.out.print(a == b);//false
//        System.out.print(a == c);//false
//        System.out.print(b == c);//true
//        System.out.print(b == d);//true
//    }
//}
//public class Test
//{
//    static boolean foo(char c)
//    {
//        System.out.print(c);
//        return true;
//    }
//    public static void main( String[] argv )
//    {
//        int i = 0;
//        for ( foo('A'); foo('B') && (i < 2); foo('C'))
//        {
//            i++ ;
//            foo('D');
//        }
//    }
//}
//public class Test
//{
//    public static int x;
//    public static void main(String []args)
//    {
//        System. out. println("Value is " + x);//0
//    }
//}
//public class Test
//{
//    public static String output = "";
//    public static void foo(int i)
//    {
//        try
//        {
//            if (i == 1)
//            {
//                throw new Exception();
//            }
//        }
//        catch (Exception e)
//        {
//            output += "2";
//            return ;
//        } finally
//        {
//            output += "3";
//        }
//        output += "4";
//    }
//    public static void main(String[] args)
//    {
//        foo(0);
//        foo(1);
//        System.out.println(output);
//    }
//}
//}
//class Chinese{
//    private static Chinese objref =new Chinese();
//    private Chinese(){}
//    public static Chinese getInstance() { return objref; }
//}
//
//public class Test {
//    public static void main(String [] args) {
//        Chinese obj1 = Chinese.getInstance();
//        Chinese obj2 = Chinese.getInstance();
//        System.out.println(obj1 == obj2);
//    }
//}
//}
//public class Test {
//    public static void main(String[] args) {
//        int a[ ][ ] = {{1, 2}, {3, 4}, {5, 6}};
//
//        System.out.println(a[1][1]);
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Runnable runner=new Runnable() {
//            @Override
//            public void run() {
//                System.out.print("foo");
//            }
//        };
//        Thread t=new Thread(runner);
//        t.run();
//        System.out.print("bar");
//    }
//}
//public class Test
//{
//    private String baseName = "base";
//    public Test()
//    {
//        callName();
//    }
//
//    public void callName()
//    {
//        System. out. println(baseName);
//    }
//
//    static class Sub extends Test
//    {
//        private String baseName = "sub";
//        public void callName()
//        {
//            System. out. println (baseName) ;
//        }
//    }
//    public static void main(String[] args)
//    {
//        Test b = new Sub();
//    }
//}
//public class Test
//{
//    public static int aMethod(int i)throws Exception
//    {
//        try{
//            return i/10;
//        }
//        catch (Exception ex)
//        {
//            throw new Exception("exception in a aMethod");
//        }finally{
//            System.out.printf("finally");
//        }
//    }
//    public static void main(String[] args){
//        try
//        {
//            aMethod(0);
//        }
//        catch (Exception ex)
//        {
//            System.out.printf("exception in main");
//        }
//        System.out.printf("finished");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        byte a=3;
//        byte b=2;
//        byte c=127;
//        byte d=126;
////        b=a+b;
//        a+=b;
////        d=c+d;
//        c+=d;
//        System.out.println(b);
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        int a='2';
//        System.out.println(a);//50
//    }
//}
//public class Test {
//
//    public static void main(String args[]) {
//        int x, y;
//        x = 5 >> 2;
//        y = x >>> 2;
//        System.out.println(y);
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Float a=1.0f;
//    }
//}
//public class Test {
//    public static void main(String args[]) {
//        String x="7";
//        int y = 2;
//        int z=2;
//        System.out.println(x+y+z);//722
//    }
//}
//class Base
//{
//    public void methodOne()
//    {
//        System.out.print("A");
//        methodTwo();
//    }
//
//    public void methodTwo()
//    {
//        System.out.print("B");
//    }
//}
//
//class Derived extends Base
//{
//    public void methodOne()
//    {
//        super.methodOne();
//        System.out.print("C");
//    }
//
//    public void methodTwo()
//    {
//        super.methodTwo();
//        System.out.print("D");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Base b=new Derived();
//        b.methodOne();//ABDC
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        int num = 2;
//        switch (num) {
//            case 1:
//                ++num;
//            case 2:
//                ++num;
//            case 3:
//                ++num;
//            default:
//                ++num;
//                break;
//        }
//        System.out.println(num);
//    }
//}
//public class Test {
//    public static void main(String args[]) {
//        int i = 7;
//        do {
//            System.out.println(--i);
//            --i;
//        } while (i != 0);
//        System.out.println(i);
//    }
//}
//public class Test {
//    public static class A {
//        private B ref;
//        public void setB(B b) {
//            ref = b;
//        }
//    }
//    public static Class B{
//        private A ref;
//        public void setA(A a) {
//            ref = a;
//        }
//    }
//    public static void main(String args[]) {
//        start();
//    }
//    public static void start() { A a = new A();
//        B b = new B();
//        a.setB(b);
//        b = null; //
//        a = null;
//    }
//}
//class A{}
//
//class B extends A{}
//
//class C extends A{}
//
//class D extends B{}
//
//public class Test {
//    public static void main(String[] args) {
//        A obj = new D();
//
//        System.out.println(obj instanceof B);//true
//
//        System.out.println(obj instanceof C);//false
//
//        System.out.println(obj instanceof D);//true
//
//        System.out.println(obj instanceof A);//true
//
//    }
//}
//public class Test {
//    public static void main(String[] args) {
////        String str = "";
////        System.out.print(str.split(",").length);//1
////        byte a=128;//err
////        boolean i=null;//err
//        long i=0xfffL;
//        double j=0.9239d;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        StringBuffer a = new StringBuffer("A");
//        StringBuffer b = new StringBuffer("B");
//        operator(a, b);
//        System.out.println(a + "," + b);
//    }
//    public static void operator(StringBuffer x, StringBuffer y) {
//        x.append(y);
//        y = x;
//    }
//}
//class P {
//    public static int abc = 123;
//    static{
//        System.out.println("P is init");
//    }
//}
//class S extends P {
//    static{
//        System.out.println("S is init");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        System.out.println(S.abc);
//        int a[]={1,2,3,4,5};
////        int a[]=new int[5]{1,2,3,4,5};//err
//    }
//}
//public class Test{
//    public static void main(String [] args){
//        List list=new ArrayList();
//        list.add("a");
//        list.add("b");
//        list.add("a");
//        Set set=new HashSet();
//        set.add("a");
//        set.add("b");
//        set.add("a");
//        System.out.println(list.size()+","+set.size());
//    }
//}
//public class Test {
//    String str=new String("good");
//    char[] ch={'a','b','c'};
//
//    public static void main(String[] args) {
//        Test t=new Test();
//        t.change(t.str,t.ch);
//        System.out.print(t.str+"and");
//        System.out.print(t.ch);
//    }
//
//    private void change(String str, char[] ch) {
//        str="test ok";
//        ch[0]='g';
//    }
//}
//public class Test
//{
//    public static Test t1 = new Test();
//    public static Test t2 = new Test();
//    {
//        System.out.println("构造块");
//    }
//    static
//    {
//        System.out.println("静态块");
//    }
//    public static void main(String[] args)
//    {
//        Test t = new Test();
//    }
//}
//public class Test
//{
//    private int a=10;
//    int b=20;
//    static int c=1;
//    public static void main(String arg[])
//    {
//        Test t = new Test();
//        System.out.println(t.a);//10
////        System.out.println(this.c);//err
////        System.out.println(Test.b);//err
//        System.out.println(t.c);//1
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        String s1 = "xiaopeng" ;
//        String s2 = "xiaopeng" ;
//        String s3 =new String (s1);
//
//        System.out.println(s1 == s2);//true
//        System.out.println(s1 = s2);//xiaopeng
//        System.out.println(s2 == s3);//false
//    }
//}
//class A{
//    public A(String str){
//
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        A classa=new A("he");
//        A classb=new A("he");
//        System.out.println(classa==classb);//false
//    }
//}
//public class Test {
//    public static void main(String[] args) {
////       String c;
////        System.out.println(c);
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//
//    }
//}
//public class Test {
//    public static void main(String sgf[]) {
//
//        StringBuffer a=new StringBuffer("A");
//
//        StringBuffer b=new StringBuffer("B");
//
//        operate(a,b);
//
//        System.out.println(a+"."+b);
//    }
//    static void operate(StringBuffer x,StringBuffer y) {
//        x.append(y);
//        y=x;
//    }
//}
//point X
//public class Test {
//    public static void main(String[] args) throws Exception {
//
//        PrintWriter out = new PrintWriter(
//                new java.io.OutputStreamWriter(System.out), true);
//        out.println("Hello");
//    }
//
//}
//public class Test {
//    public static int a = 1;
//    public static void main(String[] args) {
//        int a = 10;
//        a++; Test.a++;
//        Test t=new Test();
//        System.out.println("a=" + a + " t.a=" + t.a);
//    }
//}
//public class Test{
//    static{
//        int x=5;
//    }
//    static int x,y;
//    public static void main(String args[]){
//        x--;
//        myMethod( );
//        System.out.println(x+y+ ++x);//3
//    }
//    public static void myMethod( ){
//        y=x++ + ++x;
//    }
//}
//public class Test {
//    //静态初始化块的标准写法：没有修饰符，没有参数
//    static {
//        //初始化内容
//    }
//    public static void main(String[] args) {
//
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        String str1="hello";
//
//        String str2="he"+ new String("llo");
//
//        System.out.println(str1==str2);//false
//    }
//}
//public class Test implements B{
//    public static void main(String args[]){
//        int i;
//        Test a1=new  Test();
//        i =a1.k;
//        System.out.println("i="+i);//10
//    }
//}
//interface B{
//    int k=10;
//}
//public class Test {
//    static int x=10;
//    static {
//        x+=5;
//    }
//    public static void main(String[] args)
//    {
//        System.out.println("x="+x);//5
//    }
//    static{x/=3;};
//}
//class Base{
//    public Base(String s){
//        System.out.print("B");
//    }
//}
//public class Test extends Base{
//    public Test (String s) {//err - There is no default constructor available in 'Base'
//        System.out.print("D");
//    }
//    public static void main(String[] args){
//        new Test("C");
//    }
//}
