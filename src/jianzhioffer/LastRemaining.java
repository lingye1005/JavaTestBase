package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/1.
 * ...请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        //构造循环队列,某个元素被删除后,queue[i]值置为-1;
        int[] queue=new int[n];
        for(int i=0;i<n;i++)
            queue[i]=i;
        int count=n;//总人数
        int preNum=0;
        while (count>1){
            int tmpCount=0;
            int i;
            for(i=preNum;tmpCount<m-1;){
                if(queue[i]!=-1)
                    tmpCount++;
                if(i+1>=n)
                    i=0;
                else
                    i+=1;
            }
            if(tmpCount==m-1){
                if(i+1<n)
                    preNum=i+1;
                else
                    preNum=0;
            }
            if(queue[i]!=-1)
                queue[i]=-1;
            else{
                for(int j=i;;){
                    if(queue[j]!=-1){
                        queue[j]=-1;
                        break;
                    }else{
                        if(j==n-1)
                            j=0;
                        else
                            j+=1;
                    }
                }
            }
            count--;
        }
        for(int low=0,high=n-1;low<=high;low++,high--){
            if(queue[low]!=-1)
                return low;
            if(queue[high]!=-1)
                return high;
        }
        return -1;
    }

    public static void main(String[] args) {
        LastRemaining t=new LastRemaining();
        int n=5,m=3;
        System.out.println(t.LastRemaining_Solution(n,m));
    }
}
