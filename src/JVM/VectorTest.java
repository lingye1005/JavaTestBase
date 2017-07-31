package JVM;

import sun.java2d.loops.GraphicsPrimitive;

import java.util.Vector;

/**
 * Created by caoxiaohong on 17/7/14.
 * 对Vector的线程安全进行测试
 */
public class VectorTest {
     private static Vector<Integer> vector=new Vector<Integer>();

    public static void main(String[] args) {
        while(true){
            for(int i=0;i<10;i++){
                vector.add(i);
            }

            Thread removeThread=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<vector.size();i++){
                        vector.remove(i);
                    }
                }
            });

            Thread printThread=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<vector.size();i++){
                        System.out.println(vector.get(i));
                    }
                }
            });

            removeThread.start();
            printThread.start();

            while(Thread.activeCount()>20);
        }
    }
}
