package other.deadLock;

import java.util.concurrent.*;

public class NewThreadDemo {

    public static void main(String[] args) throws Exception {
        
        //第一种方式
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("第1种方式:new Thread 1");
            }
        };
        t1.start();



        TimeUnit.SECONDS.sleep(1);



        //第二种方式
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第2种方式:new Thread 2");
            }
        });
        t2.start();

        TimeUnit.SECONDS.sleep(1);
        
        
        //第三种方式
        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String result = "第3种方式:new Thread 3";
                return result;
            }
        });
        Thread t3 = new Thread(ft);
        t3.start();
        
        // 线程执行完，才会执行get()，所以FutureTask也可以用于闭锁
        String result = ft.get();
        System.out.println(result);
        
        TimeUnit.SECONDS.sleep(1);


         //第四种方式
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future<String> future = pool.submit(new Callable<String>(){
            @Override
            public String call() throws Exception {
                String result = "第4种方式:new Thread 4";
                return result;
            }
        });

        pool.shutdown();
        System.out.println(future.get());


        /*
pool-2-thread-2new ThreadPoolExecutor(3, 6, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
pool-2-thread-1new ThreadPoolExecutor(3, 6, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
pool-2-thread-3 threadPoolExecutor.execute(new Callable<String>() {
        * */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"new ThreadPoolExecutor(3, 6, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());");
            }
        };

        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" threadPoolExecutor.execute(new Callable<String>() {");
            }
        });

    }
}