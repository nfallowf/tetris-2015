
package application;

//import java.awt.Insets;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * @author Nate Fallowfield
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
       
        Button btnStart = new Button("Start Game");
        btnStart.setOnAction(e -> {openMainWindow(stage); stage.hide(); }); //Opens Game Window
        Button btnClose = new Button("Close");
        btnClose.setOnAction(e -> stage.close());
        Button btnInstructions = new Button("Instructions");
        btnInstructions.setOnAction(e -> {instructions();});
        VBox pane = new VBox(); //Use Vertical box layout
        
        
        
        Image tetris = new Image("http://www.3dsview.com/wp-content/uploads/2011/06/tetris-logo.jpg");
        ImageView title = new ImageView(tetris);

        title.setFitHeight(100);
        title.setFitWidth(290);
        
        pane.setSpacing(50);
        btnStart.setPrefSize(200, 50);
        btnInstructions.setPrefSize(200, 50);
        btnClose.setPrefSize(200, 50);
        pane.getChildren().add(title);
        pane.getChildren().add(btnStart);
        pane.getChildren().add(btnInstructions);
        pane.getChildren().add(btnClose);
       
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        
        Scene scene = new Scene(pane,300,500);
        stage.setTitle("Welcome to Tetris");
        stage.setScene(scene);
        stage.show();
    }

    public void openMainWindow(Stage firstWindow) {
    	Board board = new Board();
    	board.start(firstWindow);
        
    }
   
    public void instructions(){
    	Pane pane = new Pane();
    	pane.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
    	Label controls = new Label();
    	controls.setText("Control Pieces Using The keyboard. "
    			+ "The left and right arrow moves the pieces left and right respectively. "
    			+ "The up arrow controls rotation,"
    			+ "the down arrow accelerates rate of descent.");
    	controls.setFont(Font.font("Cambria", 20));
    	controls.setPrefSize(250, 250);
    	controls.setWrapText(true);
    	controls.setScaleShape(true);
    	pane.getChildren().add(controls);
    	Stage stage2 = new Stage();
    	stage2.setTitle("Instructions");
    	stage2.setScene(new Scene(pane, 250,250));
    	stage2.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
