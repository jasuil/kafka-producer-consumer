package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControll {

    @Autowired
    Produce producer;

    @GetMapping (value="/producer/{id}")
    public String producer(@PathVariable String id, @Nullable String name, @Nullable String memo){
        ConsumMap map = new ConsumMap();
        map.setId(id);
        map.setName(name);
        map.setMemo(memo);

        producer.send(map);
        return map.toString();
    }
}
