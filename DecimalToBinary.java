import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class DecimalToBinary extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtDecimal;
	private JTextField txtBinary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new DecimalToBinary();
	}

	/**
	 * Create the frame.
	 */
	public DecimalToBinary() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(getLabel("Binary",12, 16, 80, 19));
		contentPane.add(getLabel("Decimal",12, 47, 80, 19));

		txtDecimal = getTextField(90, 16, 126, 19);
		contentPane.add(txtDecimal);

		txtBinary = getTextField(90, 47, 126, 19);
		contentPane.add(txtBinary);

		JButton cmdConvert = new JButton("Convert");
		cmdConvert.setFont(new Font("Dialog", Font.PLAIN, 11));
		cmdConvert.addActionListener( this );
		cmdConvert.setBounds(227, 16, 80, 50);
		contentPane.add(cmdConvert);
		
		setResizable(false);
		setTitle("Binary To Decimal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 114);
		setLocationRelativeTo( null );
		setVisible( true );
	}
	
	private JLabel getLabel( String caption, int x, int y, int w, int h ) {
		JLabel lbl = new JLabel( caption );
		lbl.setBounds(x, y, w, h);
		
		return lbl;
	}
	
	private JTextField getTextField( int x, int y, int w, int h ) {
		JTextField tf = new JTextField();
		tf.setBounds(x, y, w, h);
		
		return tf;
	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{


		String value = txtDecimal.getText();
			int answer = 0, count = 0;

			for(int i = value.length()-1; i >= 0; i--)
			{

				switch(value.charAt(i))
				{

					case '1': answer += Math.pow(2, count);
					break;
					case '0': break;
					default: JOptionPane.showMessageDialog(this, "Invalid Input 1 and 0 only.");
					System.exit(0);

				}
				count++;

			}
			txtBinary.setText(Math.abs(answer)+"");

		
	}
}