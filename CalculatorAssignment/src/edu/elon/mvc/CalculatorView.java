package edu.elon.mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalculatorView implements ModelObserver{
	private ControllerInterface controller;
	private ModelInterface model;
	JTextField screen;

	public CalculatorView(ControllerInterface controller, ModelInterface model) {
		this.controller = controller;
		this.model = model;
		model.registerObserver((ModelObserver)this);
	}
	
	public void createView() {
		JFrame jframe = new JFrame();
		jframe.setBackground(Color.WHITE);
		jframe.setLayout(new BorderLayout());
		ArrayList<JButton> jButtons = new ArrayList();
		screen = new JTextField();
		jframe.add(screen, BorderLayout.PAGE_START);

		//Create Buttons and add to arraylist
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(4,4));
		jframe.add(gridPanel,BorderLayout.CENTER);
		String buttonText = "789/456*123-0.=+";

		for (char c : buttonText.toCharArray()) {
			JButton jButton = new JButton(""+c);
			jButtons.add(jButton);
			gridPanel.add(jButton);
			jButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!jButton.getText().equals("=")) {
						screen.setText(screen.getText() + jButton.getText());
					}else {
						String toCalculate = screen.getText(); 
						controller.calculate(model,toCalculate); //Controller
						}
			  }
		});

		}
		jframe.setSize(400, 500);
		jframe.show();
	}

	public void updateScreen() {
		String text = model.getText();
		screen.setText(text);
	}
}
