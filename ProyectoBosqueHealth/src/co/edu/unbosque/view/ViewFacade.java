package co.edu.unbosque.view;

public class ViewFacade {

	private MenuPrincipal menuPrincipal;
	private VentanaDirector ventanaDirector;
	private VentanaEspecialista ventanaEspecialista;
	private VentanaPaciente ventanaPaciente;
	private VentanaSeleccion ventanaSeleccion;
	
	public ViewFacade() {
		menuPrincipal = new MenuPrincipal();
		ventanaDirector = new VentanaDirector();
		ventanaEspecialista = new VentanaEspecialista();
		ventanaPaciente = new VentanaPaciente();
		ventanaSeleccion = new VentanaSeleccion();
	}

	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public VentanaDirector getVentanaDirector() {
		return ventanaDirector;
	}

	public void setVentanaDirector(VentanaDirector ventanaDirector) {
		this.ventanaDirector = ventanaDirector;
	}

	public VentanaEspecialista getVentanaEspecialista() {
		return ventanaEspecialista;
	}

	public void setVentanaEspecialista(VentanaEspecialista ventanaEspecialista) {
		this.ventanaEspecialista = ventanaEspecialista;
	}

	public VentanaPaciente getVentanaPaciente() {
		return ventanaPaciente;
	}

	public void setVentanaPaciente(VentanaPaciente ventanaPaciente) {
		this.ventanaPaciente = ventanaPaciente;
	}

	public VentanaSeleccion getVentanaSeleccion() {
		return ventanaSeleccion;
	}

	public void setVentanaSeleccion(VentanaSeleccion ventanaSeleccion) {
		this.ventanaSeleccion = ventanaSeleccion;
	}
	
	
}
