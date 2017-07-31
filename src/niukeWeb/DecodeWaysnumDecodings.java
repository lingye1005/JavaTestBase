package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/27.
 * 给定数字字符串,求所有可能的编码组合
 * 数字1-26对应字母:A~Z
 * 很明显:类似30或者0开头的数字都是非法的
 */
public class DecodeWaysnumDecodings {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.equals("") || s.charAt(0)=='0')
            return 0;
        int len=s.length();
        if(len==1)
            return 1;
        //dp[i]表示:到str的第i个字符,可以有的解码方案总数
        int[] dp=new int[len];
        dp[0]=1;

        //求dp[1]
        int num=Integer.valueOf(s.substring(0,2));
        if(s.charAt(1)!='0' && num>0 && num<27 ){
            dp[1]=2;
        }else if(s.charAt(1)=='0' && s.charAt(0)>'2'){
            return 0;
        }else{
            dp[1]=1;
        }
        //求dp[i]:i=2~(len-1)的值.最后返回dp[len-1];
        //影响dp[i]值的数组值:dp[i-2],dp[i-1]
        for(int i=2;i<len;i++){
            int a=Integer.valueOf(s.substring(i-1,i+1));
            if(s.charAt(i)!='0' && a>10 && a<27){
                dp[i]=dp[i-1]+dp[i-2];
            }else if(s.charAt(i)=='0' && s.charAt(i-1)!='0' && a<27){
                dp[i]=dp[i-2];
            }else if(s.charAt(i)!='0'){
                dp[i]=dp[i-1];
            }else
                return 0;
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        DecodeWaysnumDecodings test=new DecodeWaysnumDecodings();
        System.out.println(test.numDecodings("230"));
    }
}
