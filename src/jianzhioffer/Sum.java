package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/1.
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 算法思想:递归求和1+2+3...+n
 */
public class Sum {
    public int Sum_Solution(int n) {
        return helper(n);
    }
    int helper(int num){
        if(num<=0)
            return 0;
        return num+helper(num-1);
    }

    public static void main(String[] args) {
        Sum t=new Sum();
        System.out.println(t.Sum_Solution(6));
    }
}
