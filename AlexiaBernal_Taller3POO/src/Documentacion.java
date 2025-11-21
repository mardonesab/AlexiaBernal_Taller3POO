
public class Documentacion extends Tarea 
{

	public Documentacion(String idProyecto, String id, String tipo, String descripcion, String estado,
			String responsable, String complejidad, String fecha) 
	{
		super(idProyecto, id, "Documentacion", descripcion, estado, responsable, complejidad, fecha);
	}

	@Override
	public void aceptar(TareaVisitor visitante) 
	{
		visitante.visitarDocumentacion(this);
	}
	
}
