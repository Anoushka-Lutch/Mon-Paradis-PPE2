package sa2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class InterClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAge;
	private JTextField txtEmail;
	private JTextField txtTelephone;
	private JComboBox<String> comboBoxSexe,comboBoxSearchClient,comboBoxPays;
	private static JTable clientTable;
	private JTextField txtSearchBox;
	public String filterSearch;
//	private JTable clientTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterClient client = new InterClient();
					client.setVisible(true);
					showTableClient();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public InterClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClient = new JLabel("Gestion des Clients");
		lblClient.setForeground(Color.BLACK);
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClient.setBounds(33, 19, 181, 22);
		contentPane.add(lblClient);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(12, 54, 56, 16);
		contentPane.add(lblId);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(12, 99, 56, 16);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(12, 144, 56, 16);
		contentPane.add(lblPrenom);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setBounds(12, 191, 56, 16);
		contentPane.add(lblSexe);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(12, 242, 56, 16);
		contentPane.add(lblAge);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 289, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(12, 337, 79, 16);
		contentPane.add(lblTelephone);
		
		JLabel lblPays = new JLabel("Pays");
		lblPays.setBounds(12, 389, 56, 16);
		contentPane.add(lblPays);
		
		txtId = new JTextField();
		txtId.setBounds(140, 51, 116, 22);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(140, 96, 116, 22);
		contentPane.add(txtNom);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(140, 141, 116, 22);
		contentPane.add(txtPrenom);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(140, 239, 116, 22);
		contentPane.add(txtAge);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(140, 286, 116, 22);
		contentPane.add(txtEmail);
		
		txtTelephone = new JTextField();
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(140, 334, 116, 22);
		contentPane.add(txtTelephone);
		
		
		
/////////////////////////////////////Nouveau//////////////////////////////////////////////////////////////
		JButton btnNewButton = new JButton("Nouveau");
		Image img=new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//step 1 collect info from txtfield
				String id = txtId.getText();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String age = txtAge.getText();
				String email = txtEmail.getText();
				String telephone = txtTelephone.getText();
				String pays = comboBoxPays.getSelectedItem().toString();
				String sexe = comboBoxSexe.getSelectedItem().toString();
			
			System.out.println(id);
			System.out.println(nom);
			System.out.println(prenom);
			System.out.println(age);
			System.out.println(email);
			System.out.println(telephone);
			System.out.println(pays);
			System.out.println(sexe);
			
			if(id.trim().length()==0 && nom.trim().length()==0 && prenom.trim().length()==0 && age.trim().length()==0 && email.trim().length()==0 && telephone.trim().length()==0 && pays.trim().length()==0 && sexe.trim().length()==0 ) {
				
				JOptionPane.showMessageDialog(null,"Remplissez tous les champs");
				
			}
			else {
				connectdb data = new connectdb();
				try {
					Connection con;
					con = (Connection) data.db_connect();
					java.sql.PreparedStatement stmt1 = con.prepareStatement("INSERT INTO client (prenom,nom,age,sexe,email,phone,pays_origine) VALUES (?,?,?,?,?,?,?)");
					
					stmt1.setString(1, prenom);
					stmt1.setString(2, nom);
					stmt1.setString(3, age);
					stmt1.setString(4, sexe);
					stmt1.setString(5, email);
					stmt1.setString(6, telephone);
					stmt1.setString(7, pays);
					stmt1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Mise a jour effectuer");
					showTableClient(); //////Reexecute le code qui fait apparaisse la table(Refresh)////////
					
					
					
				}catch(Exception e1) {
					System.out.print(e1);
					
				}
			}
				
			}
		});
			
		btnNewButton.setBounds(12, 450, 135, 36);
		contentPane.add(btnNewButton);
		
