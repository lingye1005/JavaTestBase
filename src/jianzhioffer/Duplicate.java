package jianzhioffer;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/9/1.
 */
public class Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length==0)
            return true;
        Arrays.sort(numbers);
        int countDupl=0;
        for(int i=0;i<length;){
            if(i>=0 && i<length-1){
                if(i+1<length && numbers[i]!=numbers[i+1]){
                    i+=1;
                }else if(i+1<length && numbers[i]==numbers[i+1]){
                    if(countDupl==0)
                        duplication[0]=numbers[i];
                    countDupl+=1;
                    i+=2;
                }
            }else{
                if(i-1>=0 && numbers[i]!=numbers[i-1])
                    i+=1;
            }
        }
        if(countDupl>=1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Duplicate t=new Duplicate();
        int[] a={2,4,3,1,4};
        int[] b=new int[1];
        t.duplicate(a,5,b);
    }
}
