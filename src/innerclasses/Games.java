package innerclasses;

import print.PrintString;

/**
 * Created by caoxiaohong on 17/1/16.
 */
interface Game{boolean move();}
interface GameFactory{Game getGame();}

class Checkers implements Game{
    private Checkers(){}
    private int moves=0;
    private static final int MOVES=5;
    public boolean move(){
        PrintString.printString("Checkers move"+moves);
        return ++moves!=MOVES;
    }
    //匿名内部类,优雅
    public static GameFactory gameFactory=new GameFactory() {
        @Override
        public Game getGame() {
            return new Checkers();
        }
    };
}

public class Games {
    public static void playGame(GameFactory gameFactory){
        Game game=gameFactory.getGame();
        while(game.move());
    }
    public static void main(String[] args){
        playGame(Checkers.gameFactory);
    }
}
