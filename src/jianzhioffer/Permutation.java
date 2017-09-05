package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/8/29.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 算法思想:设字符串长度为len.
 * 从右到左查找第一个生序自序列,下标为i,j.交换str[i]和str[j],然后下标为j~len-1的字符肯定为降序子序列,再将其改为生序子序列.
 * 进行下一次循环查找.
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result=new ArrayList<String>();
        if(str==null || str.length()==0)
            return result;
        int len=str.length();
        //全部改为小写
        String tmp1=str.toLowerCase();
        //排序
        char[] tmp2=bubbleSort(tmp1);
        result.add(String.valueOf(tmp2));
        int j=len-1;
        while(j>0){
            if(tmp2[j]<=tmp2[j-1]){
                j--;
            }else{
                //从后向前,找到第一个比tmp2[j-1]大的数字,交换
                char tmp=tmp2[j-1];
                for(int k=len-1;k>=j;k--){
                    if(tmp2[k]>tmp){
                        tmp2[j-1]=tmp2[k];
                        tmp2[k]=tmp;
                        break;
                    }
                }
                //将tmp2下标为j~len-1改为升序
                int x=j,y=len-1;
                while(x<y){
                    char ch=tmp2[x];
                    tmp2[x]=tmp2[y];
                    tmp2[y]=ch;
                    x++;
                    y--;
                }
                //添加子集到结果集中
                result.add(String.valueOf(tmp2));
                j=len-1;
            }
        }
        return result;
    }
    private char[] bubbleSort(String str){
        int len=str.length();
        char[] values=str.toCharArray();
        for(int i=0;i<len;i++){
            boolean flag=false;
            for(int j=len-1;j>i;j--){
                if(values[j]<values[j-1]){
                    char tmp=values[j];
                    values[j]=values[j-1];
                    values[j-1]=tmp;
                    flag=true;
                }
            }
            if(!flag)
                break;
        }
        return values;
    }

    public static void main(String[] args) {
        Permutation t=new Permutation();
        ArrayList<String> s=t.Permutation("abc");
        System.out.println(s.size());
    }
}
