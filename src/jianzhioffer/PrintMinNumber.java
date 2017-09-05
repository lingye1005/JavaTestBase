package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/30.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 算法思想:所有数字补齐长度.补齐规则:低位补0;
 * 然后按照从大到小顺序拼接字符串即为要求的最小数字.
 * 算法思想:冒泡排序.与普通冒泡排序不一样地方是:是否交换不是大小比较,而是str1+str2是否大于str2+str1这个数字.
 * 最后直接拼接数组即为所求
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null || numbers.length==0)
            return "";
        bubbleSort(numbers);
        StringBuilder result=new StringBuilder();
        for(int i:numbers){
            result.append(String.valueOf(i));
        }
        return result.toString();
    }

    /**
     *冒泡排序
     * @param numbers
     */
    private void bubbleSort(int[] numbers){
        int len=numbers.length;
        for(int i=0;i<len;i++){
            boolean flag=false;
            for(int j=len-1;j>i;j--){
                String str1=String.valueOf(numbers[j-1]);
                String str2=String.valueOf(numbers[j]);

                double d1=Double.valueOf(str1+str2);
                double d2=Double.valueOf(str2+str1);
                if(d1>d2){
                    int tmp=numbers[j];
                    numbers[j]=numbers[j-1];
                    numbers[j-1]=tmp;
                    flag=true;
                }
            }
            if(!flag)
                break;
        }
    }
    public static void main(String[] args) {
        PrintMinNumber t=new PrintMinNumber();
        int[] a={3,5,1,4,2};
        System.out.println(t.PrintMinNumber(a));
    }
}
