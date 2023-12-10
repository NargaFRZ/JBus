package com.FairuzMuhammadJBusRA.controller;

import com.FairuzMuhammadJBusRA.Algorithm;
import com.FairuzMuhammadJBusRA.dbjson.JsonTable;
import com.FairuzMuhammadJBusRA.dbjson.Serializable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Defines basic GET operations for a controller handling Serializable entities.
 *
 * @author Fairuz Muhammad
 * @version FINAL
 * @param <T> The type of Serializable entity this controller handles.
 */
@RestController
public interface BasicGetController<T extends Serializable> {
    /**
     * Gets the JsonTable associated with the Serializable entity.
     *
     * @return The JsonTable of the specified entity type.
     */
    public abstract JsonTable<T> getJsonTable();

    /**
     * Retrieves a paginated list of entities.
     *
     * @param page The page number to retrieve.
     * @param pageSize The number of entities per page.
     * @return A list of entities corresponding to the specified page and page size.
     */
    @GetMapping("/page")
    public default List<T> getPage(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "5") int pageSize) {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    /**
     * Retrieves a specific entity by its ID.
     *
     * @param id The ID of the entity to retrieve.
     * @return The entity with the specified ID, or null if not found.
     */
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
    }
}
