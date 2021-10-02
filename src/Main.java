import java.util.Scanner;

public class Main {

	static int[][] apples = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int s = sc.nextInt();
		apples = new int[r][2];
		sc.nextLine();
		
		for (int i=0;i<r;i++) {
			String line = sc.nextLine();
			int row = r-i-1;
			apples[row][0] = line.indexOf("J");
			apples[row][1] = line.lastIndexOf("J");
		}
		
		int[] currentPos = {0,0};
		int keyPresses = 0;
		while(currentPos!=null) {
			keyPresses+=getKeyPressesOfCurrentLine(currentPos);
			int[] nextPos = getNextPosition(currentPos);
			if (nextPos!=null)
				keyPresses+=Math.abs(nextPos[0]-currentPos[0])+Math.abs(nextPos[1]-currentPos[1]);
			currentPos=nextPos;
		}
		
		System.out.println(keyPresses);
		
	}
	
	private static int getKeyPressesOfCurrentLine(int[] currentPos) {
		// TODO Auto-generated method stub

		if (currentPos[0] % 2 == 0) {// direction is going to right
			if (apples[currentPos[0]][1]<0) { // current row does not have a right "J"
				return 0;
			}
			else { // current row has a right "J"
				int steps = apples[currentPos[0]][1]- currentPos[1];
				currentPos[1]=apples[currentPos[0]][1];
				return steps;
			}
			
		} else { // direction is going to left
			if (apples[currentPos[0]][0]<0) {
				// current row does not have the left "J"
				return 0;
			} else {
				// current row has a left "J"
				int step = currentPos[1]-apples[currentPos[0]][0];
				currentPos[1] = apples[currentPos[0]][0];
				return step;
			}
		}
		
		
	}
	
	private static int[] getNextPosition(int[] currentPos) {
		// TODO Auto-generated method stub
		int[] nextPos = new int[2];
		
		int row = currentPos[0]+1; // go to next row;
		while (row < apples.length) { // if the row in within the boundary
			if (apples[row][0]<0) {
				// the row does not have a "J"
				row++;
			} else {
				// the row has a "J"
				nextPos[0]=row;
				if (row %2 == 0) {
					// the nextPos row is going to right
					nextPos[1]=apples[row][0];
					return nextPos;
				} else {
					// the nextPos row is going to left
					nextPos[1]= apples[row][1];
					return nextPos;
				}
			}
		}
		
		return null;
	}

	

}
