package schooloffer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/10/24.
 * 亮亮深吸一口气，打开了地图，地图上写着(X:12,Y:?)，这可让亮亮犯了愁，这个问号代表了什么意思呢？ 亮亮绞尽脑汁也想不出什么思路，忽然他在地图背面发现了一串数字，
 * 数字下面写着一段话“这只是一个1~n的混乱排列，不用在意第i个值”，亮亮眼前一亮，“这个混乱排列中第i个一定是Y的值！”于是，亮亮开始恢复这个混乱排列。
 */
public class DenseFog {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N;
        String numbers;
        while (scanner.hasNext()){
            N=Integer.valueOf(scanner.nextLine().trim());
            numbers=scanner.nextLine();
            ArrayList<Integer> list=new ArrayList<Integer>();
            int pre=0,p=0;
            while (pre<numbers.length() && p<=numbers.length()){
                String tmp;
                /**
                 * 之前,一直内存溢出,添加了if条件后,a过了.因为,不能添加一个字符就substring一次,这样出现太多无用的string了,而保证了字符串长度==N时候,再进行substring,
                 * 这样则减少了很多无用的substring工作,自然减少了内存消耗.
                 */
                if(p-pre<String.valueOf(N).length()){
                    p++;
                    continue;
                }
                if(p<numbers.length())
                    tmp=numbers.substring(pre,p+1);
                else{
                    tmp = numbers.substring(pre, p);
                    list.add(Integer.valueOf(tmp));
                    break;
                }
                if(Integer.valueOf(tmp)==N){
                    list.add(Integer.valueOf(tmp));
                }else if(Integer.valueOf(tmp)<N){
                    p++;
                }else{
                    if(N>=Integer.valueOf(numbers.substring(pre,p))) {//tmp长度==N,如果Integer.valueOf(tmp)<=N,则加入结果集.
                        list.add(Integer.valueOf(numbers.substring(pre, p)));
                        pre = p;
                        p++;
                    }else{
                        list.add(Integer.valueOf(numbers.substring(pre,p-1)));//tmp长度==N,但是Integer.valueOf(tmp)>N,则修改截取位置到p-1.
                        pre=p-1;
                    }
                }
            }
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
}
