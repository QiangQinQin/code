package other;

//https://www.cnblogs.com/javaboy2018/p/9040803.html
public class Singleton {

    private static Singleton singleton;

    private Singleton() {
        System.out.println("只操作一次!");
    }

    public static class SingletonHelper {
//        static final 是一个静态常量,存储在内存中的常量区,在new之前会看常量里面是否有这个值,如果有,就不再执行new操作了
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        singleton = SingletonHelper.INSTANCE;
        return singleton;
    }

    public static Singleton getInstance2() {
        singleton = new Singleton();
        return singleton;
    }

    public static Singleton getInstance3() {
        final Singleton singleton3 = new Singleton();
        return singleton;
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            /*
            只操作一次!
            * */

            Singleton.getInstance();

            /*
只操作一次!
只操作一次!
只操作一次!
只操作一次!
只操作一次!
            */
//            Singleton.getInstance2();

            /*
只操作一次!
只操作一次!
只操作一次!
只操作一次!
只操作一次!
            * */
//            Singleton.getInstance3();
        }
    }

}