/////////////////////////////////////Modifier//////////////////////////////////////////////////////////////
		JButton btnModifier = new JButton("Modifier");
		Image modifier=new ImageIcon(this.getClass().getResource("/ajouter.png")).getImage();
		btnModifier.setIcon(new ImageIcon(modifier));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//step 1 collect info from txtfield
				String id = txtId.getText();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String age = txtAge.getText();
				String email = txtEmail.getText();
				String telephone = txtTelephone.getText();
				String pays = comboBoxPays.getSelectedItem().toString();
				String sexe = comboBoxSexe.getSelectedItem().toString();
			
			System.out.println(id);
			System.out.println(nom);
			System.out.println(prenom);
			System.out.println(age);
			System.out.println(email);
			System.out.println(telephone);
			System.out.println(pays);
			System.out.println(sexe);
			
			if(id.trim().length()==0 && nom.trim().length()==0 && prenom.trim().length()==0 && age.trim().length()==0 && email.trim().length()==0 && telephone.trim().length()==0 && pays.trim().length()==0 && sexe.trim().length()==0 ) {
				
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
					java.sql.PreparedStatement stmt1 = con.prepareStatement("UPDATE client  SET prenom=?,nom=?,age=?,sexe=?,email=?,phone=?,pays_origine=? WHERE id_client=?");
					
					stmt1.setString(1, prenom);
					stmt1.setString(2, nom);
					stmt1.setString(3, age);
					stmt1.setString(4, sexe);
					stmt1.setString(5, email);
					stmt1.setString(6, telephone);
					stmt1.setString(7, pays);
					stmt1.setString(8, id);
					stmt1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Modification effectuer");
					showTableClient(); //////Reexecute le code qui fait apparaisse la table(Refresh)////////
					
					
					
				}catch(Exception e1) {
					System.out.print(e1);
					
				}
			}
				
			}
		});
		btnModifier.setBounds(169, 450, 145, 36);
		contentPane.add(btnModifier);
		
/////////////////////////////////////Effacer//////////////////////////////////////////////////////////////
		JButton btnEffacer = new JButton("Effacer");
		Image effacer=new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		btnEffacer.setIcon(new ImageIcon(effacer));
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				//step 1 collect info from txtfield
				String id = txtId.getText();
				
			
			System.out.println(id);
			
			
			if(id.trim().length()==0 ) {
				
				JOptionPane.showMessageDialog(null,"Remplit le champ #");
				
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
					java.sql.PreparedStatement stmt1 = con.prepareStatement("DELETE FROM client  WHERE id_client = ? ");
					
					stmt1.setString(1, id);
					stmt1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Donnée effacer");
					showTableClient(); //////Reexecute le code qui fait apparaisse la table(Refresh)////////
					
					
					
				}catch(Exception e1) {
					System.out.print(e1);
					
				}
			}
			}
		});
		btnEffacer.setBounds(344, 450, 145, 36);
		contentPane.add(btnEffacer);
		
/////////////////////////////////////Reinitialiser//////////////////////////////////////////////////////////////
		JButton btnReinitialiser = new JButton("Reinitialiser");
		Image refresh=new ImageIcon(this.getClass().getResource("/reinitialiser.png")).getImage();
		btnReinitialiser.setIcon(new ImageIcon(refresh));
		btnReinitialiser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//remet tout les field a null
				txtId.setText(null);
				txtPrenom.setText(null);
				txtNom.setText(null);
				txtAge.setText(null);
				txtEmail.setText(null);
				txtTelephone.setText(null);
				comboBoxPays.setSelectedItem(null);
				comboBoxSexe.setSelectedItem(null);
			}
		});
		btnReinitialiser.setBounds(520, 450, 156, 36);
		contentPane.add(btnReinitialiser);
		
