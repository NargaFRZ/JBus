package FairuzMuhammadJBusRA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public class Algorithm {
    private Algorithm(){
    }

    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred){
        if(array == null || pred == null || page < 0 || pageSize < 1){
            throw new IllegalArgumentException("Invalid Input");
        }

        List<T> res = new ArrayList<>();
        int start = page * pageSize;
        int end = Math.min(start + pageSize, array.length);
        int i;
        for(i = start;i < end; i++){
            if(pred.predicate(array[i])){
                res.add(array[i]);
            }
        }
        return res;
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred){
        if(iterable == null || pred == null || page < 0 || pageSize < 1){
            throw new IllegalArgumentException("Invalid Input");
        }

        List<T> res = new ArrayList<>();
        int i = 0;
        int start = page * pageSize;
        int added = 0;

        for (T item : iterable){
            if(i++ < start){
                continue;
            }
            if(added >= pageSize){
                break;
            }
            if(pred.predicate(item)){
                res.add(item);
                added++;
            }
        }
        return res;
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred){
        if(iterator == null || pred == null || page < 0 || pageSize < 1){
            throw new IllegalArgumentException("Invalid Input");
        }

        List <T> res = new ArrayList<>();
        int i = 0;
        int start = page * pageSize;
        int added = 0;

        while(iterator.hasNext()){
            T item = iterator.next();
            if (i++ < start){
                continue;
            }
            if (added >= pageSize){
                break;
            }
            if(pred.predicate(item)){
                res.add(item);
                added++;
            }
        }

        return res;
    }

    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                return true;
            }
        }
        return false;
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int counter = 0;
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    public static <T> T find(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }

    public static <T> T find(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                return current;
            }
        }
        return null;
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred){
        List<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                list.add(current);
            }
        }
        return list;
    }
}