
public class Administrador extends Usuario
{

	public Administrador(String nombre, String contraseña, String rol) 
	{
		super(nombre, contraseña, "Administrador");
	}

	@Override
	public void mostrarMenu() 
	{
		 System.out.println("\n--- Menú Administrador ---");
	     System.out.println("1) Ver lista completa de proyectos y tareas");
	     System.out.println("2) Agregar proyecto");
	     System.out.println("3) Eliminar proyecto");
	     System.out.println("4) Agregar tarea a proyecto");
	     System.out.println("5) Eliminar tarea");
	     System.out.println("6) Asignar prioridades");
	     System.out.println("7) Generar reporte");
	     System.out.println("8) Salir");
	}
	
	
	
}
