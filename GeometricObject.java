/*
Name: GeometricObject.java
Purpose: Base class for geometric shapes like Circle and Rectangle.
Programmer: Alex Kurcan
Date: 11/20/2025
*/


/* 
GeometricObject Class
This is an abstract "base class" for all shapes.
It holds simple properties (color + filled) and requires
each shape to provide its own getArea() and getPerimeter().
 */
public abstract class GeometricObject {

    // The color of the shape (for example: "red", "blue")
    private String color;

    // Whether the shape is filled (true) or not (false)
    private boolean filled;

    // Default constructor: sets color to white and filled to false
    public GeometricObject() {
        color = "white";
        filled = false;
    }

    // Constructor that lets you set the color and filled values
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Returns the current color
    public String getColor() {
        return color;
    }

    // Returns whether the shape is filled
    public boolean isFilled() {
        return filled;
    }

    // Sets a new color
    public void setColor(String color) {
        this.color = color;
    }

    // Sets a new filled value
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Abstract methods: subclasses MUST define these
    public abstract double getArea();
    public abstract double getPerimeter();
}


/* 
Circle Class
A simple circle that extends GeometricObject.
It adds: radius, area formula, perimeter formula.
*/
class Circle extends GeometricObject {

    // The radius of the circle
    private double radius;

    // Constructor that only sets the radius
    public Circle(double radius) {
        super(); // Calls the parent default constructor
        this.radius = radius;
    }

    // Constructor that sets radius, color, and filled
    public Circle(double radius, String color, boolean filled) {
        super(color, filled); // Calls parent constructor with color + filled
        this.radius = radius;
    }

    // Returns the circle's radius
    public double getRadius() {
        return radius;
    }

    // Sets a new radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Returns the area using A = πr²
    @Override
    public double getArea() {
        return 3.14159 * radius * radius;
    }

    // Returns the perimeter (circumference) using 2πr
    @Override
    public double getPerimeter() {
        return 2 * 3.14159 * radius;
    }

    // Returns a string version of the circle
    @Override
    public String toString() {
        return "Circle with radius = " + radius;
    }
}


/* 
Rectangle Class
A simple rectangle with width and height.
*/
class Rectangle extends GeometricObject {

    // The width of the rectangle
    private double width;

    // The height of the rectangle
    private double height;

    // Constructor that sets width and height
    public Rectangle(double width, double height) {
        super(); // Calls default GeometricObject constructor
        this.width = width;
        this.height = height;
    }

    // Constructor that also allows setting color and filled
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    // Returns the width
    public double getWidth() {
        return width;
    }

    // Returns the height
    public double getHeight() {
        return height;
    }

    // Sets a new width
    public void setWidth(double width) {
        this.width = width;
    }

    // Sets a new height
    public void setHeight(double height) {
        this.height = height;
    }

    // Returns the area using A = width × height
    @Override
    public double getArea() {
        return width * height;
    }

    // Returns perimeter using 2 × (width + height)
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Returns a string describing the rectangle
    @Override
    public String toString() {
        return "Rectangle with width = " + width + " and height = " + height;
    }
}


/*
   SimpleMax Class
   A helper class to compare two GeometricObject objects
   and return the one with the larger area.
 */
class SimpleMax {

    // Returns whichever object has the larger area
    public static GeometricObject findLarger(GeometricObject a, GeometricObject b) {
        if (a.getArea() > b.getArea()) {
            return a;
        } else {
            return b;
        }
    }
}
