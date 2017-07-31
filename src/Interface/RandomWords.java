package Interface;

import java.nio.*;
import java.util.*;

/**
 * Created by caoxiaohong on 16/12/4.
 */
public class RandomWords implements Readable{
    private static Random random=new Random(47);
    private static final char[] capitals="ABCDEFGHIJKLMNOPQRSTUVWSYZ".toCharArray();
    private static final char[] lowers="abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] overs="aeiou".toCharArray();
    private  int count;
    public RandomWords(int count){this.count=count;}
    public int read(CharBuffer charBuffer){
        if(count--==0)
            return -1;
        charBuffer.append(capitals[random.nextInt(capitals.length)]);
        for(int i=0;i<4;i++){
            charBuffer.append(lowers[random.nextInt(lowers.length)]);
            charBuffer.append((overs[random.nextInt(overs.length)]));
        }
        charBuffer.append("  ");
        return 10;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(new RandomWords(10));
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
 }
