package access;

/**
 * Created by caoxiaohong on 16/11/3.
 */
public class ChocklateChip extends Cookie {
    public void ChocklateChip(){
        System.out.println("ChocklateChip constructor");
    }
     void chomp(){
        //bite();//cant be accesed in outside package;
    }

}
