import java.util.Scanner;
import java.util.Random;

public class ColorConvertor {

    static Scanner scanner;
    static Random random;

    public ColorConvertor() {
        scanner = new Scanner(System.in);
        random = new Random();
    }
    public static void main(String[] args) {
        new ColorConvertor().run();
    }

    private void run() {
        System.out.println("1. Exam Mode");
        System.out.println("2. Practise Mode");
        System.out.println("Give Index!");
        System.out.println();
        String option = scanner.nextLine().toUpperCase();
        if(option.equals("1")) {
            exam();
        } else if(option.equals("2")) {
            train();
        }
    }

    public static void train() {
        String correctAnswer = "";
        int redDen = random.nextInt(256);
        int greenDen = random.nextInt(256);
        int blueDen = random.nextInt(256);
        String redDenNew = toHex(redDen);
        String greenDenNew = toHex(greenDen);
        String blueDenNew = toHex(blueDen);

        String[] newDens = {redDenNew, greenDenNew, blueDenNew};

        for(int i=0; i < newDens.length; i++) {
            if(newDens[i].length() == 1) {
                newDens[i] += "0";
            }
        }

        // Adding hex values or red, green and blue to correct answer
        correctAnswer += "#";
        correctAnswer += toHex(redDen);
        correctAnswer += toHex(greenDen);
        correctAnswer += toHex(blueDen);

        System.out.println("Codiere die folgende Farbe zu Hex (Mit Hashtag):");
        System.out.println("Rot, Grün und Blau Attribute in Dezimal:");
        System.out.println("Rot: " + redDen);
        System.out.println("Grün: " + greenDen);
        System.out.println("Blau: " + blueDen);
        System.out.print("Ihre Antwort: ");
        String userAnswer = scanner.nextLine();

        if (isCorrect(userAnswer, correctAnswer)) {
            System.out.println();
            System.out.println("Korrekte Antwort!");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Leider, nicht die korrekte Antwort!");
            System.out.println();
        }
        printAnswer(userAnswer);
        printCorrAnswer(correctAnswer);
    }

    public static void exam() {
        String correctAnswer = "";
        System.out.print("Geben Sie den roten Anteil an: ");
        int redDen = Integer.parseInt(scanner.nextLine());
        System.out.print("Geben Sie den grünen Anteil an: ");
        int greenDen = Integer.parseInt(scanner.nextLine());
        System.out.print("Geben Sie den blauen Anteil an: ");
        int blueDen = Integer.parseInt(scanner.nextLine());
        String redDenNew = toHex(redDen);
        String greenDenNew = toHex(greenDen);
        String blueDenNew = toHex(blueDen);

        String[] newDens = {redDenNew, greenDenNew, blueDenNew};

        for(int i=0; i < newDens.length; i++) {
            if(newDens[i].length() == 1) {
                newDens[i] += "0";
            }
        }

        // Adding hex values or red, green and blue to correct answer
        correctAnswer += "#";
        correctAnswer += toHex(redDen);
        correctAnswer += toHex(greenDen);
        correctAnswer += toHex(blueDen);

        System.out.println("Rot, Grün und Blau Attribute in Dezimal:");
        System.out.println("Rot: " + redDen);
        System.out.println("Grün: " + greenDen);
        System.out.println("Blau: " + blueDen);

        printCorrAnswer(correctAnswer);
    }

    public static String toHex(int n) {
        return Integer.toHexString(n).toUpperCase();
    }

    public static boolean isCorrect(String userAns, String correctAns) {
        return userAns.equals(correctAns);
    }

    public static void printAnswer(String answer) {
        System.out.println("Ihre Antwort: " + answer);
    }

    public static void printCorrAnswer(String answer) {
        System.out.println("Antwort: " + answer);
    }
}
