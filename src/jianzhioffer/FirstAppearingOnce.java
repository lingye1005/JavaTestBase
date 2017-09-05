package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/1.
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstAppearingOnce {
    StringBuilder sb=new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int[] character=new int[255];
        for(int i=0;i<sb.length();i++){
            character[sb.charAt(i)]+=1;
        }
        int min=-1;
        for(int i=0;i<255;i++){
            if(character[i]==1)
            {
                if(min==-1)
                    min=i;
                else {
                    if(sb.indexOf(String.valueOf((char)i))<sb.indexOf(String.valueOf((char)min)))
                        min=i;
                }
            }
        }
        if(min!=-1)
            return (char)min;
        else
            return '#';
    }

    public static void main(String[] args) {
        FirstAppearingOnce t=new FirstAppearingOnce();
        t.Insert('g');
        t.Insert('o');
        t.Insert('o');
        t.Insert('g');
        t.Insert('l');
        t.Insert('e');
        System.out.println(t.FirstAppearingOnce());
    }
}
