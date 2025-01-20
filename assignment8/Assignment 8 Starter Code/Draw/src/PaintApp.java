import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

/**
 * Expand this FXGUITemplate into your own Paint app. Don't forget to
 * comment according to course commenting standards.
 *
 * @author Hamza Saleh,000887384
 */
    //this is the paint app class that extends the application class
public class PaintApp extends Application {

    // TODO: Instance Variables for View Components and Model
    private ArrayList<GeometricObject> shapes;//the array list of shapes
    private TextField tf1,tf2,tf3,tf4,tf5,tf6;//the text fields
    private Button btn1,btn2, btn3,btn4,btn5;//the buttons
    private Label lb1, lb2, lb3, lb4, lb5, lb6,errorMessage;//the labels
    private Canvas canvas;//the canvas
    private GraphicsContext gc;//the graphics context
    private String shapeMessage="";//the shape message


    // TODO: Private Event Handlers and Helper Methods

    //the private getSize method
    private Double getSize(){
        try {
            double size = Double.parseDouble(tf6.getText());
            if (size <= 0) {
                throw new IllegalArgumentException("Bad size value" + size +". Size must be greater than 0.");//the exception
            }


            return size;
        //the catch blocks for the exceptions NumberFormatException and IllegalArgumentException
        }catch (NumberFormatException e){
            errorMessage.setText(e.getMessage()+" please enter a number for size");
            errorMessage.setTextFill(Color.RED);
         }catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());
            errorMessage.setTextFill(Color.RED);
        }
         return 0.0; //the return statement
    }

    //the private color method that returns a color
    private Color color(){
        try{
        int red = Integer.parseInt(tf3.getText());//the red color
        int green = Integer.parseInt(tf4.getText());//the green color
        int blue = Integer.parseInt(tf5.getText());//the blue color

            //the if statements for the exceptions
            if (red< 0  || red > 255) {
                throw new IllegalArgumentException(" Bad color value '" + red + "'. colors must in the range of 0-255.");
            }
            if (green < 0  || green > 255) {
                throw new IllegalArgumentException(" Bad color value '" + green + "'. colors must in the range of 0-255.");
            }
            if (blue < 0 || blue > 255) {
                throw new IllegalArgumentException(" Bad color value '" + blue + "'. colors must in the range of 0-255.");

            }

            return Color.rgb(red,green,blue); //the return statement for the color
        }
        //the catch blocks for the exceptions NumberFormatException and IllegalArgumentException
        catch (NumberFormatException e){
            errorMessage.setText(e.getMessage() +" please enter an integer number");
            errorMessage.setTextFill(Color.RED);
        } catch (IllegalArgumentException e){
            errorMessage.setText(e.getMessage());


        }return Color.TRANSPARENT;//the return statement for the color
    }

    //the private mouseAction method that takes a MouseEvent as a parameter
    private void mouseAction(MouseEvent e){
        if (shapeMessage.equals("circle")){
            double x = e.getX();
            double y = e.getY();
            double size = getSize();
            Color color = color();
            Circle circle = new Circle(x,y,color,size);
            shapes.add(circle);
            circle.draw(gc);
        }else if (shapeMessage.equals("square")){
            double x = e.getX();
            double y = e.getY();
            double size = getSize();
            Color color = color();
            Square square = new Square(x,y,color,size);
            shapes.add(square);
            square.draw(gc);
        }
    }

    //the private mouseAction2 method that takes a MouseEvent as a parameter
    private void mouseAction2 (MouseEvent e){
        if (shapeMessage.equals("circle")){
            double x = e.getX();
            double y = e.getY();
            double size = getSize();
            Color color = color();
            Circle circle = new Circle(x,y,color,size);
            shapes.add(circle);
            circle.draw(gc);
        }else if (shapeMessage.equals("square")){
            double x = e.getX();
            double y = e.getY();
            double size = getSize();
            Color color = color();
            Square square = new Square(x,y,color,size);
            shapes.add(square);
            square.draw(gc);
        }
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 620); // set the size here
        stage.setTitle("painting app"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model
        shapes = new ArrayList<>(); //the array list of shapes is initialized
        // 2. Create the GUI components
        errorMessage = new Label("  no Error"); //the error message is initialized

        btn1= new Button("circle"); //the button for circle is initialized
        btn2= new Button("square");//the button for square is initialized
        btn3 =new Button("draw");//the button for draw is initialized
        btn4 =new Button("undraw");//the button for undraw is initialized
        btn5 =new Button("clear");//the button for clear is initialized



        tf1 = new TextField("100");//the text field for x coordinate is initialized
        tf2 = new TextField("100");//the text field for y coordinate is initialized
        tf3 = new TextField("100");//the text field for red is initialized
        tf4 = new TextField("100");//the text field for green is initialized
        tf5 = new TextField("100");//the text field for blue is initialized
        tf6 = new TextField("40");//the text field for size is initialized

        lb1= new Label("x-coordinates");//the label for x coordinate is initialized
        lb2= new Label("y-coordinates");//the label for y coordinate is initialized
        lb3= new Label("red");//the label for red is initialized
        lb4= new Label("green");//the label for green is initialized
        lb5= new Label("blue");//the label for blue is initialized
        lb6= new Label("size");//the label for size is initialized

        canvas = new Canvas(600,500);//the canvas is initialized
        gc = canvas.getGraphicsContext2D();//the graphics context is initialized
        gc.setFill(Color.BLACK);//the fill color is set to white
        gc.fillRect(0,0,600,500);//the rectangle is filled with the fill color



        // 3. Add components to the root
        //the components are added to the root
        root.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,tf1,tf2,tf3,tf4,tf5,tf6,lb1,lb2,lb3,lb4,lb5,lb6,canvas, errorMessage);
        // 4. Configure the components (colors, fonts, size, location)
        errorMessage.relocate(270,510);//the error message is relocated

        //the buttons are relocated
        btn1.relocate(170,530);
        btn2.relocate(220,530);
        btn3.relocate(280,530);
        btn4.relocate(330,530);
        btn5.relocate(390,530);

        //the text fields are relocated
        tf1.relocate(10,580);
        tf2.relocate(110,580);
        tf3.relocate(210,580);
        tf4.relocate(310,580);
        tf5.relocate(410,580);
        tf6.relocate(510,580);

        //the labels are relocated
        lb1.relocate(10,560);
        lb2.relocate(110,560);
        lb3.relocate(210,560);
        lb4.relocate(310,560);
        lb5.relocate(410,560);
        lb6.relocate(510,560);

        //the canvas is relocated
        canvas.relocate(0,0);
        // 5. Add Event Handlers and do final setup

        // the second button is clicked the shape message is set to square
        btn2.setOnAction(event -> {
            shapeMessage = "square";
            errorMessage.setText("click on canvas to draw the square");;
            errorMessage.setTextFill(Color.GREEN);

        });

        //the first button is clicked the shape message is set to circle
        btn1.setOnAction(event -> {
            shapeMessage = "circle";
            errorMessage.setText("click on canvas to draw the circle");;
            errorMessage.setTextFill(Color.GREEN);
        });

        //the third button (draw) is clicked the draw method is called
        btn3.setOnAction(event -> {
            try{
                double y = Double.parseDouble(tf2.getText()) ;
                double x = Double.parseDouble(tf1.getText());
                double size = getSize();
                Color fillColor = color();
                if (shapeMessage.equals("circle")){
                    double radius = size;
                    Circle circle = new Circle(x,y,fillColor,radius);
                    shapes.add(circle);
                    circle.draw(gc);
                } else if (shapeMessage.equals("square")) {
                    Square square =new Square(x,y,fillColor,size);
                    shapes.add(square);
                    square.draw(gc);
                } if (y > 500.0 || y < 0.0){
                    throw new IllegalArgumentException("Bad y value" + y +"  y must be in the range of 0-500.");//the exception is thrown if the y value is not in the range
                } else if (x > 600.0 || x < 0.0){
                    throw new IllegalArgumentException("Bad x value" + x +" x must be in the range of 0-600.");//the exception is thrown if the x value is not in the range
                }


            //the catch block catches the exceptions and displays the error message
            }catch (NumberFormatException e){
                errorMessage.setText(e.getMessage()+" is invalid, please enter a number");
                errorMessage.setTextFill(Color.RED);
            } catch (IllegalArgumentException e){
                errorMessage.setText(e.getMessage());
                errorMessage.setTextFill(Color.RED);
                ;


            }

        });

        //the fourth button (undraw) is clicked the last shape is removed from the array list and the canvas is cleared
        btn4.setOnAction(event -> {
            if (shapes.size() > 0){
                shapes.remove(shapes.size()-1);
                gc.clearRect(0,0,600,500);

                gc.setFill(Color.BLACK);
                gc.fillRect(0,0,600,500);

                for(GeometricObject z: shapes){
                    z.draw(gc);
                }

            }

        });
        //the fifth button (clear) is clicked the array list is cleared and the canvas is cleared
        btn5.setOnAction(event -> {
            shapes.clear();
            gc.clearRect(0,0,600,500);

            gc.setFill(Color.BLACK);
            gc.fillRect(0,0,600,500);

        });

        //the mouse is pressed the mouse action method is called
        canvas.addEventFilter(MouseEvent.MOUSE_PRESSED,this::mouseAction);

        //the mouse is dragged the mouse action 2 method is called
        canvas.addEventFilter(MouseEvent.MOUSE_DRAGGED,this::mouseAction2);



        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
