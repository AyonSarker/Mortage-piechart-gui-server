package edu.citytech.cst.finance.model;

public enum MortgageOptions {


    I("-i"), INTEREST("-interest"),
    Y("-y"),YEARS("-years"),
    L("-l"),LOAN_AMOUNT("-loanAmount"),
    D("-d"),DETAIL("-detail")
    ;


    public  final String text;

    MortgageOptions(String text) {
        this.text=text;
    }

    public static boolean isValidOption(String options){

        MortgageOptions[] mo= MortgageOptions.values();

        for (var co : mo){
            if(co.text.equals(options)){
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "MortgageOptions{" +
                "text='" + text + '\'' +
                '}';
    }
}
