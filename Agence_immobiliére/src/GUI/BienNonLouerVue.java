package GUI;

import java.awt.EventQueue;
import java.sql.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Services.BienCRUD;
import Entities.Bien;

public class BienNonLouerVue {
	public JFrame frameBienNonLouerVue;
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
	 */
	public BienNonLouerVue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frameBienNonLouerVue = new JFrame();
		
		String columns[] ={
				"TYPE","Reference", "Adresse", "Tarif", "Surface Total", "En_location", "Date Debut"
			};
		String data[][] = new String[50][17];
		int x = 0;
		/*Bien*/
		BienCRUD ps= new BienCRUD();
	    List<Bien> list = ps.afficherBiennonloues();
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
		scrollPane1.setBounds(328, 103, 1212, 662);
		frameBienNonLouerVue.getContentPane().add(scrollPane1);	}

}
