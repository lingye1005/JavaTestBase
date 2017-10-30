package schooloffer16;

import java.util.*;

/**
 * Created by caoxiaohong on 17/9/11.
 * 请设计一个高效算法，再给定的字符串数组中，找到包含"Coder"的字符串(不区分大小写)，并将其作为一个新的数组返回。结果字符串的顺序按照"Coder"出现的次数递减排列，若两个串中"Coder"出现的次数相同，则保持他们在原数组中的位置关系。
 * 给定一个字符串数组A和它的大小n，请返回结果数组。保证原数组大小小于等于300,其中每个串的长度小于等于200。同时保证一定存在包含coder的字符串。
 */
public class FindCoder {
    public String[] findCoder(String[] A, int n) {
        // write code here
        if(A==null || n<=0)
            return null;
        List key=new ArrayList<String>();
        List count=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int countNum=0;
            for(int j=0;j<=A[i].length()-5;){
                if(A[i].charAt(j)!='c' && A[i].charAt(j)!='C'){
                    j++;
                    continue;
                }
                if(new StringBuilder().append(A[i].substring(j,j+1)).append(A[i].substring(j+1,j+2)).append(A[i]
                        .substring(j+2,j+3)).append(A[i].substring(j+3,j+4)).append(A[i].substring(j+4,j+5)).toString().toLowerCase().equals("coder")){
                    countNum++;
                    j+=5;
                    continue;
                }
                j++;
            }
            if(countNum!=0){
                key.add(A[i]);
                count.add(countNum);
            }
        }

        //排序
        bubbleSort(key,count);
        String[] result=new String[key.size()];
        for(int i=0;i<key.size();i++)
            result[i]=String.valueOf(key.get(i));
        return result;
    }
    void bubbleSort(List<String> key,List<Integer> count){
        for(int i=0;i<key.size();i++){
            boolean flag=false;
            for(int j=key.size()-1;j>i;j--){
                if(count.get(j)>count.get(j-1)){
                    //更改key,count
                    int tmp=count.get(j);
                    count.set(j,count.get(j-1));
                    count.set(j-1,tmp);

                    String str=key.get(j);
                    key.set(j,key.get(j-1));
                    key.set(j-1,str);

                    flag=true;
                }
            }
            if(!flag)
                break;
        }
    }

    public static void main(String[] args) {
        FindCoder t=new FindCoder();
        String[] a={"i am a coder","Coder Coder","Code"};
        String[] out=t.findCoder(a,3);
        System.out.println(out.length);
        System.out.println(out[0]);
        System.out.println(out[1]);
        //System.out.println(out[2]);
    }
}
