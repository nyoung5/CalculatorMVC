package edu.elon.mvc;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorModel implements ModelInterface{
	double answer;
	private ArrayList<ModelObserver> modelObservers = new ArrayList<>();;
	
	public double calculate(String toCalculate){
		Scanner scanner = new Scanner(toCalculate);
		String operation;
		double firstNum;
		double secondNum;
		try {
			scanner.useDelimiter("\\*|/|-|\\+");
			firstNum = scanner.nextDouble();
			scanner.useDelimiter("");
			operation = scanner.next();
			scanner.useDelimiter("\n");
			secondNum = scanner.nextDouble();
	
			System.out.println();
		}catch(Exception e){
			return 0; //case where was not parsed correctly
		}
		if(operation.equals("-")) {
			return firstNum - secondNum;

		}else if(operation.equals("+")) {
			return firstNum + secondNum;

		}else if(operation.equals("/")) {
			return firstNum / secondNum;

		}else if(operation.equals("*")) {
			return firstNum * secondNum;
		}
		return 0; //case where was not parsed correctly
	}

	public String getText() {
		return "" + answer;
	}

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
