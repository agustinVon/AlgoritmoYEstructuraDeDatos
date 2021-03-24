package AlgoritmoYEstructuraDeDatos;


import AlgoritmoYEstructuraDeDatos.Interfaces.StackInterface;
import AlgoritmoYEstructuraDeDatos.utils.StackFactory;
import AlgoritmoYEstructuraDeDatos.utils.StackType;
import org.junit.Assert;
import org.junit.Test;

public class StackTest{

    StackFactory<Integer> factory = new StackFactory();
    StackInterface stackStatic = factory.createFromType(StackType.STATIC);
    StackInterface stackDynamic = factory.createFromType(StackType.DYNAMIC);

    @Test
    public void popEmptyStack(){
        StackInterface<Integer> intStack = new Stack<>();

        intStack.empty();
        intStack.pop();
        Assert.assertEquals(0,intStack.size());
    }

    @Test
    public void addWhenFull(){
        StackInterface<Integer> intStack = new Stack<>();

        for (int i = 0; i < 1000; i++) {
            intStack.stack(i);
        }
        Assert.assertEquals(1000,intStack.size());
        for (int i = 0; i < 2000; i++) {
            intStack.stack(i);
        }
        Assert.assertEquals(3000,intStack.size());
    }

    @Test
    public void isEmptyTest(){
        StackInterface<Integer> intStack = new Stack<>();

        intStack.empty();
        Assert.assertTrue(intStack.isEmpty());
    }

    @Test
    public void size(){
        StackInterface<Integer> intStack = new Stack<>();

        for (int i = 0; i < 50; i++) {
            intStack.stack(i);
        }
        for (int i = 0; i < 20; i++) {
            intStack.pop();
        }
        Assert.assertEquals(30,intStack.size());
    }
}
