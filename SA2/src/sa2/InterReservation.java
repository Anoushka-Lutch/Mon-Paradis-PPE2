package sa2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import java.awt.Color;

public class InterReservation extends JFrame {

	private JPanel contentPane;
	private JTextField txtRef;
	private static JTable ReservationTable;
	private JTextField txtnbPersonne;
	private JLabel txtId;
	private String dateArr;
	private String dateDep;
	private String id_reservation;
	private String nbrPersonne;
	private String statut;
	private String dateReservation;
	private JTextField txtIdClient;
	private String id_categorie;
	private String id_client;
	private JTextField txtIdCategorie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterReservation frame = new InterReservation();
					frame.setVisible(true);
					showTableReservation();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterReservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 485);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Gestion des R\u00E9servations");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(31, 25, 215, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblRef = new JLabel("Ref:");
		lblRef.setBounds(31, 89, 86, 14);
		contentPane.add(lblRef);
		
		JLabel lblDateDeRservation = new JLabel("Date de R\u00E9servation:");
		lblDateDeRservation.setBounds(31, 114, 145, 14);
		contentPane.add(lblDateDeRservation);
		
		JLabel lblDateDarrive = new JLabel("Date d'arriv\u00E9e:");
		lblDateDarrive.setBounds(31, 139, 113, 14);
		contentPane.add(lblDateDarrive);
		
		JLabel lblDateDeDpart = new JLabel("Date de d\u00E9part:");
		lblDateDeDpart.setBounds(31, 164, 86, 14);
		contentPane.add(lblDateDeDpart);
		
		txtRef = new JTextField();
		txtRef.setBounds(177, 83, 171, 20);
		contentPane.add(txtRef);
		txtRef.setColumns(10);
		
		JDateChooser dateChooserReserv = new JDateChooser();
		dateChooserReserv.setDateFormatString("yyyy-MM-dd");
		dateChooserReserv.setBounds(177, 108, 171, 20);
		contentPane.add(dateChooserReserv);
		
		JDateChooser dateChooserdateArr = new JDateChooser();
		dateChooserdateArr.setDateFormatString("yyyy-MM-dd");
		dateChooserdateArr.setBounds(177, 139, 171, 20);
		contentPane.add(dateChooserdateArr);
		
		JDateChooser dateChooserdateDep = new JDateChooser();
		dateChooserdateDep.setDateFormatString("yyyy-MM-dd");
		dateChooserdateDep.setBounds(177, 170, 171, 20);
		contentPane.add(dateChooserdateDep);
		
		JLabel lblnbPersonne = new JLabel("Nombre de personne:");
		lblnbPersonne.setBounds(31, 200, 145, 14);
		contentPane.add(lblnbPersonne);
		
		txtnbPersonne = new JTextField();
		txtnbPersonne.setColumns(10);
		txtnbPersonne.setBounds(177, 201, 171, 20);
		contentPane.add(txtnbPersonne);
		
		JLabel lblIdclient = new JLabel("Id_client:");
		lblIdclient.setBounds(31, 235, 86, 14);
		contentPane.add(lblIdclient);
		
		txtIdClient = new JTextField();
		txtIdClient.setColumns(10);
		txtIdClient.setBounds(177, 232, 171, 20);
		contentPane.add(txtIdClient);
		
		JLabel lblIdcategorie = new JLabel("Id_categorie:");
		lblIdcategorie.setBounds(31, 273, 86, 14);
		contentPane.add(lblIdcategorie);
		
		txtIdCategorie = new JTextField();
		txtIdCategorie.setColumns(10);
		txtIdCategorie.setBounds(177, 263, 171, 20);
		contentPane.add(txtIdCategorie);
		
		
		
		
		///////////////////////////////////////////////////////////////////Ajouter Reservation///////////////////////////////////////////////////////////////////////////
		JButton btnAjouter = new JButton("Ajouter");
		Image img=new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage();
		btnAjouter.setIcon(new ImageIcon(img));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				
					FormReservation frame = new FormReservation();
					frame.setVisible(true);
				
				}catch(Exception e){
					System.out.print(e);
				}
				
			}
		});
		btnAjouter.setBounds(12, 396, 116, 33);
		contentPane.add(btnAjouter);
		
		
		
		///////////////////////////////////////////////////////////Modifier Reservation////////////////////////////////////////////////////////////////////////////////////////
		JButton btnModifier = new JButton("Modifier");
		Image modifier=new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage();
		btnModifier.setIcon(new ImageIcon(modifier));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			 
				//step 1 collect info from txtfield
				    String ref = txtRef.getText();
				    String dateArr = ((JTextField)dateChooserdateArr.getDateEditor().getUiComponent()).getText();
				    String dateDep = ((JTextField)dateChooserdateDep.getDateEditor().getUiComponent()).getText();
					String nbrPersonne = txtnbPersonne.getText();
					String id_client=txtIdClient.getText();
					String dateReservation =((JTextField) dateChooserReserv.getDateEditor().getUiComponent()).getText();
					String id_categorie=txtIdCategorie.getText();
					
					
					    System.out.println(ref);
					    System.out.println(dateArr);
					    System.out.println(dateDep);
					    System.out.println(nbrPersonne);
					    System.out.println(id_client);
						System.out.println(dateReservation);
						System.out.println(id_categorie);
			
						if(dateArr.trim().length()==0 && dateDep.trim().length()==0 && nbrPersonne.trim().length()==0 && id_client.trim().length()==0 &&  dateReservation.trim().length()==0 && id_categorie.trim().length()==0) {
							
							JOptionPane.showMessageDialog(null,"Remplissez tous les champs");
							
						}
			
