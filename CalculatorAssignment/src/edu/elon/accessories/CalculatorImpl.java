package edu.elon.accessories;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

//TODO Need to copy over the methods I want to use into this 
public class CalculatorImpl extends UnicastRemoteObject implements Calculator{

	//TODO maybe need to make public or change super() to nothing
	protected CalculatorImpl() throws RemoteException {
		super();
	}

	public double calculate(String toCalculate) throws RemoteException{
		Scanner scanner = new Scanner(toCalculate);
		scanner.useDelimiter("\\*|/|-|\\+");
		double firstNum = scanner.nextDouble();
		System.out.println(firstNum);
		
		scanner.useDelimiter("");
		String operation = scanner.next();
		scanner.useDelimiter("\n");

		System.out.println(operation);

		double secondNum = scanner.nextDouble();

		System.out.println();

		if(operation.equals("-")) {

			return firstNum - secondNum;

		}else if(operation.equals("+")) {

			return firstNum + secondNum;


		}else if(operation.equals("/")) {

			return firstNum / secondNum;


		}else if(operation.equals("*")) {

			return firstNum * secondNum;
			//screen.setText("" + (firstNum * secondNum));

		}
		return 0; //case where was not parsed correctly
	}
	
	
}
