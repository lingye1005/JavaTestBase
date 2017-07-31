package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/17.
 * 求一个字符串中最长的一个回文字串
 */
public class longestPalindrome {
    int middlePoint;//最大回文串中间节点下标
    int maxLenght;//最大回文串长度
    boolean flag=false;//false表aba型,true表示abba型
    public String longestPalindrome(String s) {
        if(s==null || s.equals(""))
            return s;
        for(int i=0;i<s.length()-1 && maxLenght<2*(s.length()-i);i++){
          helper(s,i);
        }
        int from=middlePoint-(maxLenght-1)/2;
        int to=middlePoint+(maxLenght-1)/2;
        if(flag)
            to+=1;
        String re=s.substring(from,to+1);
        //System.out.println(re);//test
        return re;
    }

    //index为中间节点,在s中最长的回文序列
    void helper(String str,int index){
        int left,right;
        left=index;
        right=index;
        int tempMaxLength1=1;
        while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)){
             tempMaxLength1=right-left+1;
             left--;
             right++;
        }
        left=index;
        right=index+1;
        int tempMaxLength2=1;
        while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)){
            tempMaxLength2=right-left+1;
            left--;
            right++;
        }
        int tempMaxLength=tempMaxLength1>tempMaxLength2?tempMaxLength1:tempMaxLength2;

        if(tempMaxLength>maxLenght){
            middlePoint=index;
            maxLenght=tempMaxLength;
            //aba型
            if(maxLenght%2==1)
                flag=false;
            //abba型
            else
                flag=true;
        }
    }

    public static void main(String[] args) {
        longestPalindrome test=new longestPalindrome();
        test.longestPalindrome("aaaaa");
    }
}
