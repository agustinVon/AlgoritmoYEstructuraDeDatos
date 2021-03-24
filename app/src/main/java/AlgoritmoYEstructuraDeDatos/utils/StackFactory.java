package AlgoritmoYEstructuraDeDatos.utils;

import AlgoritmoYEstructuraDeDatos.Interfaces.StackInterface;

/**
 * Factory creates stacks from types of implementation
 * Each type of implementation extends from StackInterface and
 * behaves as implementation type declares.
 *
 * @param <T>
 *     Indicates type of object to be stacked
 *     Stacks creates should also be type <T>
 */
public class StackFactory<T> {
    public StackInterface<T> createFromType(ImplementationType type){
        switch (type){
            case DYNAMIC: return null; //TODO create static stack implementation
            case STATIC: return null; //TODO create dynamic stack implementation
            default: return null;
        }
    }

}
