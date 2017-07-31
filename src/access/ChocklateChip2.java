package access;

import access.dessert.*;

/**
 * Created by caoxiaohong on 16/11/3.
 */
public class ChocklateChip2 extends Cookie{
    public ChocklateChip2(){
        System.out.println("ChocklateChip constructor");
    }
    public void chomp(){
        bite();//can be accesed in outside package;
}
}
