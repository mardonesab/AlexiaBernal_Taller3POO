/*
 * Alexia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
 */
import java.util.List;

public class FechaStrategy implements PrioridadStrategy 
{

	@Override
	public List<Tarea> ordenar(List<Tarea> tareas) 
	{
		for (int i = 0; i < tareas.size() - 1; i++) {
            for (int j = 0; j < tareas.size() - 1 - i; j++) {

                String f1 = tareas.get(j).getFecha();
                String f2 = tareas.get(j + 1).getFecha();

                if (f1.compareTo(f2) > 0) {
                    Tarea aux = tareas.get(j);
                    tareas.set(j, tareas.get(j + 1));
                    tareas.set(j + 1, aux);
                }
            }
        }
		return tareas;
	}

}
