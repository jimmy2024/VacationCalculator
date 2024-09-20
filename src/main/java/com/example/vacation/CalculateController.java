package com.example.vacation;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class CalculateController {
    @GetMapping(value = "/calculate")
    @ResponseBody
    public ResponseEntity<Utils.Response> calculate(@Valid VacationRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            var validationErrors = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return Utils.errorResponse(validationErrors);
        }
        var paySum = (long) (request.averageSalary / 29.3 * request.vacationDays);
        return Utils.okResponse(new VacationResponse(paySum));
    }
}
