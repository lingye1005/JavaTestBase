package designmodel.chapter2;

import java.text.DecimalFormat;

/**
 * @Author: cxh
 * @CreateTime: 18/1/1 12:04
 * @ProjectName: JavaBaseTest
 * 客户端:测试
 */
public class Client {
    public static void main(String[] args) {
        double result=0;
        int flag=0;//0,1,2,3代表:正常价格 ;七折; 满100减去5;  积分抵扣现金
        ContextStrategyRef cs;
        for(int i=10;i<60;i+=10){
            if(flag==0){
                cs=new ContextStrategyRef("正常收费");
                result+=cs.getSum(i);
                flag++;
                continue;
            }else if(flag==1){
                cs=new ContextStrategyRef("折扣7折");
                result+=cs.getSum(i);
                flag++;
                continue;
            }else if(flag==2){
                cs=new ContextStrategyRef("满100减5");
                result+=cs.getSum(i);
                flag++;
            }else if(flag==3){
                cs=new ContextStrategyRef("1000积分抵扣1元");
                result+=cs.getSum(i);
                flag=0;
            }
        }
        //保留2位小数
        DecimalFormat df=new DecimalFormat("#.00");
        System.out.println(df.format(result));
    }
}
