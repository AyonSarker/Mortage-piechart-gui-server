package edu.citytech.cst.finance;


import static edu.citytech.cst.finance.model.MortgageOptions.*;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {

            if(! isValidOption(args[i])){
                System.out.println("Invalid option entered");
            }

            var mode = args[i];
            var value = "";

            if(mode.equals(I.text) ||mode.equals (INTEREST.text)){
                value  =args[++i];
                System.out.println("Interest was Detected!! value:" + value);

            }

            if(mode.equals(Y.text) ||mode.equals (YEARS.text)){
                value  =args[++i];
                System.out.println("Years was Detected!! value:" + value);

            }
            if(mode.equals(L.text) ||mode.equals (LOAN_AMOUNT.text)){
                value  =args[++i];
                System.out.println("Loan_Amount was Detected!! value:" + value);

            }
            if(mode.equals(D.text) ||mode.equals (DETAIL.text)){
                System.out.println("Detail was Detected!! value:");

            }

        }
    }
}
