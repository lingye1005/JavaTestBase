package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 17:02
 * @ProjectName: JavaBaseTest
 */
public class duplicate {
    public static void main(String[] args) {
        duplicate t=new duplicate();
        int[] a={1,2,3,4,4,0};
        int[] dup=new int[1];
        boolean res=t.duplicate(a,a.length,dup);

        System.out.println(dup[0]);
        System.out.println(res);
    }


    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || length==0)
            return false;
        for(int i=0;i<length;i++){
            if(numbers[i]<0 || numbers[i]>=length)
                return false;
        }
        //deal
        for(int i=0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }else{
                    int tmp=numbers[i];
                    numbers[i]=numbers[numbers[i]];
                    numbers[tmp]=tmp;
                }
            }

        }
        return false;
    }
}
