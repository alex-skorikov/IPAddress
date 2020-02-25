package twothreads;

import java.io.IOException;

/**
 * Interface workable.
 */
public interface Workable extends Runnable {
    /**
     * Work method.
     * @throws InterruptedException thread exception.
     * @throws IOException file read-write exception.
     */
    void work() throws InterruptedException, IOException;
}
