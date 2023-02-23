package edu.citytech.cst.finance.test;

import edu.citytech.cst.finance.model.Payment;
import edu.citytech.cst.finance.service.MortgageService;
import static edu.citytech.cst.finance.service.MortgageService.*;

import java.util.Date;

public class T3_Main {

    public static void main(String[] args) {

       Payment[] payments= getAllMonthlyPayments( 300_000,30,0.06 );

        for (Payment cp:payments) {

            System.out.println(cp);

        }
    }
}
