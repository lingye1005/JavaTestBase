package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 20:18
 * @ProjectName: JavaBaseTest
 */
public class IsNumeric {
    //数字正常格式:+113.33E-3必须按照这样的格式去判定

    //遍历字符串时如果是符号,自动到下一位进行判定
//    public boolean isNumeric(char[] str) {
//        if(str==null || str.length==0)
//            return  false;
//        if(str.length==1 && (str[0]=='+' || str[0]=='-'))
//            return false;
//
//        String tmp=String.valueOf(str).toLowerCase();
//        int idxe=tmp.indexOf("e");
//        int idxp=tmp.indexOf(".");
//
//        if(idxe!=-1 && idxp!=-1){
//
//        }else if(idxe!=-1){
//
//        }else if(idxp!=-1){
//
//        }else{
//
//        }
//
//    }
//    //判定0-9位的数字情况,是否有:小数点,是否有E
//    private int getIdx(char[] str,int from){
//        for(int i=from;i<=from+10 && i<str.length;i++){
//
//        }
//    }
//    //判定指数,每一位只能是0-9
//    private boolean isExponent(char[] str,int from,int to){
//        for(int i=from;i<=to;i++){
//            if(str[i]<'0' || str[i]>'9')
//                return false;
//        }
//        return true;
//    }
}
