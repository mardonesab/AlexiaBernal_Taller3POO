/*
 * Alexia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
 */
import java.util.ArrayList;
import java.util.List;

public class Proyecto 
{
	String id;
	String nombre;
	String responsable;
	List<Tarea> tareas;
	
	public Proyecto(String id, String nombre, String responsable) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;
		this.tareas = new ArrayList<>();
		
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getResponsable() {
		return responsable;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}
	
	public void agregarTarea(Tarea t) 
	{ 
		tareas.add(t); 
	}
    
	public void eliminarTarea(String t) 
    { 
    	tareas.remove(t); 
    }

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", responsable=" + responsable + ", tareas=" + tareas
				+ "]";
	}
	
	
	
	
}
