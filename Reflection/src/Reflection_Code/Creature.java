package Reflection_Code;

import java.io.Serializable;

/**
 * @author:superherozhang
 * @create:2022-03-17 16:19
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}
