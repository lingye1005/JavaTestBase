package schooloffer;

/**
 * Created by caoxiaohong on 17/9/19.
 * 果园里有一堆苹果，一共n头(n大于1小于9)熊来分，第一头为小东，它把苹果均分n份后，多出了一个，它扔掉了这一个，拿走了自己的一份苹果，
 * 接着第二头熊重复这一过程，即先均分n份，扔掉一个然后拿走一份，以此类推直到最后一头熊都是这样(最后一头熊扔掉后可以拿走0个，也算是n份均分)。问最初这堆苹果最少有多少个。
 * 还没a过
 */
public class Apples {
    public int getInitial(int n) {
        // write code here
        int sum,res,bear;
        for(int i=n+1;;i++){
            bear=n;
            sum=i;
            res=sum;
            while (bear>0){
                if(sum%n==1){
                    sum=sum-sum/n-1;
                    bear--;
                }else{
                    break;
                }
            }
            if(bear==0)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        Apples t=new Apples();
        System.out.println(t.getInitial(3)); //25
    }
}
