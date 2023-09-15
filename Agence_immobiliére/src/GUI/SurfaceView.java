package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Services.BienCRUD;
import Entities.Bien;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SurfaceView {

	public JFrame frameVueSurface;
	private JTextField textField;
	private JButton btnNewButton;
	private JTable tablem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public SurfaceView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frameVueSurface = new JFrame();
		frameVueSurface.getContentPane().setBackground(new Color(0, 128, 255));
		frameVueSurface.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(386, 6, 96, 19);
		frameVueSurface.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Afficher par Surface");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("surface = "+textField.getText());
						String columns[] ={
					"TYPE","Reference", "Adresse", "Tarif", "Surface Total", "En_location", "Date Debut"
				};
			String data[][] = new String[50][17];
			int x = 0;
			/*Bien*/
			BienCRUD ps= new BienCRUD();
		    List<Bien> list = ps.afficherBienSurface(Float.parseFloat(textField.getText()));
			for(Bien i:list){
			int Reference = i.getReference();
			String Adresse = i.getAdresse();
		    Float tarif = i.getTarif_m();
		    Float st = i.getSurface();
		    int enl =i.getEn_location();
		    Date ddb = (Date) i.getDate_debut_location();
		    data[(int) x][0] = "BIEN";
			data[(int) x][1] = Reference + "";
			data[(int) x][2] = Adresse;
			data[(int) x][3] = tarif.toString();
			data[(int) x][4] = st.toString();
			data[(int) x][5] = enl+"";
			data[(int) x][6] = ddb.toString();
			x ++ ;
			}
			DefaultTableModel modelB = new DefaultTableModel(data, columns);
			tablem = new JTable(modelB);
			tablem.disable();
			tablem.setShowGrid(true);
			tablem.setShowVerticalLines(true);
			
			JScrollPane scrollPane1 = new JScrollPane(tablem);
			scrollPane1.setBounds(200, 103, 500, 200);
			frameVueSurface.getContentPane().add(scrollPane1);
			}
		});
		btnNewButton.setBounds(508, 5, 138, 21);
		frameVueSurface.getContentPane().add(btnNewButton);
		
		
	}
}
