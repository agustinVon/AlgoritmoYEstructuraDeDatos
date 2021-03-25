package AlgoritmoYEstructuraDeDatos;

import AlgoritmoYEstructuraDeDatos.Interfaces.QueueInterface;
import AlgoritmoYEstructuraDeDatos.Interfaces.StackInterface;
import AlgoritmoYEstructuraDeDatos.utils.ImplementationType;
import AlgoritmoYEstructuraDeDatos.utils.IsEmptyException;
import AlgoritmoYEstructuraDeDatos.utils.QueueFactory;
import AlgoritmoYEstructuraDeDatos.utils.StackFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;

@RunWith(Parameterized.class)
public class QueueTest {

    private final ImplementationType type;
    private final QueueFactory<Integer> factory;
    private QueueInterface<Integer> queue;

    public QueueTest (ImplementationType type){
        this.type = type;
        this.factory = new QueueFactory<>();
        this.queue = factory.createFromType(type);
    }

    @Parameterized.Parameters(name= "{0}")
    public static Collection<ImplementationType> parameters(){
        return new ArrayList<>(Arrays.asList(ImplementationType.STATIC, ImplementationType.DYNAMIC));
    }

    @Before
    public void before(){
        queue = factory.createFromType(type);
    }

    @Test
    public void isEmptyTest(){
        Assert.assertTrue(queue.isEmpty());
    }

    /**
     * IsEmptyException is expected when dequeue non existing element
     */
    @Test
    public void dequeueWhenIsEmpty(){
        boolean exceptionThrown = false;

        try {
            queue.dequeue();
        } catch (IsEmptyException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void differentTypesOfDataAreAccepted() throws IsEmptyException {
        QueueFactory<String> stringQueueFactory = new QueueFactory<>();
        QueueInterface<String> queue = stringQueueFactory.createFromType(type);
        queue.enqueue("Hello World");
        Assert.assertEquals("Hello World", queue.dequeue());
    }

    @Test
    public void enqueueAndDequeueTest() throws IsEmptyException {

        for (int i = 0; i < 3000; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 2000; i++) {
            queue.dequeue();
        }

        Assert.assertEquals(1000, queue.size());
    }

    @Test
    public void enqueueTest(){
        for (int i = 0; i < 40; i++) {
            queue.enqueue(i);
        }
        Assert.assertEquals(40, queue.size());
    }

    @Test
    public void dequeueTest() throws IsEmptyException {
        for (int i = 0; i < 40; i++) {
            queue.enqueue(i);
        }
        Assert.assertEquals(0,(int) queue.dequeue());
    }

    @Test
    public void indexNotAltered() throws IsEmptyException {
        for (int i = 0; i < 50; i++) {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);

            Assert.assertEquals(1,(int) queue.dequeue());
            Assert.assertEquals(2,(int) queue.dequeue());
            Assert.assertEquals(3,(int) queue.dequeue());
        }
    }
}
