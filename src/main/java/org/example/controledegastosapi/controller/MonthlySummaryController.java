package org.example.controledegastosapi.controller;

import org.example.controledegastosapi.entity.MonthlySummary;
import org.example.controledegastosapi.service.MonthlySummaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/summary")
public class MonthlySummaryController {

    private final MonthlySummaryService summaryService;

    public MonthlySummaryController(MonthlySummaryService summaryService){
        this.summaryService = summaryService;
    }

    @GetMapping()
    public ResponseEntity<MonthlySummary> calcularGastoPorMesEAno(@RequestParam int month, @RequestParam int year){
        return ResponseEntity.ok(summaryService.gastoMensal(month,year));
    }
}