////////////////pays///////////////////////
		this.comboBoxPays = new JComboBox<String>();
		comboBoxPays.setBounds(129, 386, 127, 22);
		comboBoxPays.setModel(new DefaultComboBoxModel<String>(new String[] {" ","Afghanistan", "Afrique du Sud", "Albanie",
				"Alg\u00E9rie", "Allemagne", "Andorre", "Angola", "Antigua-et-Barbuda","Arabie Saoudite", "Argentine",
				"Arm\u00E9nie", "Australie", "Autriche", "Azerba\u00EFdjan", "Bahamas", "Bahre\u00EFn", "Bangladesh", 
				"Barbade", "Belau", "Belgique", "Belize", "B\u00E9nin", "Bhoutan", "Bi\u00E9lorussie", "Birmanie", 
				"Bolivie", "Bosnie-Herz\u00E9govine", "Botswana", "Br\u00E9sil", "Brunei", "Bulgarie", "Burkina", "Burundi", 
				"Cambodge", "Cameroun", "Canada", "Cap-Vert", "Chili", "Chine", "Chypre", "Colombie", "Comores", "Congo", 
				"Cook", "Cor\u00E9e du Nord", "Cor\u00E9e du Sud", "Costa Rica", "C\u00F4te d'Ivoire", "Croatie", "Cuba", 
				"Danemark", "Djibouti", "Dominique", "\u00C9gypte", "\u00C9mirats arabes unis", "\u00C9quateur", "\u00C9rythr\u00E9e",
				"Espagne", "Estonie", "\u00C9tats-Unis", "\u00C9thiopie", "Fidji", "Finlande", "France", "Gabon", "Gambie",
				"G\u00E9orgie", "Ghana", "Gr\u00E8ce", "Grenade", "Guatemala", "Guin\u00E9e", "Guin\u00E9e-Bissao", "Guin\u00E9e \u00E9quatoriale",
				"Guyana", "Ha\u00EFti", "Honduras", "Hongrie", "Inde", "Indon\u00E9sie", "Iran", "Iraq", "Irlande", "Islande", "Isra\u00EBl",
				"Italie", "Jama\u00EFque", "Japon", "Jordanie", "Kazakhstan", "Kenya", "Kirghizistan", "Kiribati", "Kowe\u00EFt", "Laos", 
				"Lesotho", "Lettonie", "Liban", "Liberia", "Libye", "Liechtenstein", "Lituanie", "Luxembourg", "Mac\u00E9doine", "Madagascar", "Malaisie",
				"Malawi", "Maldives", "Mali", "Malte", "Maroc", "Marshall", "Maurice", "Mauritanie", "Mexique", "Micron\u00E9sie", "Moldavie",
				"Monaco", "Mongolie", "Mozambique", "Namibie", "Nauru", "N\u00E9pal", "Nicaragua", "Niger", "Nigeria", "Niue", 
				"Norv\u00E8ge", "Nouvelle-Z\u00E9lande", "Oman", "Ouganda", "Ouzb\u00E9kistan", "Pakistan", "Panama", "Papouasie - Nouvelle Guin\u00E9e",
				"Paraguay", "Pays-Bas", "P\u00E9rou", "Philippines", "Pologne", "Portugal", "Qatar", "R\u00E9publique Centrafricaine",
				"R\u00E9publique Dominicaine", "R\u00E9publique tch\u00E8que", "Roumanie", "Royaume-Uni", "Russie", "Rwanda", 
				"Saint-Christophe-et-Ni\u00E9v\u00E8s", "Sainte-Lucie", "Saint-Marin", "Saint-Si\u00E8ge, ou leVatican", "Saint-Vincent-et-les Grenadines"
				, "Salomon", "Salvador", "Samoa occidentales", "Sao Tom\u00E9-et-Principe", "S\u00E9n\u00E9gal", "Seychelles", "Sierra Leone", 
				"Singapour", "Slovaquie", "Slov\u00E9nie", "Somalie", "Soudan", "Sri Lanka", "Su\u00E8de", "Suisse", "Suriname",
				"Swaziland", "Syrie", "Tadjikistan", "Tanzanie", "Tchad", "Tha\u00EFlande", "Togo", "Tonga", "Trinit\u00E9-et-Tobago",
				"Tunisie", "Turkm\u00E9nistan", "Turquie", "Tuvalu", "Ukraine", "Uruguay", "Vanuatu", "Venezuela", "Vi\u00EAt Nam",
				"Y\u00E9men", "Yougoslavie", "Za\u00EFre", "Zambie", "Zimbabwe"}));
		contentPane.add(comboBoxPays);
		
////////////////permet pour pa faire errer ler pe rentre role e affiche le role kan click lor nom///////////////////////
		comboBoxSexe = new JComboBox();
		comboBoxSexe.addItem("");
		comboBoxSexe.addItem("Feminin");
		 comboBoxSexe.addItem("Masculin");
		comboBoxSexe.setBounds(140, 188, 124, 22);
		 comboBoxSexe.setEditable(false); ////////faire Editable pa click/////
		contentPane.add(comboBoxSexe);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(268, 65, 558, 372);
		contentPane.add(scrollPane);
		
		
		
		clientTable = new JTable() {
//////////////////////Make Rows Not Editable Step 1////////////////////////
			
	public boolean isCellEditable(int row, int colunm) {
		return false;
	}

		};
		
