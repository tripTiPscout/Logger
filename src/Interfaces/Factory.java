package Interfaces;

public interface Factory<T> {
    T produce(String type);
}
