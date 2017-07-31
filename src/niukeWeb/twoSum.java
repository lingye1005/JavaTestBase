package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/18.
 * 求数组中两个数相加的目标数字
 * 假设有且仅有一个解决方案,并且两个数字下标不能重复
 */
public class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int a[]=new int[2];
        int len=numbers.length;
        boolean flag=false;//true表示已经找到
        for(int i=0;i<len && !flag;i++){
            for(int j=i+1;j<len;j++){
                if(numbers[i]+numbers[j]==target){
                    a[0]=i+1;
                    a[1]=j+1;
                    flag=true;
                    break;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        twoSum test=new twoSum();
        int[] a={2, 7, 11, 15};
        int[] b=test.twoSum(a,9);
        for(int i:b){
            System.out.println(i);
        }
    }
}
