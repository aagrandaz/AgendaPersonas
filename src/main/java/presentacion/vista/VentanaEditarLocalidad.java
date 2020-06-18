package presentacion.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaEditarLocalidad extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLocalidad;
	private JButton btnConfirmar;
	private static VentanaEditarLocalidad INSTANCE;
	
	public static VentanaEditarLocalidad getInstance()
	{
		if(INSTANCE == null)
			return new VentanaEditarLocalidad();
		else
			return INSTANCE;
	}

	private VentanaEditarLocalidad() 
	{
		super();
		setResizable(false);
		setTitle("Editar localidad");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 397, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 381, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreLocalidad = new JLabel("Nombre de la localidad:");
		lblNombreLocalidad.setBounds(10, 14, 228, 14);
		panel.add(lblNombreLocalidad);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(10, 39, 228, 20);
		panel.add(txtLocalidad);
		txtLocalidad.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(245, 67, 126, 23);
		panel.add(btnConfirmar);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtLocalidad() 
	{
		return txtLocalidad;
	}

	public JButton getBtnConfirmar() 
	{
		return btnConfirmar;
	}

	public void cerrar()
	{
		this.txtLocalidad.setText(null);
		this.dispose();
	}
	
	public boolean verificarCampo() {
		if (txtLocalidad.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio.");
			return false;
		}
		return true;
	}
}

