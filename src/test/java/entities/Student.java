package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Integer order;
    private Integer priority;
    private Double mark;
    private String name;
}
