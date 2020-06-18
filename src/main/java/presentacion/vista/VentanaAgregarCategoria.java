package presentacion.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaAgregarCategoria extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCategoria;
	private JButton btnConfirmar;
	private static VentanaAgregarCategoria INSTANCE;
	
	public static VentanaAgregarCategoria getInstance()
	{
		if(INSTANCE == null)
			return new VentanaAgregarCategoria();
		else
			return INSTANCE;
	}

	private VentanaAgregarCategoria() 
	{
		super();
		setResizable(false);
		setTitle("Agregar categoria");
		
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
		
		JLabel lblCategoriaContacto = new JLabel("Categoria de contacto");
		lblCategoriaContacto.setBounds(10, 14, 228, 14);
		panel.add(lblCategoriaContacto);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(10, 39, 228, 20);
		panel.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(250, 67, 121, 23);
		panel.add(btnConfirmar);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtCategoria() 
	{
		return txtCategoria;
	}

	public JButton getBtnConfirmar() 
	{
		return btnConfirmar;
	}

	public void cerrar()
	{
		this.txtCategoria.setText(null);
		this.dispose();
	}
	
	public boolean verificarCampo() {
		if (txtCategoria.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio.");
			return false;
		}
		return true;
	}
	
}

