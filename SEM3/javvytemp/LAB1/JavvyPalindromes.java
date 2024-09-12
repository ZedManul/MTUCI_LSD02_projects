package LAB1;
public class JavvyPalindromes {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String inputText = args[i].toLowerCase();
			if (inputText.equals(wordInverter(inputText))) { 
				System.out.println("\"" + inputText + "\" iz palindromme :)");
			} else {
				System.out.println("\"" + inputText + "\" iz palindromn't :(");
			}
		}
	}
	public static String wordInverter(String s) {
		String res = "";
		for (int i = s.length() - 1; i >=0; i--) {
			res+=s.substring(i, i+1);
		}
		return res;
	}
}