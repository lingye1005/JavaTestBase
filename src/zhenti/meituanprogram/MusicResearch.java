//package zhenti.meituanprogram;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
///**
// * @Author: cxh
// * @CreateTime: 17/12/13 11:20
// * @ProjectName: JavaBaseTest
// * <音乐研究></>
// */
//public class MusicResearch {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while (scanner.hasNext()){
//            int n,m;
//            //输入处理
//            n=scanner.nextInt();
//            int[] ns=new int[n];//0 ≤ 音高 ≤ 1000
//            for(int i=0;i<n;i++)
//                ns[i]=scanner.nextInt();
//            m=scanner.nextInt();
//            int[] ms=new int[m];//0 ≤ 音高 ≤ 1000
//            for(int i=0;i<m;i++)
//                ms[i]=scanner.nextInt();
//
//            //逻辑处理
//            boolean[] isVisited=new boolean[m];
//            ArrayList<ArrayList<Integer>> order=new ArrayList<>();
//            for(int i=0;i<n;i++){
//                ArrayList<Integer> tmp=new ArrayList<>();
//                tmp.add(getMinAbs(ms,ns[i],isVisited);
//                order.add(tmp);
//            }
//
//        }
//    }
//    private static int getMinAbs(int[] numbers,int num,boolean[] isVisited){
//        int len=numbers.length;
//        int res=Integer.MAX_VALUE;
//        for(int i=0;i<len;i++){
//            if(numbers[i]!=-1){
//                if(res<Math.pow(Math.abs(num-numbers[i]),2) && isVisited[i]==false) {
//                    res = numbers[i];
//                    isVisited[i]=true;
//                }
//            }
//        }
//        return res;
//    }
//}
