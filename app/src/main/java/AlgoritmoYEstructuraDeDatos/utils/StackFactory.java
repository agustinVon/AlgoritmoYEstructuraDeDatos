package AlgoritmoYEstructuraDeDatos.utils;

import AlgoritmoYEstructuraDeDatos.Interfaces.StackInterface;

public class StackFactory<T> {
    public StackInterface<T> createFromType(StackType type){
        switch (type){
            case DYNAMIC: return null; //TODO Dynamic implementation
            case STATIC: return null; //TODO Static implementation
            default: return null;
        }
    }

}
