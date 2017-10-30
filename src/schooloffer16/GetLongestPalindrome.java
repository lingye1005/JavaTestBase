package schooloffer16;

/**
 * Created by caoxiaohong on 17/10/11.
 */
public class GetLongestPalindrome {
    public int getLongestPalindrome(String A, int n) {
        // write code here
        int max=-1;
        for(int i=0;i<n && max<Math.max(n-i-1,i)*2+1;i++){
            int tmp=maxLen1(A,i,n)>maxLen2(A,i,n)?maxLen1(A,i,n):maxLen2(A,i,n);
            max=max>tmp?max:tmp;
        }
        return max;
    }
    //对于一个字符串,以其为中间对称点
    private int maxLen1(String str,int idx,int len){
        int from=idx-1,to=idx+1;
        while (from>-1 && to <len){
            if(str.charAt(from)!=str.charAt(to))
                break;
            else {
                from--;
                to++;
            }
        }
        if(from==idx-1 && to==idx+1)
            return 1;
        return to-from-1;
    }
    //对于一个字符串,以其和其后一位字符为对称点
    private int maxLen2(String str,int idx,int len){
        int from=idx,to=idx+1;
        while (from>-1 && to<len){
            if(str.charAt(from)!=str.charAt(to))
                break;
            else {
                from--;
                to++;
            }
        }
        if(from==idx && to==idx+1)
            return 1;
        return to-from-1;
    }

    //test code
    public static void main(String[] args) {
        GetLongestPalindrome t=new GetLongestPalindrome();
        System.out.println(t.getLongestPalindrome("abc1234321ab",12));
    }
}
