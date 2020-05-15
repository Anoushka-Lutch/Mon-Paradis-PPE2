package sa2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class AppGestion extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGestion frame = new AppGestion("role", "nom");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param myname
	 * @param privilege
	 */
	public AppGestion(String priviledge, String myname) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestion = new JLabel("GESTION");
		lblGestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGestion.setBounds(309, 69, 80, 16);
		contentPane.add(lblGestion);
		
		JLabel lblHotel = new JLabel("Mon Paradis H\u00F4tel");
		lblHotel.setForeground(Color.BLUE);
		lblHotel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblHotel.setBounds(270, 34, 215, 22);
		contentPane.add(lblHotel);
//////////////////Deconnexion //////////
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setIcon(new ImageIcon("C:\\Eclipse\\SA2\\image\\logout.png"));
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDeconnexion.setForeground(Color.RED);
		btnDeconnexion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDeconnexion.setBounds(268, 387, 148, 40);
		contentPane.add(btnDeconnexion);
			

//////////////////Reservation//////////
		JButton btnReservation = new JButton("Reservation");
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterReservation reservation = new InterReservation();
				reservation.showTableReservation();
				reservation.setVisible(true);
			}
		});
		btnReservation.setForeground(Color.BLACK);
		btnReservation.setBackground(Color.LIGHT_GRAY);
		btnReservation.setBounds(121, 123, 115, 40);
		
//////////////////Client //////////
		JButton btnClient = new JButton("Client");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterClient client = new InterClient();
				client.showTableClient();
				client.setVisible(true);
			}
		});
		btnClient.setForeground(Color.BLACK);
		btnClient.setBackground(Color.LIGHT_GRAY);
		btnClient.setBounds(121, 310, 115, 40);
		
//////////////////Chambre//////////
		JButton btnChambres = new JButton("Chambres");
		btnChambres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				interfaceChambre chambre = new interfaceChambre();
				chambre.showTableChambre();
				chambre.setVisible(true);
			}
		});
		btnChambres.setForeground(Color.BLACK);
		btnChambres.setBackground(Color.LIGHT_GRAY);
		btnChambres.setBounds(433, 122, 115, 40);
		
		
//////////////////Utilisateur//////////
		JButton btnUtilisateur = new JButton("Utilisateur");
		btnUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserInterface user = new UserInterface();
				user.showTableUser();
				user.setVisible(true);
			}
		});
		btnUtilisateur.setForeground(Color.BLACK);
		btnUtilisateur.setBackground(Color.LIGHT_GRAY);
		btnUtilisateur.setBounds(433, 310, 115, 40);
		
		
		System.out.print(priviledge);
		System.out.print(myname);
		
	//////////////////	interface que pour voir le user ou administateur //////////
		try { if (priviledge.equals("Administrateur")) {
			
			contentPane.add(btnReservation);
			contentPane.add(btnClient);
			contentPane.add(btnChambres);
			contentPane.add(btnUtilisateur);
			
		} else if (priviledge.equals("Gestionnaire")) {
			
			contentPane.add(btnReservation);
			contentPane.add(btnClient);
			contentPane.add(btnChambres);
			
		}else {
			JOptionPane.showMessageDialog(null,"Il ya une erreur");
		}
		
		} catch(Exception e) {
			
			System.out.print(e);
		}
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setIcon(new ImageIcon("C:\\users\\user\\git\\SA2\\SA2\\image\\admin.jpg"));
		lblPhoto.setForeground(Color.WHITE);
		lblPhoto.setBounds(0, 0, 748, 468);
		contentPane.add(lblPhoto);
		
	}
	
	
}
