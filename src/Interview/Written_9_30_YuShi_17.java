package Interview;

/**
 * @author QiangQin
 * * @date 2021/9/30
 */
public class Written_9_30_YuShi_17 {

    public static void main(String[] args) {
        int  a=200628;
        int[] b = new int[2];

        Func(a,b);

        System.out.println("偶数位的和"+b[0]+"  奇数位的和"+b[1]);
    }


//    private static void Func(int a, int[] b) {
//        char[] array=String.valueOf(a).toCharArray();
//        for(int i=array.length-1;i>=0;i--){
//            if(i%2==0){
//                b[0]+=Integer.parseInt(array[i]+""); //偶数位的和
//            }else{
//                b[1]+=Integer.parseInt(array[i]+""); //奇数位的和
//            }
//        }
//    }


    private static void Func(int a, int[] b) {
        int count=1;
       while(a!=0){
           if(count%2==0){
               b[0]+=a%10;
           }else{
               b[1]+=a%10;
           }

           count++;
           a=a/10;
       }
    }
}
