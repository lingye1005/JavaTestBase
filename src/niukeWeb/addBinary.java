package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/6/27.
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a ="11"
 * b ="1"
 * Return"100".
 */
public class addBinary {
    public String addBinary(String a, String b) {
        if((a==null && b==null) || (a.equals("") && b.equals("")))
            return "";
        int lena=a.length(),lenb=b.length();
        //长度不一样,补齐
        if(lena>lenb){
            StringBuilder temp=new StringBuilder();
            for(int i=0;i<lena-lenb;i++){
                temp.append("0");
            }
            temp.append(b);
            b=temp.toString();
        }else if(lena<lenb){
            StringBuilder temp=new StringBuilder();
            for(int i=0;i<lenb-lena;i++){
                temp.append("0");
            }
            temp.append(a);
            a=temp.toString();
        }
        int len=lena>lenb?lena:lenb;
        ArrayList<String> revs=new ArrayList<String>();//存放结果,反向
        boolean flag=false;//是否有进位
        for(int i=len-1;i>-1;i--){
            char ta=a.charAt(i);
            char tb=b.charAt(i);
            if(ta=='1' && tb=='1'){
                if(flag){
                    flag=true;
                    revs.add("1");
                }else {
                    flag = true;
                    revs.add("0");
                }
            }else if(ta=='1' || tb=='1'){
               if(flag){
                   flag=true;
                   revs.add("0");
               }else {
                   flag=false;
                   revs.add("1");
               }
            }else{
                if(flag)
                    revs.add("1");
                else
                    revs.add("0");
                flag=false;
            }
        }
        if(flag) //处理最高位,如果有进位
            revs.add("1");
        StringBuilder sb=new StringBuilder();
        int k=revs.size()-1;
        for(;k>-1;k--){
            sb.append(revs.get(k));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        addBinary a=new addBinary();
        String a1="1010";
        String b1="1011";
        System.out.println(a.addBinary(a1,b1));
    }
}
