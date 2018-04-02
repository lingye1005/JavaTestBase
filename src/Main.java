public class Main {

    public static void main(String[] args){
        /**Scanner scanner  = new Scanner(System.in);
        while (scanner.hasNext()){

        }**/
        int[] a={-1,-2,-3};
        System.out.println(getInfoMaxScore(a));
    }

    //连续数组的最大和
    public static int getInfoMaxScore(int[] scoreArr){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<scoreArr.length;i++){
            if(sum<=0)
                sum=scoreArr[i];
            else
                sum+=scoreArr[i];
            max=Math.max(sum,max);
        }
        return  max;
    }
}