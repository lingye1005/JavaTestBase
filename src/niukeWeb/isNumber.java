package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/27.
 * 判定一个字符串是否为数字
 * 最多包含一个小数点,仅仅第一位可以为正负号,其他各位必须全为数字
 */
public class isNumber {
    public boolean isNumber(String s) {
       try{
           Double d=Double.valueOf(s);
           char rear=s.charAt(s.length()-1);
           if(rear=='f' || rear=='F' || rear=='d' || rear=='D')
               return false;
           return true;
       }catch(NumberFormatException e){
           return false;
       }
    }

    public static void main(String[] args) {
        isNumber a=new isNumber();
        String t1="078332e437";
        System.out.println(a.isNumber(t1));
    }
}
