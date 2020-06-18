package modelo;

import dto.CategoriaDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.CategoriaDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;


public class Agenda 
{
	private PersonaDAO persona;	
	private CategoriaDAO categoria;
	private LocalidadDAO localidad;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.categoria = metodo_persistencia.createCategoriaDAO();
		this.localidad = metodo_persistencia.createLocalidadDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}
	
	public void editarPersona(PersonaDTO persona_a_editar)
	{
		this.persona.update(persona_a_editar);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	
	public void agregarCategoria(CategoriaDTO nuevaCategoria)
	{
		this.categoria.insert(nuevaCategoria);
	}
	
	public void editarCategoria(CategoriaDTO categoria_a_editar)
	{
		this.categoria.update(categoria_a_editar);
	}

	public void borrarCategoria(CategoriaDTO categoria_a_eliminar) 
	{
		this.categoria.delete(categoria_a_eliminar);
	}
	
	public List<CategoriaDTO> obtenerCategorias()
	{
		return this.categoria.readAll();		
	}
	
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)
	{
		this.localidad.insert(nuevaLocalidad);
	}
	
	public void editarLocalidad(LocalidadDTO localidad_a_editar)
	{
		this.localidad.update(localidad_a_editar);
	}

	public void borrarLocalidad(LocalidadDTO localidad_a_eliminar) 
	{
		this.localidad.delete(localidad_a_eliminar);
	}
	
	public List<LocalidadDTO> obtenerLocalidades()
	{
		return this.localidad.readAll();		
	}
	
	public void guardarProperties(Properties properties) {
		String cwd = System.getProperty("user.dir");
		File file = new File(cwd + "/db.properties");
		try {

			FileOutputStream fr = new FileOutputStream(file);
			properties.store(fr, "Properties");
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
