package jianzhioffer2;

import java.util.HashMap;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 21:03
 * @ProjectName: JavaBaseTest
 */
public class FirstAppearingOnce {

    //test
    public static void main(String[] args) {
        FirstAppearingOnce t=new  FirstAppearingOnce();
        t.Insert('g');t.Insert('o');t.Insert('o');t.Insert('g');t.Insert('l');t.Insert('e');

        char res=t.FirstAppearingOnce();
        System.out.println(res);
    }

    //Insert one char from stringstream
    StringBuilder sb=new  StringBuilder();
    public void Insert(char ch)
    {
        sb.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int len=sb.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<len;i++){
            char tmp=sb.charAt(i);
            if(map.containsKey(tmp)){
                map.put(tmp,-1);
            }else{
                map.put(tmp,1);
            }
        }
        for(int i=0;i<len;i++){
            char tmp=sb.charAt(i);
            if(map.get(tmp)==1)
                return tmp;
        }
        return '#';
    }
}
