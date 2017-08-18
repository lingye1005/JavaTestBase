package niukeWeb;

/**
 * Created by caoxiaohong on 17/8/6.
 * 在字符串s中查找子串,要求子串包含t中所有字母,子串中字母和t中字母顺序可以不同,只要包含就行.求最短的子串.
 * 注意:如果没有找到,则返回空串;如果存在多个最短子串,则默认返回找到的一个就行了.
 * 算法时空复杂度要求:o(n)
 * 算法思想:双指针法.两个指针用于标识最小框的上下界;开始分别为-1,len,都是非法表达,因为万一找不到,得返回空串.这样才能区分出是没找到还是需要返回s整个串.
 *
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        //保存T中字符出现的情况
        //HashMap<Character,Integer> tValues=new HashMap<Character, Integer>();
        int[] tValues=new int[255];
        for(int i=0;i<T.length();i++){
            char temp=T.charAt(i);
            tValues[temp]++;
        }
        //保存S中字符出现的情况
        int[] sValues=new int[255];
        //表示找到的最小框的上下界,最小长度
        int begin=-1,end=S.length(),minLen=Integer.MAX_VALUE;
        //表示当前最小框中已经找到匹配的字符数目
        int found=0;
        for(int i=0,start=0;i<S.length();i++){
            char temp=S.charAt(i);
            sValues[temp]++;
            //found+1
            if(sValues[temp]<=tValues[temp])
                found++;
            //找到一个和T匹配的框
            if(found==T.length()){
                //截掉框左边的多出的字符,因为框内出现的字符个数不一定都是和T中一样的,很可能比T的多,就要尽量截掉左边更长的部分.
                //tValues.containsKey(S.charAt(start)) &&
                while(start<i && sValues[S.charAt(start)]>tValues[S.charAt(start)]){
                    sValues[S.charAt(start)]--;
                    start++;
                }
                //得到框框上下界(包含):start~i;
                if(i-start+1<minLen){
                    begin=start;
                    end=i;
                    minLen=i-start+1;
                }
                //把开头匹配的这个字符剔除掉
                sValues[S.charAt(start)]--;
                //匹配个数-1
                found--;
                //子串开始位置+1
                start++;
            }

        }
        //返回结果值
        return begin==-1?"":S.substring(begin,end+1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test=new MinimumWindowSubstring();
        String s="ADOBECODEBANC",t="ABC";
        String sout=test.minWindow(s,t);
        System.out.println(sout);
    }
}
