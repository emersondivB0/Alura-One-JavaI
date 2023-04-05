import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class Convertidor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtInserteMonto;
    
	public Convertidor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Conversor de Monedas");

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(39, 88, 165, 26);
		comboBox.addItem("Peso chileno");
		comboBox.addItem("Dólar");
		comboBox.addItem("Euro");
		comboBox.addItem("Libra esterlina");
		comboBox.addItem("Yen japonés");
		comboBox.addItem("Won surcoreano");
		contentPane.add(comboBox);

		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(252, 88, 155, 26);
		comboBox_1.addItem("Peso chileno");
		comboBox_1.addItem("Dólar");
		comboBox_1.addItem("Euro");
		comboBox_1.addItem("Libra esterlina");
		comboBox_1.addItem("Yen japonés");
		comboBox_1.addItem("Won surcoreano");
		contentPane.add(comboBox_1);

		JButton btnNewButton = new JButton("<>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tempIndex = comboBox.getSelectedIndex();
				comboBox.setSelectedIndex(comboBox_1.getSelectedIndex());
				comboBox_1.setSelectedIndex(tempIndex);
			}
		});
		btnNewButton.setBounds(199, 120, 53, 27);
		contentPane.add(btnNewButton);

		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtiene la moneda de origen seleccionada
				String origen = (String) comboBox.getSelectedItem();
				String destino = (String) comboBox_1.getSelectedItem();

				// Obtiene la cantidad que se va a convertir
				double cantidad = Double.parseDouble(txtInserteMonto.getText());

				// Realiza la conversión a Dólar y muestra el resultado
				double tasaConversionOrigenADolar = 1.0; // tasa de conversión de la moneda de origen a dólares
				double tasaConversionDolarADestino = 1.0; // tasa de conversión de dólares a la moneda de destino
				switch (origen) {
				case "Peso chileno":
					tasaConversionOrigenADolar = 0.00125;
					break;
				case "Dólar":
					tasaConversionOrigenADolar = 1.0;
					break;
				case "Euro":
					tasaConversionOrigenADolar = 1.06;
					break;
				case "Libra esterlina":
					tasaConversionOrigenADolar = 1.25;
					break;
				case "Yen japonés":
					tasaConversionOrigenADolar = 0.0073;
					break;
				case "Won surcoreano":
					tasaConversionOrigenADolar = 0.00076;
					break;
				}

				switch (destino) {
				case "Peso chileno":
					tasaConversionDolarADestino = 800;
					break;
				case "Dólar":
					tasaConversionDolarADestino = 1.0;
					break;
				case "Euro":
					tasaConversionDolarADestino = 0.9433;
					break;
				case "Libra esterlina":
					tasaConversionDolarADestino = 0.8;
					break;
				case "Yen japonés":
					tasaConversionDolarADestino = 136.98;
					break;
				case "Won surcoreano":
					tasaConversionDolarADestino = 1314.92;
					break;
				}
				double resultado = (cantidad * tasaConversionOrigenADolar) * tasaConversionDolarADestino;
				textField.setText(String.format("%.2f", resultado));
			}
		});
		btnConvertir.setBounds(39, 218, 105, 27);
		contentPane.add(btnConvertir);

		textField = new JTextField();
		textField.setBounds(216, 215, 191, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		txtInserteMonto = new JTextField();

		txtInserteMonto.setText("Inserte Monto");
		txtInserteMonto.setBounds(39, 149, 114, 34);
		contentPane.add(txtInserteMonto);
		txtInserteMonto.setColumns(10);
		// Agregar evento focusGained al JTextField
		txtInserteMonto.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtInserteMonto.setText("");

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				try {
		            // Intenta convertir el valor ingresado a un número
		            double monto = Double.parseDouble(txtInserteMonto.getText());
		            // Si se pudo convertir, actualiza el JTextField con el valor formateado
		            txtInserteMonto.setText(String.format("%.2f", monto));
		        } catch (NumberFormatException ex) {
		            // Captura la excepción si el valor ingresado no es un número válido
		            JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
		            // Puedes realizar otras acciones aquí, como borrar el valor ingresado o mostrar un mensaje de error
		        }

			}
		});

		JLabel lblConvertidorDeMonedas = DefaultComponentFactory.getInstance().createTitle("Conversor de Monedas");
		lblConvertidorDeMonedas.setBounds(141, 28, 177, 48);
		contentPane.add(lblConvertidorDeMonedas);
	}
}
