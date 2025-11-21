
public class Caracteristica extends Tarea
{

	public Caracteristica(String idProyecto, String id, String tipo, String descripcion, String estado,
			String responsable, String complejidad, String fecha) {
		super(idProyecto, id, "Caracteristica", descripcion, estado, responsable, complejidad, fecha);
	}

	@Override
	public void aceptar(TareaVisitor visitante) 
	{
		visitante.visitarCaracteristica(this);
	}
	
}
