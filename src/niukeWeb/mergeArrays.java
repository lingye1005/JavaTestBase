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
    //sort
    void bubbleSort(ArrayList<Interval> intervals){
        for(int i=0;i<intervals.size();i++){
            boolean flag=true;
            for(int j=intervals.size()-1;j>i;j--){
                if(intervals.get(j).start<intervals.get(j-1).start){
                    Interval temp=intervals.get(i);
                    intervals.set(i,intervals.get(j));
                    intervals.set(j,temp);
                    flag=false;
                }
            }
            if(flag)
                return;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals==null || intervals.size()==0 || intervals.size()==1)
            return intervals;
        //按照start排序
        bubbleSort(intervals);

        int preNum=0,pNum=0;//记录新建节点的第一个和第二个值
        int len=intervals.size();
        ArrayList<Interval> result=new ArrayList<Interval>();//存放结果
        int next=0;//用于记录合并节点后下一个节点序号从哪里开始
        for(int i=0;i<len;i=next){
            if(i==len-1){//如果是最后一个节点
                if(intervals.get(i).start>pNum)
                    result.add(intervals.get(i));
                next++;
            }else{
                if(intervals.get(i+1).start>intervals.get(i).end){ //不需要与后面节点合并
                    result.add(intervals.get(i));
                    next++;
                }else{
                    preNum=Math.min(intervals.get(i).start,intervals.get(i+1).start) ;
                    pNum=Math.max(intervals.get(i).end,intervals.get(i+1).end);
                    int j=0;
                    for(j=i+2;j<len;){
                        if(j<len-1){ //不到最后一个节点
                            if(pNum>=intervals.get(j).start){//继续合并
                                    pNum = Math.max(intervals.get(j).end, pNum);
                                    preNum=Math.min(intervals.get(j).start,preNum);
                                j++;
                                next=j;
                                continue;
                            }else{ //不再合并
                                next=j-1;
                                break;
                            }
                        }else{ //到达最后一个节点
                            //最后一个节点不需要合并
                            if(pNum<intervals.get(j).start)
                                next=j-1;
                            //最后一个节点需要合并
                            else {
                                preNum = Math.min(preNum, intervals.get(j).start);
                                pNum = Math.max(pNum, intervals.get(j).end);
                                next = j;
                            }
                        }
                    }
                    next++;
                    Interval a=new Interval(preNum,pNum);
                    result.add(a);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        mergeArrays test=new mergeArrays();
        Interval t1=new Interval(1,3);
        Interval t2=new Interval(2,6);
        Interval t3=new Interval(8,10);
        Interval t4=new Interval(15,18);
        Interval t5=new Interval(5,7);
        Interval t6=new Interval(2,2);
        Interval t7=new Interval(4,6);
        ArrayList<Interval> list=new ArrayList<Interval>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        list.add(t7);

        //out
        ArrayList<Interval> cout=test.merge(list);
        for(Interval interval:cout){
            System.out.print("["+interval.start+","+interval.end+"]");
            System.out.println();
        }
    }
}
