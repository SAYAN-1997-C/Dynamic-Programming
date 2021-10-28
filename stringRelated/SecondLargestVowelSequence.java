package stringRelated;

public class SecondLargestVowelSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "continious";
		System.out.println(longestVowel(s));
	}

	static boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	static int longestVowel(String str) {
		int count = 0, res = 0,res1=0;
		char[] s = str.toCharArray();

		for (int i = 0; i < s.length; i++) {

			if (isVowel(s[i]))
				count++;

			else {
				res1=Math.min(res, count);
				res = Math.max(res, count);
				count = 0;
			}
		}
		return res1;
	}

}
