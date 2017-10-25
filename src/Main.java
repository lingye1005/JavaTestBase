import java.util.Scanner;

/**
 * 快速幂求法(二进制求解)
 * 算法思想:利用了二进制和幂的对应关系.
 * 举例:求Math.pow(3,5)值.求3的5次方的值.
 * (1)底数=3,幂=5;(base=3,exp=5);
 * (2)5转为二进制为101.
 * (3)
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);//在线笔试
        //求Math.pow(base,exp)的值
        int base=scanner.nextInt();//底数
        int exp=scanner.nextInt();//幂次

        if(exp==0){
            System.out.println(1); //任何数的0次幂结果都是1
        }else{
            int ret=1; //存放输出结果
            while (exp>0){
                if( (exp&1)==1 ){
                    ret*=base;
                }
                base*=base;
                exp=exp>>1; //不能直接写成exp>>1,会显示语法错误:not a statement.
            }
            System.out.println(ret);
        }
    }
}




