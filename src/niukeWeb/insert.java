package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/6/29.
 * 给定一个数组intervals,里面每项都是一个长度范围.再给定一个长度范围,求出一个表达更简单的数组表达式(减少范围表达式个数),合并重复范围
 */
class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
}

public class insert {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals.size()==0 || (intervals.size()==1 &&intervals.get(0).start>=newInterval.start && intervals.get(0).end<=newInterval.end)){ //intervals为空 or 后面范围更大
            ArrayList<Interval> a=new ArrayList<Interval>();
            a.add(newInterval);
            return  a;
        }
        ArrayList<Interval> result=new ArrayList<Interval>();//保存结果
        int m=newInterval.start,n=newInterval.end; //插入长度的起点和终点
        int len=intervals.size(); //数组长度
        int j=0;
        int preNum=0,pNum=0;//记录合并节点的第一个和第二个节点值
        for(int i=0;i<len;i=j){
            Interval temp=intervals.get(i);//获取当前长度区间
            int start=temp.start;
            int end=temp.end;
            if(start<=m && end>=n){ //m-n范围在节点内
                result.add(temp);
                j++;
            }else if(end<m){ //m-n范围在当前节点右侧
                result.add(temp);
                //m-n范围在下一个节点范围左侧
                if(i+1<len){
                    if(intervals.get(i+1).start>n)
                        result.add(newInterval);
                }
                j++;
                if(j==len) //m-n范围在所有节点右侧,最后需要加到result后面
                    result.add(newInterval);
            }else if(start>n){ //m-n范围在当前节点左侧
                if(i==0)
                    result.add(newInterval);//m-n范围在所有节点前面,需要最先加入result里面
                result.add(temp);
                j++;
            }else {   //m-n范围在节点内,范围有重合,必须修改j值
                //是最后一个节点
                if(i==len-1){
                    Interval a=new Interval(Math.min(m,start),Math.max(n,end));
                    result.add(a);
                    break;
                }else{ //不是最后一个节点
                    preNum=Math.min(intervals.get(i).start,m);//新建节点的start
                    if(n>=intervals.get(i+1).start){ //需要跨节点
                        pNum=intervals.get(i+1).end;
                        j=i+1;
                        int k=0;
                        if(i+2<len)
                            for( k=i+2;k<len;k++){  //寻找pNum
                                if(intervals.get(k).start<=n){
                                    pNum=intervals.get(k).end;
                                    j=k;
                                }else {
                                    pNum=Math.max(n,intervals.get(k-1).end);
                                    break;
                                }
                            }
                        Interval a=new Interval(preNum,Math.max(n,pNum));
                        result.add(a);
                        j++;
                    }else{ //不需要跨界点
                        Interval a=new Interval(Math.min(m,start),Math.max(n,end));
                        result.add(a);
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        insert test=new insert();
        //test1
        Interval t1=new Interval(3,5);
        Interval t2=new Interval(12,15);
       //Interval t3=new Interval(6,6);
//        Interval t4=new Interval(8,10);
//        Interval t5=new Interval(12,16);


        Interval t6=new Interval(6,6);
        ArrayList<Interval> test1=new ArrayList<Interval>();
        test1.add(t1);
        test1.add(t2);
        //test1.add(t3);
//        test1.add(t4);
//        test1.add(t5);

        ArrayList<Interval> cout=test.insert(test1,t6);
        for(Interval a:cout){
            System.out.print("["+a.start+",");
            System.out.print(a.end+"]");
        }
        //tese2
    }
}
