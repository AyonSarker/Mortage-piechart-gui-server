package edu.citytech.cst.finance.test;

import edu.citytech.cst.finance.model.MortgageOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Enumerator Test for Mortgage Options")
public class T2_MortgageOptions {

    @DisplayName("Valid Options")
    @ParameterizedTest
    @CsvSource({
            "-detail,true",
            "-d,true",
            "-i, true",
            "-interest, true",
            "-y, true",
            "-years, true",
            "-nono, false",
    })

    void testWithCsvSource(String option, boolean isValid) {
        boolean actual = MortgageOptions.isValidOption(option);
        boolean expected = isValid;
        assertEquals(expected, actual, option);

        System.out.println("sarker,ayon " + new Date());
    }
}
