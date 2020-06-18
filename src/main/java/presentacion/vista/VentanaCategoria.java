package presentacion.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class VentanaCategoria extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaCategoria;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	private DefaultTableModel modelCategoria;
	private String[] nombreColumnas = {"Categoria"};
	private static VentanaCategoria INSTANCE;
	
	public static VentanaCategoria getInstance()
	{
		if(INSTANCE == null)
			return new VentanaCategoria();
		else
			return INSTANCE;
	}

	private VentanaCategoria() 
	{
		super();
		setResizable(false);
		setTitle("ABM Categoria");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 442, 308);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane spCategoria = new JScrollPane();
		spCategoria.setBounds(0, 0, 323, 297);
		panel.add(spCategoria);
		
		modelCategoria = new DefaultTableModel(null,nombreColumnas);
		tablaCategoria = new JTable(modelCategoria);
		
		spCategoria.setViewportView(tablaCategoria);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(333, 11, 99, 23);
		panel.add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(333, 41, 99, 23);
		panel.add(btnBorrar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(333, 71, 99, 23);
		panel.add(btnEditar);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
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

	public DefaultTableModel getModelCategoria() 
	{
		return modelCategoria;
	}
	
	public JTable getTablaCategoria()
	{
		return tablaCategoria;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}

}

