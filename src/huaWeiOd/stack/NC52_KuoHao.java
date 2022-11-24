package huaWeiOd.stack;

import java.util.Stack;

/**
 * @author QiangQin
 * * @date 2022/11/23
https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2?tpId=196&tqId=37083&ru=/exam/oj
给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。

输入："["
返回值：false

输入："[]"
返回值：true
 */
public class NC52_KuoHao {
    public static boolean isValid (String s) {
        // write code here
        boolean res=true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(ch =='{'  ||  ch=='['  ||  ch=='('){
                stack.push(ch);
            }else  if(ch =='}' ){ // 只能弹出一个
                if(!stack.isEmpty() && stack.pop()=='{'){
                    continue;
                }else{
                    return false;
                }
            }else if(ch ==']'){
                if(!stack.isEmpty() && stack.pop()=='['){
                    continue;
                }else{
                    return false;
                }
            }else if(ch ==')'){
                if(!stack.isEmpty() && stack.pop()=='('){
                    continue;
                }else{
                    return false;
                }
            }

        }

        // 处理 输入为【的情况
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }

    }
    public static void main(String[] args) {
//        {[()]}   ()[]{}   [
        System.out.println(isValid("["));
    }
}
