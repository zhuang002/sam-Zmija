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
			int row = r-i;
			apples[row][0] = line.indexOf("J");
			apples[row][1] = line.lastIndexOf("J");
		}
		
		int[] currentPos = {0,0};
		int keyPresses = 0;
		for (int i=0;i<r;i++) {
			keyPresses+=getKeyPressesOfCurrentLine(currentPos);
		}
		
		System.out.println(keyPresses);
		
	}
	
	private static int getKeyPressesOfCurrentLine(int[] currentPos) {
		// TODO Auto-generated method stub
		int[] targetPos = new int[2];
		int steps=0;
		if (currentPos[0] % 2 == 0) {
			if (currentPos[0]==apples.length-1) {
				targetPos[0]++;
				targetPos[1]=apples[currentPos[0]][1];
				steps = targetPos[1]-currentPos[1];
			} else {
				targetPos[0]++;
				targetPos[1]=Math.max(apples[currentPos[0]][1], apples[currentPos[0]+1][1]);
				steps = targetPos[1]-currentPos[1];
			}
		} else {
			if (currentPos[0]==apples.length-1) {
				targetPos[0]++;
				targetPos[1]=apples[currentPos[0]][0];
				steps = currentPos[1] - targetPos[1];
			} else {
				targetPos[0]++;
				targetPos[1]=Math.min(apples[currentPos[0]][0], apples[currentPos[0]+1][0]);
				steps = currentPos[1] - targetPos[1];
			}
		}
		
		currentPos[0] = targetPos[0];
		currentPos[1] = targetPos[1];
		
		if (currentPos[0]<apples.length-1)
			steps++;
		return steps;
	}

}
