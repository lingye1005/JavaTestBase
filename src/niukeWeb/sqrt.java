package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/26.
 *分治思想:求x的开方
 */
public class sqrt {
    public int sqrt(int x) {
        return (int)Math.sqrt(x);
    }

    public static void main(String[] args) {
        sqrt s=new sqrt();
        System.out.println(s.sqrt(3));
        System.out.println(s.sqrt(9));
    }
}
