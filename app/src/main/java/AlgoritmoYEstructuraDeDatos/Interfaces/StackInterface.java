package AlgoritmoYEstructuraDeDatos.Interfaces;

public interface StackInterface<T> {
    
    public boolean isEmpty();
    public T peek();
    public void pop();
    public void stack(T element);
    public int size();
    public void empty();
}
