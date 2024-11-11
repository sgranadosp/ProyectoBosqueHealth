package co.edu.unbosque.controller;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

/**
 * Clase principal de la aplicación, encargada de iniciar la interfaz gráfica de usuario
 * y gestionar el lanzamiento del controlador.
 * 
 * Esta clase utiliza {@link EventQueue} para ejecutar el hilo de la interfaz gráfica 
 * de manera segura y ejecuta el controlador {@link Controller} dentro de dicho hilo.
 */
public class AplMain {

	/**
     * Método principal que se ejecuta al iniciar la aplicación.
     * Crea e inicializa el controlador {@link Controller} dentro del hilo de la interfaz gráfica
     * para asegurar que la GUI se ejecute en el hilo adecuado.
     * 
     * En caso de que ocurra una excepción durante la creación del controlador, se muestra
     * un mensaje de error al usuario mediante un cuadro de diálogo.
     * 
     * @param args Argumentos de línea de comandos. No se utilizan en esta implementación.
     */
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
