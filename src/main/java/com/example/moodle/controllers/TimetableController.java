package com.example.moodle.controllers;

import com.example.moodle.models.TimetableModel;
import com.example.moodle.services.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/timetable")
public class TimetableController {
    private final TimetableService timetableService;

    @Autowired
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody TimetableModel timetableModel, @RequestParam String from){

        System.out.println(from + " " + timetableModel);
        timetableService.add(timetableModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<Map<Long, List<TimetableModel>>> get(@RequestParam String className){

        return ResponseEntity.ok(timetableService.get(className).stream().collect(Collectors.groupingBy(TimetableModel::getDayOfWeak)));
    }
}
