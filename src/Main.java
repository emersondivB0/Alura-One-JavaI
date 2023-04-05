import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMonedas = new JButton("Monedas");
		btnMonedas.setIcon(new ImageIcon(Main.class.getResource("/Icons/coins_icon_129479.png")));
		btnMonedas.setBounds(56, 73, 147, 157);
		contentPane.add(btnMonedas);
		 btnMonedas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Convertidor frame = new Convertidor();
                frame.setVisible(true);
            }
        });
		 
		JButton btnUnidades = new JButton("Unidades");
		btnUnidades.setHorizontalAlignment(SwingConstants.LEADING);
		btnUnidades.setIcon(new ImageIcon(Main.class.getResource("/Icons/drawing_tools_icon_129102.png")));
		btnUnidades.setBounds(251, 73, 147, 157);
		contentPane.add(btnUnidades);
		
		JLabel lblConversor = DefaultComponentFactory.getInstance().createTitle("CONVERSOR");
		lblConversor.setBounds(183, 26, 110, 17);
		contentPane.add(lblConversor);
		
		JLabel lblMonedas = DefaultComponentFactory.getInstance().createTitle("Monedas");
		lblMonedas.setBounds(104, 55, 110, 17);
		contentPane.add(lblMonedas);
		
		JLabel lblLongitud = DefaultComponentFactory.getInstance().createTitle("Longitud");
		lblLongitud.setBounds(300, 55, 110, 17);
		contentPane.add(lblLongitud);
		btnUnidades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConvertirSistemas frame = new ConvertirSistemas();
                frame.setVisible(true);
            }
        });

	}
}
