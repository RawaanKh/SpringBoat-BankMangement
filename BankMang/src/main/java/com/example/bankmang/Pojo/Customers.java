package com.example.bankmang.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {
    private String Id;
    private int Balance;
    private String Username;
}
