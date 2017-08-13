package niukeWeb;

import java.util.ArrayList;
/**
 * Created by caoxiaohong on 17/8/11.
 * 给定一个单词和长度L的数组，格式化文本，使得每一行都具有正好L个字符，并且完全（左和右）对齐。
 * 你应该用贪婪的方法包装你的话; 也就是说，在每一行中都可以包含尽可能多的单词。 必要时填充多余的空格“，使每一行都具有正确的L个字符。
 * 单词之间的额外空格应尽可能均匀分布。 如果一行中的空格数不能均匀地分配到单词之间，则左侧空白的空格将分配更多的空格，而不是右侧的位置。
 * 对于文本的最后一行，应该保持对齐，并且不会在单词之间插入额外的空格。
 */
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result=new ArrayList<String>();
        if(words==null || words.length==0)
            return result;
        int len=words.length;
        for(int i=0;i<len;){
            int from=i,to=-1;
            int sumLen=words[from].length()+1;//当前拼接字符串长度
            for(int j=i+1;j<len;){
                if(words[j].length()+sumLen<=L){
                    sumLen+=words[j].length()+1;
                    to=j;
                }else{
                    break;
                }
            }
            //words[from]~words[to]词可以加入结果集中
            //StringBuilder sb=;
            i=to;
        }
        return result;
    }

    private String getSb(String[] words,int from ,int to,int L){
        StringBuilder sb=new StringBuilder();

        if(to==-1){
            sb.append(words[from]);
            return sb.toString();
        }else{
            //所有单词总长度
            int wordLen=0;
            for(int i=from;i<=to;i++){
                wordLen+=words[i].length();
            }
            //空格总长度
            int spaceLen=L-wordLen;
            //单词个数
            int wordNum=to-from+1;
            //空格个数是(wordNum-1)整数倍
            int avgSpaceNo=spaceLen/(wordNum-1);
            if(spaceLen%(wordNum-1)==0){
                for(int i=from;i<=to;i++){
                    sb.append(words[i]);
                    for(int j=0;j<avgSpaceNo;j++){
                        sb.append(" ");
                    }
                }
            }
            //空格个数不是(wordNum-1)整数倍
            else{

            }
        }
        return null;
    }
}
