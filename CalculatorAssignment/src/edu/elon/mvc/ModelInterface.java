package edu.elon.mvc;

public interface ModelInterface {

	void registerObserver(ModelObserver modelObserver);
	void removeObserver(ModelObserver o);
	void notifyObservers();
	
	String getText();
	void operation(String toCalculate);
}
