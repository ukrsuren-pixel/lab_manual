import java.util.Scanner;
class PiCalculator {
    private double piValue;
    public void calculatePi(int terms) {
        piValue = 0.0;
        for (int i = 0; i < terms; i++) {
            if (i % 2 == 0)
                piValue += 4.0 / (2 * i + 1);
            else
                piValue -= 4.0 / (2 * i + 1);
        }
    }
    public void displayResult() {
        System.out.println("Public Method - Displaying Result:");
        System.out.println("Approximated value of Pi: " + piValue);
    }
    protected void displayPrecisionInfo(int terms) {
        System.out.println("\nProtected Method - Displaying Precision Info:");
        System.out.println("Precision used: " + terms + " terms");
        System.out.println("Series used: Leibniz Series (4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...)");
    }
    private void displayPrivateData() {
        System.out.println("\nPrivate Data - Accessed only within class:");
        System.out.println("Raw computed value (private): " + piValue);
    }
    public void showPrivateData() {
        displayPrivateData();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Pi Calculator using Access Specifiers ===");
        System.out.print("Enter the number of terms for Pi approximation: ");
        int terms = sc.nextInt();
        PiCalculator calculator = new PiCalculator();
        System.out.println("\nCalculating Pi using Leibniz Series...\n");
        calculator.calculatePi(terms);
        calculator.displayResult();
        calculator.displayPrecisionInfo(terms);
        calculator.showPrivateData();
        sc.close();
    }
}
