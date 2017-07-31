package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/15.
 * 罗马数字转整数
 * 因为输入的一定是罗马数字，那么我们只要考虑两种情况即可：
 * 第一，如果当前数字是最后一个数字，或者之后的数字比它小的话，则加上当前数字
 * 第二，其他情况则减去这个数字
 */
public class romanToInt {
    public int romanToInt(String s) {
        int res=number(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(number(s.charAt(i))<=number(s.charAt(i-1))){
                res+=number(s.charAt(i));
            }else{
                res+=number(s.charAt(i))-2*number(s.charAt(-1));
            }
        }
        return res;
    }


    /**
     * 罗马字转为对应的十进制数字
     * @param c 被查找罗马字
     * @return
     */
    int number(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        romanToInt test=new romanToInt();
        System.out.println(test.romanToInt("DCXXI"));
    }
}
