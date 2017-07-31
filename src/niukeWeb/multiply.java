package niukeWeb;


/**
 * Created by caoxiaohong on 17/7/6.
 * 两个正整数以字符串形式给出,求其乘积并以字符串形式返回.注意:整数可能很大
 * 大数乘法
 */
public class multiply {
    public String multiply(String num1, String num2) {
        //参考资料:http://www.cnblogs.com/TenosDoIt/p/3735309.html
        int len1=num1.length();
        int len2=num2.length();
        int k=len1+len2-2;
        int[]  tempRe=new int[len1+len2];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                tempRe[k-i-j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');  //存储方式:高位乘积存放在tempRe低位
            }
        }
        int carrybit=0;//进位
        for(int i=0;i<len1+len2;i++){
            tempRe[i]+=carrybit;
            carrybit=tempRe[i]/10;
            tempRe[i]=tempRe[i]%10;
        }
        //处理0
        if(num1.equals("0" )|| num2.equals("0"))
            return "0";
        //去除前面的0
        int index=len1+len2-1;
        while(tempRe[index]==0)
            index--;
        //从0~index都不为0
        StringBuilder sb=new StringBuilder();
        int num=len1+len2-1;
        while(index>=0){
            sb.append(String.valueOf(tempRe[index--]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        multiply test=new multiply();
        String a="1",b="1";
        String cout=test.multiply(a,b);
        System.out.println(cout);
    }
}
