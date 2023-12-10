package com.FairuzMuhammadJBusRA.controller;

/**
 * Represents a generic base response structure for API responses.
 * This class is designed to standardize the response format across different API endpoints.
 *
 * @param <T> The type of the payload object that this response contains.
 * @author Fairuz Muhammad
 * @version FINAL
 */
public class BaseResponse<T> {
    /**
     * Indicates whether the request was processed successfully or not.
     */
    public boolean success;
    
    /**
     * A message describing the result of the request. 
     * This could be an error message or a success confirmation, based on the value of {@link #success}.
     */
    public String message;

    /**
     * The payload of the response, containing the data requested or relevant to the request.
     * The type of this payload is generic and can vary based on the context of the API endpoint.
     */
    public T payload;

    /**
     * Constructs a new BaseResponse object with the specified success status, message, and payload.
     *
     * @param success A boolean indicating the success status of the API request.
     * @param message A string providing additional information about the response, such as an error message or a success note.
     * @param payload The data associated with the response, can be any type as specified by the generic type parameter T.
     */
    public BaseResponse(boolean success, String message, T payload) {
        this.success = success;
        this.message = message;
        this.payload = payload;
    }
}
