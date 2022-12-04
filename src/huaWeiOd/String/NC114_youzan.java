package huaWeiOd.String;
/*
 字符串旋转:
       给定两字符串A和B，
                  如果能将A从中间某个位置   分割  为左右两部分字符串（都不为空串），并将左边的字符串  移动  到右边字符串后面组成新的字符串       
      可以变为字符串B时返回true。
例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割   换位后得到‘zanyou’  和  B相同返回true。

示例1
"youzan","zanyou"  true
示例2
"youzan","zyouan"  false


两个字符串长度不一致直接返回false
再判断A + A的结果是否包含B,包含返回true
return str1.length() == str2.length() ? (str1 + str1).contains(str2) : false;
*/
public class NC114_youzan {
	public boolean solve (String A, String B) {
        // write code here
		if(A.length()!=B.length())
			return false;
		
		if( (A + A).contains(B))//切割 移位    等价于   AA中找B
			return true;
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
