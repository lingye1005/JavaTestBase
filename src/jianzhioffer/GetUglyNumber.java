package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/3.
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 1,-1
 * 2,3,5,--3
 * 4,6,10,  9,15,25--6
 * 8,12,20,18,30,50,  27,45,75,125--10
 *
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index<0)
            return 0;
        int[] values=new int[index];
        values[0]=1;
        int count=1;
        int idx2=0,idx3=0,idx5=0;
        while (count<index){
            int minNum=min(values[idx2]*2,values[idx3]*3,values[idx5]*5);
            values[count]=minNum;
            while (values[idx2]*2<=values[count])
                idx2++;
            while (values[idx3]*3<=values[count])
                idx3++;
            while (values[idx5]*5<=values[count])
                idx5++;
            count++;
        }
        return values[index-1];
    }

    /**
     * 求3个数中最小的数字
     * @param a1
     * @param a2
     * @param a3
     * @return
     */
    int min(int a1,int a2,int a3){
        int tmp=Math.min(a1,a2);
        return Math.min(tmp,a3);
    }

    public static void main(String[] args) {
        GetUglyNumber t=new GetUglyNumber();
        System.out.println(t.GetUglyNumber_Solution(1500));
    }
}
