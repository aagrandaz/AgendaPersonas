package presentacion.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Vista
{
	private JFrame frmAgenda;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre", "Telefono", "Email", "Cumpleaños", "Localidad", "Calle", "Altura", "Piso", "Dpto", "Categoria"};
	private JButton btnLocalidad;
	private JButton btnCategoria;
	private JButton btnEditar;
	private JButton btnConfig;

	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		
		frmAgenda = new JFrame();
		frmAgenda.setTitle("Agenda");
		frmAgenda.setBounds(100, 100, 870, 358);
		frmAgenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgenda.getContentPane().setLayout(null);
		frmAgenda.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 854, 319);
		frmAgenda.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 834, 263);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		spPersonas.setViewportView(tablaPersonas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 285, 89, 23);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 285, 89, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(208, 285, 89, 23);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(307, 285, 89, 23);
		panel.add(btnReporte);
		
		btnLocalidad = new JButton("Localidad");
		btnLocalidad.setBounds(616, 285, 109, 23);
		panel.add(btnLocalidad);
		
		btnCategoria = new JButton("Categoria");
		btnCategoria.setBounds(735, 285, 109, 23);
		panel.add(btnCategoria);
		
		btnConfig = new JButton("Configuracion");
		btnConfig.setBounds(406, 285, 137, 23);
		panel.add(btnConfig);
	}
	
	public void show()
	{
		this.frmAgenda.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frmAgenda.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "¿¡Estas seguro que quieres salir de la Agenda!?", 
		             "Confirmacion", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	//Conexion.getConexion().cerrarConexion();
		           System.exit(0);
		        }
		    }
		});
		this.frmAgenda.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnEditar() 
	{
		return btnEditar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	
	public JButton getBtnLocalidad()
	{
		return btnLocalidad;
	}
	
	public JButton getBtnCategoria()
	{
		return btnCategoria;
	}
	
	public JButton getBtnConfig()
	{
		return btnConfig;
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
}
