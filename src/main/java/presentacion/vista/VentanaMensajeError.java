package presentacion.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaMensajeError extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblError;
	private static VentanaMensajeError INSTANCE;

	public static VentanaMensajeError getInstance()
	{
		if(INSTANCE == null)
			return new VentanaMensajeError();
		else
			return INSTANCE;
	}

	private VentanaMensajeError()
	{
		super();
		setResizable(false);
		setTitle("ERROR 404");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 424, 112);
		contentPane.add(panel);
		panel.setLayout(null);

		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setHorizontalTextPosition(SwingConstants.LEADING);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblError.setBounds(10, 14, 404, 87);
		panel.add(lblError);

		this.setVisible(false);
	}

	public void mostrarVentana()
	{
		this.setVisible(true);
	}

	public JLabel getError() {
		return lblError;
	}

}