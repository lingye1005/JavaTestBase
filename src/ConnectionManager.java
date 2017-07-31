/**
 * Created by caoxiaohong on 16/11/6.
 */
 class ConnectionManager {

    private ConnectionManager(){};//构造函数

    private static int[] connection;//私有成员

    public  static int[] createConn()
    {
        return connection;
    }
    public  void shared(){
        System.out.println("creating"+this);
    }

    public static void main(String[] args){

    }
}
