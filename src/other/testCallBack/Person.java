package other.testCallBack;

//问问题的人
public class Person implements CallBack {
 
    private Genius genius; 
 
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