package com.example.moodle.repository.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class TimetableModelKey implements Serializable {
    private Long className;
    private Long dayOfWeak;
    private Long lessonNumber;
}
