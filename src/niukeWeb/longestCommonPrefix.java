package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/15.
 * 找出string[]数组中所有字符串的最长前缀匹配
 */
public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        int len= strs.length;
        if(len==1)
            return strs[0];
        //求strs最短字符串长度
        int minLen=getMinLength(strs);
        if(minLen==0)
            return "";
        int rear=0;//记录达到最长的前缀的下标
        boolean flag=true;
        for(int i=0;i<minLen && flag;i++){  //公共前缀长度最长为minLen
            char temp=strs[0].charAt(i);
            for(int j=1;j<len;j++){  //len个字符串比较
                if(strs[j].charAt(i)==temp)
                    continue;
                else{
                    flag=false;
                    rear=i;
                    break;
                }
            }
        }
        if(rear!=0 )  //rear被改过,自然flag==false
            return strs[0].substring(0,rear);
        else if(rear==0 && flag) //最短前缀:就是最短字符串
            return strs[0].substring(0,minLen);
        else
            return "";
    }

    int getMinLength(String[] strs){
        int len= strs.length;
        int minLen=strs[0].length();
        for(int i=1;i<len;i++){
            if(strs[i].length()<minLen)
                minLen=strs[i].length();
        }
        return minLen;
    }

    public static void main(String[] args) {
        longestCommonPrefix test=new longestCommonPrefix();
        String[] a={"abc","acb"}; //a
        System.out.println(test.longestCommonPrefix(a));
    }
}
