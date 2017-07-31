package innerclasses;

/**
 * Created by caoxiaohong on 16/12/18.
 */

class Outter{
    public class Inner{}
    public Inner getInner(){
        return  new Inner();
    }
}

public class ContainsClass {
    Outter  ou =new Outter();
    Outter.Inner inner=ou.getInner();
}
