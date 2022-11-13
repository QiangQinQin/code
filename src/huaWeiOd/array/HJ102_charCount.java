package huaWeiOd.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/11/13
 */
public class HJ102_charCount {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String  s=in.nextLine();
////        char[] chs=in.nextLine().toCharArray();
//
//
///*
//HashMap + Collections.sort()
//    遍历字符串，将字符：字符出现次数存入HashMap中
//    将HashMap放入ArrayList中， 并对其进行排序，重写排序规则。
//    遍历ArrayList，打印输出
//* */
//        HashMap<Character,Integer> map=new HashMap<>();
//        //统计字符出现次数
//        for(int i=0;i<s.length();i++){
//            map.put(s.charAt(i),   map.getOrDefault(s.charAt(i),0) +  1);
//        }
//
//        //把map放入list中。
//        ArrayList<Map.Entry> list=new ArrayList<>(map.entrySet());//entryset如map所包含的键值对所组成的set集合，如[a=2, c=3, d=3]  2是Map.Entry.getKey() a是Map.Entry.getValue()
//        System.out.println(list);
//        Collections.sort(list, new Comparator<Map.Entry>() {
//            @Override
//            public int compare(Map.Entry o1, Map.Entry o2) {
//                if(o1.getValue()!=o2.getValue()){//如果字符出现次数不同 按照出现次数从高到底 (02-01)
//                    return (int)(o2.getValue())-(int)(o1.getValue());
//                }else{//若次数相同则对比ASCII的大小 按照由小到大排列（o1-o2）
//                    return (char)(o1.getKey())-(char)(o2.getKey());
//                }
//            }
//        });
//        //最后打印输出
//        for (Map.Entry entry : list) {
//            System.out.print(entry.getKey());
//        }




/*
TreeMap存放，自动按ASCII码 由小到大 排序
利用map.values() 遍历 次数，由最大 到 0依次打印所有出现的次数

*/

//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.next();
//
//        //将字符存入TreeMap
//        TreeMap<Character,Integer> map = new TreeMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            if(!map.containsKey(str.charAt(i))){
//                map.put(str.charAt(i),1);
//            }else{
//                map.put(str.charAt(i),  map.get(str.charAt(i))+1 );
//            }
//        }
//        System.out.println(map);  //{a=2, c=3, d=3}
//        //找到max值
//        int max = 0;
//        for (int val:map.values()) {
//            if(val>max)
//                max = val;
//        }
//
//        //输出
//        while (max>0){
//            for (char key:map.keySet()){
//                if(map.get(key)==max)
//                    System.out.print(key);  //  c   d  a
//            }
//            max--;
//        }


            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String str;
            try{
                while((str=br.readLine())!=null)
                {
                    System.out.println(count(str).toString());
                }
            }catch(IOException e){
                e.printStackTrace();
            }


    }
    public static StringBuilder count(String str)
    {
        char[] strArray=str.toCharArray();
        int[] chArray=new int[129]; // 0...128

        //字符对应ascll码值下标元素自增来统计数量
        for(char i:strArray)
            chArray[(int)i]++;

        int max=0;
        //找出字符数量最多的ascll码值
        for(int i=0;i<chArray.length;i++)
            if(max<chArray[i])
                max=chArray[i];
        StringBuilder sb=new StringBuilder();

        //按数量从大到小添加到可变字符序列sb
        while(max!=0)
        {
            for(int i=0;i<chArray.length;i++)
                if(chArray[i]==max)
                    sb.append((char)i);
            max--;
        }
        return sb;
    }


}

