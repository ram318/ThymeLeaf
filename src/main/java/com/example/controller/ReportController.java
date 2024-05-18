package com.example.controller;

import com.example.model.Report;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class ReportController {

    @GetMapping("/report")
    public String getReport(Model model) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getResourceAsStream("/report.json")) {
            Report report = mapper.readValue(is, Report.class);
            model.addAttribute("report", report);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "report";
    }
}
