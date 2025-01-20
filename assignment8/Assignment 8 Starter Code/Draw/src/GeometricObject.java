import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The parent class for Circle and Square.
 *
 * @author: Hamza Saleh,000887384
 */
// The GeometricObject class is an abstract class that implements the Drawable interface
public abstract class GeometricObject implements Drawable {

    private double x, y;// The x and y coordinates of the object
    private Color fillColor;// The fill color of the object

    // The constructor for the GeometricObject class
    public GeometricObject(double x, double y, Color fillColor) {
        this.x = x;
        this.y = y;
        this.fillColor = fillColor;
    }
    //the x getter
    public double getX() {
        return x;
    }

    //the y getter
    public double getY() {
        return y;
    }

    //the fill color getter
    public Color getFillColor() {
        return fillColor;
    }

}
