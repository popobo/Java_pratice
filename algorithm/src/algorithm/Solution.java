package algorithm;

public class Solution {
	public String replaceSpace(StringBuffer str) {
        StringBuffer resultStr = new StringBuffer();
		int j = 0;
        for(int i = 0; i < str.length(); i++){
			if (' ' == str.charAt(i)) {
				resultStr.append("%20");
			}else {
				resultStr.append(str.charAt(i));
			}
        }
		return resultStr.toString();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		StringBuffer str = new StringBuffer("hello world");
		System.out.println(solution.replaceSpace(str));
	}
}
