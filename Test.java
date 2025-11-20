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

        // Use SimpleMax to determine the larger circle (by area)
        Circle biggerCircle = (Circle) SimpleMax.findLarger(c1, c2);

        // Display radius and full description of the larger circle
        System.out.println("Bigger circle radius: " + biggerCircle.getRadius());
        System.out.println(biggerCircle);

        // Create two Rectangle objects with different dimensions
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(3, 6);

        // Use SimpleMax to determine the larger rectangle (by area)
        Rectangle biggerRectangle = (Rectangle) SimpleMax.findLarger(r1, r2);

        // Display area and full description of the larger rectangle
        System.out.println("Bigger rectangle area: " + biggerRectangle.getArea());
        System.out.println(biggerRectangle);
    }
}


/*
GeometricObject Class
Abstract base class for all shapes. Stores shared properties
(color + filled) and forces subclasses to implement area/perimeter.
*/
abstract class GeometricObject {

    private String color = "white";   // Default color of the shape
    private boolean filled = false;   // Indicates whether shape is filled

    public GeometricObject() {}

    // Constructor allowing color and filled status to be set
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Accessor and mutator methods
    public String getColor() { return color; }
    public boolean isFilled() { return filled; }

    public void setColor(String color) { this.color = color; }
    public void setFilled(boolean filled) { this.filled = filled; }

    // Abstract methods that all shapes must implement
    public abstract double getArea();
    public abstract double getPerimeter();
}


/*
Circle Class
Represents a circle, storing radius and providing formulas
for area and perimeter.
*/
class Circle extends GeometricObject {

    private double radius; // Radius of the circle

    // Constructor that sets radius
    public Circle(double radius) { this.radius = radius; }

    // Constructor that sets radius plus inherited fields
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() { return radius; }

    // Compute area of the circle
    @Override
    public double getArea() { return Math.PI * radius * radius; }

    // Compute perimeter (circumference)
    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }

    // Text description of this circle
    @Override
    public String toString() {
        return "Circle (radius = " + radius + ")";
    }
}


/*
Rectangle Class
Represents a rectangle with width and height, with formulas
for area and perimeter.
*/
class Rectangle extends GeometricObject {

    private double width;   // Rectangle width
    private double height;  // Rectangle height

    // Constructor for width and height
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Constructor with inherited fields included
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    // Compute rectangle area
    @Override
    public double getArea() { return width * height; }

    // Compute rectangle perimeter
    @Override
    public double getPerimeter() { return 2 * (width + height); }

    // Text description of this rectangle
    @Override
    public String toString() {
        return "Rectangle (" + width + " × " + height + ")";
    }
}


/*
SimpleMax Class
Provides a method to compare two GeometricObjects and
return the one with the larger area.
*/
class SimpleMax {

    // Returns 'a' if its area is greater/equal, otherwise 'b'
    public static GeometricObject findLarger(GeometricObject a, GeometricObject b) {
        return (a.getArea() >= b.getArea()) ? a : b;
    }
}
