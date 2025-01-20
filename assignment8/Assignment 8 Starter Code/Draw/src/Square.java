import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The Square class contains information about a square. It extends the GeometricObject class
 *
 * @author: Hamza Saleh,000887384
 */
// The Square class extends the GeometricObject class
public class Square extends GeometricObject {

    private double size;// The size of the square

    // The constructor for the Square class
    public Square(double x, double y, Color fillColor, double radius) {
        super(x, y, fillColor);
        this.size = radius;
    }

    // The draw method for the Square class
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillRect(getX() - size, getY() - size, size * 2, size * 2);
    }
}
