package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/18.
 * 从小明家所在公交站出发有n路公交到公司，现给出每路公交的停站数(不包括起点和终点)，及每次停的时间(一路车在每个站停的时间相同)和发车的间隔，
 * 先假定每辆车同时在相对时间0分开始发车，且所有车在相邻两个站之间的耗时相同,都为5分钟。给定小明起床的相对时间(相对0的分钟数)，请计算他最早到达公司的相对时间。
 * 数据说明:
 * 给定每路车的停站数stops,停站时间period,发车间隔interval及公交路数n，出发时间s。请返回最早到达时间。保证公交路数小于等于500，停站数小于等于50。
 */
public class TakeBuses {
    public int chooseLine(int[] stops, int[] period, int[] interval, int n, int s) {
        // write code here
        //等车时间+车子行驶时间+车子站点停留时间
        int minTime=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int waitTime=s%interval[i]==0?0:interval[i]-s%interval[i];
            int moveTime=(stops[i]+1)*5;
            int stopTime=period[i]*stops[i];
            if(waitTime+moveTime+stopTime+s<minTime)
                minTime=waitTime+moveTime+stopTime+s;
        }
        return minTime;
    }

    public static void main(String[] args) {
        TakeBuses t=new TakeBuses();
        int[] a={13,15,26,7,27,3,30};//停站数
        int[] b={1,2,1,2,2,2,1};//停站时间
        int[] c={5,1,4,3,2,1,4};//发车间隔
        int n=7,s=10;
        System.out.println(t.chooseLine(a,b,c,n,s));
    }
}
