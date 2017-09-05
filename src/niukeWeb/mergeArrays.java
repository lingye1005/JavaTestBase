package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/6/30.
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given[1,3],[2,6],[8,10],[15,18],
 * return[1,6],[8,10],[15,18].
 * 注意:这个题目和上个题目不一样的地方:各个相邻长度范围之间可以有重合
 */
public class mergeArrays {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals==null || intervals.size()==0 || intervals.size()==1)
            return intervals;
        //按照start排序
        bubbleSort(intervals);

        int iSize=intervals.size();
        ArrayList<Interval> result=new ArrayList<Interval>();//存放结果
        //每次循环找出start相同的几个子数组,让这几个子数组中范围最大的数组去和结果result比较.
        for(int i=0;i<iSize;){
            int index=i;//记录最大范围的子数组下标
            int j;
            for(j=i+1;j<iSize;){
                if(intervals.get(j).start==intervals.get(i).start){
                    if(intervals.get(j).end>intervals.get(index).end){
                       index=j;
                    }
                    j++;
                }else{
                    break;
                }
            }

            //获取最大范围的子数组
            Interval maxRange=intervals.get(index);
            if(i!=0){
                //获取结果集中最后一个数组;
                Interval tail = result.get(result.size() - 1);
                //显然maxRange.start>tail.start.所以只针对数值范围右侧end进行判定.有3种情况
                if (maxRange.end <= tail.end && maxRange.start <= tail.end) {
                    i=j;
                    //result不改变
                    continue;
                } else if (maxRange.end >= tail.end && maxRange.start <= tail.end) {
                    //新生成一个节点Interval
                    Interval newInterval = new Interval(tail.start, maxRange.end);
                    //删除result中最后一个节点.
                    result.remove(result.size() - 1);
                    //为result添加刚刚生成的节点
                    result.add(newInterval);
                } else if (tail.end < maxRange.start) {
                    result.add(maxRange);
                }
            }else{
                result.add(maxRange);
            }
            //更改i的值
            i=j;
        }
        return result;
    }

    /**
     * 将待合并数组,按照start进行升序排序.
     * 冒泡法
     * @param intervals
     */
    void bubbleSort(ArrayList<Interval> intervals){
        for(int i=0;i<intervals.size();i++){
            boolean flag=true;
            for(int j=intervals.size()-1;j>i;j--){
                if(intervals.get(j).start<intervals.get(j-1).start){
                    Interval temp=intervals.get(j-1);
                    intervals.set(j-1,intervals.get(j));
                    intervals.set(j,temp);
                    flag=false;
                }
            }
            if(flag)
                return;
        }
    }
    public static void main(String[] args) {
        mergeArrays test=new mergeArrays();
        Interval t1=new Interval(9,11);
        Interval t2=new Interval(9,13);
        Interval t3=new Interval(0,0);
        Interval t4=new Interval(9,12);
        Interval t5=new Interval(3,5);
        Interval t6=new Interval(7,9);
        Interval t7=new Interval(1,2);
        Interval t8=new Interval(6,7);
        Interval t9=new Interval(8,8);
        Interval t10=new Interval(4,4);
        Interval t11=new Interval(1,2);
        Interval t12=new Interval(3,3);
        ArrayList<Interval> list=new ArrayList<Interval>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        list.add(t7);
        list.add(t8);
        list.add(t9);
        list.add(t10);
        list.add(t11);
        list.add(t12);

        //out
        ArrayList<Interval> cout=test.merge(list);
        for(Interval interval:cout){
            System.out.print("["+interval.start+","+interval.end+"]");
            System.out.println();
        }
    }
}
