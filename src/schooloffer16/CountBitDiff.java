package schooloffer16;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/9/9.
 * 世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 */
public class CountBitDiff {
    public int countBitDiff(int m, int n) {
        ArrayList<Character> arrm=null;
        ArrayList<Character> arrn=null;
        if(m==0 && n==0){
            return  32;
        }else if(m==0 && n!=0){
            arrm=new ArrayList<Character>();
            for(int i=0;i<32;i++)
                arrm.add('0');
            if(n>0)
                arrn=getOriginal(n);
            else
                arrn=getCompliant(getOriginal(n));
        }else if(n==0 && m!=0){
            if(m>0)
                arrm=getOriginal(m);
            else
                arrm=getCompliant(getOriginal(m));
            arrn=new ArrayList<Character>();
            for(int i=0;i<32;i++)
                arrn.add('0');
        }
        else if(m>0 && n>0){
            arrm=getOriginal(m);
            arrn=getOriginal(n);
        }else if(m>0 && n<0){
            arrm=getOriginal(m);
            arrn=getCompliant(getOriginal(n));
        }else if(m<0 && n>0){
            arrm=getCompliant(getOriginal(m));
            arrn=getCompliant(getOriginal(n));
        }else{//均<0
            arrm=getCompliant(getOriginal(m));
            arrn=getCompliant(getOriginal(n));
        }
        int count=0;
        for(int i=0;i<32;i++){
            if(arrm.get(i)!=arrn.get(i))
                count++;
        }
        return count;
    }
    //求原码二进制位数
    ArrayList<Character> getOriginal(int num){
        ArrayList<Character> list=new ArrayList<Character>();//list存储了从低位到高位的二进制数字
        while (num/2!=0){
            int tmp=num%2;
            if(tmp==0)
                list.add('0');
            else
                list.add('1');
            num/=2;
        }
        if(num==1)
            list.add('1');
        //高位不足补齐
        while (34-list.size()>1){
            list.add('0');
        }
        //添加符号位
        if(num>0)
            list.add('0');
        else
            list.add('1');
        return list;
    }
    //求原码对应的补码:针对负数
    ArrayList<Character> getCompliant(ArrayList<Character> list){
        boolean isFind=false;
        //最高位:符号位不变
        for(int i=0;i<list.size()-1;i++){
            if(!isFind && list.get(i)=='1'){
                isFind=true;
            }
            if(isFind){
                if(list.get(i)=='1'){
                    list.set(i,'0');
                }else{
                    list.set(i,'1');
                }
            }
        }
        return list;
    }
    //test code
    public static void main(String[] args) {
        CountBitDiff t=new CountBitDiff();
        System.out.println(t.countBitDiff(0,2147483647));
    }
}
