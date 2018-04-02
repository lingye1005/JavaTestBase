package jianzhioffer2;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author: cxh
 * @CreateTime: 18/3/30 21:15
 * @ProjectName: JavaBaseTest
 */
public class GetMedian {
    TreeSet<Integer>  sets=new TreeSet<>();
    public void Insert(Integer num) {
        sets.add(num);
    }

    public Double GetMedian() {
        int size=sets.size();
        if(size==1)
            return sets.first()*1.0;
        double first=-1,seconde=-1;
        int count=0;
        Iterator<Integer> ite=sets.iterator();
        while (ite.hasNext()){
            int a=ite.next();
            //size/2 or size/2-1
            if(count==size/2-1)
                first=a;
            if(count==size/2)
                seconde=a;
            count++;
        }
        if(size%2==0)
            return (first+seconde)/2;
        else
            return seconde;
    }

    //test
    public static void main(String[] args) {
        GetMedian t=new GetMedian();
        //5,2,3,4,1,6,7,0,8
        t.Insert(5);
        double d=t.GetMedian();
        System.out.println(d);

        t.Insert(2);
        d=t.GetMedian();
        System.out.println(d);

        t.Insert(3);
        d=t.GetMedian();
        System.out.println(d);

        t.Insert(4);
        d=t.GetMedian();
        System.out.println(d);

        t.Insert(1);
        d=t.GetMedian();
        System.out.println(d);

        t.Insert(6);
        d=t.GetMedian();
        System.out.println(d);

        t.Insert(7);
        d=t.GetMedian();
        System.out.println(d);

        t.Insert(0);
        d=t.GetMedian();
        System.out.println(d);

        t.Insert(8);
        d=t.GetMedian();
        System.out.println(d);

    }
}
