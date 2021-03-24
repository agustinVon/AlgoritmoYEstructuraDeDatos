package AlgoritmoYEstructuraDeDatos;

import AlgoritmoYEstructuraDeDatos.Interfaces.QueueInterface;
import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    @Test
    public void isEmptyTest(){
        QueueInterface<Integer> intQueue = new Queue<>();

        Assert.assertTrue(intQueue.isEmpty());
    }

    @Test
    public void sizeTest(){
        QueueInterface<Integer> intQueue = new Queue<>();

        for (int i = 0; i < 5; i++) {
            intQueue.enqueue(i);
        }
        for (int i = 0; i < 2; i++) {
            intQueue.dequeue();
        }

        Assert.assertEquals(3, intQueue.size());
    }

    @Test
    public void addTest(){
        QueueInterface<Integer> intQueue = new Queue<>();
        intQueue.enqueue(747);
        for (int i = 0; i < 9; i++) {
            intQueue.enqueue(i);
        }
        Assert.assertEquals(747, java.util.Optional.ofNullable(intQueue.dequeue()));
        intQueue.enqueue(888);
        for (int i = 0; i < 10; i++) {
            intQueue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            intQueue.dequeue();
        }
        Assert.assertEquals(888, java.util.Optional.ofNullable(intQueue.dequeue()));
    }
}
