package edu.elon.mvc;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorModel implements ModelInterface{

	double answer;
	private ArrayList modelObservers = new ArrayList();;
	
	public double calculate(String toCalculate){
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

	@Override
	public String getText() {
		return "" + answer;
	}

	@Override
	public void operation(String toCalculate) {
		answer = calculate(toCalculate);
		notifyObservers();
	}

	public void notifyObservers() {
		for(int i = 0; i < modelObservers.size(); i++) {
			ModelObserver observer = (ModelObserver) modelObservers.get(i);
			observer.updateScreen();
		}
	}
	public void registerObserver(ModelObserver o) {
		     modelObservers.add(o);
	}
	public void removeObserver(ModelObserver o) {
		int i = modelObservers.indexOf(o);
			if (i >= 0) {
				modelObservers.remove(i);
			}
	}
	
}
