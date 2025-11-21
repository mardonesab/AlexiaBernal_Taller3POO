
public abstract class Tarea 
{
	String idProyecto;
	String id;
	String tipo;
	String descripcion;
	String estado;
	String responsable;
	String complejidad;
	String fecha;
	
	public Tarea(String idProyecto, String id, String tipo, String descripcion, String estado, String responsable,
			String complejidad, String fecha) 
	{
		super();
		this.idProyecto = idProyecto;
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.responsable = responsable;
		this.complejidad = complejidad;
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public String getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getComplejidad() {
		return complejidad;
	}

	public String getFecha() {
		return fecha;
	}

	@Override
	public String toString() 
	{
		return "Tarea [idProyecto=" + idProyecto + ", id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion
				+ ", estado=" + estado + ", responsable=" + responsable + ", complejidad=" + complejidad + ", fecha="
				+ fecha + "]";
	}
	
	public abstract void aceptar(TareaVisitor visitante);
	
	
	
	
	
	
	
	
}






