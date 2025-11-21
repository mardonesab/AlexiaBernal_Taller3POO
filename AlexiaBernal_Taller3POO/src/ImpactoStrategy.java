import java.util.List;

public class ImpactoStrategy implements PrioridadStrategy 
{
	
	private int valorImpacto(String c) {
        if (c.equalsIgnoreCase("Alta")) return 3;
        if (c.equalsIgnoreCase("Media")) return 2;
        return 1; 
    }
	
	@Override
	public List<Tarea> ordenar(List<Tarea> tareas) 
	{
		for (int i = 0; i < tareas.size() - 1; i++) {
            for (int j = 0; j < tareas.size() - 1 - i; j++) {

                int imp1 = valorImpacto(tareas.get(j).getComplejidad());
                int imp2 = valorImpacto(tareas.get(j + 1).getComplejidad());

                if (imp1 < imp2) {
                    Tarea aux = tareas.get(j);
                    tareas.set(j, tareas.get(j + 1));
                    tareas.set(j + 1, aux);
                }
            }
        }
		return tareas;
	}

}
