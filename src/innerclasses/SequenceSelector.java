package innerclasses;

/**
 * Created by caoxiaohong on 17/1/17.
 */
class Seq{
    int i=0;
    public void seqMethod(){}
}
class SeqExt {
    class First extends Seq{
        @Override
        public void seqMethod() {
            if(i<=0){
                i++;
                System.out.println("the value of i is "+i);
            }
            else {
                System.out.println("i should be added!");
            }
        }
    }
    class Second extends Seq{
        @Override
        public void seqMethod(){
            if(i>=10){
                i--;
                System.out.println("the value of i is "+i);
            }
            else {
                System.out.println("i shoud be minus;");
            }
        }
    }
}
public class SequenceSelector {
}
