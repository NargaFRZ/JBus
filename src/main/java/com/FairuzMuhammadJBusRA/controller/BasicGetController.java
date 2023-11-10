package com.FairuzMuhammadJBusRA.controller;

import com.FairuzMuhammadJBusRA.Algorithm;
import com.FairuzMuhammadJBusRA.dbjson.JsonTable;
import com.FairuzMuhammadJBusRA.dbjson.Serializable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {
    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "5") int pageSize) {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
    }
}
