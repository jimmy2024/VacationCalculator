package com.example.vacation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VacationRequest {
    @NotNull(message = "average salary must not be empty")
    @Positive(message = "average salary must be positive number") long averageSalary;

    @NotNull(message = "vacation must not be empty")
    @Positive(message = "vacation must be positive number") int vacationDays;

    public long getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(long averageSalary) {
        this.averageSalary = averageSalary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }
}
