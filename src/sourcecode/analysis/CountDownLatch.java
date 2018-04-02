package sourcecode.analysis;

/**
 * @Author: cxh
 * @CreateTime: 18/3/11 11:20
 * @ProjectName: JavaBaseTest
 */
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * java.util.concurrent中高级的工具分为三类:
 * 1.Executor Framework
 * 2.并发集合(Concurrent Framework)
 * 3.同步器.
 * 常用同步器:CountDownLatch和Semaphore
 * 不常用同步器:CyclicBarrier和Exchanger
 * 同步器定义:是一些使线程能够等待另一个线程的对象,允许它们协调工作.
 * 本节讲的就是:CountDownLatch,称为:倒计数锁存器
 * CountDownLatch是一次性障碍,允许一个或者多个线程等待一个或者多个线程来做某些事情.
 * CountDownLatch的唯一构造器带有一个int类型的参数,这个int参数是指允许所有在等待
 * 的线程被处理之前,必须在锁存器上调用countDown方法的次数.
 *
 * CountDownLatch根据给定的count进行初始化.
 * 在countDown方法的调用次数从count降低到0的过程中,await方法始终被阻塞;到0后所有等待
 * 的进程都会被释放,并且任何后续的await调用都会立即返回.
 * 这是一次性现象---count是不能被重置的.
 * 如果你需要重置count,可以考虑使用另一个同步器:CyclicBarrier.
 *
 * CountDownLatch是一个多功能的同步工具,并可以用于许多场景.
 * CountDownLatch作为一个简单的开/关锁存器(or门),使用count进行初始化:所有的线程都会
 * 在gate处调用await方法,直到有一个线程调用了countDown方法这个gate才会打开.
 * CountDownLatch初始化的参数N的含义:
 * 使得一个线程一直等待,直到有N个线程完成了同样的操作,or
 * 同样的行为被完成了N次.
 *
 * CountDownLatch的一个有用属性是，它不要求调用countDown的线程在继续之前等待count达到零，
 * 它只是阻止任何线程继续超过一个await,直到所有线程可以通过.
 *
 * 简单应用:这里有一对类，其中一组工作线程使用两个倒计数锁存器：
 * 1.首先是一个启动信号，防止任何工人继续前进，直到司机准备好继续行驶;
 * 2.第二个是允许驾驶员等待的完成信号,直到所有工人都准备好。
 * 代码如下:
 * class Driver { // ...
 *   void main() throws InterruptedException {
 *     CountDownLatch startSignal = new CountDownLatch(1);
 *     CountDownLatch doneSignal = new CountDownLatch(N);
 *
 *     for (int i = 0; i < N; ++i) // create and start threads
 *       new Thread(new Worker(startSignal, doneSignal)).start();
 *
 *     doSomethingElse();            // don't let run yet
 *     startSignal.countDown();      // let all threads proceed
 *     doSomethingElse();
 *     doneSignal.await();           // wait for all to finish
 *   }
 * }
 *
 * class Worker implements Runnable {
 *   private final CountDownLatch startSignal;
 *   private final CountDownLatch doneSignal;
 *   Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
 *     this.startSignal = startSignal;
 *     this.doneSignal = doneSignal;
 *   }
 *   public void run() {
 *     try {
 *       startSignal.await();
 *       doWork();
 *       doneSignal.countDown();
 *     } catch (InterruptedException ex) {} // return;
 *   }
 *
 *   void doWork() { ... }
 * }}</pre>
 *
 * 另一个典型应用是:将一个问题划分为N个部分,
 * 每个部分都使用一个单独的线程表示，该Runnable执行该部分并在锁存器上进行倒计时.
 * 当所有的part都执行完成,对应的线程才能通过await方法.(如果线程必须重复这一行为,
 * 则同步器需使用CyclicBarrier)
 * 如下代码:
 *  <pre> {@code
 * class Driver2 { // ...
 *   void main() throws InterruptedException {
 *     CountDownLatch doneSignal = new CountDownLatch(N);
 *     Executor e = ...
 *
 *     for (int i = 0; i < N; ++i) // create and start threads
 *       e.execute(new WorkerRunnable(doneSignal, i));
 *
 *     doneSignal.await();           // wait for all to finish
 *   }
 * }
 *
 * class WorkerRunnable implements Runnable {
 *   private final CountDownLatch doneSignal;
 *   private final int i;
 *   WorkerRunnable(CountDownLatch doneSignal, int i) {
 *     this.doneSignal = doneSignal;
 *     this.i = i;
 *   }
 *   public void run() {
 *     try {
 *       doWork(i);
 *       doneSignal.countDown();
 *     } catch (InterruptedException ex) {} // return;
 *   }
 *
 *   void doWork() { ... }
 * }}</pre>
 *
 * 内存一致性影响：直到计数达到零为止,线程中的action执行时间在前,需要从其他线程中成功返回
 * 结果的action执行时间在后.
 * @since 1.5
 * @author Doug Lea
 */
