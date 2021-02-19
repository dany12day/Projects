
public class Harta {
	private int harta[][] = new int[10][10];
	public Harta(int map[][]) {
		harta=map;
	}
	public int getValueFromPos(int x, int y) {
		return harta[x][y];
	}
	public void setValueAtPos(int x, int y, int z) {
		harta[x][y]=z;
	}
}
