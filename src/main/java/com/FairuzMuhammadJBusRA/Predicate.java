package com.FairuzMuhammadJBusRA;

/**
 * Represents a predicate (boolean-valued function) of one argument.
 * This functional interface defines a method for evaluating a condition or property on an object of type T.
 *
 * @param <T> the type of the input to the predicate
 */
public interface Predicate<T>{
    /**
     * Evaluates this predicate on the given argument.
     * 
     * @param t the input argument
     * @return true if the input argument matches the predicate, otherwise false
     */
    boolean predicate(T t);
}