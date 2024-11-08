package co.edu.unbosque.controller;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class AplMain {

	public static void main(String[] args) {
		///	
		//Controller c = new Controller();
		
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	Controller c = new Controller();
	            } catch (Exception e) {
	                JOptionPane.showMessageDialog(null, e.getMessage());
	            }
	        }
	    });
	}

}
