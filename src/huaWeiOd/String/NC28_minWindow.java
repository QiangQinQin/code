package huaWeiOd.String;

import java.util.HashMap;

/**
 * @author QiangQin
 * * @date 2022/11/27
https://www.nowcoder.com/practice/c466d480d20c4c7c9d322d12ca7955ac?tpId=196&tqId=37066&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3DNC28%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=NC28
给出两个字符串 s 和 t，要求在 s 中找出最短的包含 t 中所有字符的连续子串。

数据范围：0≤∣S∣,∣T∣≤10000，保证s和t字符串中仅包含 大小写英文字母
要求：进阶：空间复杂度 O(n) ， 时间复杂度 O(n)
例如：
S ="XDOYEZODEYXNZ"
T ="XYZ"
找出的最短子串为"YXNZ"

注意：
如果 s 中没有包含 t 中所有字符的子串，返回空字符串 “”；
满足条件的子串可能有很多，但是题目保证满足条件的最短的子串唯一。

示例1
输入：
"XDOYEZODEYXNZ","XYZ"
返回值：
"YXNZ"


示例2
输入：
"abcAbA","AA"
返回值：
"AbA"
 */
public class NC28_minWindow {
    /*
    ==================官方=============================
    https://www.nowcoder.com/practice/c466d480d20c4c7c9d322d12ca7955ac?tpId=196&tqId=37066&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3DNC28%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=NC28
● tep 1：建立哈希表，遍历字符串T，统计各个字符出现的频率，频率计为负数。
● step 2：依次遍历字符串S，如果匹配则将哈希表中的相应的字符加1。
● step 3：在遍历过程中维护一个窗口，
  ○ 如果哈希表中所有元素都大于0，意味着已经找全了，则窗口收缩向左移动，找最小的窗口，
  ○ 如果不满足这个条件则窗口右移继续匹配。
  ○ 窗口移动的时候需要更新 最小窗口，以取得最短子串。
● step 4：如果匹配到最后，窗口left（初始为-1）也没有右移，说明没有找到，返回空串即可。
● step 5：最后使用字符串截取函数，截取刚刚记录下的窗口即可得到符合条件的最短子串。


    * */
    //检查是否有小于0的
    boolean check(int[] hash) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] < 0)
                return false;
        }
        return true;
    };

    public String minWindow (String S, String T) {
        int cnt = S.length() + 1; //最短区间长度

        // 记录目标字符串T的字符个数
        int[] hash = new int[128];
        for(int i = 0; i < T.length(); i++)
            hash[T.charAt(i)] -= 1; // //初始化哈希表  都为负数， 找的时候再加为正

        int slow = 0, fast = 0;
        /*
           记录左右区间,
           先移动fast，到 目标串中字符全为正，   再右移slow，缩小区间
         */
        int left = -1, right = -1; //保存最终区间的上下限
        for(; fast < S.length(); fast++){

            char c = S.charAt(fast);
            hash[c]++;

            //没有小于0的说明都覆盖了，缩小窗口
            while(check(hash)){
                //取最优解
                if(cnt > fast - slow + 1){
                    cnt = fast - slow + 1;
                    left = slow;
                    right = fast;
                }

                //缩小窗口再试
                c = S.charAt(slow);
                hash[c]--;
                slow++;
            }
        }
        //找不到的情况
        if(left == -1)
            return "";
        return S.substring(left, right + 1);// [left, right + 1)
    }


//    /*
//    ============自己滑动窗口==================，
//       遍历所有起点  和 窗口大小
//       比较  窗口内  字母种类和个数  是否>=  目标值
//    * */
//   HashMap<Character, Integer> map= new HashMap<>();
//
//    public String minWindow (String S, String T) {
//        // ”a“中 不含有 “aa“的子串
//        if(S.length() < T.length()){
//            return "";
//        }
//
//
//        int start=0;
//        int window=T.length();// 初始和 目标串长度一致
//        judge(T,map);
//        for (; window <= S.length(); window++) { //窗口由小到大
//            boolean isFind = false; // 标志 是否找到 最小串，找到 则不用看下一window
//
//            for (start = 0; start < S.length() - window + 1; start++) { // 起点由前到后
//                HashMap<Character, Integer> cur = new HashMap<>();
////                System.out.println(S.substring(start, start + window));
//                judge(S.substring(start, start + window), cur);// [i+0,...,i+window-1,i+window)
//
//                //  是否包含 目标串的字符种类和个数,根据flag可提前跳出 该比较
//                boolean flag = true; //
//                for (Character ch : map.keySet()) {
//                    if (  !(cur.containsKey(ch) && cur.get(ch) >= map.get(ch))  ) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag == true) {
//                    isFind = true;
//                    break;
//                }
//
//            }
//
//            if (isFind) {
//                return  S.substring(start,start+window);
//            }
//        }
//
//        return  "";
//    }

