package huaWeiOd.Interview;

import java.util.Stack;
/*
手撕代码：
    给定一个只包含两种字符的字符串：（ 和  ）
    写一个函数来检验这个字符串是否为有效字符串。
    有效字符串具有如下规则：
        1.任何左括号 ( 必须有相应的右括号 )
        2.任何右括号 ) 必须有相应的左括号 (
        3.左括号 ( 必须在对应的右括号之前 )

自己： 栈
面试官思路： +1  -1 维护左右括号的数量值就行
扩展：
   *可以被视为单个右括号 )，或单个左括号 (，或一个空字符串
   LC678: https://leetcode.cn/problems/valid-parenthesis-string/solution/

 */

public class Interview1_2022_validString {
    public static boolean checkValidString(String s) {
        boolean res=true;

        if(s.length() ==0 ){
            return  true;
        }else{
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == '('  ){
                    stack.push(ch);
                }else  if(ch == ')'  ){
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        if( stack.pop() == '('){
                            continue;
                        }else{
                            res = false;
                            break;
                        }
                    }
                }
            }

            if(!stack.isEmpty()){
                res=false;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(())"));
        System.out.println(checkValidString(")("));

        System.out.println(checkValidString("())"));
        System.out.println(checkValidString("))"));

        System.out.println(checkValidString("(()"));
    }

}
