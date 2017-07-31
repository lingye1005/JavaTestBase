package niukeWeb;


/**
 * Created by caoxiaohong on 17/7/9.
 * 求最长连续的符号匹配
 * 算法未写完,有问题
 */
public class longestValidParentheses {
    int max=0;

    public int longestValidParentheses(String s) {
        for(int i=0;i<s.length();i++){
            int n=helper(s.substring(i,s.length()));
            if(n>max)
                max=n;
        }
        return max;
    }

    
    int helper(String s){
        int temp=0;
        StringBuilder sb=new StringBuilder();
        //长度:1-len
        sb.append(String.valueOf(s.charAt(0)));
        for(int i=1;i<s.length();i++){
            sb.append(String.valueOf(s.charAt(i)));
            int length=sb.length();
            if(length>1 && String.valueOf(sb.charAt(length-2)).equals("(") && String.valueOf(sb.charAt(length-1)).equals(")")){
                temp+=2;
                //去掉字符串后两个字符
                String str=sb.substring(0,length-2);
                sb=new StringBuilder();
                sb.append(str);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        longestValidParentheses test=new longestValidParentheses();
        String s="()(((((((((()";
        System.out.println(test.longestValidParentheses(s));
    }
}
