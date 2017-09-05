package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/1.
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 算法思想:位运算
 * 三步走:(1)各位相加,不计进位.即为求异或
 * (2)记下进位
 * (3)把前两步的结果相加
 */
public class Add {
    public int Add(int num1,int num2) {
        if(num2==0)
            return num1;
        int sum=num1 ^ num2;//求异或
        int carry=(num1 & num2)<<1;//与运算后,左移一位
        return  Add(sum,carry);
    }
}
