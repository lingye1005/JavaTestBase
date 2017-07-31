package polymorphism.music3;
import polymorphism.shape.Note;
/**
 * Created by caoxiaohong on 16/11/26.
 * p155 练习题6
 */
class Instrument{
    void play(Note n){System.out.println("this is Instrument play "+n.toString());}
    String what(Instrument instrument){return instrument.toString();  }
    void adjust(){System.out.println("this is Instrument adjust ");}
}
class Wind extends Instrument{
    void play(Note note){System.out.println("this is Wind play"+note.toString());}
    String what(){return "this is wind what";}
    void adjust(){System.out.println("this is wind adjust");}
}
class Percusssion extends Instrument{
    void play(Note note){System.out.println("this is Percussion play"+note.toString());}
    String what(){return "this is percusssion what";}
    void adjust(){System.out.println("this is percussion adjust");}
}
class Stringed extends Instrument{
    void play(Note note){System.out.println("this is stringed play");}
    String what(){return "Stringed what";}
    void adjust(){System.out.println("this is stringed adjust");}
}
class Brass extends Instrument{
    void play(Note note){System.out.println("this is brass play");}
    void adjust(){System.out.println("this is brass adjust");}
}
class Woodwind extends Instrument{
    void play(Note note){System.out.println("this is woodwind play");}
    String what(){return "Woodwind";}
}


public class Music3 {
    static void tune(Instrument instrument){
        //instrument.play(Note.MIDDLE_C);
        System.out.println(instrument.what(instrument));
    }
    static void tuneAll(Instrument[] e){
        for(Instrument i:e)
            tune(i);
    }
    public static void main(String[] args){
        Instrument[] orch={
                new Wind(),new Percusssion(),new Stringed(),new Brass(),new Woodwind()
        };
        tuneAll(orch);
    }
}
