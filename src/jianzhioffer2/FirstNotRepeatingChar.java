package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 16:38
 * @ProjectName: JavaBaseTest
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.equals(""))
            return -1;
        int len=str.length();
        for(int i=0;i<len;i++){
            char tmp=str.charAt(i);
            if(str.indexOf(tmp)==str.lastIndexOf(tmp))
                return i;
        }
        return -1;
    }
}
