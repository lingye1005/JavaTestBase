package niukeWeb;


/**
 * Created by caoxiaohong on 17/6/27.
 * 给定一个非负数字,用数组表示各个位上的数字(0~9),给这个数字执行+1操作,并存回数组.
 */
public class plusOne {
    public int[] plusOne(int[] digits) {
        boolean flag=false;//记录当前数值是否有进位
        int len=digits.length;
        int i;
        for(i=len-1;i>-1;i--){
            if(i==len-1){
                int t=digits[i]+1;
                if(t>9){
                    flag=true;
                }else{
                    break;
                }

            }else{
                if(flag==true){//上一次有进位
                    int t=digits[i]+1;
                    if(t>9){
                        flag=true;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        if(i==len-1){//数组仅仅最后一位改变
            digits[len-1]++;
            return digits;
        }else if(i==-1){  //全部有修改
            int[] result=new int[len+1];
            result[0]=1;
            return result;
        }else{  //数组从0~i不变,后面全为0
            digits[i]++;
            for(int j=i+1;j<len;j++){
                digits[j]=0;
            }
            return digits;
        }
    }

    public static void main(String[] args) {
        plusOne t=new plusOne();
        int[] a=new int[5];
        int[] b=new int[5];
        int[] c=new int[5];
        for(int i=0;i<5;i++){
            a[i]=9;
            b[i]=i;
        }
        c[0]=1;
        c[1]=2;
        c[2]=3;
        c[3]=9;
        c[4]=9;
        int[] a1=t.plusOne(a);
        int[] b1=t.plusOne(b);
        int[] c1=t.plusOne(c);

        for(int i:a1)
            System.out.print(i+",");
        System.out.println();
        for(int i:b1)
            System.out.print(i+",");
        System.out.println();
        for(int i:c1)
            System.out.print(i+",");
    }
}
