package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/26.
 * unique-binary-trees-search
 */
public class numTrees {
    public int numTrees(int n) {
        //卡特兰数A(2n,n)/(A(n,n)*(n+1))
        int dividend=1;
        int divisor=1;
        int result;
        if(n<4){
            for(int i=2*n;i>n;i--){
                dividend*=i;
            }
            for(int i=2;i<=n;i++){
                divisor*=i;
            }
            divisor*=n+1;
            return dividend/divisor;
        }
        else{
            for(int i=n+1,j=1;i<=2*n && j<=n;i++,j++){
                dividend*=i;
                divisor*=j;
                for(int k=i;k>=2 && divisor!=1;k--){
                    if(dividend%k==0 && divisor%k==0){
                        dividend=dividend/k;
                        divisor=divisor/k;
                    }
                }
            }
            result=dividend/divisor;
            return result/(n+1);
        }
    }



    public static void main(String[] args) {
        numTrees test=new numTrees();
        System.out.println(test.numTrees(9));
    }
}
