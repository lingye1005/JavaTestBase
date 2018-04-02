package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 10:11
 * @ProjectName: JavaBaseTest
 */
public class LeftRotateString {
    //test
    public static void main(String[] args) {
        LeftRotateString t=new LeftRotateString();
        String out=t.LeftRotateString("abcXYZdef",3);
        System.out.println(out);
    }


    public String LeftRotateString(String str,int n) {

        if(str==null || str.length()==0)
            return "";
        if(n==0 || n==str.length())
            return str;
        //deal
        int len=str.length();
        //全部
        str=getReverse(str,0,len-1);
        //［0，len-n-1］
        str=getReverse(str,0,len-n-1);
        //［len-n，len-1］
        str=getReverse(str,len-n,len-1);
        return str;
    }
    //字符串旋转，［low，high］
    private String getReverse(String str,int low,int high){
        char[] tmp=str.toCharArray();
        while(low<high){
            char cc= tmp[low];
            tmp[low]=tmp[high];
            tmp[high]=cc;
            low++;
            high--;
        }
        return String.valueOf(tmp);
    }
}
