package huaWeiOd.math;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author QiangQin
 * * @date 2022/12/18
https://www.nowcoder.com/practice/9566499a2e1546c0a257e885dfdbf30d?tpId=37&tqId=21277&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=undefined&tags=&title=

描述
给定一个字符串描述的算术表达式，计算出结果值。
输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
数据范围：运算过程中和最终结果均满足 |val| <  2^{31}-1
 ，即只进行整型运算，确保输入的表达式合法

输入描述：
输入算术表达式

输出描述：
计算出结果值

示例1
输入：
400+5
输出：
405


难点：
   优先级
   正负号
 */
public class HJ54_ExpressionValue_BuHui {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        //将其他括号，替换成小括号
        s=s.replace("{","(");
        s=s.replace("[","(");
        s=s.replace("}",")");
        s=s.replace("]",")");
        System.out.println(slove(s));
    }
    public static int slove(String s){
        Stack<Integer> stack=new Stack<>();
        int n=s.length();
        char[] chs=s.toCharArray();
        int index=0;
        //初始化符号为'+'
        char sign='+';
        //记录数字
        int number=0;
        for(int i=0;i<n;i++){
            char ch=chs[i];
            //当前字符是空格，跳过
            if(ch==' ')continue;
            //当前字符是数字，拼数字
            if(Character.isDigit(ch)){
                number=number*10+ch-'0';
            }
            //如果当前字符是小括号
            if(ch=='('){
                //移到小括号后一位字符
                int j=i+1;
                //统计括号的数量
                int count=1;
                while(count>0){
                    //遇到右括号，括号数-1
                    if(chs[j]==')')count--;
                    //遇到左括号，括号数+1
                    if(chs[j]=='(')count++;
                    j++;
                }
                //递归，解小括号中的表达式
                number=slove(s.substring(i+1,j-1));
                i=j-1;
            }
            //遇到符号，将数字处理后放进栈
            if(!Character.isDigit(ch) || i==n-1){
                //如果是'+',直接入栈
                if(sign=='+'){
                    stack.push(number);
                }
                //如果是'-',数字取相反数在入栈
                else if(sign=='-'){
                    stack.push(-1*number);
                }
                //如果是'*',弹出一个数字乘后放入栈
                else if(sign=='*'){
                    stack.push(stack.pop()*number);
                }
                //如果是'/',弹出一个数字/后放入栈
                else if(sign=='/'){
                    stack.push(stack.pop()/number);
                }
                //更新符号
                sign=ch;
                //刷新数字
                number=0;
            }
        }
        //栈中数字求和得到结果
        int ans=0;
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }
}
