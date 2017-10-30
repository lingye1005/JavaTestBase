package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/20.
 * 有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。给定一个二位数组arr及题目中的参数n，请返回结果数组。
 */
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] result=new int[n*n];
        //第0行遍历n次;第1~(n-1)行遍历1次
        int idx=0; //result下标
        for(int i=0;i<n;i++){
            if(i==0){
                for(int j=0;j<n;j++){
                    int p=0,q=n-1-j;//行下标p,列下标q
                    while (p<n && q<n){
                        result[idx++]=arr[p][q];
                        p++;
                        q++;
                    }
                }
            }else{
                int p=i,q=0;
                while (p<n && q<n){
                    result[idx++]=arr[p][q];
                    p++;
                    q++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Printer a=new Printer();
        int[][] t=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] out=a.arrayPrint(t,4);
    }
}
