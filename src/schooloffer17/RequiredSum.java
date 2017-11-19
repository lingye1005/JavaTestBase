package schooloffer17;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/18 20:05.
 * <求和></>
 */
public class RequiredSum {
    public static void main(String[] args) {
        int n,m;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            n=scanner.nextInt();//1~n的数字范围
            m=scanner.nextInt();//求和为m
            dfs(1,m,n);
            //输出
            for(ArrayList<Integer> list:res){
                for(int i=0;i<list.size()-1;i++){
                    System.out.print(list.get(i)+" ");
                }
                System.out.println(list.get(list.size()-1));
            }
        }
    }

    //主算法:dfs
    static ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> tmp=new ArrayList<Integer>();
    private static void dfs(int index,int sum,int n){
        if(sum==0){
            res.add(new ArrayList<Integer>(tmp));
        }else{
            for(int i=index;i<=n && i<=sum;i++){
                tmp.add(i);
                dfs(i+1,sum-i,n);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
