package ac.cr.ucenfotec.ProyectoPatrones;

public class Tarea {
	public int id;
	public String nombre;
	public String descripcion;
	public int estado;
	public int id_usuario;
	
	public Tarea() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String toString() {
		return "Nombre de la tarea: " + this.getNombre()+
				"\nDescripción: "+ this.getDescripcion();
		
	} 
}
