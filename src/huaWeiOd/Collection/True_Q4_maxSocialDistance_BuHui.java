package huaWeiOd.Collection;

import java.util.TreeSet;

/**
 * @author QiangQin
 * * @date 2022/12/25
https://blog.csdn.net/misayaaaaa/article/details/128132107?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167195553816800188525994%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=167195553816800188525994&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-2-128132107-null-null.blog_rank_default&utm_term=%E6%9C%80%E5%A4%A7%E7%A4%BE%E4%BA%A4%E8%B7%9D%E7%A6%BB&spm=1018.2226.3001.4450

题目
疫情期间需要大家保证一定的社交距离，公司组织开交流会议。
座位一排共N个座位，编号分别为[0,N-1].要求员工一个接着一个进入会议室，并且可以在任何时候离开会议室。


满足:
每当一个员工进入时，需要坐到最大社交距离(最大化自己和其他人的距离的座位);
如果有多个这样的座位，则坐到索引最小的那个座位。

输入描述
    会议室座位总数seatNum。(1 <= seatNum <= 500)
    员工的进出顺序seatOrLeave数组，元素值为1，表示进场;元素值为负数，表示出场（特殊:位置0的员工不会离开)。例如-4表示坐在位置4的员工离开(保证有员工坐在该座位上)
输出描述
    最后进来员工，他会坐在第几个位置，如果位置已满，则输出-1。

示例1输入输出示例仅供调试，后台判题数据─般不包含示例输入
10
[1,1,1,1,-4,1]
输出
5
说明
    seat ->0,空在任何位置都行，但是要给他安排索引最小的位置，也就是座位О
    seat -> 9,要和旁边的人距离最远，也就是座位9
    seat ->4,要和旁边的人距离最远，应该坐到中间，也就是座位4
    seat -> 2,员工最后坐在2号座位上
    leave[4],4号座位的员工离开
    seat -> 5,员工最后坐在5号座位上

10
[1,1,1,1,-4,1]



 */
public class True_Q4_maxSocialDistance_BuHui {
    public static void main(String[] args) {

        /*
        //todo 自己2
 treeset
    值即对应位置有人
    size即入座人数
    max即社交距离
    maxSub/2即下标？？？
 人满则返回 -1

  思路不清楚 才写注释；
  否则靠变量名+读代码就能理解思路
        * */
        int seatNum=10;
        int[] seatOrLeave={1,1,1,1,-4,1};
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < seatOrLeave.length; i++) {
            if(seatOrLeave[i] < 0 ){
                set.remove(Math.abs(seatOrLeave[i]));
            }else if(seatOrLeave[i]>0){
                if(set.size() == 0 ) { //没人时 优先座0，并且 0位置人 一直不会离开
                    set.add(1);
                }else if(set.size() ==1){
                    set.add((seatNum-0)/2);
                }else if(set.size() == seatNum){
                    System.out.println(-1);
                    break;
                }else{
//                    寻找位置 放
                    int index=0;
                    int maxDis=0;
                    for (Integer integer : set) {
                        int sub=0;
                    }
                    for (int j = 0; j < set.size() ; j++) {

                    }
                }
            }
        }

//         自己1：未完
//        Scanner sc = new Scanner(System.in);
//        int seatNum=Integer.parseInt(sc.nextLine());
//        String seatOrLeaveArray=sc.nextLine();
//        String[] orders=seatOrLeaveArray.substring(1,seatOrLeaveArray.length()-1).split(",");
//
///*
//若有多个这样的座位，则坐到索引最小的那个座位
//高效寻找 两边的人？  treeSet  arrlist
//index位离开，i--  j++找两边第一个人
//
//
// */
//        ArrayList<Integer> seatList = new ArrayList<>(); // 已落座
//        for (int i = 0; i < orders.length; i++) {
//            int order=Integer.parseInt(orders[i]);
//            if(order>0){
//                if(seatList.size() == seatNum){
//                    System.out.println(-1);
//                    break;
//                }else{
//                    // 寻找座位
//                    Collections.sort(seatList);
//
//                }
//
//
//            }
//            if(order<0){
//                order=Math.abs(order);
//                seatList.remove(order);// 移走该座位的人 ??
//            }
//        }


/*
CSDN:
1:模拟整个过程即可，可以用一个set有序去重的集合来存放已经坐过的位置，以便快速查找。
* */
//        //处理输入
//        Scanner in = new Scanner(System.in);
//        int seat_num = in.nextInt(); // 座位数
//        in.nextLine();
//
//        String seat_str = in.nextLine();
//        String[] seats = seat_str.substring(1, seat_str.length() - 1).split(",");
//        int[] seat_status = new int[seats.length]; // 入座  出座 命令
//        for (int i = 0; i < seats.length; i++) {
//            seat_status[i] = Integer.parseInt(seats[i]);
//        }
//
//        System.out.print(get_distance(seat_num, seat_status));
//    }
//
//
//    public static int get_distance(int seat_num, int[] seat_status) {
//        TreeSet<Integer> taken_seats = new TreeSet<>();
//        for (int i = 0; i < seat_status.length; i++) {
//            int op = seat_status[i];
//            if (op > 0) {
//                if (taken_seats.size() == 0) {
//                    if (i == seat_status.length - 1) {
//                        return 0;
//                    }
//                    taken_seats.add(0);
//                } else if (taken_seats.size() == 1) {
//                    taken_seats.add(seat_num - 1);
//                    if (i == seat_status.length - 1) {
//                        return seat_num - 1;
//                    }
//                } else if (taken_seats.size() > 1 && taken_seats.size() < seat_num) {
//                    int[] ints = new int[taken_seats.size()];
//                    int count = 0;
//                    for (Integer taken_seat : taken_seats) {
//                        ints[count++] = taken_seat;
//                    }
//                    int max_len = 0;
//                    int start = 0;
//                    for (int j = 0; j < ints.length - 1; j++) {
//                        int len = ints[j + 1] - ints[j];
//                        if (len / 2 > max_len) {
//                            max_len = len / 2;
//                            start = ints[j];
//                        }
//                    }
//                    taken_seats.add(start + max_len);
//                    if (i == seat_status.length - 1) {
//                        return start + max_len;
//                    }
//                } else {
//                    return -1;
//                }
//            } else {
//                taken_seats.remove(-op);
//            }
//        }
//        return 0;
    }
}
