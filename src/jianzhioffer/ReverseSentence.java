package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/31.
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么
 * 测试用例:好像是必须保留句子的最前面和最后空格;
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        //只有空格.trim是去除首尾空格
        if(str.trim().length()==0 && str.length()!=0)
            return str;
        String[] list=str.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=list.length-1;i>0;i--){
            sb.append(list[i] + " ");
        }
        sb.append(list[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseSentence t=new ReverseSentence();
        System.out.println(t.ReverseSentence(" student. a am I "));
    }
}
