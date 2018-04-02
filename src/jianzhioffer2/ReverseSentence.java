package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 09:49
 * @ProjectName: JavaBaseTest
 */
public class ReverseSentence {

    //tes
    public static void main(String[] args) {
        ReverseSentence t=new ReverseSentence();


        String out=t.ReverseSentence("I am a student.");

        System.out.println(out);

    }


    public String ReverseSentence(String str) {
        if(str==null || str.length()==0)
            return "";

        int len=str.length();
        //整个字符串旋转
        str=reverse(str.toCharArray(),0,len-1);
        //每个单词旋转
        int idx=0;
        int pre=0,end=0;
        while(end<len){
            if(end==len-1 || (end<len-1 && str.charAt(end+1)==' ')){
                str=reverse(str.toCharArray(),pre,end);
                pre=end+2;
                end=end+2;
            }else{
                end++;
            }
        }
        return str;
    }

    //字符串旋转 ,[low,high]
    private String reverse(char[] chars,int low ,int high){
        while(low<high){
            char tmp=chars[low];
            chars[low++]=chars[high];
            chars[high--]=tmp;
        }
        return String.valueOf(chars);
    }
}
