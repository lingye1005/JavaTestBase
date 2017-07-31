package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/9.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e.,0 1 2 4 5 6 7might become4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 */
public class search2 {
    public int search(int[] A, int target) {
        int len=A.length;
        if( len==0 || (len==1 && A[0] !=target))
            return -1;
        int left=0,right=len-1;
        while(left<=right){
            if(A[left]==target)
                return left;
            if(A[right]==target)
                return right;
            else{
                left++;
                right--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        search2 test=new search2();
        int[] a={4,5,6,7,0,1,2};
        int t=1;
        System.out.println(test.search(a,t));
    }
}
