package Annotation_Code;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 *
 * @author:superherozhang
 * @create:2022-03-11 16:20
 */

@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";

}

