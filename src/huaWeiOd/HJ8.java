package huaWeiOd;

import java.util.*;

/**
 * @author QiangQin
 * * @date 2021/10/3
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        while (scanner.hasNextInt()){
            int key=scanner.nextInt();
            int value=scanner.nextInt();

            if(map.get(key)==null){
                map.put(key,value);
            }else{
                map.put(key,map.get(key)+value);
            }

        }


        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            Integer key = iterator.next();
            Integer value = map.get(key);

            System.out.println(key+" "+value);
        }
    }
}
