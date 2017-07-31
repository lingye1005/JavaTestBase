package Interface;

/**
 * Created by caoxiaohong on 16/12/17.
 */
interface Game{ boolean move();}
interface GameFactory{Game getGame();}

class Checkers implements  Game{
    Checkers(){}
    private int moves=0;
    private static final int MOVES=3;
    public boolean move(){
        System.out.println("Checkers move()");
        return ++moves!=MOVES;
    }
}
class CheckersFacotory implements GameFactory{
    CheckersFacotory(){}
    public Game getGame(){
        return new Checkers();
    }
}
class Chess implements Game{
    Chess(){}
    private  int moves=0;
    private  static final int MOVES=5;
    public boolean move(){
        System.out.println("Chess move()");
        return  ++moves!=MOVES;
    }
}
class ChessFactory implements GameFactory{
    ChessFactory(){}
    public Game getGame(){
        return new Chess();
    }
}


public class Games {
    public static void playGame(GameFactory gameFactory){
        Game game=gameFactory.getGame();
        game.move();
    }
    public static void main(String[] args){
        playGame(new CheckersFacotory());
        playGame(new ChessFactory());
    }
}