public class CountDownLatch {
    /**
     * CountDownLatch同步控制.
     * 说明：对CountDownLatch方法的调用会转发到对Sync或AQS的方法的调用，
     * 所以，AQS对CountDownLatch提供底层支持.
     *
     * AQS的数据结构核心就是两个虚拟队列：同步队列sync queue 和
     * 条件队列condition queue，不同的条件会有不同的条件队列。
     * 使用AQS状态代表count.
     */
    //内部类
    private static final class Sync extends AbstractQueuedSynchronizer {
        //版本号
        private static final long serialVersionUID = 4982264981922014374L;
        //构造器
        Sync(int count) {
            setState(count);
        }
        //返回当前计数
        int getCount() {
            return getState();
        }
        //试图在共享模式下获取对象的状态
        protected int tryAcquireShared(int acquires) {
            return (getState() == 0) ? 1 : -1;
        }
        //试图设置状态来反映共享模式下的一个释放
        protected boolean tryReleaseShared(int releases) {
            // Decrement count; signal when transition to zero
            //死循环
            for (;;) {
                //获取状态
                int c = getState();
                //没有被线程占用
                if (c == 0)
                    return false;
                //下一个状态
                int nextc = c-1;
                //比较并且设置成功
                if (compareAndSetState(c, nextc))
                    return nextc == 0;
            }
        }
    }

    //同步队列,是CountDownLatch的唯一一个变量域
    private final Sync sync;

    /**
     * 构造器
     * 构造函数内完成了sync的初始化，并设置了状态数。
     * @param count 在所有线程通过await方法之前,countDown方法必须被调用的次数.
     */
    public CountDownLatch(int count) {
        if (count < 0) throw new IllegalArgumentException("count < 0");
        this.sync = new Sync(count);
    }

    /**
     * 此方法的调用会引起当前线程被阻塞,直到锁存器的状态数将为0,除非线程被中断.
     *
     * 如果锁存器的状态数count是0,则此方法被立即返回.
     *
     * 如果锁存器的count>0,那么为了线程调度目的，当前线程被禁用，并且处于休眠状态，
     * 直到发生以下两种情况之一：
     * 1.countDown方法的调用导致count降为0;or
     * 其他线程中断了当前线程.
     * 2.如果当前线程:
     *  1)在进入此方法时设置了其中断状态;
     *  2)等待时被中断.
     *  出现上述1),2)情况时,会抛出InterruptedException异常
     */
    public void await() throws InterruptedException {
        //对CountDownLatch对象的await的调用会转发为对
        // Sync的acquireSharedInterruptibly（从AQS继承的方法）方法的调用
        sync.acquireSharedInterruptibly(1);
    }

    /**
     * 此方法的调用会引起当前线程被阻塞,直到锁存器的状态数将为0,除非线程被中断or等待超时.
     * 果锁存器的状态数count是0,则此方法被立即返回.
     * 如果锁存器的count>0,那么为了线程调度目的，当前线程被禁用，并且处于休眠状态，
     * 直到发生以下三种情况之一：
     * 1.锁存器状态值count将为0.
     * 2.其他线程中断当前线程.
     * 3.指定等待时间到达.
     *
     * 如果锁存器的状态值到达0,则本方法返回true.
     *
     * 如果当前的线程:
     * 1.在进入此方法时设置了其中断状态
     * 2.等待时被其他线程中断.
     * 遇到上面两个情况时,抛出中断异常.
     *
     * 如果指定等待时间到达,则返回false.
     * 如果等待时间<=0,则本方法不再进行等待.
     * @param timeout 等待最长时间
     * @param unit timeout参数的时间单位
     * @return 如果count到达0,则返回true;
     *         如果在count到达0之前等待超时,返回false;
     */
    public boolean await(long timeout, TimeUnit unit)
            throws InterruptedException {
        return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    /**
     * 降低锁存器的count值,如果count降为0,则释放所有等待线程.
     *
     * 如果当前count>0,则降低count值.
     * 如果新的count初始值为0,则所有等待的线程都将重新启用以进行线程调度
     * 如果当前count=0,则什么也不发生.
     */
    public void countDown() {
        sync.releaseShared(1);
    }

    /**
     * 返回当前锁存器的状态值.
     * 这一方法通常用作:debug和测试
     */
    public long getCount() {
        return sync.getCount();
    }

    /**
     * 返回一个标志当前锁存器的字符串,包括其状态.
     * 括号中的状态包括字符串“count”，后跟当前计数。
     */
    public String toString() {
        return super.toString() + "[Count = " + sync.getCount() + "]";
    }
}
