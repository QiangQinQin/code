package huaWeiOd;

import java.util.Scanner;

/**

 asdfas
 werasdfaswer
      asdfas
 wer  asdfas  wer
 */
public class HJ75 {

    private static int LCS(String s1, String s2) {
        int maxLen = 0;
        s1=" "+ s1;
        s2=" "+ s2;
        int n = s1.length(), m = s2.length();

        int[][] dp=new int [n][m];
        for(int i = 0; i < n; i++) dp[i][0] = 0;
        for(int j = 0; j < m; j++) dp[0][j] = 0;

        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j < m; j++)
            {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1; // i=1时，i-1为0
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        System.out.println(LCS(s1,s2));
//        String s3=null;
//
//        if(s1.length() > s2.length()){
//            s3=s2;
//            s2=s1;
//            s1=s3;
//        }
//
//        int max=0;
//        for (int len = 1; len <= s1.length(); len++) { //所有长度
//            for(int i=0;i<=s1.length()-len;i++){        //所有起点
//                String tmp=s1.substring(i,i+len);    //[i,i+len-1]
//
//                if(s2.contains(tmp)  && tmp.length()>max){
//                    max=tmp.length();
//                }
//            }
//        }
//
//        System.out.println(max);
    }


}
