package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

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
        if(index==1)
            return 1;
        else if(index==2)
            return 2;
        else if(index==3)
            return 3;
        else if(index==4)
            return 5;

        ArrayList<Integer> values=new ArrayList<Integer>();
        //values.add(1);
        values.add(2);
        values.add(3);
        values.add(5);
        while (values.size()<index-1) {
            //*2
            for (int i = 0; i < values.size(); i++) {
                if (!values.contains(values.get(i) * 2)) {
                    values.add(values.get(i) * 2);
                    if (values.size() == index - 1)
                        break;
                }
            }
            //*3
            for(int i=values.size()/2;i<values.size();i++){
                if (!values.contains(values.get(i) * 3)) {
                    values.add(values.get(i) * 3);
                    if (values.size() == index - 1)
                        break;
                }
            }
            //*5

        }
        values.add(1);
        Collections.sort(values);
        return values.get(values.size()-1);
    }

    public static void main(String[] args) {
        GetUglyNumber t=new GetUglyNumber();
        System.out.println(t.GetUglyNumber_Solution(10));
    }
}
