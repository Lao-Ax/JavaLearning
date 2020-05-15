package ThinkingInJava.Threads.SharedResources;

/**
 * Created by Alex on 31.08.2015 031.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();

    // Allow this to be canceled:
    public void cancel() { canceled = true; }
    public boolean isCanceled() { return canceled; }
}
