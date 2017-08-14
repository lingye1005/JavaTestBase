package niukeWeb;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/7/21.
 * 题意:给定一个开始转化的字符串start,和一个最终需要被转化成的字符串,以及一个字符串字典.
 * 从start开始,每次只能转化一个字符,通过字典中的多个字符串进行转化,最终转化成为一个和end仅仅有一个字符之差的字符串.
 * 求最小的转化次数.
 * 问题实质:图中两个给定点之间的最短路径长度.
 * 算法思想:求图中两点之间的最短路径通常都用bfs
 */
public class WordLadder {

    static int min;
    //主方法
    public int ladderLength(String start, String end, HashSet<String> dict) {
        //深搜
        bfs(start,end,dict);
        return min;
    }

    void bfs(String start,String end, HashSet<String> dict){
        LinkedList<String> queue=new LinkedList<String>();//用于存放转化过程中的用到的字符串
        int front=-1,rear=-1;
        int last=0,level=0;

        queue.add(start);
        rear++;
        dict.add(end);
        while(!queue.isEmpty()){
            String node=queue.poll();
            front ++;
            if(node.equals(end)) {
                min=level+1;
                return;
            }
            char[] arr=node.toCharArray();
            for(int i=0;i<arr.length;i++){
                for(char c='a';c<='z';c++){
                    char temp=arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
                    String s=new String(arr);
                    if(dict.contains(s)){
                        queue.add(s);
                        dict.remove(s);
                        rear++;
                    }
                    arr[i]=temp;
                }
            }
            if(front==last){
                last=rear;
                level++;
            }
        }
    }


    public static void main(String[] args) {
        WordLadder test=new WordLadder();
        HashSet<String> dict=new HashSet<String>();
        dict.add("hot"); dict.add("dot");
        dict.add("dog"); dict.add("lot");
        dict.add("log");dict.add("hig");
        test.ladderLength("hit","cog",dict);
        System.out.println(min);
        Math.round(2);
    }
}
