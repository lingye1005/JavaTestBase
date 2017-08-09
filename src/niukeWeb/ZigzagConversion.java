package niukeWeb;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/8/9.
 * 字符串“PAYPALISHIRING”以给定行数的锯齿形图案写成：（您可能希望以固定字体显示此模式以获得更好的可读性）
 * convert("PAYPALISHIRING", 3)should return"PAHNAPLSIIGYIR".
 */
public class ZigzagConversion {
    public String convert(String s, int nRows) {
        int len=s.length();
        if(s.length()==0 || nRows<=1)
            return s;
        int upOrDown=1;//1:向下;  0:向上
        int row=0;
        String[] result=new String[nRows];
        Arrays.fill(result,"");//这一步必须有,否则就有null,因为没有被初始化
        for(int i=0;i<len;i++){
            result[row]+=s.substring(i,i+1);
            if(upOrDown==1){
                row++;
            }else{
                row--;
            }
            if(row>=nRows){  //到达底部,需要向上了
                upOrDown=0;
                row=nRows-2;//注意这里不是row=nRows-1,开始写错了
            }
            if(row<0){  //到达顶部,需要向下了
                upOrDown=1;
                row=1;//注意这里不是row=0,开始我就写错了
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<nRows;i++){
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion a=new ZigzagConversion();
        System.out.println(a.convert("PAYPALISHIRING",3));
    }
}
