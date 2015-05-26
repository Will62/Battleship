import java.awt.*;
import javax.swing.*;
public class Progreso extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Thread hilo;
	  Object objeto = new Object();
	  JLabel texto;
	  JProgressBar barra;
	  public Progreso() {
		    setLayout(new BorderLayout());
		    texto = new JLabel();
		    add(texto,BorderLayout.CENTER);
		    JPanel panelInferior = new JPanel();
		    barra = new JProgressBar();
		    panelInferior.setLayout(new GridLayout(0,1));
		    panelInferior.add(barra);
		    panelInferior.add(new JLabel("Chargement en cours..."));    
		    add(panelInferior,BorderLayout.SOUTH);
		    this.iniciaCuenta();
		    
	  } 
	  public void iniciaCuenta() {
		    if( hilo == null ) {
		      hilo = new ThreadCarga();
		      hilo.start();
		    }
	  }
	  class ThreadCarga extends Thread {
		    public void run() {
		        int min = 0;
		        int max = 100;
		        barra.setValue( min );
		        barra.setMinimum( min );
		        barra.setMaximum( max );
		        barra.setBackground(Color.black);
		        barra.setForeground(Color.blue);
			    for (int i=min; i <= max; i++ ) {
					barra.setValue( i );
					texto.setText( "                                " +
							"                              "+i +"%");
					synchronized( objeto ) {
						try {
							objeto.wait(15);
						} 
						catch( InterruptedException e ) {
						}
					}	
			    }
		        hilo = null;
		    }
	  }
}