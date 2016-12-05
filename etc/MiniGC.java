import java.lang.ref.*;
import java.util.*;


public class MiniGC<T> {
    private final static ReferenceQueue referenceQueue = new ReferenceQueue();
    //WeakReference<T> wref;// = new WeakReference<>(o, referenceQueue);
    List<WeakReference<T>> wref = new ArrayList<WeakReference<T>>();
    public MiniGC() {
        new Monitor().start();
    }

    public void monitor(T o) {
        wref.add(new WeakReference<T>(o, referenceQueue));
    }

    static class Monitor extends Thread {
        Monitor() {
            setPriority(Thread.MAX_PRIORITY);
            setDaemon(true);
        }

        public void run() {
            System.out.println("start GC monitoring...");
            while(true) {
                try {
                    Object o = referenceQueue.remove();
                    System.out.println("POLLED:"+o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
