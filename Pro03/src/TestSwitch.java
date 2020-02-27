
public class TestSwitch {
	public static void main(String[] args) {
		int choice = 1;
		String day = "Monday";
		// java1.7后switch可以使用字符串
		switch (day) {
		case "Monday":
			System.out.println("1");
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + choice );
		}
	}
}
