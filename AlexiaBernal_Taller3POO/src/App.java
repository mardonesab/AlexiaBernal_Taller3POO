/*
 * Alexia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
 */
import java.util.Scanner;
import java.util.List;

public class App 
{

    private static Scanner sc = new Scanner(System.in);
    private static Repositorio repo = Repositorio.obtenerInstancia();

    public static void main(String[] args) 
    {

        Usuario u = login();

        if (u == null) return;

        if (u instanceof Administrador)
            menuAdministrador((Administrador) u);
        else
            menuColaborador((Colaborador) u);
    }

    private static Usuario login() 
    {
        System.out.print("Usuario: ");
        String u = sc.nextLine();

        System.out.print("Contraseña: ");
        String p = sc.nextLine();

        Usuario user = repo.buscarUsuario(u);

        if (user != null && user.getContraseña().equals(p)) 
        {
            System.out.println("Bienvenido " + user.getNombre());
            return user;
        }

        System.out.println("Credenciales incorrectas.");
        return null;
    }


    private static void menuAdministrador(Administrador a) 
    {
        int op = -1;

        while (op != 8) 
        {
            a.mostrarMenu();
            System.out.print("Opción: ");
            op = leerEntero();

            switch (op) {
                case 1: verProyectosYTareas(); break;
                case 2: agregarProyecto(); break;
                case 3: eliminarProyecto(); break;
                case 4: agregarTarea(); break;
                case 5: eliminarTarea(); break;
                case 6: asignarPrioridad(); break;
                case 7: generarReporte(); break;
                case 8: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        }
    }


    private static void menuColaborador(Colaborador c) 
    {
        int op = -1;

        while (op != 5) 
        {
            c.mostrarMenu();
            System.out.print("Opción: ");
            op = leerEntero();

            switch (op) 
            {
                case 1: verProyectos(); break;
                case 2: verMisTareas(c); break;
                case 3: actualizarEstado(c); break;
                case 4: aplicarVisitor(c); break;
                case 5: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        }
    }


    private static void verProyectosYTareas() 
    {
        for (Proyecto p : repo.obtenerProyectos()) 
        {
            System.out.println("\nProyecto: " + p);
            List<Tarea> ts = p.getTareas();
            for (Tarea t : ts) 
            {
                System.out.println("   - " + t);
            }
        }
    }

    private static void agregarProyecto() 
    {
        System.out.print("Nombre del proyecto: ");
        String nombre = sc.nextLine();

        String id = repo.siguienteIdProyecto();

        Proyecto p = new Proyecto(id, nombre, "admin");

        repo.agregarProyecto(p);

        System.out.println("Proyecto creado con ID: " + id);
    }

    private static void eliminarProyecto() 
    {
        System.out.print("ID del proyecto: ");
        String id = sc.nextLine();

        repo.eliminarProyecto(id);

        System.out.println("Proyecto eliminado.");
    }

    private static void agregarTarea() 
    {

        System.out.print("ID del proyecto: ");
        String pid = sc.nextLine();

        Proyecto p = repo.buscarProyecto(pid);
        if (p == null) {
            System.out.println("Proyecto no encontrado.");
            return;
        }

        System.out.print("Tipo (bug / caracteristica / documentacion): ");
        String tipo = sc.nextLine();

        System.out.print("Descripción: ");
        String desc = sc.nextLine();

        System.out.print("Estado inicial (Pendiente): ");
        String estado = sc.nextLine();
        if (estado.isEmpty()) estado = "Pendiente";

        System.out.print("Responsable: ");
        String resp = sc.nextLine();

        System.out.print("Complejidad (Alta / Media / Baja): ");
        String comp = sc.nextLine();

        System.out.print("Fecha (yyyy-MM-dd): ");
        String fecha = sc.nextLine();

        if (repo.usuarioAsignadoEnFecha(resp, fecha)) 
        {
            System.out.println("Error: el usuario ya tiene una tarea asignada en esa fecha.");
            return;
        }

        String tid = repo.siguienteIdTarea();

        TareaFactory f = new TareaFactory();
        Tarea t = f.crear(pid, tid, tipo, desc, estado, resp, comp, fecha);

        repo.agregarTarea(t);

        System.out.println("Tarea creada con ID: " + tid);
    }

    private static void eliminarTarea() 
    {
        System.out.print("ID de la tarea: ");
        String id = sc.nextLine();

        repo.eliminarTarea(id);

        System.out.println("Tarea eliminada.");
    }

    private static void asignarPrioridad() 
    {
        System.out.println("Aquí se ejecuta el patrón Strategy para asignar prioridad.");
    }

    private static void generarReporte() 
    {
        System.out.println("Aquí se ejecuta el patrón Visitor para generar reporte.");
    }


    private static void verProyectos() 
    {
        for (Proyecto p : repo.obtenerProyectos()) 
        {
            System.out.println(p);
        }
    }

    private static void verMisTareas(Colaborador c) 
    {
        for (Tarea t : repo.obtenerTareas()) 
        {
            if (t.getResponsable().equalsIgnoreCase(c.getNombre())) 
            {
                System.out.println(t);
            }
        }
    }

    private static void actualizarEstado(Colaborador c) 
    {
        System.out.print("ID de la tarea: ");
        String id = sc.nextLine();

        Tarea t = repo.buscarTarea(id);

        if (t == null) 
        {
            System.out.println("Tarea no encontrada.");
            return;
        }

        if (!t.getResponsable().equalsIgnoreCase(c.getNombre())) 
        {
            System.out.println("No puedes modificar una tarea que no es tuya.");
            return;
        }

        System.out.print("Nuevo estado: ");
        String e = sc.nextLine();

        t.setEstado(e);

        System.out.println("Estado actualizado.");
    }

    private static void aplicarVisitor(Colaborador c) 
    {
        System.out.println("Aplicando Visitor (implementación pendiente).");
    }

    private static int leerEntero() 
    {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}
