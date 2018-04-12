package edu.elon.accessories;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* This program demonstrates how to call a remote method on two objects that are located through the
* naming service.
*/

public class CalculatorClient {
	
	/**
	* Driver program to find remove product server and connect to it
	* 
	* @param args String array not used but should be used to pass rmiregistry server location
	*/
	public static void main(String[] args) {
	
	 String url = "rmi://localhost/";
	 if (args.length == 1) {
	   url = "rmi://" + args[0] + "/";
	 }
	 // change to "rmi://yourserver.com/"
	 // when server runs on remote machine yourserver.com
	 //
	 
	 
	
	 
	 //
	 try {
	   Context namingContext = new InitialContext();
	   Calculator c1 = (Calculator) namingContext.lookup(url + "calculator");
	   
	   JFrame jframe = new JFrame();

		jframe.setBackground(Color.WHITE);

		jframe.setLayout(new BorderLayout());

		ArrayList<JButton> jButtons = new ArrayList();



		JTextField screen = new JTextField();

		jframe.add(screen, BorderLayout.PAGE_START);



		//Create Buttons and add to arraylist

		JPanel gridPanel = new JPanel();

		gridPanel.setLayout(new GridLayout(4,4));

		jframe.add(gridPanel,BorderLayout.CENTER);



		String buttonText = "789/456*123-0.=+";

		for (char c : buttonText.toCharArray()) {

			System.out.println(c);

			JButton jButton = new JButton(""+c);

			jButtons.add(jButton);

			gridPanel.add(jButton);

			jButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {

					if(!jButton.getText().equals("=")) {

						screen.setText(screen.getText() + jButton.getText());

					}else {

						String toCalculate = screen.getText();
						
						
						//in try catch because in loop
						double answer =0;
						try {
							answer = c1.calculate(toCalculate);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						screen.setText(""+answer);
						
						}

			  }

		});

		}
		jframe.setSize(400, 500);
		jframe.show();
	 }
	    catch (Exception e) {
	   e.printStackTrace();
	 }
	}
}
	
	


