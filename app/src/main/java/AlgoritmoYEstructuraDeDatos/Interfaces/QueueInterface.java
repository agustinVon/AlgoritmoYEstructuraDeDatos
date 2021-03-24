package AlgoritmoYEstructuraDeDatos.Interfaces;

public interface QueueInterface<T> {

    public void enqueue(T element);
    public T dequeue();
    public boolean isEmpty();
    public int size();

}
