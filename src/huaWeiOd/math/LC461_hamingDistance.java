package huaWeiOd.math;

/**
 * @author QiangQin
 * * @date 2022/12/25
 */
public class LC461_hamingDistance {
//    public static int hammingDistance(int x, int y) {
//        String xString = Integer.toBinaryString(x);
//        String yString = Integer.toBinaryString(y);
//
//        int len=Math.max(xString.length(),yString.length());
//        StringBuilder builder = new StringBuilder("");
//        if(xString.length() < len){
//            for (int i = 0; i < len-xString.length(); i++) {
//               builder.append("0");
//            }
//            builder.append(xString);
//            xString=builder.toString();
//        }else if(yString.length() < len){
//            for (int i = 0; i < len-yString.length(); i++) {
//                builder.append("0");
//            }
//            builder.append(yString);
//            yString=builder.toString();
//        }
//
//        int count=0;
//        for (int i = yString.length()-1; i >=0 ; i--) {
//            if(xString.charAt(i) != yString.charAt(i)){
//                count++;
//            }
//        }
//        return count;
//    }

//     先计算x 异或 y,然后统计结果中 等于1 的位数
    public static int hammingDistanceLC(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


    public static void main(String[] args) {
//        System.out.println( hammingDistance(1,4));;
        System.out.println( hammingDistanceLC(3,1));;
    }
}
