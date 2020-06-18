import java.util.*;
class rev {
	public static String revstr(String str3) {
		int len1 = str3.length();
		String str4 = "";
		for (int i = 0;i < len1;i++) {
			str4 = str4.charAt(i) + str4;
		}
		return str4;

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String str1 ="";
		int len = str.length();
		
	}
}

	