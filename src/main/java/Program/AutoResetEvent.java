package Program;

/**
 * Created by sircodesalot on 15/2/2.
 */
public class AutoResetEvent {
  private Object monitor = new Object();
  private volatile boolean open = false;

  public void set() {
    synchronized (monitor) {
      open = true;
      monitor.notify();
    }
  }

  public void waitOne() throws InterruptedException {
    synchronized (monitor) {
      while (!open) { monitor.wait(); }
      open = false;
    }
  }
}