//////////////////Pour afficher les valeur en clickant////////////////////////////
  clientTable.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		connectdb data = new connectdb();
		try {
			int row = clientTable.getSelectedRow();
			
//			System.out.print(row);
			
			String tableClick = (clientTable.getModel().getValueAt(row,0).toString()); ///0=colunm 
//			System.out.print(tableClick);
			Connection con;
			con = (Connection) data.db_connect();
			java.sql.PreparedStatement callinfo = con.prepareStatement("SELECT * FROM client where id_client='"+tableClick+"'");
			ResultSet rs = callinfo.executeQuery();
			if(rs.next()) {
				String data1 = rs.getString("id_client");
				String data2 = rs.getString("prenom");
				String data3 = rs.getString("nom");
				String data4 = rs.getString("age");
				String data5 = rs.getString("sexe");
				String data6 = rs.getString("email");
				String data7 = rs.getString("phone");
				String data8 = rs.getString("pays_origine");
				
				System.out.println(data1);
				System.out.println(data2);
				System.out.println(data3);
				System.out.println(data4);
				System.out.println(data5);
				System.out.println(data6);
				System.out.println(data7);
				System.out.println(data8);
				System.out.println("_____");
				
				txtId.setText(data1);
				txtPrenom.setText(data2);
				txtNom.setText(data3);
				txtAge.setText(data4);
				txtEmail.setText(data6);
				txtTelephone.setText(data7);
				comboBoxPays.setSelectedItem(data8);
				comboBoxSexe.setSelectedItem(data5);
			}
			
		} catch(Exception e1) {
			
			System.out.print(e1);
		}
		
	}
});
		scrollPane.setViewportView(clientTable);
		
/////////////////Retour////////////////////////////	
		JButton btnRetour = new JButton("Retour");
		Image retour=new ImageIcon(this.getClass().getResource("/Logout.png")).getImage();
		btnRetour.setIcon(new ImageIcon(retour));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(718, 450, 116, 36);
		contentPane.add(btnRetour);
	
	//////////////////////SearchBox////////////////////////////////////	
		txtSearchBox = new JTextField();
		txtSearchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				connectdb data = new connectdb();
				
				try {
					String searchObject = txtSearchBox.getText();
					Connection con;
					con = (Connection) data.db_connect();
					java.sql.PreparedStatement clientStmt = con.prepareStatement("SELECT id_client as'#',nom as'Nom',prenom as 'Prénom',sexe as 'Sexe',age as 'Age',email as 'E-mail',phone as 'Telephone',pays_origine as 'Pays' FROM client WHERE "+filterSearch+" LIKE?");
					clientStmt.setString(1,"%"+ searchObject + "%");
					
					ResultSet rs = clientStmt.executeQuery();
					clientTable.setModel(DbUtils.resultSetToTableModel(rs));
				
				} catch (Exception e) {
					
					System.out.print(e);
				}
			}
		});
		txtSearchBox.setBounds(324, 36, 116, 22);
		contentPane.add(txtSearchBox);
		txtSearchBox.setColumns(10);
		
//////////////////////SearchBox////////////////////////////////////	
		 comboBoxSearchClient = new JComboBox();
		 comboBoxSearchClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object selected = comboBoxSearchClient.getSelectedItem();
				if(selected.toString().equals("Nom"))
					filterSearch = "nom";
				if(selected.toString().equals("Prénom"))
					filterSearch = "prenom";
				
			}
		});
             //////////////les menu du comboBoxSearch/////////////////////////////////
             comboBoxSearchClient.setModel(new DefaultComboBoxModel<String>(new String[]
	              	{"","Nom","Prénom"}
              ));
		 comboBoxSearchClient.setBounds(494, 36, 196, 22);
		contentPane.add(comboBoxSearchClient);
		
		JLabel lblSearch = new JLabel("");
		Image search=new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		lblSearch.setIcon(new ImageIcon(search));
		lblSearch.setBounds(292, 36, 36, 29);
		contentPane.add(lblSearch);
		
		JLabel lbl = new JLabel("Mon Paradis H\u00F4tel");
		lbl.setForeground(Color.BLUE);
		lbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbl.setBounds(354, 1, 215, 22);
		contentPane.add(lbl);
		
		
	 
	}	
		
		/////////////////Pour Afficher la base de donner////////////////////////////
	
	
	public static void showTableClient() {
		
		connectdb data = new connectdb();
		
		try {
			Connection con;
			con = (Connection) data.db_connect();
			java.sql.PreparedStatement clientStmt = con.prepareStatement("SELECT id_client as'#',nom as'Nom',prenom as 'Prénom',sexe as 'Sexe',age as 'Age',email as 'E-mail',phone as 'Telephone',pays_origine as 'Pays' FROM client");
			ResultSet rs = clientStmt.executeQuery();
			clientTable.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			
			System.out.print(e);
		}
		
	}
}
