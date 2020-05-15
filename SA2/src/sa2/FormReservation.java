package sa2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class FormReservation extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAge;
	private JTextField txtEmail;
	private JTextField txtTelephone;
	private JTextField txtPays;
	private JTextField txtnbrPersonne;
	private String dateArriver;
	private String dateDepart;
	private String dateReservation;
	private JComboBox<String> comboBoxSexe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReservation form = new FormReservation();
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormReservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(23, 51, 56, 16);
		contentPane.add(lblId);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(23, 106, 56, 16);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(23, 153, 56, 16);
		contentPane.add(lblPrenom);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setBounds(23, 201, 56, 16);
		contentPane.add(lblSexe);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(23, 254, 56, 16);
		contentPane.add(lblAge);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(23, 313, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblTel = new JLabel("T\u00E9l\u00E9phone");
		lblTel.setBounds(23, 369, 79, 16);
		contentPane.add(lblTel);
		
		JLabel lblPays = new JLabel("Pays");
		lblPays.setBounds(23, 424, 56, 16);
		contentPane.add(lblPays);
		
		JLabel lblFormulaireDeRservation = new JLabel("Formulaire de R\u00E9servation");
		lblFormulaireDeRservation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFormulaireDeRservation.setBounds(274, 13, 187, 16);
		contentPane.add(lblFormulaireDeRservation);
		
		JLabel lblDateRservation = new JLabel("Date R\u00E9servation");
		lblDateRservation.setBounds(411, 51, 97, 16);
		contentPane.add(lblDateRservation);
		
		JLabel lblDateArrive = new JLabel("Date Arriv\u00E9e");
		lblDateArrive.setBounds(411, 106, 86, 16);
		contentPane.add(lblDateArrive);
		
		JLabel lblDateDpart = new JLabel("Date D\u00E9part");
		lblDateDpart.setBounds(411, 153, 97, 16);
		contentPane.add(lblDateDpart);
		
		JLabel lblNombresDePersonnes = new JLabel("Nombres de Personnes");
		lblNombresDePersonnes.setBounds(411, 201, 151, 16);
		contentPane.add(lblNombresDePersonnes);
		
		txtId = new JTextField();
		txtId.setBounds(114, 48, 116, 22);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(114, 103, 116, 22);
		contentPane.add(txtNom);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(114, 150, 116, 22);
		contentPane.add(txtPrenom);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(114, 251, 116, 22);
		contentPane.add(txtAge);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(114, 310, 116, 22);
		contentPane.add(txtEmail);
		
		txtTelephone = new JTextField();
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(114, 366, 116, 22);
		contentPane.add(txtTelephone);
		
		txtPays = new JTextField();
		txtPays.setColumns(10);
		txtPays.setBounds(114, 421, 116, 22);
		contentPane.add(txtPays);
		
		txtnbrPersonne = new JTextField();
		txtnbrPersonne.setColumns(10);
		txtnbrPersonne.setBounds(557, 198, 116, 22);
		contentPane.add(txtnbrPersonne);
		
		comboBoxSexe = new JComboBox();
		comboBoxSexe.addItem("");
		comboBoxSexe.addItem("Feminin");
		comboBoxSexe.addItem("Masculin");
		comboBoxSexe.setBounds(114, 198, 116, 27);
		comboBoxSexe.setEditable(false); ////////faire Editable pa click/////
		contentPane.add(comboBoxSexe);
		
		JDateChooser dateReserv = new JDateChooser();
		dateReserv.setDateFormatString("yyyy-MM-dd");
		dateReserv.setBounds(557, 45, 100, 22);
		contentPane.add(dateReserv);
		
		JDateChooser dateArr = new JDateChooser();
		dateArr.setDateFormatString("yyyy-MM-dd");
		dateArr.setBounds(557, 100, 100, 22);
		contentPane.add(dateArr);
		
		JDateChooser dateDep = new JDateChooser();
		dateDep.setDateFormatString("yyyy-MM-dd");
		dateDep.setBounds(557, 153, 100, 22);
		contentPane.add(dateDep);
		
		JButton btnAjouter = new JButton("Ajouter");
		Image img=new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage();
		btnAjouter.setIcon(new ImageIcon(img));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Id = txtId.getText();
				String nbrPersonne = txtnbrPersonne.getText();
				
				String dateArriver = ((JTextField)dateArr.getDateEditor().getUiComponent()).getText();
				String dateDepart = ((JTextField)dateDep.getDateEditor().getUiComponent()).getText();
				String dateReservation =((JTextField)dateReserv.getDateEditor().getUiComponent()).getText();
				
				String nom = txtNom.getText();
				String prenom= txtPrenom.getText();
				String age = txtAge.getText();
				String sexe = comboBoxSexe.getSelectedItem().toString();
				String telephone = txtTelephone.getText();
				String pays = txtPays.getText();
				
				
				
				if( dateReservation.trim().length()==0 || dateArriver.trim().length()==0 || dateDepart.trim().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Veuillez d'abord selectionner une reservation");
					return;
				}
				
				else {
					connectdb data = new connectdb();
					try {
						
						Connection con;
						con = (Connection) data.db_connect();
						java.sql.PreparedStatement stmt = con.prepareStatement("INSERT INTO client (prenom,nom,age,sexe,phone,pays_origine) VALUES (?,?,?,?,?,?),Statement.RETURN_GENERATED_KEYS");
						
						stmt.setString(1, prenom);
						stmt.setString(2, nom);
						stmt.setString(3, age);
						stmt.setString(4, sexe);
						stmt.setString(5, telephone);
						stmt.setString(6, pays);
						stmt.executeUpdate();
						
						ResultSet rs=stmt.getGeneratedKeys();
						if(rs.next()) {
							Id=rs.getString(1);
							
						java.sql.PreparedStatement stmt1 = con.prepareStatement("INSERT INTO reservation (dateArr,dateDep,dateReserv,nbrPersonne,id_client) VALUES (?,?,?,?,?)");	
						stmt1.setString(1, dateArriver);
						stmt1.setString(2, dateDepart);
						stmt1.setString(3, dateReservation);
						stmt1.setString(4, nbrPersonne);
						stmt1.setString(5, Id);
						stmt1.executeUpdate();
						
						JOptionPane.showMessageDialog(null,"Votre réservation a bien été effectuer!");
				
				}
						else {JOptionPane.showMessageDialog(null,"Erreur!");}	
			}
					catch(Exception e1) {
						
					}
		}
	}
});
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAjouter.setBounds(298, 439, 137, 39);
		contentPane.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		Image retour=new ImageIcon(this.getClass().getResource("/Logout.png")).getImage();
		btnAnnuler.setIcon(new ImageIcon(retour));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					dispose();
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnnuler.setBounds(536, 439, 121, 39);
		contentPane.add(btnAnnuler);
		
			}
		}		
