package presentacion.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaConfiguracion extends JFrame
{
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField txtIP;
		private JTextField txtUser;
		private JTextField txtPass;
		private JTextField txtPort;
		private JButton btnConfirmar;
		private static VentanaConfiguracion INSTANCE;
		
		public static VentanaConfiguracion getInstance()
		{
			if(INSTANCE == null)
				return new VentanaConfiguracion();
			else
				return INSTANCE;
		}

		private VentanaConfiguracion() 
		{
			super();
			setResizable(false);
			setTitle("Configuracion de red");
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 349, 295);
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 313, 234);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblIP = new JLabel("IP:");
			lblIP.setBounds(10, 11, 72, 14);
			panel.add(lblIP);
			
			JLabel lblUser = new JLabel("Usuario:");
			lblUser.setBounds(10, 52, 72, 14);
			panel.add(lblUser);
			
			JLabel lblPass = new JLabel("Pass:");
			lblPass.setBounds(10, 93, 72, 14);
			panel.add(lblPass);
			
			JLabel lblPort = new JLabel("Port:");
			lblPort.setBounds(10, 134, 72, 14);
			panel.add(lblPort);
			
			txtIP = new JTextField();
			txtIP.setBounds(92, 8, 207, 20);
			panel.add(txtIP);
			txtIP.setColumns(10);
			
			txtUser = new JTextField();
			txtUser.setBounds(92, 49, 207, 20);
			panel.add(txtUser);
			txtUser.setColumns(10);
			
			txtPass = new JTextField();
			txtPass.setColumns(10);
			txtPass.setBounds(92, 90, 207, 20);
			panel.add(txtPass);
			
			txtPort = new JTextField();
			txtPort.setColumns(10);
			txtPort.setBounds(92, 131, 207, 20);
			panel.add(txtPort);
			
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setBounds(186, 200, 113, 23);
			panel.add(btnConfirmar);
			
			this.setVisible(false);
		}
		
		public void mostrarVentana()
		{
			this.setVisible(true);
		}
		
		public JTextField getTxtIP() 
		{
			return txtIP;
		}

		public JTextField getTxtUser() 
		{
			return txtUser;
		}
		
		public JTextField getTxtPass()
		{
			return txtPass;
		}
		
		public JTextField getTxtPort()
		{
			return txtPort;
		}
		

		public JButton getBtnConfirmar() 
		{
			return btnConfirmar;
		}

		public void cerrar()
		{
			this.txtIP.setText(null);
			this.txtUser.setText(null);
			this.txtPass.setText(null);
			this.txtPort.setText(null);
			this.dispose();
		}
		
		public boolean verificarCampo() {
			if (txtIP.getText().isEmpty() || txtUser.getText().isEmpty() || txtPort.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Los campos IP, Usuario, o Port no pueden estar vacios.");
				return false;
			}
			return true;
		}
}
