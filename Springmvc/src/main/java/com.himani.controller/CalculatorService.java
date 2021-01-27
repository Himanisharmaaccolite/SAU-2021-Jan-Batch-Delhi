package com.himani.controller;
import org.springframework.stereotype.Service;
@Service
public class CalculatorService {

    public int calculate(String num1, String num2, String operator) {

            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            switch (operator) {
                case "ADD":
                    return a+b;
                case "SUBSTRACT":
                    return a-b;
                case "MULTIPLY":
                    return a*b;
                case "DIVIDE":
                    return a/b;
                default:
                    return -1;
            }
        }
    }

