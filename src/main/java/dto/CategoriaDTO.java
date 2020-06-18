package dto;

public class CategoriaDTO
{
	private int idCategoria;
	private String nombre;
	
	public CategoriaDTO(int idCategoria, String nombre)
	{
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
