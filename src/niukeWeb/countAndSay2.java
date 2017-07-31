package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/8.
 * 本题非递归算法
 */
public class countAndSay2 {
    public String countAndSay(int n) {
        String result="1";
        int i=1;
        while(i<n){
            result=getNextString(result);
            i++;
        }
        return result;
    }
    String getNextString(String str){
        //对于输入的一个str求出其下一个表达str
        int count=1;
        str=str+"*";//添加*为了使得后面的for循环可以不会越界
        StringBuilder res=new StringBuilder();//返回结果
        int len=str.length();
        for(int i=0;i<len-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                count++;
            }else{
                res.append(Integer.toString(count)+String.valueOf(str.charAt(i)));
                count=1;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        countAndSay2 test=new countAndSay2();
        int a=5;
        String b=test.countAndSay(a);
        System.out.println(b);
    }
}
