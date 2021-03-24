package AlgoritmoYEstructuraDeDatos.utils;

import AlgoritmoYEstructuraDeDatos.Interfaces.QueueInterface;

/**
 * Factory creates queues from types of implementation
 * Each type of implementation extends from QueueInterface and
 * behaves as implementation type declares.
 *
 * @param <T>
 *     Indicates type of object to be queued
 *     Queues creates should also be type <T>
 */
public class QueueFactory<T> {
    public QueueInterface<T> createFromType(ImplementationType type){
        switch (type){
            case STATIC: return null; //TODO create static queue implementation
            case DYNAMIC: return null; //TODO create dynamic queue implementation
            default: return null;
        }
    }
}
