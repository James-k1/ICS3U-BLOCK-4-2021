package week1;

/**
 * Compound Assignment Statements - Shortcut assignment statements
 */
public class ExampleSix {
  public static void main(String[] args) {
    int x = 1;
    int y = 3;
    double z = 1;

    x = x + 1; // (x = 2) take x add 1 to it and assign it back to x
    y = y - 1; // (y = 2)
    x = x + 3; // (x = 5)

    x += 1; // equvilent to x = x + 1;
    y -= 1; // equvilent to y = y - 1;
    x += 3; // equvilent to x = x + 3;

    y = y / 2; // equvilent to y /= 2;
    z = z * 2; // equvilent to z *= 2;

    x++; // x += 1 and x = x + 1
    y--; // y -= 1 and y = y - 1

  }
}