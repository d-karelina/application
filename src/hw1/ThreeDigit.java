package hw1;

public class ThreeDigit {
    public static void main(String[] args) {
        int threeDigit = 465 ;
        System.out.println(threeDigit / 100 + (threeDigit % 100) / 10 + (threeDigit % 100) % 10 );
    }
}
