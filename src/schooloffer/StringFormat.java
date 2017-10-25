package schooloffer;

/**
 * Created by caoxiaohong on 17/9/18.
 * 请你实现一个简单的字符串替换函数。原串中需要替换的占位符为"%s",请按照参数列表的顺序一一替换占位符。若参数列表的字符数大于占位符个数。则将剩下的参数字符添加到字符串的结尾。
 * 给定一个字符串A，同时给定它的长度n及参数字符数组arg，请返回替换后的字符串。保证参数个数大于等于占位符个数。保证原串由大小写英文字母组成，同时长度小于等于500。
 */
public class StringFormat {
    public String formatString(String A, int n, char[] arg, int m) {
        // write code here
        int idxB=0;
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;){
            if(i+1<n && A.charAt(i)=='%' && A.charAt(i+1)=='s'){
                sb.append(arg[idxB]);
                i+=2;
                idxB++;
            }else if(A.charAt(i)!='%'){
                sb.append(A.charAt(i));
                i++;
            }else{
                i++;
            }
        }
        if(idxB<m){
            for(int i=idxB;i<m;i++)
                sb.append(arg[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringFormat t=new StringFormat();
        String str="A%sC%sE";
        char[] b={'B','D','F'};
        System.out.println(t.formatString(str,7,b,3));
    }
}
