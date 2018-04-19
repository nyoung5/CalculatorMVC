package edu.elon.mvc;

public class CalculatorTestDrive {

	public static void main(String[] args) {
		CalculatorModel model = new CalculatorModel();
		CalculatorController controller = new CalculatorController(model);
	}

}
