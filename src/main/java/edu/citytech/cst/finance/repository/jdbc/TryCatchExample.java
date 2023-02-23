package edu.citytech.cst.finance.repository.jdbc;

import java.util.function.Consumer;

public class TryCatchExample {

    public static void main(String[] args) {


        try(OutsideResource o = new OutsideResource();){
            o.on();
            Consumer<Float> consumer = o::getSalaryInfo;
            Consumer<String> c2 = o::getEmployeeName;
            consumer.accept(400f);
            c2.accept("Peter Parker");

            int x = 3/0;

        }
        catch (Exception e){
            System.out.println(e);

        }
    }
}
