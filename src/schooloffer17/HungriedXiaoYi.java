//package schooloffer17;
//
//import java.util.*;
//
///**
// * Created by caoxiaohong on 17/11/8 15:20.
// * <饥饿的小易></>
// * 实质:bfs
// */
//public class HungriedXiaoYi {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        long x;
//        Set<Long> occur=new HashSet<Long>();
//        Queue<Long> queue=new LinkedList<Long>();
//        while (scanner.hasNextLong()){
//            x=scanner.nextLong();//输入起始位置,可以行走的位置4 * x + 3或者8 * x + 7;
//
//            int front=-1,rear=-1;
//            int last=0,level=0;
//            queue.add(x%1000000007);
//            rear++;
//            occur.add(x%1000000007);
//            while (level<100001 && !queue.isEmpty()){
//                long loc=queue.poll();
//                front++;
//                if(loc==0){//找到
//                    System.out.println(level);
//                    break;
//                }else{
//                    if(!occur.contains((4 * loc + 3)%1000000007)) {
//                        queue.add((4 * loc + 3) % 1000000007);
//                        occur.add((4*loc+3)%1000000007);
//                        rear++;
//                    }
//                    if(!occur.contains((8 * loc + 7)%1000000007)){
//                        queue.add((8 * loc + 7)%1000000007);
//                        occur.add((8*loc+7)%1000000007);
//                        rear++;
//                    }
//                }
//                if(front==last){
//                    level++;
//                    last=rear;
//                }
//            }
//            if(level==100001 || (level<=100000 && queue.isEmpty()))
//                System.out.println(-1);
//            queue.clear();
//            occur.clear();
//        }
//    }
//}
