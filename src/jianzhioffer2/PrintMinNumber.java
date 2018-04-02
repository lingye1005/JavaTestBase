package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 15:03
 * @ProjectName: JavaBaseTest
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        PrintMinNumber t=new PrintMinNumber();
        int[] a={3,5,1,4,2};
        System.out.println(t.PrintMinNumber(a));
    }

    public String PrintMinNumber(int [] numbers) {
        if(numbers==null || numbers.length==0)
            return "";
        bubbleSort(numbers);
        StringBuilder sb=new StringBuilder();
        for(int i:numbers)
            sb.append(i);
        return sb.toString();
    }
    private void bubbleSort(int[] numbers){
        int len=numbers.length;
        for(int i=0;i<len;i++){
            boolean change=false;
            for(int j=len-1;j>i;j--){
                String str1=String.valueOf(numbers[i]);
                String str2=String.valueOf(numbers[j]);
                String s1=str1+str2;
                String s2=str2+str1;
                Double d1=Double.valueOf(s1);
                Double d2=Double.valueOf(s2);
                if(Double.compare(d1,d2)>0){
                    int tmp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=tmp;
                    change=true;
                }
            }
            if(!change)
                break;
        }
    }
}
