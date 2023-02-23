package edu.citytech.cst.finance.test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import edu.citytech.cst.finance.service.MortgageService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Date;

public class T1_Loan
{


    @ParameterizedTest
    @CsvSource({
            "300_000,30,.06 ,1799.00",
            "400_000,30,.06 ,2398.20",
            "500_000,30,.06 ,2997.75",
            "400_000,30,.07 ,2661.21",
            "400_000,30,.08 ,2935.06",
            "600_000,30,.08 ,4402.59",
            "500_000,30,.07 ,3326.51",
            "400_000,15,.07 ,3595.31",
            "500_000,20,.07 ,3876.49",
            "400_000,30,.09 ,3218.49"
    })

    void testWithCsvSource(float loanAmount, int years , float interest, float monthlyPayment) {
        double actual = MortgageService.getSchedulePayments(loanAmount, years, interest);
        float expected = monthlyPayment;
        assertThat(actual, closeTo(expected, 1f));

        System.out.println("Ayon ,Sarker" + new Date());
    }
}
