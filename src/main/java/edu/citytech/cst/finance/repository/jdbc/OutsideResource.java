package edu.citytech.cst.finance.repository.jdbc;

public class OutsideResource implements AutoCloseable {

    public OutsideResource (){
        System.out.println("Outside resource is alive");
    }

    public void on(){
        System.out.println("Outside resource is turned on");
    }
    public void off(){
        System.out.println("Outside resource is turned off");
    }

    public void getSalaryInfo(float salary){

        System.out.println("salary" + salary);

    }

    public void getEmployeeName(String name){
        System.out.println("name " + name);
    }

    @Override
    public void close() throws Exception {
        this.off();
    }
}
