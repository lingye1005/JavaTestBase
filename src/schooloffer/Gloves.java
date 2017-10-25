package schooloffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by caoxiaohong on 17/9/23.
 * 在地下室里放着n种颜色的手套，手套分左右手，但是每种颜色的左右手手套个数不一定相同。.....
 */
public class Gloves {
    public int findMinimum(int n, int[] left, int[] right) {
        // write code here
        int sum=0;
        ArrayList<Integer> list1=new ArrayList<Integer>();
        ArrayList<Integer> list2=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if((left[i]==0 && right[i]!=0) || (left[i]!=0 && right[i]==0)){
                sum+=Math.max(left[i],right[i]);
            }
            if(left[i]!=0 && right[i]!=0){
                list1.add(left[i]);
                list2.add(right[i]);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);

        int sum1=0;
        int sum2=0;
        for(int i=list1.size()-1;i>0;i--){
            sum1+=list1.get(i);
            sum2+=list2.get(i);
        }
        return Math.min(sum1,sum2)+2+sum;
    }

    public static void main(String[] args) {
        Gloves t=new Gloves();
        int[] a={1,2,0,1,3,1};
        int[] b={0,0,0,2,0,1};
        System.out.println(t.findMinimum(6,a,b));
    }
}
