import java.util.List;

public class CalculatorController {
    private CalculatorFrame view;

    public CalculatorController() {
        this.view = new CalculatorFrame();
    }


    public static int add(List<Integer> numbers) {
       return Calculator.add(numbers);
    }

    public static int subtract(List<Integer> numbers) {
        return Calculator.subtract(numbers);
    }

    public static int mod(int number, int number2) {
        return Calculator.modulus(number, number2);
    }

    public static double squareRoot(int number) {
        return Calculator.squareRoot(number);
    }

    public static double average(List<Integer> numbers){
        return Calculator.average(numbers);
    }

    public static boolean prime(int number) {
        return Calculator.prime(number);
    }
}