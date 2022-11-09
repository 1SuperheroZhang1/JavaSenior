package Class_Exer;



import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:superherozhang
 * @create:2022-03-10 23:13
 */
public class SimpleTimeFormatDemo {
    //练习一: 字符串"2020-09-08"转换为java.sql.Date
    @Test
    public void testDemo() throws ParseException {
        String str="2020-09-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
//        System.out.println(date);

        java.sql.Date birthDate=new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }
    /*练习二:"三天打鱼，两天晒网" 1990-01-01 xxxx-xx-xx 打鱼？晒网？

    举例: 2020-09-08  ?  总天数

    总天数 % 5 ==1,2,3 : 打鱼
    总天数 % 5==4，0  :  晒网

    总天数的计算？
    方式一: (date2.getTime()-date1.getTime())/(1000*60*60*24)+1
    方式二: 1990-01-01 -->2019-12-31 + 2020-01-01 -->2020-09-08
    */
}
