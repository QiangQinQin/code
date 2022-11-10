package Interview;

/**
 * @author QiangQin
 * * @date 2021/10/7
 */
public class Written_9_30_YuShi_20 {
    public static void main(String[] args) {
        // 测试数据
        int a = 69;
        // 进行转换
        String b = tenChangeFour(a);
        // 输出结果
        System.out.println(b);



        int n = 1011;//需要转换的数字
        int m = 4; //进制
        int des = 0; //储存转换后的结果

        String s = new StringBuilder(String.valueOf(n)).reverse().toString();  // reverse 使字符串 倒序
        for (int i = 0 ;i<s.length();i++){
//            int charIndex = s.charAt(i)-'0';
//            des += charIndex*Math.pow(m, i);

            int num=Integer.parseInt(s.charAt(i)+"");
            des += num*Math.pow(m,i);
        }

        System.out.println(des);
    }

    public static String tenChangeFour(int a) {
        StringBuilder str = new StringBuilder();
        while (a != 0) {
            str.insert(0, a % 4);
            a /= 4;
        }
        return str.toString();
    }


}
