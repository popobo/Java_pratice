
public class TestSwitch {
	public static void main(String[] args) {
		int choice = 1;
		String day = "Monday";
		// java1.7��switch����ʹ���ַ���
		switch (day) {
		case "Monday":
			System.out.println("1");
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + choice );
		}
	}
}
