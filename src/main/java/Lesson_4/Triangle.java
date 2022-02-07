package Lesson_4;

import lombok.*;

import java.text.DecimalFormat;

@Data
@NoArgsConstructor
public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String calculateArea() {
        checkSidesArePositive();
        checkValid();
        double p = ((a + b + c)/2);
        double i = (p * (p - a) * (p - b) * (p - c));
        double area = Math.sqrt(i);
//        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String result = String.format("%.3f", area);
        return result;
    }

    private void checkSidesArePositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("The sides must be positive");
        }
    }

    private void checkValid() {
        double max = Math.max(Math.max(a, b), c);
        if (max >= (a + b + c - max)) {
            throw new IllegalArgumentException("The any two sides must be greater than other side");
        }
    }
}
