package niukeWeb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoxiaohong on 17/8/11.
 * 给定一个单词和长度L的数组，格式化文本，使得每一行都具有正好L个字符，并且完全（左和右）对齐。
 * 你应该用贪婪的方法包装你的话; 也就是说，在每一行中都可以包含尽可能多的单词。 必要时填充多余的空格，使每一行都具有正确的L个字符。
 *
 * 非最后一行:单词之间的额外空格应尽可能均匀分布。 如果一行中的空格数不能均匀地分配到单词之间，则左侧空白的空格将分配更多的空格，而不是右侧的位置。
 * 最后一行:各个单词之间都空一个空格.后面不足长度L部分补充为空格.
 */
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result=new ArrayList<String>();
        if(L==0) {
            result.add("");
            return result;
        }
        if(words==null || words.length==0){
            result.add(" ");
            return result;
        }
        int len=words.length;
        for(int i=0;i<len;){
            int from=i,to=-1;
            int sumLen=words[from].length()+1;//当前拼接字符串长度
            for(int j=i+1;j<len;j++){
                if(words[j].length()+sumLen<=L){
                    sumLen+=words[j].length()+1;
                    to=j;
                }else{
                    break;
                }
            }
            //words[from]~words[to]词可以加入结果集中
            String str=getSb(words,from,to,L);
            result.add(str);
            if(to!=-1)
                i=to+1;
            else
                i=i+1;
        }
        return result;
    }

    private String getSb(String[] words,int from ,int to,int L){
        StringBuilder sb=new StringBuilder();

        if(to==-1){   //只有一个单词的行
            sb.append(words[from]);
            //右侧填充空格
            int wordLen = words[from].length();
            for (int i = 1; i <= L - wordLen; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }else if(to!=-1 && to!=words.length-1){  //一行有多个单词 且  不是最后一行
            //所有单词总长度
            int wordLen=0;
            for(int i=from;i<=to;i++){
                wordLen+=words[i].length();
            }
            //空格总长度
            int spaceLen=L-wordLen;
            //单词个数
            int wordNum=to-from+1;
            int avgSpaceNo=spaceLen/(wordNum-1);
            //空格个数是(wordNum-1)整数倍
            if(spaceLen%(wordNum-1)==0){
                for(int i=from;i<=to;i++){
                    sb.append(words[i]);
                    if(to!=words.length-1 && i!=to) {  //非最后一个字符加入空格
                        for (int j = 0; j < avgSpaceNo; j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            //空格个数不是(wordNum-1)整数倍
            else{
                //可以多出一个空格的单词个数
                int moreOne=spaceLen-(wordNum-1)*avgSpaceNo;
                //所以从from到from-1+spaceLen-wordNum*avgSpaceNo是多出空格的数组下标
                for(int i=from;i<=from-1+spaceLen-(wordNum-1)*avgSpaceNo;i++){
                    sb.append((words[i]));
                    if(i!=to){
                        for(int j=0;j<=avgSpaceNo;j++){
                            sb.append(" ");
                        }
                    }
                }
                //words[from-1+spaceLen-wordNum*avgSpaceNo+1]~words[to]添加avgSpaceNo个空格
                for(int i=from-1+spaceLen-(wordNum-1)*avgSpaceNo+1;i<=to;i++){
                    sb.append(words[i]);
                    if(i!=to){
                        for(int j=0;j<avgSpaceNo;j++){
                            sb.append(" ");
                        }
                    }
                }
            }
        }else{   //最后一行
            int i;
            int len=0;
            for( i=from;i<=to;i++){
                sb.append(words[i]+" ");
                len+=words[i].length()+1;
            }
            if(len<L){
                for(int k=1;k<=L-len;k++){
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] str={"This", "is", "an", "example", "of", "text", "justification."};
        TextJustification test=new TextJustification();
        List<String> result=test.fullJustify(str,16);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
