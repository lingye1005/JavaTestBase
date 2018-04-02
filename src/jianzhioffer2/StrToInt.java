package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 16:01
 * @ProjectName: JavaBaseTest
 */
public class StrToInt {

    //test
    public static void main(String[] args) {
        StrToInt t=new StrToInt();
        System.out.println(t.StrToInt("+2147483647"));
        System.out.println(t.StrToInt("-233333"));
        System.out.println(t.StrToInt("-2147483648"));
    }

    public int StrToInt(String str) {
        if(str==null || str.length()==0)
            return 0;
        //deal
        if(!isValid(str))
            return 0;
        long res;
        if(str.charAt(0)=='+' || str.charAt(0)=='-')
            res=toInt(str.substring(1));
        else
            res=toInt(str);
        //System.out.println("orl:"+res);
        if(str.charAt(0)!='-')
            return (int)res;
        String str0=String.valueOf("-"+res);
        return Integer.valueOf(str0);
    }
    //字符串转为整数
    private long toInt(String str){
        int carry=0;
        int len=str.length();
        int base=0;
        long sum=0;//可能会溢出,故不能为int类型
        while(len-->0){
            int num=Integer.valueOf(String.valueOf(str.charAt(len)));
            num+=carry;
            sum+=Math.pow(10,base)*(num%10);
            carry=num/10;
            base++;
        }
        if(carry!=0){
            sum+=Math.pow(10,base);
        }
        return sum;
    }
    //判定一个字符串是否合法
    private boolean isValid(String str){
        str=str.replaceAll("1","").replaceAll("2","").replaceAll("3","").replaceAll("4","").
                replaceAll("5","").replaceAll("6","").replaceAll("7","").replaceAll("8","").
                replaceAll("9","").replaceAll("0","");
        if(str.length()==0 || str.equals("+") || str.equals("-"))
            return true;
        else
            return false;
    }
}
