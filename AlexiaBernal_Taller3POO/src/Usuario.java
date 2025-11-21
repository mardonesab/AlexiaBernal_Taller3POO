
public abstract class Usuario 
{
	String nombre;
	String contraseña;
	String rol;
	public Usuario(String nombre, String contraseña, String rol) 
	{
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public String getRol() {
		return rol;
	}
	
	public abstract void mostrarMenu();
	
	
	
}
