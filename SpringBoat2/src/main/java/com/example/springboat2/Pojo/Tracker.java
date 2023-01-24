package com.example.springboat2.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracker {
    private String ID;
    private String title;
    private String description;
    private boolean status;

}
