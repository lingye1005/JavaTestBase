package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/18.
 * 求字符串中最长的不重复子串长度,并返回其长度
 */
public class lengthOfLongestSubstring {
    int maxLen;//最长不重复字符字串长度

    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        int len=s.length();
        for(int i=0;i<len && maxLen<len-i;i++){
            int j;
            for(j=i;j<len;j++){
                char temp=s.charAt(j);
                if(s.substring(i,j).contains(String.valueOf(temp))){
                    if(maxLen<j-i)
                        maxLen=j-i;
                    break;
                }
            }
            if(j==len && (len-i)>maxLen){
                maxLen=len-i;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring test=new lengthOfLongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("hchzvfrkmlnozjk"));
    }
}
