package schooloffer17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/11/19 18:40.
 * <geohash编码></>
 */
public class GeoHash {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        ArrayList<Integer> list=new ArrayList<Integer>();
        while (scanner.hasNextInt()){
            n=scanner.nextInt();
            //进行6次循环
            int from=-90,to=90;
            for(int i=6;i>0;i--){
                int mid=(from+to)/2;
                if(n>=mid){
                    from=mid;
                    list.add(1);
                }else{
                    to=mid;
                    list.add(0);
                }
            }
            Iterator<Integer> iterator=list.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next());
            }
            System.out.println();
            list.clear();
        }
    }
}
