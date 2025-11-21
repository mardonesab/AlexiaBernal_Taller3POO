/*
 * Alexia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
 */
public class TareaFactory 
{
	public  Tarea crear(String idProyecto, String id, String tipo, String descripcion,
            String estado, String responsable, String complejidad, String fecha)
	{
		if (tipo == null)
		{
			tipo = "Documentación";
		}
		
		tipo = tipo.toLowerCase();
		
		if (tipo.equalsIgnoreCase("bug"))
		{
			return new Bug(idProyecto, id, tipo, descripcion, estado, responsable, complejidad, fecha);
		}
		
		if (tipo.equalsIgnoreCase("caracteristica") || tipo.startsWith("feature") )
		{
			return new Caracteristica(idProyecto, id, tipo, descripcion, estado, responsable, complejidad, fecha);
		}
		return new Documentacion(idProyecto, id, tipo, descripcion, estado, responsable, complejidad, fecha);

	}
}
