package persistencia.dao.interfaz;

import dto.LocalidadDTO;

import java.util.List;

public interface LocalidadDAO {

	public boolean insert(LocalidadDTO localidad);

	public boolean delete(LocalidadDTO localidad_a_eliminar);
	
	public List<LocalidadDTO> readAll();

	public boolean update(LocalidadDTO localidad_a_editar);
}
