package reusing;

/**
 * Created by caoxiaohong on 16/11/23.
 * 7.7向上转型
 */

class Instrument{
    public void play(){
        System.out.println("this is playing");
    }
    static void tune(Instrument i){
        i.play();
    }
}

public class Wind extends Instrument{
  public static void main(String[] args){
      Wind wind=new Wind();
      wind.tune(wind);
  }
}