//			else if(username.trim().length()==0) {
//				
//			
//			}else if(password.trim().length()==0) {
//				
//			}
			else {
				connectdb data = new connectdb();
				try {
					Connection con;
					con = (Connection) data.db_connect();
					java.sql.PreparedStatement reservstmt = con.prepareStatement("UPDATE reservation  SET dateArr=?,dateDep=?,nbrPersonne=?,id_client=?,dateReserv=?,id_categorie=? WHERE id_reservation=?");
					reservstmt.setString(1, dateArr);
					reservstmt.setString(2, dateDep);
					reservstmt.setString(3, nbrPersonne);
					reservstmt.setString(4, id_client);
					reservstmt.setString(5, dateReservation);
					reservstmt.setString(6, id_categorie);
					reservstmt.setString(7, ref);
					reservstmt.executeUpdate();
					showTableReservation();
					JOptionPane.showMessageDialog(null, "Modification effectuer");
					
					
					
					
				}catch(Exception e1) {
					
				}
			}
				
				
				
				
				
				
				
				
			}
		});
		btnModifier.setBounds(194, 396, 113, 33);
		contentPane.add(btnModifier);
		
		/////////////////////////////////////////////////////////////////////Effacer reservation////////////////////////////////////////////////////////////////////////////
		JButton btnEffacer = new JButton("Effacer");
		Image effacer=new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		btnEffacer.setIcon(new ImageIcon(effacer));
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//step 1 collect info from txtfield
//				    String ref = txtRef.getText();
					String id_reservation=txtRef.getText();
			
				System.out.println(id_reservation);
//			    System.out.println(dateArr);
//			    System.out.println(dateDep);
//			    System.out.println(nbrPersonne);
//			    System.out.println(id_client);
//				System.out.println(dateReservation);
//				System.out.println(id_categorie);
//			
			
if(id_reservation.trim().length()==0) {
				
				JOptionPane.showMessageDialog(null,"Remplissez tous les champs");
				
			}
