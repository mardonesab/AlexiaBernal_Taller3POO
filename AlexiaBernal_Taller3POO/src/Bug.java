/*
 * Alexia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
 */
public class Bug extends Tarea
{

	public Bug(String idProyecto, String id, String tipo, String descripcion, String estado, String responsable,
			String complejidad, String fecha) 
	{
		super(idProyecto, id, "Bug", descripcion, estado, responsable, complejidad, fecha);
	}

	@Override
	public void aceptar(TareaVisitor visitante) 
	{
		visitante.visitarBug(this);
	}
	
}
