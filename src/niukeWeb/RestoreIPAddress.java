package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/27.
 * 给定字符串,仅仅包含数字.求这个字符串可以表示的有效IP地址有多少种组合.返回所有组合
 */
public class RestoreIPAddress {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result=new ArrayList<String>();

        if(s==null || s.length()<4 || s.length()>12)
            return result;
        int len=s.length();//字符串长度
        for(int i=1;i<4 && i<len-2;i++){
            for(int j=i+1;j<i+4 && j<len-1;j++){
                for(int k=j+1;k<j+4 && k<len;k++){
                    String str1=s.substring(0,i);
                    String str2=s.substring(i,j);
                    String str3=s.substring(j,k);
                    String str4=s.substring(k,len);
                    if(isValid(str1) && isValid(str2) && isValid(str3) && isValid(str4)){
                        StringBuilder sb=new StringBuilder();
                        sb.append(str1);
                        sb.append(".");
                        sb.append(str2);
                        sb.append(".");
                        sb.append(str3);
                        sb.append(".");
                        sb.append(str4);
                        result.add(sb.toString());
                    }
                }
            }
        }
        return result;
    }

    /**
     * 判定IP地址,1/4处是否有效
     * 测试数据中:如果partIP位数超过1,则第一位不允许为0
     * @param partIP
     * @return
     */
    boolean isValid(String partIP){
        if(partIP.length()>3 || (partIP.length()>1 && partIP.charAt(0)=='0'))
            return false;
        int num=Integer.valueOf(partIP);
        if(num>255)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {

    }
}
