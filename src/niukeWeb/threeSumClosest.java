package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/14.
 * 给定数组num和数字target,求num中三个数的和最接近target的组合,并返回其和.
 */
public class threeSumClosest {
    int minSum; //结果和
    /**
     *
     * @param num  数组
     * @param target 目标和
     * @return
     */
    public int threeSumClosest(int[] num, int target) {
        if(num==null || num.length<3)
            return 0;
        minSum=num[0]+num[1]+num[2];
        helper(num,target);
        return minSum;
    }

    /**
     *
     * @param num  被查找数组
     * @param target 目标和
     */
    void helper(int[] num,int target){
        int len=num.length;
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                 for(int k=j+1;k<len;k++){
                     if(Math.abs(num[i]+num[j]+num[k]-target)<Math.abs(minSum-target))
                         minSum=num[i]+num[j]+num[k];
                 }
            }
        }
    }

    public static void main(String[] args) {
        threeSumClosest test=new threeSumClosest();
        int[] a={0,1,2};
        System.out.println(test.threeSumClosest(a,0));
    }
}
