package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/16.
 * 整数倒置
 */
public class reverse {
    public int reverse(int x) {
        int b=x;
        if(x==0)
            return 0;
        else{
            int count=0;
            ArrayList<Integer> temp=new ArrayList<Integer>();
            x=Math.abs(x);
            while(x>0){
                int a=x%10;
                temp.add(a);
                count++;
                x=x/10;
            }
            int result=0;
            for(int i=0;i<temp.size();i++){
                result+=temp.get(i)*Math.pow(10,--count);
            }
            if(b>0)
                return result;
            else
                return 0-result;
        }

    }
    static void helper(){

    }

    public static void main(String[] args) {
        reverse test=new reverse();
        System.out.println(test.reverse(-123));
    }
}
