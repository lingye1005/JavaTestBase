package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/27.
 * 判定一个字符串是否为数字
 * 最多包含一个小数点,仅仅第一位可以为正负号,其他各位必须全为数字
 */
public class isNumber {
    public boolean isNumber(String s) {
        if(s==null || s.equals(""))
            return false;
        //s去除所有空格
        s=s.replace(" ","");
        int len=s.length();
        int countpoint=0;
        if(len==0)
            return false;
        for(int i=0;i<len;i++){
            if(i==0){
                if(s.charAt(i)=='+' || s.charAt(i)=='-')//第一位符号表达式
                    continue;
                else{
                    if(s.charAt(i)=='.') {//第一位为小数点
                        //return false;
                        countpoint++;
                        continue;
                    }
                    else{
                        if( (s.charAt(i)>=48 && s.charAt(i)<=57) || s.charAt(i)==32 ||(s.charAt(i)>=41 && s.charAt(i)<=46)) {
                            if(s.charAt(i)==32) {
                                continue;
                            }
                        }
                        else
                            return false;
                    }
                }
            }else{
                    if(s.charAt(i)=='.')
                        countpoint++;
                    if(countpoint<=1) {
                        if ((s.charAt(i) >= 48 && s.charAt(i) <= 57) || s.charAt(i)=='.' || s.charAt(i)==32 ||
                                (s.charAt(i)>=41 && s.charAt(i)<=46) || (s.charAt(i)>=97 && s.charAt(i)<=102)) {
                                continue;
                        }
                        else
                            return false;
                    }else{
                        return  false;
                    }
                }
        }
        if(len==1 && countpoint==1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        isNumber a=new isNumber();
        String t=".";
        String t1="0";
        String t2="0.1";
        String t3="abc";
        String t4="1 a";
        String t5="2e10";

        System.out.println(a.isNumber(t5));
        System.out.println(a.isNumber(t1));
        System.out.println(a.isNumber(t2));
        System.out.println(a.isNumber(t3));
        System.out.println(a.isNumber(t5));
    }
}
