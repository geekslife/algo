import java.lang.ref.*;
import java.util.*;

public class MiniGCTest implements Observer {
    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public void update(Observable o, Object arg) {
        System.out.println("UNREACHABLE:"+arg);
    }

    public static void main(String[] args) {
        MiniGCTest test = new MiniGCTest();
        new Thread() {
            public void run() {
                try {
                    int count=0;
                    ArrayList data = new ArrayList();
                    //MiniGC gc = null;
                    while (true) {
                        Thread.sleep(1000);
                        System.out.println("tick");
                        count++;
                        if (count == 2) {
                            WeakReferenceMonitor.instance().monitor(test.obj1,test);
                            //gc = new MiniGC();
                            //gc.monitor(test.obj1);
                        }

                        if (count == 3) {
                            System.out.println("now run gc when obj1 is not null..");
                            System.gc();
                        }

                        if (count == 4) {
                            // 모니터의 키는 WeakReference. 이제 WeakReference 가 감싸고 있는 Object 를 봐ㅈ.
                            Object test_obj1 = WeakReferenceMonitor.instance().map.keySet().toArray()[0];
                            System.out.println("test.obj1 ==>"+
                                ((WeakReference)test_obj1).get());
                            test.obj1 = null;
                        }

                        if (count == 6) {
                            System.out.println("now run gc..");
                            System.gc();
                            // 모니터의 키는 WeakReference. 이제 WeakReference 가 감싸고 있는 Object 를 봐ㅈ.
                            Object test_obj1 = WeakReferenceMonitor.instance().map.keySet().toArray()[0];
                            System.out.println("test.obj1 ==>"+
                                ((WeakReference)test_obj1).get());
                        }

                        /*
                        if (count > 10) {
                            data.add(new byte[1024*1024*100]);
                            System.out.println("data size="+Runtime.getRuntime().freeMemory());
                        }
                        */
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
