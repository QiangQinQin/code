package other.testCallBack;

//问问题的人   由于Person要提供回调方法，因此实现CallBack接口及其方法，方法中主要针对回调结果进行处理。

public class Person implements CallBack {
 
    private Genius genius;
    /*
由于Person要调用Genius对应的方法，因此要持有Genius的引用，这里通过构造方法传入。
    * */
    public Person(Genius genius) { 
        this.genius = genius; 
    } 
 
    @Override 
    public void callback(String string) { 
        System.out.println("收到答案：" + string); 
    } 
 
    public void ask() { 
        genius.answer(this); 
    }

     public void askASyn() { 
    System.out.println("创建新线程请教问题"); 
    new Thread(() -> genius.answer(this)).start(); 
    System.out.println("新线程已启动..."); 
    } 


} 