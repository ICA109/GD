import java.util.concurrent.locks.ReentrantLock;

public class Count implements Runnable {

    //Need to be static so main can get final cumulative results
    private static int one;
    private static int two;
    private static int three;
    private int id; //Thread ID

    private static ReentrantLock lock;  //Single lock shared between all threads

    public Count(int id) {
        this.id = id;
    }

    public void action(int id) {
        if (one + two + three >= 30) {
            return;
        }
        switch (id) {
            case 1:
                one++;
                break;
            case 2:
                two++;
                break;
            case 3:
                three++;
                break;
        }
    }

    public static String result() {
        return String.format("One=%d, Two=%d, Three=%d", one, two, three);
    }


    @Override
    public void run() {
        int sum = 0;
        do {
            lock.lock();

            //Attempt actions
            try {
                action(this.id);
                sum = one + two + three;
            }
            catch (Exception ex) {
            }
            //When done
            finally {
                lock.unlock();  //Done so release so other threads can use resource
            }

        } while (sum < 30);

    }

    public static void main(String[] args) {

        //Don't forget to setup lock
        lock = new ReentrantLock();

        Runnable plus1 = new Count(1);
        Runnable plus2 = new Count(2);
        Runnable plus3 = new Count(3);

        Thread t1 = new Thread(plus1);
        Thread t2 = new Thread(plus2);
        Thread t3 = new Thread(plus3);

        t1.start();
        t2.start();
        t3.start();


        //KEY STEP: join threads to main thread. Program will not progress until given thread quits
        //i.e. Wait until all threads are done calculating before printing results
        try {
            t1.join();  //Current thread (i.e. main will pause until t1 is finished so t2 won't run)
            t2.join();
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Count.result());
    }
}
