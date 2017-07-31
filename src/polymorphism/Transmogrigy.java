package polymorphism;

import javax.activity.ActivityRequiredException;

/**
 * Created by caoxiaohong on 16/11/28.
 * page165 practice16
 */

class Actor{
   void play(){}
}
class FrontActor extends Actor{
    void play(){System.out.println("this is FrontActor play()");}
}
class MiddleAcotr extends Actor{
    void play(){System.out.println("this is MiddleAcotr play()");}
}
class BackActor extends Actor{
    void play(){System.out.println("this is BackActor play()");}
}
class StarShip{
    private Actor actor=new FrontActor();
    public void changeToFront(){
        actor=new MiddleAcotr();
    }
    public void changeToMiddle(){
        actor=new MiddleAcotr();
    }
    public void changeToBack(){
        actor=new BackActor();
    }
    public  void actorPlay(){
        actor.play();
    }
}

public class Transmogrigy {
    public static void main(String[] args) {
        StarShip starShip = new StarShip();
        starShip.actorPlay();

        starShip.changeToFront();
        starShip.actorPlay();

        starShip.changeToBack();
        starShip.actorPlay();
    }
}
