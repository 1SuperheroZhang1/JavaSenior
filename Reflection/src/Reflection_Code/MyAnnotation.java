package Reflection_Code;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author:superherozhang
 * @create:2022-03-17 16:28
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)//生命周期；要想通过反射获取注解的信息，必须声明为RUNTIME
public @interface MyAnnotation {
    String value() default "hello";
}
