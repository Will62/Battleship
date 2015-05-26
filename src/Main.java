import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrame frame1 = new JFrame( "Chargement en cours" );
		Progreso p = new Progreso();
	    frame1.getContentPane().add(p);
	    frame1.setSize( 400,200);
	    frame1.setLocationRelativeTo(null);
	    frame1.setVisible( true );
	    final Ventana v = new Ventana();
	    final JFrame frame;
		final JTextField jug1 = new JTextField("");
		final JTextField jug2 = new JTextField("");
		final JButton ingresar = new JButton("Accepter");
		final JLabel juga1 = new JLabel("Joueur 1 :");
		final JLabel juga2 = new JLabel("Joueur 2 :");
		final JLabel errorIngreso = new JLabel();
		frame = new JFrame("Registration...");
		frame.setSize( 400,200);
		
		frame.setResizable(false);
		jug1.setBounds(50, 50, 145, 25);
		jug2.setBounds(205, 50, 145, 25);
		juga1.setBounds(50, 20, 100, 30);
		juga2.setBounds(205, 20, 100, 30);
		frame.getContentPane().add(jug1);
		frame.getContentPane().add(jug2);
		frame.getContentPane().add(juga1);
		frame.getContentPane().add(juga2);
		errorIngreso.setBounds(140, 135, 250, 30);
		frame.getContentPane().add(errorIngreso);
		ingresar.setBounds(155, 90, 90,40 );
		final Naval n = new Naval();
		ingresar.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				
				if ((!jug1.getText().equals("")) && (!jug2.getText().equals(""))) {
					v.mensajeBarcos.setText("Appuyez sur Start pour commencer le jeu");
					//v.mensajeBarcos2.setText("Pour commencer le jeu");
					if (v.maquina.isEnabled()) {
						v.dosPlayers.setEnabled(false);
						v.dosPlayers.setVisible(true);
						v.maquina.setVisible(false);
					}
					else {
						v.dosPlayers.setVisible(false);
						v.maquina.setEnabled(false);
						v.maquina.setVisible(true);
					}
					String s1 = jug1.getText();
					String s2 = jug2.getText();
					v.completar.setEnabled(true);
					frame.setVisible(false);
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					v.jugador1.setText("Joueur 1 : " + s1);
					v.jugador2.setText("Joueur 2 : " + s2);
					v.j1.setText(s1);
					v.j2.setText(s2);
					errorIngreso.setText(null);
				}
				else
					errorIngreso.setText("Entrez les noms");
			}
		});
		v.salir.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				frame.dispose();
				v.frame.dispose();
			}
		});
		v.maquina.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				jug2.setText("Ordinateur");
				errorIngreso.setText("S'il vous plaît, entrez un nom");
				jug2.setEnabled(false);
				frame.setVisible(true);
			}
		});
		v.cambiarJ.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				jug1.setText(null);
				jug2.setText(null);
				if (!v.maquina.isEnabled()) {
					jug2.setText("Ordinateur");
				}
				frame.setVisible(true);
			}
		});
		v.dosPlayers.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed (java.awt.event.ActionEvent  evt) {
				jug2.setEnabled(true);
				jug1.setText(null);
				jug2.setText(null);
				v.vaciar.doClick();
				frame.setVisible(true);
			}
		});
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(ingresar);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
	    synchronized( v ) {
			try {
				v.wait( 1500 );
				frame1.dispose();
				String s1 = jug1.getText();
				v.completar.setEnabled(true);
				String s2 = jug2.getText();
				frame.setVisible(false);
				if (n.bander()==false)
					v.start();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				n.bander2(true);
				v.jugador1.setText("Joueur 1 : " + s1);
				v.jugador2.setText("Joueur 2 : " + s2);
				v.j1.setText(s1);
				v.j2.setText(s2);
				errorIngreso.setText(null);
			} 
			catch( InterruptedException e ) {
			}
		}
	}    
}