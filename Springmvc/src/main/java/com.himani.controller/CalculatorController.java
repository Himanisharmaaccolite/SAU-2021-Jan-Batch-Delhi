package com.himani.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import org.json.JSONObject;

@Controller
public class CalculatorController {

    private CalculatorService calculatorService = new CalculatorService();

    @RequestMapping(value = "/login", method = RequestMethod.GET)

    public String showLoginPage() {
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleUserLogin(ModelMap model, @RequestParam String firstNum,
        @RequestParam String secondNum, @RequestParam String operator)
    throws Exception {


        if (firstNum.isEmpty() || secondNum.isEmpty()) {
            throw new NumberFormatException("Input is wrong");
        }

        if (operator.equals("DIVIDE") && secondNum.equals("0")) {
            JSONObject obj = new JSONObject();
            obj.put("operation", "/");
            obj.put("message", "Divide By Zero");
            model.put("msg", obj);
            System.out.println(obj);
            return "NullPointerException";
        }
        int result = calculatorService.calculate(firstNum, secondNum, operator);

        if (result > 1000) {
            throw new IOException("Large Output");
        }
        else {
            model.put("result", result);
            return "result";
        }
    }


    @ExceptionHandler(value = IOException.class)
    public String handleNullPointException(Exception e) {
        return "LargeNumber";
    }

    //	Generic Exception

    @ExceptionHandler(value = Exception.class)
    public String handleGenericException(Exception e) {
        return "GenericError";
    }
}