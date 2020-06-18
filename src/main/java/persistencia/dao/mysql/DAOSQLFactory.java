/**
 * 
 */
package persistencia.dao.mysql;

import persistencia.dao.interfaz.CategoriaDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;

public class DAOSQLFactory implements DAOAbstractFactory 
{
	/* (non-Javadoc)
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	public PersonaDAO createPersonaDAO() 
	{
		return new PersonaDAOSQL();
	}

	@Override
	public LocalidadDAO createLocalidadDAO() {
		// TODO Auto-generated method stub
		return new LocalidadDAOSQL();
	}

	@Override
	public CategoriaDAO createCategoriaDAO() {
		// TODO Auto-generated method stub
		return new CategoriaDAOSQL();
	}

}
