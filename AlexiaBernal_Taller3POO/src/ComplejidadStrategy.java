import java.util.List;

public class ComplejidadStrategy implements PrioridadStrategy 
{
	private int valorComplejidad(String descripcion) {
        return descripcion.length();
    }

	@Override
	public List<Tarea> ordenar(List<Tarea> tareas) 
	{
		for (int i = 0; i < tareas.size() - 1; i++) {
            for (int j = 0; j < tareas.size() - 1 - i; j++) {

                int c1 = valorComplejidad(tareas.get(j).getDescripcion());
                int c2 = valorComplejidad(tareas.get(j + 1).getDescripcion());

                if (c1 < c2) {
                    Tarea aux = tareas.get(j);
                    tareas.set(j, tareas.get(j + 1));
                    tareas.set(j + 1, aux);
                }
            }
        }
		
		
		return tareas;
	}
	
}
