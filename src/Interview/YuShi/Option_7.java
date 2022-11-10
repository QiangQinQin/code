package Interview.YuShi;

/**
 * @author QiangQin
 * * @date 2021/10/8
 */

 class OuterClass {
     private double d1 = 1.0;
     // insert code here
    // A
//     class InnerOne { public static double methoda() { return d1; } }

     //B
//    public class InnerOne { static double methoda() { return d1; } }

    // C
    private class InnerOne { double methoda() { return d1; } }

    //D
//    static class InnerOne { protected double methoda() { return d1; } }

   }
public class Option_7 {

}
