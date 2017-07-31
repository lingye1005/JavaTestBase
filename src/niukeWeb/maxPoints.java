package niukeWeb;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by caoxiaohong on 17/5/2.
 * 牛客网第3题
 * 2D平面上:求在一条直线上最多的点个数.
 * 知识点:穷举
 */

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class maxPoints {

    int maxPoints(Point[] points) {
        if(points==null || points.length==0) return 0;
        if(points.length==1) return 1; //只有1个点
        if(points.length==2) return 2; //只有2个点
        //多个点
        int max=1;
        Map<Double,Integer> map=new HashMap<Double, Integer>();
        for(int i=0;i<points.length;i++){
            map.clear();
            map.put((double)Integer.MIN_VALUE,1);
            int dup=0;

            for(int j=i+1;j<points.length;j++){
                if(points[j].x==points[i].x && points[j].y==points[i].y){
                    dup++;
                    continue;
                }
                // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                // problem

                // if the line through two points are parallel to y coordinator, then K(slop) is
                // Integer.MAX_VALUE
                double key=points[j].x-points[i].x==0 ? Integer.MAX_VALUE : 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }else{
                    map.put(key,1);
                }
            }
            //map存在比值k的键值对,dup存放和i点重复的j点
            for(int temp:map.values()){
                if(temp+dup>max)
                    max=temp+dup;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
