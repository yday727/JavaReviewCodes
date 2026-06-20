package exercise.t4;

public class Pair<T, U>{
    public T first;
    public U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public void swap(){
        T temp = first;
        first = (T) second;
        second = (U) temp;
    }
}