//    private void judge(String t, HashMap<Character, Integer> map) {
//        for (int i = 0; i < t.length(); i++) {
//            char c = t.charAt(i);
//            if(map.containsKey(c)){
//                map.put(c,map.get(c)+1);
//            }else{
//                map.put(c,1);
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new NC28_minWindow().minWindow("XDOYEZODEYXNZ","XYZ"));
        /*  未通过的 */
//        System.out.println(new NC28_minWindow().minWindow("a","aa"));
//        System.out.println(new NC28_minWindow().minWindow("a","b"));
//        System.out.println(new NC28_minWindow().minWindow("wyqaalfdtavrmkvrgbrmauenibfxrzjpzzqzlveexayjkvdsyueboloymtvfugvtgnutkyzhaztlvwdvqkwgvmejhbpdimwqbslnrkutkpehnkefwblrprcxvtaffzxitivmssgehklvwqastojihmhcfkhnlexemtrhnxlujxrgpuyiikspycufodubisfwnydaxrwhqqpfkppuzjlzlfhbjbcttkriixkiohpexgjjvafxjqyvyfyjhbccltlvsvdgeumdavoyxtvhmtekzctidxkqsxmlvrrzmefobtmznhizdmlcoemudwkvuyirscqegvsjrfkgoshrgsvvyhrbgdycehtwjlcrjucabpgsjnjqhhnfqeiwhgalptjyflpoiuqjjwdslpiswvxobfljnnwdhgdortezpulysoqddbxbwuqabdjqqhtzpxpjsvkjrvhjmzoralvzhlzkqkbgrwijvzspvcymafymfmfhaaghnfsdrvmlruuntmcqqbdqideprkxrmfbanvfeqrphnlwjxbzqcegmhnczxbslitnvotaemroadkjclksppzeyoiznlsytnopchritiyvlleqypiqgjugxeikpclipzxtgoebxcxkpdaoulecuajueretvpbkqbgwrkaooxbeaduvoaxlaifgblzwdcjtfpsxbsnrrovturokrovtycbcqcytfjomygj","baxtr"));
//        System.out.println(new NC28_minWindow().minWindow("twxpxwljvoxkpjjpfvccyikbbrpdsyvlxscuoofkecwtnfkvcnzbxkeabtdusyhrqklhaqreupakxkfzxgawqfwsaboszvlshwzhosojjotgyagygguzntrouhiweuomqptfjjqsxlbylhwtpssdlltgubczxslqjgxuqnmpynnlwjgmebrpokxjnbiltvbebyytnnjlcwyzignmhedwqbfdepqakrelrdfesqrumptwwgifmmbepiktxavhuavlfaqxqhreznbvvlakzeoomykkzftthoemqwliednfsqcnbexbimrvkdhllcesrlhhjsspvfupxwdybablotibypmjutclgjurbmhztboqatrdwsomnxnmocvixxvfiqwmednahdqhxjkvcyhpxxdmzzuyyqdjibvmfkmonfxmohhshpkhmntnoplphqyprveyfsmsxjfosmicdsjrieeytpnbhlsziwxnpmgoxneqbnufhfwrjbqcsdfarybzwaplmxckkgclvwqdbpumsmqkswmjwnkuqbicykoisqwoootrdpdvcuiuswfqmrkctsgrevcxnyncmivsxbpbxzxpwchiwtkroqisnmrbmefbmatmdknaklpgpyqlsccgunaibsloyqpnsibwuowebomrmcegejozypjzjunjmeygozcjqbnrpakdermjcckartbcppmbtkhkmmtcngteigjnxxyzaibtdcwutkvpwezisskfaeljmxyjwykwglqlnofhycwuivdbnpintuyhtyqpwaoelgpbuwiuyeqhbvkqlsfgmeoheexbhnhutxvnvfjwlzfmvpcghiowocdsjcvqrdmkcizxnivbianfpsnzabxqecinhgfyjrjlbikrrgsbgfgyxtzzwwpayapfgueroncpxogouyrdgzdfucfrywtywjeefkvtzxlw"));
    }
}
