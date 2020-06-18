package persistencia.dao.mysql;

import dto.LocalidadDTO;
import excepciones.InvalidPropertiesException;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;
import presentacion.vista.VentanaMensajeError;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalidadDAOSQL implements LocalidadDAO{
	
	private VentanaMensajeError VME = VentanaMensajeError.getInstance();

	private static final String insert = "INSERT INTO localidad(idLocalidad, nombre) VALUES(?, ?)";
	private static final String delete = "DELETE FROM localidad WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM localidad";
	
	private static final String update = "UPDATE localidad SET nombre = ? WHERE idLocalidad = ?";
	
	public boolean insert(LocalidadDTO localidad) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, localidad.getIdLocalidad());
			statement.setString(2, localidad.getNombre());
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException | ClassNotFoundException | IOException | InvalidPropertiesException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(LocalidadDTO localidad_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(localidad_a_eliminar.getIdLocalidad()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException | ClassNotFoundException | IOException | InvalidPropertiesException e) 
		{
			VME.getError().setText("No puede borrar una localidad en uso.");
			VME.mostrarVentana();
		}
		return false;
	}

	@Override
	public List<LocalidadDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				localidades.add(new LocalidadDTO(resultSet.getInt("idLocalidad"),
						resultSet.getString("Nombre")
						));
			}
		} 
		catch (SQLException | ClassNotFoundException | IOException | InvalidPropertiesException e) 
		{
			e.printStackTrace();
		}
		return localidades;
	}

	public boolean update(LocalidadDTO localidad)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, localidad.getNombre());
			statement.setInt(2, localidad.getIdLocalidad());
			
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
