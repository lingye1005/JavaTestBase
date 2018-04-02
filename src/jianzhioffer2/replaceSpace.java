package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/1/16 17:35
 * @ProjectName: JavaBaseTest
 * 面试题4
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        //return str.toString().replaceAll(" ","%20");源码使用的是:StringBuffer,线程安全的,而且还是这个方法用时少
        //现在采用书上的写法,从尾到头的遍历:先找出有几个空格,然后声明一个新数组
        int spaceSize=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
               spaceSize++;
        }
        int size=spaceSize*2+str.length();
        char[] res=new char[size];
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                res[count]='%';
                res[count+1]='2';
                res[count+2]='0';
                count+=3;
            }else{
                res[count++]=str.charAt(i);
            }
        }
        return String.valueOf(res);
    }
    //test
    public static void main(String[] args) {
        ReplaceSpace test=new ReplaceSpace();
        StringBuffer sb=new StringBuffer();
        sb.append("We Are Happy");
        System.out.println(test.replaceSpace(sb));
    }
}
