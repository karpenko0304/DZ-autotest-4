import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double p = (a + b + c)/2;

    public boolean isValid() {
        int maxSide = Math.max(a, Math.max(b, c));
        return maxSide < (a + b + c - maxSide);
    }

    public boolean hasPositiveSides() {
        return a > 0 && b > 0 && c > 0;
    }

    public int countArea() {
        if (!hasPositiveSides()) {
            throw new IllegalArgumentException("The sides must be positive");
        }
        if (!isValid()) {
            throw new IllegalArgumentException("The triangle must be valid");
        }
        return (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}