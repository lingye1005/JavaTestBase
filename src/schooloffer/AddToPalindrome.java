package schooloffer;

/**
 * Created by caoxiaohong on 17/10/10.
 * 对于一个字符串，我们想通过添加字符的方式使得新的字符串整体变成回文串，但是只能在原串的结尾添加字符，请返回在结尾添加的最短字符串。
 * 算法思想:不管是偶数还是技术个字符,开始遍历位置都是len/2,因为必须保证开始位置mid,在mid左边的字符个数<=mid右边字符个数
 * eg:abc    开始位置:3/2=1---b开始
 *    abcd   开始位置:4/2=2---c开始
 * 只要任意一次mid右侧字符可以遍历到最后一个字符,则说明此次查找成功.
 * 但是注意:对于偶数个字符的字符串,首先应该确定一次,本身是不是已经是回文:即为第一次比较为mid和mid-1比较.而不是mid+1和mid-1比较.
 */
public class AddToPalindrome {
    public String addToPalindrome(String A, int n) {
        // write code here
        if(n%2==0 && isPalindrome(A,n))//是偶数个字符且本来就是回文串
            return "";
        for(int i=n/2;i<n;i++){
            if(isMidPalin1(A,i,n)){//i为对称中心
                int to=2*i-n+1;
                String tmp=A.substring(0,to);
                return revStr(tmp);
            }
            if(isMidPalin2(A,i,n)){ //i和i+1为对称中心
                int to=2*i-n+2;
                String tmp=A.substring(0,to);
                return revStr(tmp);
            }
        }
        //没有找到
        String tmp=A.substring(0,n-1);
        return revStr(tmp);
    }

    /**
     * 判定偶数个字符的字符串是否回文
     * @param str
     * @param len
     * @return
     */
    private boolean isPalindrome(String str,int len){
        for(int i=0,j=len-1;i<j;i++,j--){
            if(str.charAt(i)!=str.charAt(j))
                return false;
        }
        return true;
    }
    /**
     * 字符串反转
     * @param str
     * @return
     */
    private String revStr(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--)
            sb.append(str.charAt(i));
        return sb.toString();
    }

    /**
     * 按照mid为对称中心
     * 通过数学计算发现:此方法找到的需要添加的字符个数比下面2方法少1个字符
     * @param str
     * @param mid
     * @return
     */
    private boolean isMidPalin1(String str,int mid,int len){
        int from=mid-1,end=mid+1;
        while (from>=0 && end<len){
            if(str.charAt(from)!=str.charAt(end))
                return false;
            else {
                from--;
                end++;
            }
        }
        return true;
    }

    /**
     * 按照mid和mid+1为对称中心
     * @param str
     * @param mid
     * @return
     */
    private boolean isMidPalin2(String str,int mid,int len){
        int from=mid,end=mid+1;
        while (from>=0 && end<len){
            if(str.charAt(from)!=str.charAt(end))
                return false;
            else {
                from--;
                end++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        AddToPalindrome t=new AddToPalindrome();
        System.out.println(t.addToPalindrome("abcba",5));
    }
}
