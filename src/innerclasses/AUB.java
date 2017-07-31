package innerclasses;

/**
 * Created by caoxiaohong on 17/1/17.
 */
interface U{
    public void getName();
    int getNum();
    String getStr();
}
class A{
    public U getU(){//下面为匿名内部类
        return new U() {
            @Override
            public void getName() {
                System.out.println("this is getName()");
            }

            @Override
            public int getNum() {
                System.out.println("this is getNum()");
                return 0;
            }

            @Override
            public String getStr() {
                System.out.println("this is getStr()");
                return null;
            }
        };
    }
}
class B{
    U[] temp=new U[10];//U类型数组
    public void insertU(U[] u){//为数组赋值
        int i=0;
        while(i<temp.length){
            temp[i]=u[i];
            i++;
        }
    }
    public void insertNull(U u){//为数组赋值为null
        int i=0;
        while(i<temp.length){
            temp[i++]=null;
        }
    }
    public void traverse(U[] u){//调用对象中每个方法;
        if(u[0]!=null) {
            int i = 0;
            while(i<10){
                u[i].getName();
                u[i].getNum();
                u[i].getStr();
                i++;
            }
        }
        else{
            System.out.println("数组为null!");
        }
    }
}
public class AUB {
    public static void main(String[] args) {
        A[] a=new A[10];
        B b=new B();
        A x=new A();
        for(int i=0;i<10;i++){//A类型对象产生的U型的引用填充B对象的数组;
            b.temp[i]=x.getU();
        }
        //使用B回调所有A的对象;
        b.traverse(b.temp);
        //从B中移除某些U的引用;
        for(int i=0;i<10;i++){
            if(i%2==0){//移除偶数部分对U的引用;
                b.insertNull(b.temp[i]);
            }
        }
    }
}
