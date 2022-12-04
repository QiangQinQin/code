package other.testCallBack;

//回答问题的大神
public class Genius {
 
    public void answer(CallBack callBack) { 
        System.out.println("在忙其他事..."); 
        try { 
            Thread.sleep(2000); 
            System.out.println("忙完其他事，开始计算..."); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
 
        System.out.println("天才计算出答案为：2"); 
        // 开始帮忙计算答案，获得答案之后，调用CallBack接口的callback方法进行回调，通知结果
        callBack.callback("2"); 
    } 
} 