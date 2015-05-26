import java.util.*;
public class Naval {

	private boolean bandera = false;
	private int[][] matriz = new int[7][7];
	private int barcos = 0;
	private boolean[][] marcados = new boolean[7][7];
	private boolean[][] marcados2 = new boolean[7][7];
		
	
	public void completar() {
		Random gen = new Random();
		int num1;
		int num2;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++){
				marcados[i][j] = false;
				marcados2[i][j] = false;
			}	
		}
		this.vaciar();
		for(int i = 0; i < 6;i++) {
			num1 = gen.nextInt(7);
			num2 = gen.nextInt(7);
			if (matriz[num1][num2] != 1) {
				matriz[num1][num2] = 1;
			}
			else i--;
		}
		barcos = 6;
	}
	public boolean bander() {
		return bandera;
	}
	public void bander2(boolean b) {
		bandera = b;
	}
	public boolean marc(int i, int j) {
		return marcados[i][j] == true;
	}
	public boolean marc2(int i, int j) {
		return marcados2[i][j] == true;
	}
	public void setMarc2(int i, int j, boolean b) {
		marcados2[i][j] = b;
	}
	public int getBarcos() {
		return barcos;
	}
	public void vaciar() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++){
				matriz[i][j] = 0;
			}	
		}
		barcos = 0;
	}
		
	public boolean probar(int i, int j) {
		if (matriz[i][j] == 1) {
			barcos--;
			marcados[i][j] = true;
			marcados2[i][j] = true;
			return true;
		}
		else {
			marcados2[i][j] = true;
			return false;
		}
		
	}
}

