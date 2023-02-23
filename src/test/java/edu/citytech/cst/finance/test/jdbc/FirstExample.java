package edu.citytech.cst.finance.test.jdbc;

import java.sql.*;

public class FirstExample {

   //connect 'jdbc:derby://localhost:1527/data/realEstate2022;create=true;user=realEstate;password=pwd1234';
   static final String DB_URL = "jdbc:derby://localhost:1527/data/realEstate2022";
   static final String USER = "realEstate";
   static final String PASS = "pwd1234";
   static final String QUERY = """
                                 select id,
                                      cost,
                                      downPayment,
                                      netIncome ,
                                      profitYear
                                      from properties
                                 """;


   public static void select() {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("id: " + rs.getString("id"));
            System.out.print(", cost: " + rs.getFloat("cost"));
            System.out.print(", downPayment: " + rs.getFloat("downPayment"));
            System.out.print(", netIncome: " + rs.getFloat("netIncome"));
            System.out.println(", profitYear: " + rs.getInt("profitYear"));
         }



      } catch (SQLException e) {
         e.printStackTrace();
      }

      new java.util.Date();
      System.out.println("sarker, ayon " + new java.util.Date());
   }

   public static void update(){
      try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
          Statement stmt = conn.createStatement();
      ){
         String sql =   """
                         Update properties
                         SET profitYear = 121266
                           WHERE id in ('H001','H002')
                        """;

         System.out.println("sarker,ayon: executing update @ " + new java.util.Date());


         stmt.executeUpdate(sql);
      } catch (SQLException e){
         e.printStackTrace();
      }
   }

   public static void insert(){
      try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
          Statement stmt = conn.createStatement();
      ){
         final String sql =   """
          INSERT INTO Properties (id,   cost,   downPayment,  state,percentage,  netIncome, profitYear)
                         VALUES ('$id', $cost , $downPayment, 'NJ', $percentage, $netIncome,$profitYear)
                       """;
         int id = 2000, cost = 20_000;
         String state = "NJ";
         float[] percentage = {.04f,.05f,.06f,.07f,.08f,.09f};
         float netIncome = 50_000;

         for (int i = 0; i < 100; i++) {
           float newCost = ( 160_000 + (i*7));
           double downPayment = newCost*.25;
            String newSQL = sql.replace("$id",(id + i) + "")
                               .replace("$cost",newCost + "")
                               .replace("$downPayment", downPayment+ "")
                               .replace("$percentage", ".04")
                               .replace("$netIncome", (newCost * .25 )+ "")
                               .replace("$profitYear",(newCost * .17) + "");

            stmt.executeUpdate(newSQL);
            System.out.println(newSQL);
         }

         System.out.println("sarker,ayon: executing update @ " + new java.util.Date());



      } catch (SQLException e){
         e.printStackTrace();
      }
   }

   public static void delete(){
      try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
          Statement stmt = conn.createStatement();
      ){
         String sql =   """
                         delete from properties
                        """;

         System.out.println("sarker,ayon: executing update @ " + new java.util.Date());
         stmt.executeUpdate(sql);


      } catch (SQLException e){
         e.printStackTrace();
      }
   }

   public static void main(String[] args){

      delete();
      insert();
   }
}