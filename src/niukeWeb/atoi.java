package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/16.
 * 字符串转为整数
 * 从第一个非空格字符开始,有没有+或者-号都行,然后接下来将相连接的尽可能多的数字作为此整数
 * 组合出第一个整数后,后面可能还有字符,这不影响此次已经组合出来的整数
 * 如果字符串中第一个非空字符串不是一个有效的整数,或者本来就不存在这样的可以组成整数的序列,亦或者字符串本身就是空串,则不存在转化
 * 如果没有有效的组合序列,则返回0.如果大于整数上限,返回上限.如果小于整数下限,返回下限.
 * 整数范围:-2147483648  到 2147483647
 */
public class atoi {
    public int atoi(String str) {
        //全空
        if(str==null || str.length()==0 || str.replace(" ","").length()==0){
            return 0;
        }
        int len=str.length();
        int validIndex=-1;
        boolean flag=false;
        for(int i=0;i<len && !flag ;i++){
            char temp= str.charAt(i);
            //+:43,-:45,0-9:48-57
            if(temp!=' '){
                flag=true;
                validIndex=i;
                break;
            }else{
                continue;
            }
        }
        //没有数字
        if(validIndex==-1)
            return 0;
        //str中最后一个字符为+或者-,前面前部为空格
        if(flag && validIndex==len-1 && (str.charAt(validIndex)=='+' || str.charAt(validIndex)=='-'))
            return 0;
        //找到第一个字符,且为+或者-
        else  if(flag && validIndex<len-1 && (str.charAt(validIndex)=='+' || str.charAt(validIndex)=='-')) {
            int count=0;
            int i;
            for(i = validIndex+1; i < len; i++) {
                if(str.charAt(i)<48 ||str.charAt(i)>57)
                    break;
                count++;
            }
            if(count==0)
                return 0;
            if(count>10) {
                if (str.charAt(validIndex) == '-')
                    return   Integer.MIN_VALUE;
                if(str.charAt(validIndex)=='+')
                    return   Integer.MAX_VALUE;
            }else{
                //0--1--2--3--4--5--6--7--8--9
                //48-49-50-51-52-53-54-55-56-57
                //21474 83647
                if(str.charAt(validIndex)=='+'){
                    if(count<10)
                        return Integer.valueOf(str.substring(validIndex,validIndex+count+1));
                    else{
                        if(str.charAt(validIndex+1)>50)
                            return Integer.MAX_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)>49)
                            return Integer.MAX_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)>52)
                            return Integer.MAX_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)>55)
                            return Integer.MAX_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)>52)
                            return Integer.MAX_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)==52 && str.charAt(validIndex+6)>56)
                            return Integer.MAX_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)==52 && str.charAt(validIndex+6)==56 &&
                                str.charAt(validIndex+7)>51)
                            return Integer.MAX_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)==52 && str.charAt(validIndex+6)==56 &&
                                str.charAt(validIndex+7)==51 && str.charAt(validIndex+8)>54)
                            return Integer.MAX_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)==52 && str.charAt(validIndex+6)==56 &&
                                str.charAt(validIndex+7)==51 && str.charAt(validIndex+8)==54&& str.charAt(validIndex+9)>52)
                            return Integer.MAX_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)==52 && str.charAt(validIndex+6)==56 &&
                                str.charAt(validIndex+7)==51 && str.charAt(validIndex+8)==54&& str.charAt(validIndex+9)==52 && str.charAt(validIndex+10)>55)
                            return Integer.MAX_VALUE;

                        else return Integer.valueOf(str.substring(validIndex,validIndex+count+1));
                    }
                }else{
                    if(count<10)
                        return Integer.valueOf(str.substring(validIndex,validIndex+count+1));
                    else{
                        if(str.charAt(validIndex+1)>50)
                            return Integer.MIN_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)>49)
                            return Integer.MIN_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)>52)
                            return Integer.MIN_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)>55)
                            return Integer.MIN_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)>52)
                            return Integer.MIN_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)==52 && str.charAt(validIndex+6)>56)
                            return Integer.MIN_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)==52 && str.charAt(validIndex+6)==56 &&
                                str.charAt(validIndex+7)>51)
                            return Integer.MIN_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)==52 && str.charAt(validIndex+6)==56 &&
                                str.charAt(validIndex+7)==51 && str.charAt(validIndex+8)>54)
                            return Integer.MIN_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)==52 && str.charAt(validIndex+6)==56 &&
                                str.charAt(validIndex+7)==51 && str.charAt(validIndex+8)==54&& str.charAt(validIndex+9)>52)
                            return Integer.MIN_VALUE;
                        else if(str.charAt(validIndex+1)==50 && str.charAt(validIndex+2)==49 && str.charAt(validIndex+3)==52 &&
                                str.charAt(validIndex+4)==55 && str.charAt(validIndex+5)==52 && str.charAt(validIndex+6)==56 &&
                                str.charAt(validIndex+7)==51 && str.charAt(validIndex+8)==54&& str.charAt(validIndex+9)==52 && str.charAt(validIndex+10)>56)
                            return Integer.MIN_VALUE;
                        else
                            return Integer.valueOf(str.substring(validIndex,validIndex+count+1));
                    }
                }
            }
        }
        //找到第一个字符,且为数字
        else if(flag && str.charAt(validIndex) >=48 && str.charAt(validIndex)<=57){
            int count=1;
            int i;
            for(i = validIndex+1; i < len; i++) {
                if(str.charAt(i)<48 ||str.charAt(i)>57)
                    break;
                count++;
            }
            if(count>10) {
                return   Integer.MAX_VALUE;
            }else {
                if(count<10)
                    return Integer.valueOf(str.substring(validIndex,validIndex+count));
                else{
                    //0--1--2--3--4--5--6--7--8--9
                    //48-49-50-51-52-53-54-55-56-57
                    //21474 83647
                    if(str.charAt(validIndex)>50)
                        return Integer.MAX_VALUE;
                    else if(str.charAt(validIndex)==50 && str.charAt(validIndex+1)>49)
                        return Integer.MAX_VALUE;
                    else if(str.charAt(validIndex)==50 && str.charAt(validIndex+1)==49 && str.charAt(validIndex+2)>52)
                        return Integer.MAX_VALUE;
                    else if(str.charAt(validIndex)==50 && str.charAt(validIndex+1)==49 && str.charAt(validIndex+2)==52 &&
                            str.charAt(validIndex+3)>55)
                        return Integer.MAX_VALUE;
                    else if(str.charAt(validIndex)==50 && str.charAt(validIndex+1)==49 && str.charAt(validIndex+2)==52 &&
                            str.charAt(validIndex+3)==55 && str.charAt(validIndex+4)>52)
                        return Integer.MAX_VALUE;
                    else if(str.charAt(validIndex)==50 && str.charAt(validIndex+1)==49 && str.charAt(validIndex+2)==52 &&
                            str.charAt(validIndex+3)==55 && str.charAt(validIndex+4)==52 && str.charAt(validIndex+5)>56)
                        return Integer.MAX_VALUE;
                    else if(str.charAt(validIndex)==50 && str.charAt(validIndex+1)==49 && str.charAt(validIndex+2)==52 &&
                            str.charAt(validIndex+3)==55 && str.charAt(validIndex+4)==52 && str.charAt(validIndex+5)==56 &&
                            str.charAt(validIndex+6)>51)
                        return Integer.MAX_VALUE;
                    else if(str.charAt(validIndex)==50 && str.charAt(validIndex+1)==49 && str.charAt(validIndex+2)==52 &&
                            str.charAt(validIndex+3)==55 && str.charAt(validIndex+4)==52 && str.charAt(validIndex+5)==56 &&
                            str.charAt(validIndex+6)==51 && str.charAt(validIndex+7)>54)
                        return Integer.MAX_VALUE;
                    else if(str.charAt(validIndex)==50 && str.charAt(validIndex+1)==49 && str.charAt(validIndex+2)==52 &&
                            str.charAt(validIndex+3)==55 && str.charAt(validIndex+4)==52 && str.charAt(validIndex+5)==56 &&
                            str.charAt(validIndex+6)==51 && str.charAt(validIndex+7)==54&& str.charAt(validIndex+8)>52)
                        return Integer.MAX_VALUE;
                    else if(str.charAt(validIndex)==50 && str.charAt(validIndex+1)==49 && str.charAt(validIndex+2)==52 &&
                            str.charAt(validIndex+3)==55 && str.charAt(validIndex+4)==52 && str.charAt(validIndex+5)==56 &&
                            str.charAt(validIndex+6)==51 && str.charAt(validIndex+7)==54&& str.charAt(validIndex+8)==52 && str.charAt(validIndex+9)>55)
                        return Integer.MAX_VALUE;

                    else return Integer.valueOf(str.substring(validIndex,validIndex+count));
                }
            }
        }else{  //找到第一个字符,但是不是正负号,也不是数字
            if(str.charAt(validIndex)!=43 && str.charAt(validIndex)!=45 && (str.charAt(validIndex)>57 || str.charAt(validIndex)<48))
                return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        atoi test=new atoi();
        System.out.println(test.atoi("-2147483647"));
    }
}
