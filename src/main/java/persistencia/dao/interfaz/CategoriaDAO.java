package persistencia.dao.interfaz;

import dto.CategoriaDTO;

import java.util.List;

public interface CategoriaDAO {

	public boolean insert(CategoriaDTO categoria);

	public boolean delete(CategoriaDTO categoria_a_eliminar);
	
	public List<CategoriaDTO> readAll();

	public boolean update(CategoriaDTO categoria_a_editar);
}
