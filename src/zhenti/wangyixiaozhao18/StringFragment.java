package zhenti.wangyixiaozhao18;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/4 09:46
 * @ProjectName: JavaBaseTest
 * <>字符串碎片</>
 * 100%
 */
public class StringFragment {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashMap<String,Integer> map=new HashMap<>();
        int len;
        while (scanner.hasNext()){
            String str=scanner.next().trim();//字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')
            len=str.length();

            StringBuilder tmp=new StringBuilder();
            tmp.append(str.charAt(0));
            char pre=str.charAt(0);
            for(int i=1;i<len;i++){
                if(str.charAt(i)==pre) {
                    tmp.append(str.charAt(i));
                    //处理最后一个字符
                    if(i==len-1){
                        if(map.containsKey(tmp.toString())){
                            map.put(tmp.toString(),map.get(tmp.toString())+1);
                        }else{
                            map.put(tmp.toString(),1);
                        }
                    }
                }else{
                    if(map.containsKey(tmp.toString())){
                        map.put(tmp.toString(),map.get(tmp.toString())+1);
                    }else{
                        map.put(tmp.toString(),1);
                    }
                    //更新pre
                    pre=str.charAt(i);
                    tmp.delete(0,tmp.length());
                    tmp.append(pre);
                    //处理最后一个字符
                    if(i==len-1){
                        if(map.containsKey(tmp.toString())){
                            map.put(tmp.toString(),map.get(tmp.toString())+1);
                        }else{
                            map.put(tmp.toString(),1);
                        }
                    }
                }
            }
            //计算平均长度
            Collection<Integer> values=map.values();
            double count=0;
            Iterator<Integer> iterator=values.iterator();
            while (iterator.hasNext()){
                count+=iterator.next();
            }
            //保留2位小数
            DecimalFormat df=new DecimalFormat("#.00");
            System.out.println(df.format(len/count));
        }
    }
}
