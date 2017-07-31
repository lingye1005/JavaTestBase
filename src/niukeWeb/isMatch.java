package niukeWeb;


/**
 * Created by caoxiaohong on 17/7/5.
 * 判定两个字符串是否匹配:p中可能包含?或者*.
 * ?代表任意一个字符,但不包括空格.*代表任意一串字符
 */
public class isMatch {
    public boolean isMatch(String s, String p) {
        if( (s==null || s.length()==0 ) && p!="" && p.contains("?") )
            return false;
        //p中不包含?和*
        if(!p.contains("*") && !p.contains("?")){
            return commonMethod1(s,p,0);
        }
        //p中仅仅包含?
        else if(!p.contains("*") && p.contains("?")){
            return commonMethod1(s,p,1);
        }
        //p中仅仅包含*
        else if(p.contains("*") && !p.contains("?")){
            //如果第一个字符不相同,则不匹配
            if( s!="" && p!=""  && s.charAt(0)!=p.charAt(0) && p.charAt(0)!='*')
                return false;
            //如果最后一个字符不相同,则不匹配
            if( s!="" && p!="" && s.charAt(s.length()-1)!=p.charAt(p.length()-1) && p.charAt(p.length()-1)!='*')
                return false;
           return  commonMethod2(s,p,0);
        }
        //p中既包含?也包含*
        else{
            //如果第一个字符不相同,则不匹配
            if(s!="" && p!=""  && s.charAt(0)!=p.charAt(0) && p.charAt(0)!='*' && p.charAt(0)!='?')
                return false;
            //如果最后一个字符不相同,则不匹配
            if(s!="" && p!=""  && s.charAt(s.length()-1)!=p.charAt(p.length()-1) && p.charAt(p.length()-1)!='*' && p.charAt(p.length()-1)!='?')
                return false;
            //先判定p中其他字符顺序是否和s中一致
            if(!commonMethod2(s,p,1))
                return false;
            //如果一致,则继续进行下列的判定
            int lens=s.length();
            int lenp=p.length();
            int index=0;//表示p正在比较的字符下标
            for(int i=0;i<lens;i++){
                if(s.charAt(i)!=p.charAt(index) && p.charAt(index)!='*' && p.charAt(index)!='?')
                    return false;
                else if(s.charAt(i)!=p.charAt(index) && p.charAt(index)=='?' && s.charAt(i)!=' ')
                    index++;
                else if(s.charAt(i)!=p.charAt(index) && p.charAt(i)=='?' && s.charAt(i)==' ')
                    return false;
            }
            return true;
        }
    }

    //common1
    private boolean commonMethod1(String s,String p,int flag){
        if(flag==0){//p不包含*和?
            int lens=s.length();
            int lenp=p.length();
            if(lenp!=lens)
                return false;
            for(int i=0;i<lens;i++){
                if(s.charAt(i)!=p.charAt(i))
                    return false;
            }
            return true;
        }else{//p仅仅包含?
            int lens=s.length();
            int lenp=p.length();
            if(lenp!=lens)
                return false;
            for(int i=0;i<lens;i++){
                if(s.charAt(i)!=p.charAt(i) && p.charAt(i)!='?') //字符和字符不匹配
                    return false;
                if(s.charAt(i)!=p.charAt(i) && p.charAt(i)=='?' && s.charAt(i)==' ') //空格和?不匹配
                    return false;
            }
            return true;
        }
    }

    //common2 肯定包含* ;如果flag==0,则不包含?;否则包含?
    private boolean commonMethod2(String s,String p,int flag){
        //取出p中非*字符,即仅仅不取出*字符
        int lenp=p.length();
        char[] temp=new char[lenp];//0~(index-1)存储了真正的char字符
        int index=0;
        for (int i = 0; i < lenp; i++) {
            if (p.charAt(i) != '*')
                temp[index++] = p.charAt(i);
        }
        //如果p中无字符,即为p中仅仅有,显然返回true
        if(index==0 && flag==0) //p中不包括?,只有*
            return true;
        //s中查找是否存在p中取出的非*字符,并且从左到右顺序不改变
        int j=0;//
        int lens=s.length();
        if(flag==0 && s.length()!=0) {  //p只包含*
            for (int i = 0; i < lens; i++) {
                if (j == index)
                    return true;
                if (s.charAt(i) == temp[j]) {
                    j++;
                }
            }
        }else if(flag!=0 &&s.length()!=0  ){  //p包含*和?  //'\u0000' 0
            if(index>lens)   // p中字符数目>s中字符数目;必须<=才有可能匹配
                return false;
            for(int i=0;i<lens;i++){
                if(s.charAt(i)!=temp[i] && temp[i]!='?' && temp[i]!=0)
                    return false;
                if(s.charAt(i)!=temp[i] && s.charAt(i)==' ' && temp[i]!=0)
                    return false;
            }
            return true;
        }
        if(j==index)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        isMatch test=new isMatch();
        String a="";
        String b="*";
        System.out.println(test.isMatch(a,b));
    }
}
