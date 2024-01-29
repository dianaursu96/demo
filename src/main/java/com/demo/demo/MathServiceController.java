package com.demo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathServiceController {

    @PostMapping("/math-service")
    public MathResult performMathOperation(@RequestBody MathRequest request) {
        int firstNumber = request.getFirstNumber();
        int secondNumber = request.getSecondNumber();
        String operation = request.getOperation();

        int result = 0;
        switch (operation) {
            case "sum":
                result = firstNumber + secondNumber;
                break;
            case "difference":
                result = firstNumber - secondNumber;
                break;
            case "multiply":
                result = firstNumber * secondNumber;
                break;
            case "divide":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                break;
            case "power":
                result = (int) Math.pow(firstNumber, secondNumber);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
        return new MathResult(result);

    }
}
