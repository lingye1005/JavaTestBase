package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/10/31.
 * n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果...
 */
public class DivideApples {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        String[] apples;
        while (scanner.hasNext()){
            n=Integer.valueOf(scanner.nextLine().trim());
            apples=scanner.nextLine().split(" ");
            //求苹果总个数
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=Integer.valueOf(apples[i]);
            }
            //如果总苹果个数不能被平均分配,则不存在解决方案
            if(sum%n!=0){
                System.out.println(-1);
                continue;
            }
            int avg=sum/n;
            //如果有奶牛拥有的苹果个数和avg的差不是2的整数倍,则不存在解决方案
            boolean notFind=false;
            for(int i=0;i<n;i++){
                if(Math.abs(Integer.valueOf(apples[i])-avg)%2!=0){
                    System.out.println(-1);
                    notFind=true;
                    break;
                }
            }
            if(notFind)
                continue;
            //存在解决方案:最少移动次数
            int p=0,helper=0; //p为当前需要被分给苹果的奶牛下标,helper为向外分出苹果的奶牛下标
            //找到第一个helper位置
            for(int i=0;i<n;i++){
                if(Integer.valueOf(apples[i])>avg){
                    helper=i;
                    break;
                }
            }
            //移动开始
            int steps=0;
            int pApple=0;
            int hApple=0;
            while (p<n && helper<n){
                pApple=Integer.valueOf(apples[p]);
                if(pApple>=avg){
                    p++;
                    continue;
                }
                if(pApple<avg){
                    steps++;

                    hApple=Integer.valueOf(apples[helper]);
                    apples[helper]=String.valueOf(hApple-2);
                    apples[p]=String.valueOf(pApple+2);
                    //是否修改helper指针
                    if(hApple-2==avg){
                        for(int i=helper+1;i<n;i++){
                            if(Integer.valueOf(apples[i])>avg){
                                helper=i;
                                break;
                            }
                        }
                    }
                    //是否修改p指针
                    if(pApple+2==avg){
                        for(int i=p+1;i<n;i++){
                            if(Integer.valueOf(apples[i])<avg){
                                p=i;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(steps);
        }
    }
}