//			else if(username.trim().length()==0) {
//				
//			
//			}else if(password.trim().length()==0) {
//				
//			}
			else {
				connectdb data = new connectdb();
				try {
					Connection con;
					con = (Connection) data.db_connect();
					java.sql.PreparedStatement reservstmt = con.prepareStatement("DELETE FROM reservation  WHERE id_reservation = ? ");
					reservstmt.setString(1, id_reservation);
					showTableReservation();
					reservstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Donnée effacer");
					
					
					
					
				}catch(Exception e1) {
					
				}
			}
				
				
			}
		});
		btnEffacer.setBounds(367, 396, 113, 31);
		contentPane.add(btnEffacer);
		
		
		///////////////////////////////////////////////////////////Reinitialiser reservation/////////////////////////////////////////////////////////////////////////////
		JButton btnReinitialiser = new JButton("R\u00E9initialiser");
		Image refresh=new ImageIcon(this.getClass().getResource("/reinitialiser.png")).getImage();
		btnReinitialiser.setIcon(new ImageIcon(refresh));
		btnReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				//remet tout les field a null
		txtRef.setText(null);				
		((JTextField)dateChooserdateArr.getDateEditor().getUiComponent()).setText("");
		((JTextField)dateChooserdateDep.getDateEditor().getUiComponent()).setText("");
		txtnbPersonne.setText(null);
		txtIdClient.setText(null);
		((JTextField) dateChooserReserv.getDateEditor().getUiComponent()).setText("");
		txtIdCategorie.setText(null);		
				
				
				}
				
			});
		btnReinitialiser.setBounds(567, 396, 127, 31);
		contentPane.add(btnReinitialiser);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		scrollPane.setBounds(357, 58, 583, 329);
		contentPane.add(scrollPane);
		
		ReservationTable = new JTable() { //////////////////////Make Rows Not Editable Step 1////////////////////////
				
				public boolean isCellEditable(int row, int colunm) {
					return false;
				}

					};
					
			//////////////////Pour afficher les valeur en clickant////////////////////////////
			ReservationTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					connectdb data = new connectdb();
					try {
						int row = ReservationTable.getSelectedRow();
						
//						System.out.print(row);
						
						String tableClick = (ReservationTable.getModel().getValueAt(row,0).toString()); ///0=colunm 
//						System.out.print(tableClick);
						Connection con;
						con = (Connection) data.db_connect();
						java.sql.PreparedStatement callinfo = con.prepareStatement("SELECT * FROM reservation where id_reservation='"+tableClick+"'");
						ResultSet rs = callinfo.executeQuery();
						if(rs.next()) {
						String data1 = rs.getString("id_reservation");
						String data2 = rs.getString("dateArr");
						String data3 = rs.getString("dateDep");
						String data4 = rs.getString("nbrPersonne");
						String data5 = rs.getString("id_client");
						String data6 = rs.getString("dateReserv");
						String data7 = rs.getString("id_categorie");
						
						System.out.println( data1);
						System.out.println(data2);
						System.out.println(data3);
						System.out.println(data4);
						System.out.println(data5);
						System.out.println(data6);
						System.out.println(data7);
						System.out.println("_____");
						
						txtRef.setText(data1);
						((JTextField)dateChooserdateArr.getDateEditor().getUiComponent()).setText(data2);
						((JTextField)dateChooserdateDep.getDateEditor().getUiComponent()).setText(data3);
						txtnbPersonne.setText(data4);
						txtIdClient.setText(data5);
						((JTextField) dateChooserReserv.getDateEditor().getUiComponent()).setText(data6);
						txtIdCategorie.setText(data7);		
						
					
					}	
				}
					catch(Exception e1) {
					
					System.out.print(e1);
				}
				
				}
			
				
		});
		
		scrollPane.setViewportView(ReservationTable);
		
/////////////////////////////////////////////////Boutou assigner Chambre//////////////////////
		JButton btnAssignerChambre = new JButton("Voir/Assigner Chambre");
		btnAssignerChambre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignChambre frame = new AssignChambre("id_reservation","id_client","cnom","cprenom"); 
				frame.setVisible(true);
			}
		});
		btnAssignerChambre.setBounds(803, 20, 97, 25);
		contentPane.add(btnAssignerChambre);
		
		JButton btnRetour = new JButton("Retour");
		Image retour=new ImageIcon(this.getClass().getResource("/Logout.png")).getImage();
		btnRetour.setIcon(new ImageIcon(retour));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnRetour.setBounds(758, 396, 113, 31);
		contentPane.add(btnRetour);
		
		JLabel lblHotel = new JLabel("Mon Paradis H\u00F4tel");
		lblHotel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblHotel.setForeground(Color.BLUE);
		lblHotel.setBounds(401, 20, 215, 22);
		contentPane.add(lblHotel);
	
	}		
	
	/////////////////////////////////////////////////fonction showTable qui permet de faire apparaitre la table des reservations de la bdd///////////////////////////////////////
	public static void showTableReservation(){
		connectdb data = new connectdb();
		try {
			Connection con;
			con=data.db_connect();
			java.sql.PreparedStatement reservStmt=con.prepareStatement(
					"SELECT id_reservation AS '#',dateArr AS 'Date d_arrivée',"
					+ "dateDep AS 'Date de départ',nbrPersonne AS 'Nombre de personne',"
					+ "id_client AS 'id_Client',dateReserv AS 'Date de Réservation',"
					+ "id_categorie AS 'Categorie' FROM reservation ");
		    ResultSet rs=reservStmt.executeQuery();
			ReservationTable.setModel(DbUtils.resultSetToTableModel(rs));
			}
		catch(Exception e) {
			System.out.print(e);
		}


	}
}
