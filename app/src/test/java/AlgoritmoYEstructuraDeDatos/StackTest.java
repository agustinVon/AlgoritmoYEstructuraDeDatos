package AlgoritmoYEstructuraDeDatos;

import AlgoritmoYEstructuraDeDatos.Interfaces.StackInterface;
import AlgoritmoYEstructuraDeDatos.utils.IsEmptyException;
import AlgoritmoYEstructuraDeDatos.utils.StackFactory;
import AlgoritmoYEstructuraDeDatos.utils.ImplementationType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class StackTest{

    private final ImplementationType type;
    private final StackFactory<Integer> factory;
    private StackInterface<Integer> stack;

    public StackTest(ImplementationType type){
        this.type=type;
        this.factory=new StackFactory<>();
        this.stack = factory.createFromType(type);
    }

    @Parameterized.Parameters(name= "{0}")
    public static Collection<ImplementationType> parameters(){
        return new ArrayList<>(Arrays.asList(ImplementationType.STATIC, ImplementationType.DYNAMIC));
    }

    @Before
    public void before(){
        stack= factory.createFromType(type);
    }

    @Test
    public void differentTypesOfDataAreAccepted(){
        StackFactory<String> stringStackFactory = new StackFactory<>();
        StackInterface<String> stack = stringStackFactory.createFromType(type);
        stack.stack("Hello World");
        Assert.assertEquals("Hello World", stack.peek());
    }

    /**
     * IsEmptyException is expected when dequeue non existing element
     */
    @Test
    public void popEmptyStack(){
        boolean exceptionWasThrown = false;
        try {
            stack.pop();
        } catch (IsEmptyException e) {
            exceptionWasThrown = true;
        }
        Assert.assertTrue(exceptionWasThrown);
    }

    @Test
    public void emptyTest(){
        for (int i = 0; i < 50; i++) {
            stack.stack(i);
        }
        stack.empty();
        Assert.assertEquals(0,stack.size());
    }

    @Test
    public void peekDoesNotPopElement(){
        stack.stack(1);
        stack.stack(2);

        int firstPeek = stack.peek();
        Assert.assertEquals(firstPeek,(int) stack.peek());
    }

    @Test
    public void orderConservationTest() throws IsEmptyException {
        boolean orderIsConserved = true;

        for (int i = 0; i < 200; i++) {
            stack.stack(i);
        }
        for (int i = 199; i >= 0 ; i--) {
            if(stack.peek() != i) orderIsConserved = false;
            stack.pop();
        }

        Assert.assertTrue(orderIsConserved);
    }

    @Test
    public void isEmptyTest(){
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void size() throws IsEmptyException {
        for (int i = 0; i < 50; i++) {
            stack.stack(i);
        }
        for (int i = 0; i < 20; i++) {
            stack.pop();
        }
        Assert.assertEquals(30,stack.size());
    }
}
