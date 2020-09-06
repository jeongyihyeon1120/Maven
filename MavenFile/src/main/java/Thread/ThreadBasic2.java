package Thread;

public class ThreadBasic2 implements Runnable {
    private int index;
    
    public ThreadBasic2(int index) {
        this.index = index;
    }

    public void run() {
        // TODO Auto-generated method stub
        System.out.println(index + "번째 쓰레드가 동작합니다.");
    }

    public static void main(String[] args) {
        for(int i=0; i<15; i++) {
        	Runnable r = new ThreadBasic2(i); 
            Thread t = new Thread(r);
            // = Thread t new Thread(ThreadBasic2(i);
            t.start();
        }
    }
}