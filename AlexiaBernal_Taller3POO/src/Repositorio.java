/*
 * Alexia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repositorio 
{
	static Repositorio instancia = null;

	 private List<Usuario> usuarios = new ArrayList<>();
	 private List<Proyecto> proyectos = new ArrayList<>();
	 private List<Tarea> tareas = new ArrayList<>();

    private Repositorio() 
    {
        cargarUsuarios();
        cargarProyectos();
        cargarTareas();
    }
    
    public static Repositorio obtenerInstancia() 
    {
        if (instancia == null) instancia = new Repositorio();
        return instancia;
    }
    
    private void cargarUsuarios() 
    {
        try 
        {
            File archivo = new File("usuarios.txt");
            if (!archivo.exists()) return;

            Scanner sc = new Scanner(archivo);

            while (sc.hasNextLine()) 
            {

                String l = sc.nextLine().trim();
                if (l.isEmpty()) continue;

                String[] p = l.split("\\|");
                if (p.length < 3) continue;

                String nombre = p[0];
                String pass = p[1];
                String rol = p[2];

                Usuario u;
                if (rol.equalsIgnoreCase("Administrador"))
                    u = new Administrador(nombre, pass, "Administrador");
                else
                    u = new Colaborador(nombre, pass, "Colaborador");

                usuarios.add(u);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error al cargar usuarios.txt");
        }
    }

    private void cargarProyectos() 
    {
        try {
            File archivo = new File("proyectos.txt");
            if (!archivo.exists()) return;

            Scanner sc = new Scanner(archivo);

            while (sc.hasNextLine()) 
            {

                String l = sc.nextLine().trim();
                if (l.isEmpty()) continue;

                String[] p = l.split("\\|");
                if (p.length < 3) continue;

                Proyecto pr = new Proyecto(p[0], p[1], p[2]);
                proyectos.add(pr);
            }
            sc.close();

        } catch (Exception e) 
        {
            System.out.println("Error al cargar proyectos.txt");
        }
    }

    private void cargarTareas() 
    {
        try {
            File archivo = new File("tareas.txt");
            if (!archivo.exists()) return;

            Scanner sc = new Scanner(archivo);

            while (sc.hasNextLine()) 
            {

                String l = sc.nextLine().trim();
                if (l.isEmpty()) continue;

                String[] p = l.split("\\|");
                if (p.length < 8) continue;

                String idProyecto = p[0];
                String id = p[1];
                String tipo = p[2];
                String descripcion = p[3];
                String estado = p[4];
                String responsable = p[5];
                String complejidad = p[6];
                String fecha = p[7];

                TareaFactory f = new TareaFactory();
                Tarea t = f.crear(idProyecto, id, tipo, descripcion, estado, responsable, complejidad, fecha);

                tareas.add(t);

                Proyecto pr = buscarProyecto(idProyecto);
                if (pr != null) pr.agregarTarea(t);
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error al cargar tareas.txt");
        }
    }
    
    public Usuario buscarUsuario(String nombre) 
    {
        for (Usuario u : usuarios) 
        {
            if (u.getNombre().equalsIgnoreCase(nombre)) return u;
        }
        return null;
    }
    
    public Proyecto buscarProyecto(String id) 
    {
        for (Proyecto p : proyectos) 
        {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }
    
    public Tarea buscarTarea(String id) 
    {
        for (Tarea t : tareas) 
        {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }
    
    public List<Proyecto> obtenerProyectos() 
    { 
    	return proyectos; 
    }
    
    public List<Tarea> obtenerTareas() 
    { 
    	return tareas; 
    }
    
    public boolean usuarioAsignadoEnFecha(String usuario, String fecha) 
    {
        for (Tarea t : tareas) 
        {
            if (t.getResponsable().equalsIgnoreCase(usuario) && t.getFecha().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    
    public void agregarProyecto(Proyecto p) 
    {
        proyectos.add(p);
    }

    public void eliminarProyecto(String id) 
    {

        Proyecto eliminar = null;

        for (Proyecto p : proyectos) 
        {
            if (p.getId().equals(id)) 
            {
                eliminar = p;
                break;
            }
        }

        if (eliminar == null) return;

        proyectos.remove(eliminar);

        List<Tarea> porEliminar = new ArrayList<>();

        for (Tarea t : tareas) 
        {
            if (t.getIdProyecto().equals(id)) porEliminar.add(t);
        }

        tareas.removeAll(porEliminar);

        guardarTareasEnArchivo();
    }

    public void agregarTarea(Tarea t) 
    {
        tareas.add(t);

        Proyecto p = buscarProyecto(t.getIdProyecto());
        if (p != null) p.agregarTarea(t);

        guardarTareasEnArchivo();
    }

    public void eliminarTarea(String id) 
    {

        Tarea eliminar = null;

        for (Tarea t : tareas) 
        {
            if (t.getId().equals(id)) 
            {
                eliminar = t;
                break;
            }
        }

        if (eliminar == null) return;

        tareas.remove(eliminar);

        Proyecto p = buscarProyecto(eliminar.getIdProyecto());
        if (p != null) p.eliminarTarea(id);

        guardarTareasEnArchivo();
    }
    
    private void guardarTareasEnArchivo() 
    {
        try 
        {
            PrintWriter pw = new PrintWriter("tareas.txt");

            for (Tarea t : tareas) {
                pw.println(t.toString());
            }

            pw.close();

        } catch (Exception e) 
        {
            System.out.println("Error al guardar tareas.txt");
        }
    }
    
    public String siguienteIdTarea() 
    {
        return "T" + (tareas.size() + 1);
    }

    public String siguienteIdProyecto() 
    {
        return "PR" + (proyectos.size() + 1);
    }
    
    
    
    
    
    
    
    
}
