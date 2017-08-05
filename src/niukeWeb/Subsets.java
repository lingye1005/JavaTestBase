package niukeWeb;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/8/5.
 * Given a set of distinct integers, S, return all possible subsets.
 * 注意:子序列中元素非递减排序
 */
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();  //结果集

        if(S==null || S.length==0)
            return result;
        /**
         * 主要处理过程
         */
        Arrays.sort(S);//先排序
        ArrayList<Integer> temp;//存放临时结果集
        result.add(new ArrayList<Integer>());//结果集加入空子集

        int count;//存放一次遍历过程中新生成的结果集个数.
        int len=S.length;

        temp=new ArrayList<Integer>();
        temp.add(S[0]);
        result.add(temp);
        count=1;

        for(int i=1;i<len;i++){
            int size=result.size();
            if(S[i]!=S[i-1]){
                //取出结果集中所有结果,都新添加一个S[i],再都存回结果集中
                for(int j=0;j<size;j++){
                    temp=new ArrayList<Integer>(result.get(j));
                    temp.add(S[i]);
                    result.add(temp);
                }
                count=size;//更新结果集中新增元素个数值
            }else{
                //取出结果集中上一次新增的元素,都添加一个S[i],再都存回结果集中.
                for(int j=size-1;j>size-1-count;j--){
                    temp=new ArrayList<Integer>(result.get(j));
                    temp.add(S[i]);
                    result.add(temp);
                }
                //count值不改变.
            }
        }
        /**
         * 到达此处是,result结果集已经找到了,现在需要对子集进行排序
         * 基数排序
         */
        int maxLen=result.get(result.size()-1).size();//基数排序最长比较位数
        int groups=result.size();//需要被排序的组数
        int[][] budgets=new int[groups][maxLen];//记录各组每位出现的数值
        for(int i=0;i<groups;i++){
            int index=maxLen-1;
            for(int j=maxLen-1;j>=0;j--){
                if(result.get(i).size()>j){
                    budgets[i][index--]=result.get(i).get(j);  //从低位开始存放数据
                }
            }
        }
        for(int k=maxLen-1;k>=0;k--){  //每次各个组的比较都从最低位开始比较
            for(int i=0;i<groups-1;i++){
               //按关键字: result[j][k]result[j+1][k]进行生序排序
                boolean flag=false;//是否进行了交换
                for(int j=groups-1;j>i;j--){
                    if(budgets[j-1][k]>budgets[j][k]){ //交换result[j]和result[j-1]
                        ArrayList<Integer> arr=result.get(j);
                        result.set(j,result.get(j-1));
                        result.set(j-1,arr);
                        //交换budgets[j-1][k]和budgets[j][k]的值
                        int[] bd=budgets[j-1];
                        budgets[j-1]=budgets[j];
                        budgets[j]=bd;
                        flag=true;
                    }
                }
                if(!flag)
                    break;
            }
        }

        /**
         * 再按照子集长度排序;
         * 冒泡排序
         */
        for(int i=0;i<result.size();i++){
            boolean flag=false;
            for(int j=result.size()-1;j>i;j--){
                if(result.get(j-1).size()>result.get(j).size()){
                    ArrayList<Integer> arrays=result.get(j-1);
                    result.set(j-1,result.get(j));
                    result.set(j,arrays);
                    flag=true;
                }
            }
            if(!flag)
                break;
        }
        return  result;
    }

    public static void main(String[] args) {
        Subsets a=new Subsets();
        int[] S=new int[]{1,2,3,4};
        ArrayList<ArrayList<Integer>> b=a.subsets(S);
        System.out.println("------");
        System.out.println("-------");
    }
}