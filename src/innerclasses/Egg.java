package innerclasses;

/**
 * Created by caoxiaohong on 17/2/7.
 * 检验内部类能否被覆盖
 */

class BigEgg{
    private Tolk y;
    protected class Tolk{
        public Tolk(){
            System.out.println("BigEgg.Tolk()");
        }
    }
    public BigEgg(){
        System.out.println("new BigEgg()");
        y=new Tolk();
    }
}

public class Egg extends BigEgg{
    public class Tolk{
        public Tolk(){
            System.out.println("Egg.Tolk()");
        }
    }
    public static void main(String[] args){
        new Egg();
    }
}

