package JDK9_10_11;

/**
 * @author:superherozhang
 * @create:2022-03-19 20:12
 */
public class MyInterfaceImpl implements MyInterface {

    @Override
    public void methodAbstract() {

    }

    @Override
    public void methodDefault() {
        MyInterface.super.methodDefault();
        System.out.println("实现类重写了接口中的默认方法");
    }

    public static void main(String[] args) {
        //接口中的静态方法只能由自己调用
        MyInterface.methodStatic();
        //接口的实现类不能调用接口中的静态方法
//        MyInterfaceImpl.methodStatic();

        MyInterfaceImpl impl=new MyInterfaceImpl();
        impl.methodDefault();

        //接口中的私有方法，不能在接口外部调用。
//        impl.methodPrivate();
    }
}
