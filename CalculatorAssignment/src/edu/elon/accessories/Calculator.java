package edu.elon.accessories;

import java.rmi.Remote;
import java.rmi.RemoteException;

//TODO change calculate to methods we need
public interface Calculator extends Remote{

	double calculate(String toCalculate) throws RemoteException;

}
