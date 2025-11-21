
public class Colaborador extends Usuario
{

	public Colaborador(String nombre, String contraseña, String rol) 
	{
		super(nombre, contraseña, "Colaborador");
	}

	@Override
	public void mostarMenu() 
	{
		System.out.println("\n--- Menú Colaborador ---");
        System.out.println("1) Ver proyectos disponibles");
        System.out.println("2) Ver mis tareas");
        System.out.println("3) Actualizar estado de una tarea");
        System.out.println("4) Aplicar visitor sobre mis tareas");
        System.out.println("5) Salir");
	}
		
}
