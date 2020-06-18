import java.util.*;
class rec {
	public static int power(int x,int y) {
		if (y > 0) {
                return  x * power(x, y- 1);
            } else {
                return 1;
            }
        }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int t = sc.nextInt();
		System.out.println(power(s,t));
	}
}