package com.FairuzMuhammadJBusRA;
import com.FairuzMuhammadJBusRA.dbjson.JsonTable;

import java.io.Serializable;
import java.util.*;

/**
 * Provides utility methods for various common operations on arrays and collections.
 * This class includes methods for collecting, counting, finding elements, checking existence,
 * and paginating elements based on specified conditions.
 * 
 * @author Fairuz Muhammad
 * @version FINAL
 * @see Serializable
 */
public class Algorithm {
    private Algorithm() {
    }

    /**
     * Collects elements from an iterable that match a given value.
     * 
     * @param iterable The iterable to search.
     * @param value The value to match.
     * @param <T> The type of elements in the iterable.
     * @return A list of elements that match the value.
     */
    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        Iterator<T> i = iterable.iterator();
        return collect(i, value);
    }

    /**
     * Collects elements from an iterable that satisfy a given predicate.
     * 
     * @param iterable The iterable to search.
     * @param predicate The predicate to evaluate.
     * @param <T> The type of elements in the iterable.
     * @return A list of elements that satisfy the predicate.
     */
    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> predicate) {
        Iterator<T> i = iterable.iterator();
        return collect(i, predicate);
    }

    /**
     * Collects elements from an array that match a given value.
     * 
     * @param array The array to search.
     * @param value The value to match.
     * @param <T> The type of elements in the array.
     * @return A list of elements that match the value.
     */
    public static <T> List<T> collect(T[] array, T value) {
        Iterator<T> i = Arrays.stream(array).iterator();
        return collect(i, value);
    }

    /**
     * Collects all elements from an iterator that match a given value.
     * This method iterates through each element of the iterator, using the equals method to compare
     * each element with the specified value. If an element matches the value, it is added to the resulting list.
     *
     * @param iterator The iterator to iterate over.
     * @param value The value to match against each element.
     * @param <T> The type of elements in the iterator.
     * @return A list of elements that match the specified value.
     */
    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        Objects.requireNonNull(value);
        Predicate<T> predicate = value::equals;
        return collect(iterator, predicate);
    }

    /**
     * Collects elements from an iterator based on a given predicate.
     * 
     * @param iterator The iterator to search.
     * @param pred The predicate to evaluate.
     * @param <T> The type of elements in the iterator.
     * @return A list of elements that satisfy the predicate.
     */
    public static <T> List<T> collect(T[] array, Predicate<T> predicate) {
        Iterator<T> i = Arrays.stream(array).iterator();
        return collect(i, predicate);
    }

    /**
     * Collects all elements from an iterator that satisfy a specified predicate.
     * This method iterates through each element of the iterator, applying the predicate to each element.
     * If the predicate condition is met, the element is added to the resulting list.
     *
     * @param iterator The iterator to iterate over.
     * @param pred The predicate to apply to each element.
     * @param <T> The type of elements in the iterator.
     * @return A list of elements that satisfy the predicate.
     */
    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<>();

        while(iterator.hasNext()) {
            T tempVar = iterator.next();
            if (pred.predicate(tempVar)) {
                list.add(tempVar);
            }
        }

        return list;
    }

    /**
     * Counts the number of elements in an iterator that match a given value.
     * 
     * @param iterator The iterator to search.
     * @param value The value to match.
     * @param <T> The type of elements in the iterator.
     * @return The count of elements that match the value.
     */
    public static <T> int count(Iterator<T> iterator, T value) {
        Objects.requireNonNull(value);
        Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    /**
     * Counts the number of elements in an iterable collection that match a given value.
     * This method iterates through each element of the iterable, using the equals method to compare
     * each element with the specified value.
     *
     * @param iterable The iterable collection to search through.
     * @param value The value to match against each element.
     * @param <T> The type of elements in the iterable.
     * @return The count of elements that match the specified value.
     */
    public static <T> int count(Iterable<T> iterable, T value) {
        Objects.requireNonNull(value);
        Predicate<T> pred = value::equals;
        return count(iterable, pred);
    }

    /**
     * Counts the number of elements in an array that satisfy a specified predicate.
     * This method iterates through each element of the array, applying the predicate to each element
     * to determine if it should be counted.
     *
     * @param array The array to search through.
     * @param pred The predicate to apply to each element.
     * @param <T> The type of elements in the array.
     * @return The count of elements that satisfy the predicate.
     */
    public static <T> int count(T[] array, Predicate<T> pred) {
        Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    /**
     * Counts the number of elements in an array that match a given value.
     * 
     * @param array The array to search.
     * @param value The value to match.
     * @param <T> The type of elements in the array.
     * @return The count of elements that match the value.
     */
    public static <T> int count(T[] array, T value) {
        Iterator<T> it = Arrays.stream(array).iterator();
        Objects.requireNonNull(value);
        Predicate<T> pred = value::equals;
        return count(it, value);
    }

    /**
     * Counts the number of elements in an iterable collection that satisfy a specified predicate.
     * This method iterates through each element of the iterable, applying the predicate to determine
     * if the element should be counted.
     *
     * @param iterable The iterable collection to search through.
     * @param pred The predicate to apply to each element.
     * @param <T> The type of elements in the iterable.
     * @return The count of elements that satisfy the predicate.
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    /**
     * Counts the number of elements in an iterator that satisfy a specified predicate.
     * This method iterates through each element of the iterator, applying the predicate to determine
     * if the element should be counted.
     *
     * @param iterator The iterator to search through.
     * @param pred The predicate to apply to each element.
     * @param <T> The type of elements in the iterator.
     * @return The count of elements that satisfy the predicate.
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;

        while(iterator.hasNext()) {
            if (pred.predicate(iterator.next())) {
                ++count;
            }
        }

        return count;
    }

    /**
     * Finds the first occurrence of a specified value in an iterator.
     * This method iterates through each element of the iterator, comparing it with the specified value.
     * It returns the first element that matches the value, or null if no such element is found.
     *
     * @param iterator The iterator to search through.
     * @param number The value to find in the iterator.
     * @param <T> The type of elements in the iterator.
     * @return The first element that matches the specified value, or null if no match is found.
     */
    public static <T> T find(Iterator<T> iterator, T number) {
        Objects.requireNonNull(number);
        Predicate<T> pred = number::equals;
        return find(iterator, pred);
    }

    /**
     * Finds the first occurrence of a specified value in an array.
     * This method iterates through each element of the array, comparing it with the specified value.
     * It returns the first element that matches the value, or null if no such element is found.
     *
     * @param array The array to search through.
     * @param value The value to find in the array.
     * @param <T> The type of elements in the array.
     * @return The first element that matches the specified value, or null if no match is found.
     */
    public static <T> T find(T[] array, T value) {
        Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }

    /**
     * Finds the first element in an iterable that matches a given predicate.
     * 
     * @param iterable The iterable to search.
     * @param pred The predicate to evaluate.
     * @param <T> The type of elements in the iterable.
     * @return The first matching element, or null if no match is found.
     */
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    /**
     * Finds the first element in an array that matches a given predicate.
     * 
     * @param arr The array to search.
     * @param pred The predicate to evaluate.
     * @param <T> The type of elements in the array.
     * @return The first matching element, or null if no match is found.
     */
    public static <T> T find(T[] arr, Predicate<T> pred) {
        Iterator<T> it = Arrays.stream(arr).iterator();
        return find(it, pred);
    }

    /**
     * Finds the first element in an iterator that matches a given value.
     * 
     * @param iterator The iterator to search.
     * @param number The value to match.
     * @param <T> The type of elements in the iterator.
     * @return The first matching element, or null if no match is found.
     */
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while(true) {
            if (iterator.hasNext()) {
                T current = iterator.next();
                if (!pred.predicate(current)) {
                    continue;
                }

                return current;
            }

            return null;
        }
    }

    /**
     * Finds the first occurrence of a specified value in an iterable collection.
     * This method iterates through each element of the iterable, comparing it with the specified value.
     * It returns the first element that matches the value, or null if no such element is found.
     *
     * @param iterable The iterable collection to search through.
     * @param value The value to find in the iterable.
     * @param <T> The type of elements in the iterable.
     * @return The first element that matches the specified value, or null if no match is found.
     */
    public static <T> T find(Iterable<T> iterable, T value) {
        Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    /**
     * Determines if any element in an array matches a given value.
     * 
     * @param array The array to search.
     * @param value The value to match.
     * @param <T> The type of elements in the array.
     * @return True if any element matches the value, false otherwise.
     */
    public static <T> boolean exists(T[] array, T value) {
        Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    /**
     * Determines if a specific value exists in an iterable collection.
     * This method iterates through each element of the iterable, comparing it with the specified value.
     * The iteration stops as soon as a matching element is found.
     *
     * @param iterable The iterable collection to search through.
     * @param value The value to look for in the iterable.
     * @param <T> The type of elements in the iterable.
     * @return True if the value is found in the iterable, false otherwise.
     */
    public static <T> boolean exists(Iterable<T> iterable, T value) {
        Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    /**
     * Determines if any element in an iterator matches a given value.
     * 
     * @param iterator The iterator to search.
     * @param value The value to match.
     * @param <T> The type of elements in the iterator.
     * @return True if any element matches the value, false otherwise.
     */
    public static <T> boolean exists(Iterator<T> iterator, T value) {
        Objects.requireNonNull(value);
        Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    /**
     * Determines if any element in an iterable satisfies a given predicate.
     * 
     * @param iterable The iterable to search.
     * @param pred The predicate to evaluate.
     * @param <T> The type of elements in the iterable.
     * @return True if any element satisfies the predicate, false otherwise.
     */
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    /**
     * Determines if any element in an array satisfies a specified predicate.
     * This method iterates through each element of the array, testing it against the predicate.
     * The iteration stops as soon as an element that satisfies the predicate is found.
     *
     * @param array The array to search through.
     * @param pred A predicate to test each element against.
     * @param <T> The type of elements in the array.
     * @return True if at least one element in the array satisfies the predicate, false otherwise.
     */
    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    /**
     * Checks if any element in an iterator satisfies a specified predicate.
     * This method iterates through all elements, testing each one against the predicate.
     * The iteration stops as soon as an element satisfying the predicate is found.
     *
     * @param iterator The iterator to search through.
     * @param pred A predicate to test each element against.
     * @param <T> The type of elements in the iterator.
     * @return True if at least one element in the iterator satisfies the predicate, false otherwise.
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while(true) {
            if (iterator.hasNext()) {
                T current = iterator.next();
                if (!pred.predicate(current)) {
                    continue;
                }

                return true;
            }

            return false;
        }
    }

    /**
     * Paginates elements from an array based on a given page number, page size, and predicate.
     * 
     * @param arr The array to paginate.
     * @param page The page number (zero-based).
     * @param pagesize The number of elements per page.
     * @param pred The predicate to filter elements.
     * @param <T> The type of elements in the array.
     * @return A list of elements for the specified page that match the predicate.
     */
    public static <T> List<T> paginate(T[] arr, int page, int pagesize, Predicate<T> pred) {
        Iterator<T> i = Arrays.stream(arr).iterator();
        return paginate(i, page, pagesize, pred);
    }

    /**
     * Paginates elements from an iterable based on a given page number, page size, and predicate.
     * This method filters elements that match the predicate and returns a sublist representing a specific page.
     * 
     * @param iterable The iterable to paginate.
     * @param page The page number (zero-based). Specifies the page of data to return.
     * @param pagesize The number of elements per page. This determines the size of each page.
     * @param pred A predicate to apply to each element in the iterable. Only elements that satisfy the predicate will be included.
     * @param <T> The type of elements in the iterable.
     * @return A list of elements for the specified page that satisfy the predicate. If the specified page goes beyond the available elements, an empty list is returned.
     */
    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pagesize, Predicate<T> pred) {
        Iterator<T> i = iterable.iterator();
        return paginate(i, page, pagesize, pred);
    }

    /**
     * Paginates elements from an iterator based on a given page number, page size, and predicate.
     * 
     * @param iterator The iterator to paginate.
     * @param page The page number (zero-based).
     * @param pagesize The number of elements per page.
     * @param pred The predicate to filter elements.
     * @param <T> The type of elements in the iterator.
     * @return A list of elements for the specified page that match the predicate.
     */
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pagesize, Predicate<T> pred) {
        List<T> pageResult = new ArrayList<>();
        int count = 0;
        int startindex = page * pagesize;
        int endindex = startindex + pagesize;
        while(iterator.hasNext()) {
            T obj = iterator.next();
            if (pred.predicate(obj)) {
                if (count >= startindex && count < endindex) {
                    pageResult.add(obj);
                }

                ++count;
            }
        }

        return pageResult;
    }
}