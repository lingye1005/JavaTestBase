package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/15.
 */
public class intToRoman {
    public String intToRoman(int num) {
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };

        String result="";
        int rowindex=0;
        while(num!=0){
            int temp=num%10;//依次得到个位/十位/百位/千位的数字
            result=roman[rowindex][temp]+result; //注意:此处的两个加数是有顺序的,result必须在后面,才能保证从低位到高位的数字获得拼接后依然保证低位在低位
            rowindex++;
            num=num/10;
        }
        return result;
    }

    public static void main(String[] args) {
        intToRoman test=new intToRoman();
        System.out.println(test.intToRoman(12));
    }
}
