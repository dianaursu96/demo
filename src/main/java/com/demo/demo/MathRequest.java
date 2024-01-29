package com.demo.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MathRequest {
    private int firstNumber;
    private int secondNumber;
    private String operation;
}
