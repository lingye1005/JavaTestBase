package schooloffer17;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/5 14:45.
 * <小易喜欢的单词></>
 */
public class LikedWords {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        while (scanner.hasNext()){
            str=scanner.nextLine();
            int len=str.length();
            //判定:每个字母都是大写字母
            if(!str.toUpperCase().equals(str)){
                System.out.println("Dislikes");
                continue;
            }
            //判定:没有连续相等的字母
            boolean consist=false;
            for(int i=0;i<len-1;i++){
                if(str.charAt(i)==str.charAt(i+1)){
                    consist=true;
                    break;
                }
            }
            if(consist==true){
                System.out.println("Dislikes");
                continue;
            }
            //判定:xyxy子序列
            int first,last;
            char tmp;
            boolean like=true;
            for(int i=0;i<len-3;i++){
                tmp=str.charAt(i);
                first=str.indexOf(tmp);
                last=str.lastIndexOf(tmp);
                if(first!=last){
                    //首先判定是否为xyxy型
                    for(int j=first+1;j<last;j++){
                        if(str.lastIndexOf(str.charAt(j))>last){
                            like=false;
                            break;
                        }
                    }
                    //然后判定是否为xxxx型
                    int count=2;
                    if(like){
                        for(int j=first+1;j<last;j++){
                            if(str.charAt(j)==tmp){
                                count++;
                                if(count==4)
                                    break;
                            }
                        }
                        if(count==4)
                            like=false;
                    }
                }
                if(like==false)
                    break;
            }
            System.out.println(like==false?"Dislikes":"Likes");
        }
    }
}
