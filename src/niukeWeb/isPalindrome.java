package niukeWeb;

/**
 * Created by caoxiaohong on 17/5/13.
 * 给定一个string,判定是否为回文序列
 * 注意:字符串可以包含标点符号和大小写不定.
 * 所以应该先去掉标点符号和统一为大小写,再从字符串两端开始判定
 */
public class isPalindrome {

    public boolean isPalindromeT(String s) {
        //string去掉空格
        String s1=s.replace(" ","");
        //string去标点符号
        String s2=s1.replaceAll("[\\pP\\p{Punct}]", "");
        //string转为小写
        String s3=s2.toLowerCase();

        char[] temp=s3.toCharArray();
        int length=temp.length;
        int left=0,right=length-1;
        while(left<right){
            if(temp[left]==temp[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        //test
        //String ss=str.replace(" ","");
        //System.out.println(ss);

        isPalindrome test=new isPalindrome();
        boolean istrue=test.isPalindromeT(str);
        System.out.println(istrue);
    }
}
