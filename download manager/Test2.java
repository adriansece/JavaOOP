//
import java.util.ArrayList; 
import java.util.List; 
import java.util.concurrent.atomic.AtomicInteger;

//
public interface DownloadManager { 
    public void startDownload(Runnable download); 
} 

//
public class SimpleDM implements DownloadManager { 

    private static final int MAX_DOWNLOADS = 1; 
    private int count = 0; 
    private Thread dThread; 

    public void startDownload(Runnable download) { 
        if (count < MAX_DOWNLOADS) { 
            dThread = new Thread(download); 
            dThread.start(); 
            count++; 
        } 
    } 
} 

//
public class MultipleDM implements DownloadManager { 

    private static int MAX_DOWNLOADS; 
    private int count; 
    private List<Thread> dThreads; 

    public MultipleDM(int maxDownloads) { 
        int Count = 0; 
        dThreads = new ArrayList<>(); 
    } 

    public void startDownload(Runnable download) { 
        if (count < MAX_DOWNLOADS) { 
            Thread dThread = new Thread(download); 
            dThreads.add(dThread); 
            dThread.start(); 
            count++; 
        } 
    } 
} 

//
public class PooledDM implements DownloadManager { 

    private static int MAX_DOWNLOADS; 
    private AtomicInteger count; 
    private List<Thread> dThreads; 

    public PooledDM(int maxDownloads) { 
        MAX_DOWNLOADS = maxDownloads; 
        count = new AtomicInteger(0); 
        dThreads = new ArrayList<>(); 


        for (int i = 0; i < MAX_DOWNLOADS; i++) { 
            Thread thread = new Thread(new Runnable() { 
                public void run() { continueDownload(); } 
            }); 
            dThreads.add(thread); 
            thread.start(); 
        } 
    } 

    public void startDownload(Runnable download) { 
        if (count.get() < MAX_DOWNLOADS) { 
            count.incrementAndGet(); 
            synchronized (dThreads) { 
                dThreads.notify(); 
            } 
        } 
    } 


    private void continueDownload() { 
        while (true) { 
            synchronized (dThreads) { 
                try { 
                    dThreads.wait(); 
                    count.decrementAndGet(); 
                } catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            } 
        } 
    } 
}

 
DownloadManager manager = new PooledDM(4); 

 
manager.startDownload(new Runnable() { 
    public void run() { 
    }
}
