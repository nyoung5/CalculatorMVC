package edu.elon.calculator;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
* This server program instantiates two remote objects, registers them
* with the naming service, and waits for clients to invoke methods on
* the remote objects.
*/
public class CalculatorServer {
 public static void main(String args[]) {
   try {
     System.out.println("Constructing server implementations...");

     Calculator c1 = new CalculatorImpl();
//     Calculator p2 = new ProductImpl("ZapXpress Microwave Oven");

     System.out.println("Binding server implementations to registry...");
     Context namingContext = new InitialContext();
     namingContext.rebind("rmi:calculator", c1);
     //bind other if needed
     System.out.println("Waiting for invocations from clients...");
   } catch (Exception e) {
     e.printStackTrace();
   }
 }
}
