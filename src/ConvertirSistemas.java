import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class ConvertirSistemas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtInserteMonto;

	public ConvertirSistemas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Conversor de Unidades");
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(39, 88, 165, 26);
		comboBox.addItem("Pulgada (in)");
		comboBox.addItem("Pie (ft)");
		comboBox.addItem("Yarda (yd)");
		comboBox.addItem("Milla (mile)");
		comboBox.addItem("Milímetro (mm)");
		comboBox.addItem("Centímetro (cm)");
		comboBox.addItem("Metro (m)");
		comboBox.addItem("Kilómetro (km)");
		contentPane.add(comboBox);

		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(252, 88, 155, 26);
		comboBox_1.addItem("Pulgada (in)");
		comboBox_1.addItem("Pie (ft)");
		comboBox_1.addItem("Yarda (yd)");
		comboBox_1.addItem("Milla (mile)");
		comboBox_1.addItem("Milímetro (mm)");
		comboBox_1.addItem("Centímetro (cm)");
		comboBox_1.addItem("Metro (m)");
		comboBox_1.addItem("Kilómetro (km)");
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
				double resultado = 0.0;

				// Realiza la conversión de pulgada (in) a...
				if (origen.equals("Pulgada (in)")) {
				    switch (destino) {
				        case "Pulgada (in)":
				            resultado = cantidad;
				            break;
				        case "Pie (ft)":
				            resultado = cantidad / 12.0;
				            break;
				        case "Yarda (yd)":
				            resultado = cantidad / 36.0;
				            break;
				        case "Milla (mile)":
				            resultado = cantidad / 63360.0;
				            break;
				        case "Milímetro (mm)":
				            resultado = cantidad * 25.4;
				            break;
				        case "Centímetro (cm)":
				            resultado = cantidad * 2.54;
				            break;
				        case "Metro (m)":
				            resultado = cantidad * 0.0254;
				            break;
				        case "Kilómetro (km)":
				            resultado = cantidad * 2.54e-5;
				            break;
				    }
				}

				// Realiza la conversión de pie (ft) a...
				if (origen.equals("Pie (ft)")) {
				    switch (destino) {
				        case "Pulgada (in)":
				            resultado = cantidad * 12.0;
				            break;
				        case "Pie (ft)":
				            resultado = cantidad;
				            break;
				        case "Yarda (yd)":
				            resultado = cantidad / 36.0;
				            break;
				        case "Milla (mile)":
				            resultado = cantidad / 63360.0;
				            break;
				        case "Milímetro (mm)":
				            resultado = cantidad * 25.4;
				            break;
				        case "Centímetro (cm)":
				            resultado = cantidad * 2.54;
				            break;
				        case "Metro (m)":
				            resultado = cantidad * 0.0254;
				            break;
				        case "Kilómetro (km)":
				            resultado = cantidad * 2.54e-5;
				            break;
				    }
				}

				// Resto de los casos de conversión
				
				if (origen.equals("Yarda (yd)")) {
				    switch (destino) {
				        case "Pulgada (in)":
				            resultado = cantidad * 36.0;
				            break;
				        case "Pie (ft)":
				            resultado = cantidad * 3.0;
				            break;
				        case "Yarda (yd)":
				            resultado = cantidad;
				            break;
				        case "Milla (mile)":
				            resultado = cantidad / 1760.0;
				            break;
				        case "Milímetro (mm)":
				            resultado = cantidad * 914.4;
				            break;
				        case "Centímetro (cm)":
				            resultado = cantidad * 91.44;
				            break;
				        case "Metro (m)":
				            resultado = cantidad * 0.9144;
				            break;
				        case "Kilómetro (km)":
				            resultado = cantidad * 0.0009144;
				            break;
				    }
				}

				if (origen.equals("Milla (mile)")) {
				    switch (destino) {
				        case "Pulgada (in)":
				            resultado = cantidad * 63360.0;
				            break;
				        case "Pie (ft)":
				            resultado = cantidad * 5280.0;
				            break;
				        case "Yarda (yd)":
				            resultado = cantidad * 1760.0;
				            break;
				        case "Milla (mile)":
				            resultado = cantidad;
				            break;
				        case "Milímetro (mm)":
				            resultado = cantidad * 1609344.0;
				            break;
				        case "Centímetro (cm)":
				            resultado = cantidad * 160934.4;
				            break;
				        case "Metro (m)":
				            resultado = cantidad * 1609.344;
				            break;
				        case "Kilómetro (km)":
				            resultado = cantidad * 1.609344;
				            break;
				    }
				}

				if (origen.equals("Milímetro (mm)")) {
				    switch (destino) {
				        case "Pulgada (in)":
				            resultado = cantidad * 0.03937;
				            break;
				        case "Pie (ft)":
				            resultado = cantidad * 0.003281;
				            break;
				        case "Yarda (yd)":
				            resultado = cantidad * 0.001094;
				            break;
				        case "Milla (mile)":
				            resultado = cantidad * 6.2137e-7;
				            break;
				        case "Milímetro (mm)":
				            resultado = cantidad;
				            break;
				        case "Centímetro (cm)":
				            resultado = cantidad * 0.1;
				            break;
				        case "Metro (m)":
				            resultado = cantidad * 0.001;
				            break;
				        case "Kilómetro (km)":
				            resultado = cantidad * 1e-6;
				            break;
				    }
				}

				if (origen.equals("Centímetro (cm)")) {
				    switch (destino) {
				        case "Pulgada (in)":
				            resultado = cantidad / 2.54;
				            break;
				        case "Pie (ft)":
				            resultado = cantidad / 30.48;
				            break;
				        case "Yarda (yd)":
				            resultado = cantidad / 91.44;
				            break;
				        case "Milla (mile)":
				            resultado = cantidad / 160934.4;
				            break;
				        case "Milímetro (mm)":
				            resultado = cantidad * 10.0;
				            break;
				        case "Centímetro (cm)":
				            resultado = cantidad;
				            break;
				        case "Metro (m)":
				            resultado = cantidad / 100.0;
				            break;
				        case "Kilómetro (km)":
				            resultado = cantidad / 100000.0;
				            break;
				    }
				}
				
				if (origen.equals("Metro (m)")) {
				    switch (destino) {
				        case "Pulgada (in)":
				            resultado = cantidad * 39.37;
				            break;
				        case "Pie (ft)":
				            resultado = cantidad * 3.281;
				            break;
				        case "Yarda (yd)":
				            resultado = cantidad * 1.094;
				            break;
				        case "Milla (mile)":
				            resultado = cantidad / 1609.34;
				            break;
				        case "Milímetro (mm)":
				            resultado = cantidad * 1000;
				            break;
				        case "Centímetro (cm)":
				            resultado = cantidad * 100;
				            break;
				        case "Metro (m)":
				            resultado = cantidad;
				            break;
				        case "Kilómetro (km)":
				            resultado = cantidad / 1000;
				            break;
				    }
				}
				
				if (origen.equals("Kilómetro (km)")) {
				    switch (destino) {
				        case "Pulgada (in)":
				            resultado = cantidad * 39370.1;
				            break;
				        case "Pie (ft)":
				            resultado = cantidad * 3280.84;
				            break;
				        case "Yarda (yd)":
				            resultado = cantidad * 1093.61;
				            break;
				        case "Milla (mile)":
				            resultado = cantidad * 0.621371;
				            break;
				        case "Milímetro (mm)":
				            resultado = cantidad * 1000000;
				            break;
				        case "Centímetro (cm)":
				            resultado = cantidad * 100000;
				            break;
				        case "Metro (m)":
				            resultado = cantidad * 1000;
				            break;
				        case "Kilómetro (km)":
				            resultado = cantidad;
				            break;
				    }
				}

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
				// Crea un patrón de formato que siempre utiliza punto decimal
			    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			    symbols.setDecimalSeparator('.');
			    String pattern = "#0.00";
			    DecimalFormat format = new DecimalFormat(pattern, symbols);
			    try {
			        // Intenta convertir el valor ingresado a un número utilizando el patrón creado
			        double monto = format.parse(txtInserteMonto.getText()).doubleValue();
			        // Si se pudo convertir, actualiza el JTextField con el valor formateado
			        txtInserteMonto.setText(format.format(monto));
			    } catch (ParseException ex) {
			        // Captura la excepción si el valor ingresado no es un número válido
			        JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
			        // Puedes realizar otras acciones aquí, como borrar el valor ingresado o mostrar un mensaje de error
			    }

			}
		});

		JLabel lblConvertidorDeMonedas = DefaultComponentFactory.getInstance().createTitle("Convertidor de Monedas");
		lblConvertidorDeMonedas.setBounds(141, 28, 177, 48);
		contentPane.add(lblConvertidorDeMonedas);
	}
}