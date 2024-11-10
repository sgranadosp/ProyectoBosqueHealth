package co.edu.unbosque.view;

/**
 * La clase ViewFacade actúa como una fachada que encapsula las diferentes vistas o ventanas de la aplicación.
 * Proporciona acceso a las instancias de las vistas de Menú Principal, Director, Especialista y Paciente.
 * 
 * La clase es responsable de inicializar las instancias de las ventanas y proporcionar métodos getter y setter
 * para cada una de ellas. 
 * 
 * @author Santiago Granados Pascagaza
 * @version 1.0
 * @since 2024-11-10
 */
public class ViewFacade {

	private MenuPrincipal menuPrincipal;
	private VentanaDirector ventanaDirector;
	private VentanaEspecialista ventanaEspecialista;
	private VentanaPaciente ventanaPaciente;
	
	/**
     * Constructor de la clase ViewFacade. Inicializa las vistas del menú principal, director, especialista y paciente.
     */
	public ViewFacade() {
		menuPrincipal = new MenuPrincipal();
		ventanaDirector = new VentanaDirector();
		ventanaEspecialista = new VentanaEspecialista();
		ventanaPaciente = new VentanaPaciente();
	}

	 /**
     * Obtiene la instancia del menú principal.
     *
     * @return la instancia del menú principal.
     */
	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	 /**
     * Establece la instancia del menú principal.
     *
     * @param menuPrincipal la instancia del menú principal a establecer.
     */
	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	/**
     * Obtiene la instancia de la ventana del director.
     *
     * @return la instancia de la ventana del director.
     */
	public VentanaDirector getVentanaDirector() {
		return ventanaDirector;
	}

	 /**
     * Establece la instancia de la ventana del director.
     *
     * @param ventanaDirector la instancia de la ventana del director a establecer.
     */
	public void setVentanaDirector(VentanaDirector ventanaDirector) {
		this.ventanaDirector = ventanaDirector;
	}

	/**
     * Obtiene la instancia de la ventana del especialista.
     *
     * @return la instancia de la ventana del especialista.
     */
	public VentanaEspecialista getVentanaEspecialista() {
		return ventanaEspecialista;
	}

	/**
     * Establece la instancia de la ventana del especialista.
     *
     * @param ventanaEspecialista la instancia de la ventana del especialista a establecer.
     */
	public void setVentanaEspecialista(VentanaEspecialista ventanaEspecialista) {
		this.ventanaEspecialista = ventanaEspecialista;
	}

	 /**
     * Obtiene la instancia de la ventana del paciente.
     *
     * @return la instancia de la ventana del paciente.
     */
	public VentanaPaciente getVentanaPaciente() {
		return ventanaPaciente;
	}

	 /**
     * Establece la instancia de la ventana del paciente.
     *
     * @param ventanaPaciente la instancia de la ventana del paciente a establecer.
     */
	public void setVentanaPaciente(VentanaPaciente ventanaPaciente) {
		this.ventanaPaciente = ventanaPaciente;
	}

}
