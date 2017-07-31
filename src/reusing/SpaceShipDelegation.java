package reusing;

import java.awt.*;

/**
 * Created by caoxiaohong on 16/11/20.
 * 测试idea可以手动选择生成代理
 *
 */

class SpaceShipControls{
    void up(int i){}
    void down(int i){}
    void left(int i){}
    void right(int i){}
    void forward(int i){}
    void back(int i){}
}
class  test extends SpaceShipControls{
    @Override
    void up(int i){
        System.out.println("override test");
    }
}
public class SpaceShipDelegation {

    private SpaceShipControls controls=new SpaceShipControls();

    public void up(int i) {
        controls.up(i);
    }

    public void right(int i) {
        controls.right(i);
    }

    public void back(int i) {
        controls.back(i);
    }

    public void down(int i) {
        controls.down(i);
    }

    public void forward(int i) {
        controls.forward(i);
    }

    public void left(int i) {
        controls.left(i);
    }
   /*public static void main(String[] args){

    }*/
}
