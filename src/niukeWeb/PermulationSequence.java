package niukeWeb;

/**
 * Created by caoxiaohong on 17/8/8.
 * 给定整数n,1<=n<=9.可以有n!个不同的排列组合.
 * 求从小到达的排列组合中第k个数字是什么,以string类型返回
 * 字典序排序生成算法
 */
public class PermulationSequence {
    public String getPermutation(int n, int k) {
        //非法:k>n!
        if(getN(n)<k)
            return "";
        else{
            int[] temp=new int[n];
            for(int i=0;i<n;i++){
                temp[i]=i+1;
            }
            for(int i=2;i<=k;i++){
                //从后向前:查找第一个顺序
                for(int j=n-1;j>0;j--){
                    if(temp[j]>temp[j-1]){
                        //temp[j-1]和j-1后面最后一个比temp[j-1]大的数字
                        for(int s=n-1;s>j-1;s--){
                            if(temp[s]>temp[j-1]){
                                int a=temp[s];
                                temp[s]=temp[j-1];
                                temp[j-1]=a;
                                break;
                            }
                        }
                        //显示j-1后面的数字是降序,需要将j-1后面的数值改为升序
                        for(int x=j,y=n-1;x<y;x++,y--){
                            int a=temp[x];
                            temp[x]=temp[y];
                            temp[y]=a;
                        }
                        break;
                    }
                }
            }
            //将temp[]改为string
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++)
                sb.append(temp[i]);
            return sb.toString();
        }
    }

    int getN(int n){
        int count=1;
        for(int i=2;i<=n;i++)
           count*=i;
        return count;
    }

    public static void main(String[] args) {
        PermulationSequence test=new PermulationSequence();
        String xxx=test.getPermutation(3,7);
        System.out.println(xxx);
    }
}
