package Enum_Code;

/**
 * 使用enum关键字定义枚举类
 *
 * 说明:定义的枚举类默认继承于java.lang.Enum类
 * @author:superherozhang
 * @create:2022-03-11 14:02
 */
public class EnumTest1 {
    public static void main(String[] args) {
        Season_ summer = Season_.SUMMER;
        //toString():
        System.out.println(summer);//SUMMER

//        System.out.println(Season_.class.getSuperclass());//class java.lang.Enum

        System.out.println("*****************************");
        //values():
        Season_[] values = Season_.values();
        for(int i=0;i< values.length;i++){
            System.out.println(values[i]);
        }
        System.out.println("*****************************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String objName): 返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛异常IllegalArgumentException
        Season_ winter = Season_.valueOf("WINTER");
//        Season_ winter = Season_.valueOf("WINTER1");
        System.out.println(winter);//WINTER
    }
}
//使用enum关键字定义枚举类
enum Season_{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地");

    //2.声明当前Season对象的属性: private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器
    private Season_(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }

    //4.其他诉求1: 获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //其他诉求2:提供toString()方法

//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
