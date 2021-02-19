
public class Labirint {
	int nPasi=0;
	private Harta harta = new Harta(new int[][]{
			{1,1,0,1,0,0,1,0,0,1},
			{0,1,0,1,1,1,1,1,1,1},
			{0,1,1,0,1,0,1,0,1,0},
			{0,1,0,0,1,0,1,0,1,0},
			{1,1,1,1,1,1,1,0,1,1},
			{0,1,0,0,0,0,1,0,1,0},
			{0,1,0,1,1,1,0,0,1,0},
			{0,1,0,1,0,1,1,1,1,1},
			{1,1,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,1},
				});
	public int getValueFromPos(int x, int y) {
		return harta.getValueFromPos(x, y);
	}
	public void setValueAtPos(int x, int y, int z) {
		harta.setValueAtPos(x, y, z);
	}
	public String toString() {
		String s="";
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				s=s+harta.getValueFromPos(i, j)+" ";
			}
			s=s+"\n";
		}
		return s;
	}
	public int solve() {
		int i=0;
		int j=0;
		int min1,min2,min3,min4;
		System.out.println(this.toString());
		while(i!=9 || j!=9) {
			nPasi++;
			min1=99999;
			min2=99999;
			min3=99999;
			min4=99999;
			harta.setValueAtPos(i, j, harta.getValueFromPos(i, j)+1);
			System.out.println(this.toString());
			if(j+1<10 && harta.getValueFromPos(i, j+1)!=0 && harta.getValueFromPos(i, j+1)<harta.getValueFromPos(i, j)) {
				min1=harta.getValueFromPos(i, j+1);
			}
			if(i+1<10 && harta.getValueFromPos(i+1, j)!=0 && harta.getValueFromPos(i+1, j)<harta.getValueFromPos(i, j)) {
				min2=harta.getValueFromPos(i+1, j);
			}
			if(j-1>-1 && harta.getValueFromPos(i, j-1)!=0 && harta.getValueFromPos(i, j-1)<harta.getValueFromPos(i, j)) {
				min3=harta.getValueFromPos(i, j-1);
			}
			if(i-1>-1 && harta.getValueFromPos(i-1, j)!=0 && harta.getValueFromPos(i-1, j)<harta.getValueFromPos(i, j)) {
				min4=harta.getValueFromPos(i-1, j);
			}
			if(min1<=min2 && min1<=min3 && min1<=min4 && min1!=99999) {
				j++;
				continue;
			}
			if(min2<=min1 && min2<=min3 && min2<=min4 && min2!=99999) {
				i++;
				continue;
			}
			if(min3<=min1 && min3<=min2 && min3<=min4 && min3!=99999) {
				j--;
				continue;
			}
			if(min4<=min1 && min4<=min2 && min4<=min3 && min4!=99999) {
				i--;
				continue;
			}
		}
		harta.setValueAtPos(i, j, harta.getValueFromPos(i, j)+1);
		System.out.println(this.toString());
		System.out.println("i="+i+" j="+j);
		System.out.println(nPasi);
		return 0;
	}
}
