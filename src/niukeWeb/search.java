package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/24.
 * 对于一个升序或者降序数组,求是否存在target
 */
public class search {
    public boolean search(int[] A, int target) {
        int len=A.length;
        if(len==0)
            return false;
        for(int i:A){
            if(target==i)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        search test=new search();
        int[] t1=new int[2];
        t1[0]=1;
        t1[1]=2;
        int[] t2=new int[2];
        t2[0]=2;
        t2[1]=1;
        System.out.println(test.search(t1,1));
        System.out.println(test.search(t2,1));
    }
}
