package allAlgos;

public class TowerOfHanoi {
	//The following main method is for Tower of Hanoi assignment 2
	public static void main(String[] args) {
		for (int n = 2;;n *= 2) {
			//uncomment the following line along with 
			//the print statements inside the towerOfHanoi method to test if code works.
			//Also comment out the infinite for loop along with it's ending bracket.
			//int n = 4;
			long start = System.nanoTime();
			towerOfHanoi(n, 'A', 'B', 'C');
			long finish = System.nanoTime() - start;
			System.out.println("Time (n = " + n + "): " + finish + " ns");
		}
	}
	
    public static void towerOfHanoi(int n, char firstTower, char secondTower, char thirdTower) {
        if (n == 1) {
        	//Uncomment the following to see if code works.
            //System.out.println("Move disk 1 from rod " + firstTower + " to rod " + thirdTower);
            return;
        }
        towerOfHanoi(n-1, firstTower, thirdTower, secondTower);
        //Uncomment the following to see if code works.
        //System.out.println("Move disk " + n + " from rod " + firstTower + " to rod " + thirdTower);
        towerOfHanoi(n-1, secondTower, firstTower, thirdTower);
    }
}
