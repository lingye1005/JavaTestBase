package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/11.
 */
public class nextPermutation {

    public void nextPermutation(int[] num) {
        //从后向前找第一个升序数值对
        if(num==null || num.length==1)
            return;
        int len=num.length;
        int change=-1;//num[change-1]<num[change]
        for(int i=len-1;i>0;i--){
            if(num[i]>num[i-1]){
                change=i;
                break;
            }
        }
        if(change==len-1){
            int temp=num[change];
            num[change]=num[change-1];
            num[change-1]=temp;
        }else if(change==-1){  //全为降序
            for(int i=0,j=len-1;i<j;i++,j--){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }else{
            //找出change~len-1中第一个比num[change-1]大的数,交换位置;
            for(int j=len-1;j>=change;j--){
                if(num[j]>num[change-1]){
                    int temp=num[j];
                    num[j]=num[change-1];
                    num[change-1]=temp;
                    break;
                }
            }
            //升序排列change~len-1的数字;
            for(int k=change,j=len-1;k<j;k++,j--){
                int temp=num[k];
                num[k]=num[j];
                num[j]=temp;
            }
        }
    }


    public static void main(String[] args) {
        nextPermutation test=new nextPermutation();
        int[] a={1,2,3,1,2};
        test.nextPermutation(a);
        for(int i:a){
            System.out.println(i);
        }

    }
}
