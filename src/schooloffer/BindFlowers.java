package schooloffer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/9/22.
 * 扎金花: 两个搜狐的程序员加了一个月班，终于放假了，于是他们决定扎金花渡过愉快的假期 。...
 * 90%通过率,最后一个case在idea里面没有问题,不知道为什么牛客网不对....
 */

public class BindFlowers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str1=scanner.next();
            String str2=scanner.next();
            //长度范围:3-6;  10和0个数是否一致;  是否还包含其他字符
            if(str1.length()<3 || str1.length()>6 || str2.length()<3 || str2.length()>6 || !isConstain(str1) || !isConstain(str2) ||
                    isContainsOthers(str1) || isContainsOthers(str2))
                System.out.println(-2);
            else{
                int[] tmp11=new int[3];
                int[] tmp22=new int[3];

                if(str1.length()==3) {
                    tmp11[0]=helper(str1.charAt(0));
                    tmp11[1]=helper(str1.charAt(1));
                    tmp11[2]=helper(str1.charAt(2));
                }
                else{
                    if(str1.length()==4){
                        tmp11[0]=10;
                        str1=str1.replace("10","");
                        tmp11[1]=helper(str1.charAt(0));
                        tmp11[2]=helper(str1.charAt(1));
                    }else if(str1.length()==5){
                        tmp11[0]=10;
                        tmp11[1]=10;
                        str1=str1.replace("10","");
                        tmp11[2]=helper(str1.charAt(0));
                    }else{
                        tmp11[0]=10;
                        tmp11[1]=10;
                        tmp11[2]=10;
                    }
                }
                if(str2.length()==3){
                    tmp22[0]=helper(str2.charAt(0));
                    tmp22[1]=helper(str2.charAt(1));
                    tmp22[2]=helper(str2.charAt(2));
                }else{
                    if(str2.length()==4){
                        tmp22[0]=10;
                        str2=str2.replace("10","");
                        tmp22[1]=helper(str2.charAt(0));
                        tmp22[2]=helper(str2.charAt(1));
                    }else if(str2.length()==5){
                        tmp22[0]=10;
                        tmp22[1]=10;
                        str2=str2.replace("10","");
                        tmp22[2]=helper(str2.charAt(0));
                    }else{
                        tmp22[0]=10;
                        tmp22[1]=10;
                        tmp22[2]=10;
                    }
                }

                //输入是否合法?判断两个int[]是否有4个以上数字相同
                if(isValid(tmp11,tmp22)==false){
                    System.out.println(-2);
                    continue;
                }

                Arrays.sort(tmp11);
                Arrays.sort(tmp22);

                //查看牌类型;
                //tmp11
                int flag1;
                if(tmp11[0]==tmp11[2]){//豹子
                    flag1=1;
                }else if(tmp11[1]-tmp11[0]==1 && tmp11[2]-tmp11[1]==1){//顺子
                    flag1=2;
                }else if( (tmp11[1]==tmp11[0] && tmp11[1]!=tmp11[2]) || (tmp11[1]==tmp11[2] && tmp11[1]!=tmp11[0])){//对子
                    flag1=3;
                }else {
                    flag1=4; //普通牌型
                }

                //tmp22
                int flag2;
                if(tmp22[0]==tmp22[2]){
                    flag2=1;
                }else if(tmp22[1]-tmp22[0]==1 && tmp22[2]-tmp22[1]==1){
                    flag2=2;
                }else if( (tmp22[1]==tmp22[0] && tmp22[1]!=tmp22[2]) || (tmp22[1]==tmp22[2] && tmp22[1]!=tmp22[0])){
                    flag2=3;
                }else{
                    flag2=4;
                }

                //判定牌大小
                if(flag1==1 && flag2>1){
                    System.out.println(1);
                }else if(flag1==1 && flag2==1){
                    if(tmp11[0]>tmp11[0]){
                        System.out.println(1);
                    }else{
                        System.out.println(-1);
                    }
                }else if(flag1==2 && flag2==1){
                    System.out.println(-1);
                }else if(flag1==2 && flag2==2){
                    if(tmp11[0]==tmp22[0])
                        System.out.println(0);
                }else if(flag1==2 && flag1>2){
                    System.out.println(1);
                }else if(flag1==3 && flag2<3){
                    System.out.println(-1);
                }else if(flag1==3 && flag2==3){
                    //先比较对子大小,如果对子大小一致,再比较另一张牌大小
                    if(tmp11[1]>tmp22[1]){
                        System.out.println(1);
                    }else if(tmp11[1]<tmp22[1]){
                        System.out.println(-1);
                    }else{
                        int simple1=tmp11[1]==tmp11[2]?tmp11[0]:tmp11[2];
                        int simple2=tmp22[1]==tmp22[2]?tmp22[0]:tmp22[2];
                        if(simple1>simple2)
                            System.out.println(1);
                        else if(simple1==simple2)
                            System.out.println(0);
                        else
                            System.out.println(-1);
                    }
                }else if(flag1==3 && flag2>3){
                    System.out.println(1);
                }else if(flag1==4 && flag2<4){
                    System.out.println(-1);
                }else if(flag1==4 && flag2==4){
                    if(tmp11[2]>tmp22[2] || (tmp11[2]==tmp22[2] && tmp11[1]>tmp22[1]) || (tmp11[2]==tmp22[2] && tmp11[1]>tmp22[1] && tmp11[0]>tmp22[0])){
                        System.out.println(1);
                    }else{
                        System.out.println(-1);
                    }
                }
            }
        }
    }
    //处理123...JQKA
    private static int helper(char c){
        if(c=='1')
            return 1;
        else if(c=='2')
            return 2;
        else if(c=='3')
            return 3;
        else if(c=='4')
            return 4;
        else if(c=='5')
            return 5;
        else if(c=='6')
            return 6;
        else if(c=='7')
            return 7;
        else if(c=='8')
            return 8;
        else if(c=='9')
            return 9;
        else if(c=='J')
            return 11;
        else if(c=='Q')
            return 12;
        else if(c=='K')
            return 13;
        else if(c=='A')
            return 14;
        else
            return 10;//因为10不能是字符,所以只能最后处理
    }
    //输入是否合法
    private static boolean isValid(int[] a,int[] b){
        int[] tmp=new int[a.length+b.length];
        System.arraycopy(a,0,tmp,0,a.length);
        System.arraycopy(b,0,tmp,a.length,b.length);
        Arrays.sort(tmp);//012345
        if(tmp[0]==tmp[4] || tmp[1]==tmp[5])
            return false;
        else
            return true;
    }

    //判定0的个数和10的个数一样
    private  static  boolean isConstain(String str){
        int count1=0;
        int count10=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0')
                count1++;
        }
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)=='1' && str.charAt(i+1)=='0')
                count10++;
        }
        return count1==count10;
    }
    //判定一个字符串包含字母
    private  static  boolean isContainsOthers(String str){
        String tmp=str.replace("2","").replace("3","").replace("4","").replace("5","").replace("6","").replace("7","")
                .replace("8","").replace("9","").replace("10","").replace("J","").replace("Q","").replace("K","").replace("A","");
        if(tmp.length()>0)
            return true;
        else
            return false;
    }
}
