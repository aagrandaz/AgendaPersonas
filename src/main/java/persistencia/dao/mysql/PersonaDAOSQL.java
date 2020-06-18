package persistencia.dao.mysql;

import dto.PersonaDTO;
import excepciones.InvalidPropertiesException;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, email, cumpleaños, calle, altura, piso, dpto, localidad, categoria) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
		
	private static final String update = "UPDATE personas SET nombre = ?, telefono = ?, email = ?, cumpleaños = ?, calle = ?, altura = ?, piso = ?, dpto = ?, localidad = ?, categoria = ? WHERE idPersona = ?";
	
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getEmail());
			statement.setDate(5, persona.getCumpleaños());
			statement.setString(6, persona.getCalle());
			statement.setString(7, persona.getAltura());
			statement.setString(8, persona.getPiso());
			statement.setString(9, persona.getDpto());
			statement.setString(10, persona.getLocalidad());
			statement.setString(11, persona.getCategoria());
			
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException | ClassNotFoundException | IOException | InvalidPropertiesException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecutó devuelvo true
				return true;
			} 
			catch (SQLException | ClassNotFoundException | IOException | InvalidPropertiesException e) 
			{
				e.printStackTrace();
			}
		return false;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"),
						resultSet.getString("Nombre"),
						resultSet.getString("Telefono"),
						resultSet.getString("Email"),
						resultSet.getDate("Cumpleaños"),
						resultSet.getString("Calle"),
						resultSet.getString("Altura"),
						resultSet.getString("Piso"),
						resultSet.getString("Dpto"),
						resultSet.getString("Localidad"),
						resultSet.getString("Categoria")
						
						));
			}
		} 
		catch (SQLException | ClassNotFoundException | IOException | InvalidPropertiesException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}

	public boolean update(PersonaDTO persona)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getTelefono());
			statement.setString(3, persona.getEmail());
			statement.setDate(4, persona.getCumpleaños());
			statement.setString(5, persona.getCalle());
			statement.setString(6, persona.getAltura());
			statement.setString(7, persona.getPiso());
			statement.setString(8, persona.getDpto());
			statement.setString(9, persona.getLocalidad());
			statement.setString(10, persona.getCategoria());
			statement.setInt(11, persona.getIdPersona());
			
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
			} 
		catch (SQLException | ClassNotFoundException | IOException | InvalidPropertiesException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
}
