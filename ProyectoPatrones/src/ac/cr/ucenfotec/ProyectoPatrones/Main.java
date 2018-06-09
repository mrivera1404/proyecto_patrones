package ac.cr.ucenfotec.ProyectoPatrones;

import java.io.*;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static SqlDao conn = new SqlDao();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try{
			Start();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void Start() throws Exception {
		System.out.println("Bienvenido app Procesos!");
		CrearUsuario();
	}
	
	public static void CrearUsuario() throws Exception {
		System.out.println("Nuevo Usuario");
		Usuario usr= new Usuario();
		System.out.println("Ingrese el nombre del ususario:");
		String nombre = in.readLine();
		usr.setNombre(nombre);
		System.out.println("Ingrese el apellido del ususario:");
		String apellido = in.readLine();
		usr.setApellido(apellido);
		System.out.println("Ingrese el correo del ususario:");
		String correo = in.readLine();
		usr.setCorreo(correo);
		System.out.println("Ingrese el telefono del ususario:");
		String telefono = in.readLine();
		usr.setTelefono(telefono);
		conn.NewRecord(usr);	
		
		System.out.println("Siguiente?\n1.Si\n2. No");
		if(Integer.parseInt(in.readLine())==1) {
			
		}
		
	}
	
	public static void CrearTarea() throws IOException{
		System.out.println("Registrar nueva tarea");
		Tarea tarea = new Tarea();
		
		System.out.println("Ingrese el nombre de la tarea:");
		String nombre = in.readLine();
		tarea.setNombre(nombre);
		System.out.println("Ingrese la descripción de la tarea:");
		String descripcion = in.readLine();
		tarea.setDescripcion(descripcion);
		System.out.println("Ingrese el estado de la tarea: \n 1.Por hacer \n 2.En proceso \n 3.Finalizada");
		int estado = Integer.parseInt(in.readLine());
		tarea.setEstado(estado);
	}

}
