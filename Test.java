/*
Name: Test.java
Purpose: Test program for GeometricObject, Circle, Rectangle, and SimpleMax.
Programmer: Alex Kurcan
Date: 11/20/2025
*/

public class Test {
    public static void main(String[] args) {

        // Create two Circle objects with different radii
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(4);

        // Use SimpleMax to determine which circle is larger (based on area)
        Circle biggerCircle = (Circle) SimpleMax.findLarger(c1, c2);

        // Output the radius of the larger circle
        System.out.println("Bigger circle radius: " + biggerCircle.getRadius());

        // Print the larger circle's description (uses toString())
        System.out.println(biggerCircle);


        // Create two Rectangle objects with different dimensions
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(3, 6);

        // Use SimpleMax to determine which rectangle is larger (based on area)
        Rectangle biggerRectangle = (Rectangle) SimpleMax.findLarger(r1, r2);

        // Output the area of the larger rectangle
        System.out.println("Bigger rectangle area: " + biggerRectangle.getArea());

        // Print the larger rectangle's description (uses toString())
        System.out.println(biggerRectangle);
    }
}

// Abstract base class for all geometric objects
abstract class GeometricObject {
    private String color;      // Color of the object
    private boolean filled;    // Whether the object is filled or hollow

    // Default constructor initializes to a white, unfilled object
    public GeometricObject() {
        this.color = "white";
        this.filled = false;
    }

    // Constructor allowing user-defined color and filled state
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Returns the object's color
    public String getColor() {
        return color;
    }

    // Sets the object's color
    public void setColor(String color) {
        this.color = color;
    }

    // Returns whether the object is filled
    public boolean isFilled() {
        return filled;
    }

    // Sets whether the object is filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
