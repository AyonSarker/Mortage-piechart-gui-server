package edu.citytech.cst.finance.webapi;


import edu.citytech.cst.finance.model.MortgageSummary;
import edu.citytech.cst.finance.model.Payment;
import edu.citytech.cst.finance.service.MortgageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MortgageWebAPI {

    //http://localhost:8080/mortgage?loanAmount=100000&year=30&interest=.05
    //http://localhost:8080/mortgage

    @GetMapping("/mortgage")
    public Map<String,Object> getMortgageInformation(
            @RequestParam (value="loanAmount", defaultValue = "300000") double loanAmount
            ,@RequestParam (value="year", defaultValue = "30") int year
            ,@RequestParam (value="interest", defaultValue = ".06") double interest

            ){



        Payment[] payments = MortgageService.getAllMonthlyPayments(loanAmount,year,interest);
        MortgageSummary mortgageSummary =MortgageService.getSummary(loanAmount,year,interest);


        Map<String,Object> map = new HashMap<>();
        map.put("loanAmount",loanAmount);
        map.put("year",year);
        map.put("interest",interest);
        map.put("payments",payments);
        map.put("mortgageSummary", mortgageSummary);
        map.put("developer", "Sarker,Ayon");

        return map;
    }
}
