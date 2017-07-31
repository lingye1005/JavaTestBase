package innerclasses;

/**
 * Created by caoxiaohong on 17/2/21.
 * 局部内部类和匿名内部类,具有相同的能力和作用,但是局部内部类的名字在方法外是不可见的,那么为什么我们使用局部内部类而不是匿名内部类呢?
 * 唯一理由是:我们需要一个命名的构造器或者需要重载构造器,而匿名内部类只能用于实例初始化.
 * 另一个理由:需要不止一个该内部类的对象.
 */
interface Counter{
    int next();
}

public class LocalInnerClass {
    private int count=0;
    Counter getCounter(final String name){
        //局部内部类
        class LocalCounter implements Counter{
            public LocalCounter(){
                System.out.println("LocalCounter()");
            }
            public int next(){
                System.out.println(name);
                return count++;
            }
        }
        return new LocalCounter();
    }
    Counter getCounter2(final String name){
        return new Counter() {
            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
            //匿名内部类不能有带名字的构造器,只能有内容初始化;
            {
                System.out.println("Counter()");
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass localInnerClass=new LocalInnerClass();
        Counter
                c1=localInnerClass.getCounter("Local inner"),
                c2=localInnerClass.getCounter2("annomous class");
        for(int i=0;i<7;i++){
            System.out.println(c1.next());
        }
        for(int i=0;i<7;i++){
            System.out.println(c2.next());
        }
    }
}
