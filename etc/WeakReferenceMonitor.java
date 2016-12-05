import java.lang.ref.*;
import java.util.*;

public class WeakReferenceMonitor extends Observable {
    private final static ReferenceQueue referenceQueue = new ReferenceQueue();
    Map<WeakReference<Object>,Observer> map = new HashMap<>();

    private WeakReferenceMonitor() {
        new Monitor().start();
    }
    private static WeakReferenceMonitor instance;
    public static WeakReferenceMonitor instance() { 
        if (instance == null) instance = new WeakReferenceMonitor();
        return instance;
    }

    public void monitor(Object object, Observer owner) {
        map.put(new WeakReference<Object>(object, referenceQueue),owner);
    }

    static class Monitor extends Thread {
        Monitor() {
            setPriority(Thread.MAX_PRIORITY);
            setDaemon(true);
        }

        public void run() {
            while(true) {
                try {
                    WeakReference<Object> o = (WeakReference) referenceQueue.remove();
                    System.out.println("REFERENCEQUEUE.REMOVE");
                    Observer owner = instance.map.get(o);
                    owner.update(instance, o);
                } catch (Exception e) {
                }
            }
        }
    }
}
