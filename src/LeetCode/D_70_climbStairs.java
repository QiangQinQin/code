package LeetCode;

/**
 * @author QiangQin
 * * @date 2022/8/24
 */
public class D_70_climbStairs {
    public int climbStairs(int n) {
        String str = "we are family";
        System.out.println(str.toUpperCase());

        int[] m = new int[n+1];
        m[0]=1;
        m[1]=1;

        for(int i=2;i<=n;i++){
            m[i]=m[i-2]+m[i-1];
        }
        
        return m[n];
    }
}
