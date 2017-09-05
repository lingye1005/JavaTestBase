package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/8/31.
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 要求:输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        for(int i=1;i<sum;i++){
            ArrayList<Integer> list=new ArrayList<Integer>();
            int sumNum=i;
            list.add(i);
            for(int j=i+1;j<sum/2+2;j++){  //开始范围写的j<sum/2,后来发现如果sum比较小,比如一位数时,就没有结果.故改为+2才对
                sumNum+=j;
                if(sumNum<sum)
                    list.add(j);
                else if(sumNum==sum){
                    list.add(j);
                    result.add(list);
                    break;
                }else{
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindContinuousSequence t=new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> a=t.FindContinuousSequence(3);
        for(int i=0;i<a.size();i++){
            for(int j=0;j<a.get(i).size();j++){
                System.out.print(a.get(i).get(j)+",");
            }
            System.out.println();
        }
    }
}
