package schooloffer17;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/24 10:57
 * @ProjectName: JavaBaseTest
 * <彩色宝石项链></>
 */
public class Diamend {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        while (scanner.hasNext()){
            str=scanner.next();
            int len=str.length();

            int res=0;
            for(int i=0;i<len;i++){
                int a=-1,b=-1,c=-1,d=-1,e=-1;//记录各个找到的位置
                HashSet<Character> set=new HashSet<Character>();
                if(str.charAt(i)>=65 && str.charAt(i)<=69){//找到第一个字母
                    a=i;
                    set.add(str.charAt(i));
                    for(int j=i+1;;j++){
                        if(j==i)
                            break;
                        if(j==len)
                            j=0;
                        if(b==-1 && str.charAt(j)>=65 && str.charAt(j)<=69 && !set.contains(str.charAt(j))) {
                            b = j;
                            set.add(str.charAt(j));
                            continue;
                        }else if(c==-1 && str.charAt(j)>=65 && str.charAt(j)<=69 && !set.contains(str.charAt(j))){
                            c=j;
                            set.add(str.charAt(j));
                            continue;
                        }else if(d==-1 && str.charAt(j)>=65 && str.charAt(j)<=69 && !set.contains(str.charAt(j))){
                            d=j;
                            set.add(str.charAt(j));
                            continue;
                        }else if(e==-1 && str.charAt(j)>=65 && str.charAt(j)<=69 && !set.contains(str.charAt(j))){
                            e=j;
                            set.add(str.charAt(j));
                            break;
                        }
                    }
                }
                //更改最大值
                if(e!=-1){
                    if(a<e)
                        res=Math.max(res,a+len-1-e);
                    else
                        res=Math.max(res,a-e-1);

                }
            }
            System.out.println(res);
        }
    }
}
