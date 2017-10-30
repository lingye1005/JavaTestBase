package schooloffer16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by caoxiaohong on 17/9/18.
 * 现在有一个字符串列表，和一个关键词列表，请设计一个高效算法，检测出含关键字列表中关键字(一个或多个)的字符串。
 * 给定字符串数组A及它的大小n以及关键词数组key及它的大小m，请返回一个排好序的含关键词的字符串序号的列表。保证所有字符串长度小于等于100，关键词个数小于等于100，
 * 字符串个数小于等于200。保证所有字符串全部由小写英文字符组成。若不存在含关键字的字符串，请返回一个只含-1的数组。
 */
public class KeywordDetect {
    public int[] containKeyword(String[] A, int n, String[] keys, int m) {
        // write code here
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(keys[j].length()<=A[i].length() && A[i].contains(keys[j])){
                    list.add(i);
                    break;
                }
            }
        }
        if(list.size()==0){
            int[] result=new int[1];
            result[0]=-1;
            return result;
        }
        int[] result=new int[list.size()];
        Iterator<Integer> li=list.iterator();
        int i=0;
        while (li.hasNext()){
            result[i++]=li.next();
        }
        return result;
    }

    public static void main(String[] args) {
        KeywordDetect t=new KeywordDetect();
        String[] a={"nowcoder","hello","now"};
        String[] b={"coder","now"};
        int[] out=t.containKeyword(a,3,b,2);

    }
}
