package edu.elon.mvc;

public class CalculatorController implements ControllerInterface{
	private ModelInterface model;
	private CalculatorView view;
	
	public CalculatorController(ModelInterface model){
		this.model = model;
		view = new CalculatorView(this, model);
		view.createView();
	}

	public void calculate(ModelInterface model, String toCalculate) {
		model.operation(toCalculate);
		
	}

}
