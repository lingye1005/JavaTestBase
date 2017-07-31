package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/8.
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as"one 1"or11.
 * 11 is read off as"two 1s"or21.
 * 21 is read off as"one 2, thenone 1"or1211.
 * 将一个整数的读字符串表达出来.
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as one 1 or 11.
 * 11 is read off as two 1s or 21.
 * 21 is read off as one 2, then one 1 or 1211.
 * Given an integer n, generate the nth sequence.
 * 递归实现,但是超时
 */
public class countAndSay {
    //n表达的是这个特殊序列第n个数,用口语来怎么表达
    public String countAndSay(int n) {
       if(n==1)
           return "1";
        String str=countAndSay(n-1)+"*";  //是为了好处理for循环中最后一个字符问题.因为有temp[i]和temp[i+1]比较,为了保证i+1时候数组不越界.
        char[] temp=str.toCharArray();
        int count=1;
        String s=new String();
        for(int i=0;i<temp.length-1;i++){
            if(temp[i]==temp[i+1]){
                count++;
            }else{
                s=s+count+temp[i];
            }
        }
        return s;
    }

    public static void main(String[] args) {
        countAndSay test=new countAndSay();
        int a=1;
        String b=test.countAndSay(a);
        System.out.println(b);
    }
}
