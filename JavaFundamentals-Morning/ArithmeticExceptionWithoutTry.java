import java.util.*;

class ArithmeticExceptionWithoutTry {

	public static void main(String[] args) throws ArithmeticException
{
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the dividend");
    int dividend = scanner.nextInt();
    System.out.println("Enter the divisor");
    int divisor = scanner.nextInt();
    System.out.println("Result: " + (dividend / divisor));
    throw new ArithmeticException("Division by Zero");
}
}