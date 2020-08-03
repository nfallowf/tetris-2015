package application;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Nate Fallowfield
 */

public class Shapes extends Board{

	private Pane pane;
	ArrayList<Rectangle> r1 = new ArrayList<Rectangle>();
	ArrayList<Rectangle> r2 = new ArrayList<Rectangle>();
	ArrayList<Rectangle> r3 = new ArrayList<Rectangle>();
	ArrayList<Rectangle> r4 = new ArrayList<Rectangle>();
	final int WIDTH = 30, HEIGHT= 30;
	
	public Shapes(Pane root){
		pane = root;
		
	}
	
	//Creates a line shape
	public void line(int count){
		r1.add(new Rectangle());
		r2.add(new Rectangle());
		r3.add(new Rectangle());
		r4.add(new Rectangle());
		r1.get(count).setX(100);
		r1.get(count).setY(10);
		r1.get(count).setWidth(WIDTH);
		r1.get(count).setHeight(HEIGHT);
		r2.get(count).setX(130);
		r2.get(count).setY(10);
		r2.get(count).setWidth(WIDTH);
		r2.get(count).setHeight(HEIGHT);
		r3.get(count).setX(160);
		r3.get(count).setY(10);
		r3.get(count).setWidth(WIDTH);
		r3.get(count).setHeight(HEIGHT);
		r4.get(count).setX(190);
		r4.get(count).setY(10);
		r4.get(count).setWidth(WIDTH);
		r4.get(count).setHeight(HEIGHT);
		r1.get(count).setStroke(Color.BLACK);
		r1.get(count).setFill(Color.LIGHTBLUE);
		r2.get(count).setStroke(Color.BLACK);
		r2.get(count).setFill(Color.LIGHTBLUE);
		r3.get(count).setStroke(Color.BLACK);
		r3.get(count).setFill(Color.LIGHTBLUE);
		r4.get(count).setStroke(Color.BLACK);
		r4.get(count).setFill(Color.LIGHTBLUE);
		pane.getChildren().add(r1.get(count));
		pane.getChildren().add(r2.get(count));
		pane.getChildren().add(r3.get(count));
		pane.getChildren().add(r4.get(count));
		
	}
	//creates square shape	
	public void square(int count) {
		r1.add(new Rectangle());
		r2.add(new Rectangle());
		r3.add(new Rectangle());
		r4.add(new Rectangle());
		r1.get(count).setX(130);
		r1.get(count).setY(10);
		r1.get(count).setWidth(WIDTH);
		r1.get(count).setHeight(HEIGHT);
		r2.get(count).setX(160);
		r2.get(count).setY(10);
		r2.get(count).setWidth(WIDTH);
		r2.get(count).setHeight(HEIGHT);
		r3.get(count).setX(130);
		r3.get(count).setY(40);
		r3.get(count).setWidth(WIDTH);
		r3.get(count).setHeight(HEIGHT);
		r4.get(count).setX(160);
		r4.get(count).setY(40);
		r4.get(count).setWidth(WIDTH);
		r4.get(count).setHeight(HEIGHT);
		r1.get(count).setStroke(Color.BLACK);
		r1.get(count).setFill(Color.ORANGE);
		r2.get(count).setStroke(Color.BLACK);
		r2.get(count).setFill(Color.ORANGE);
		r3.get(count).setStroke(Color.BLACK);
		r3.get(count).setFill(Color.ORANGE);
		r4.get(count).setStroke(Color.BLACK);
		r4.get(count).setFill(Color.ORANGE);
		pane.getChildren().add(r1.get(count));
		pane.getChildren().add(r2.get(count));
		pane.getChildren().add(r3.get(count));
		pane.getChildren().add(r4.get(count));
	}
	
	
	//creates l shape
	public void lShape(int count){
		r1.add(new Rectangle());
		r2.add(new Rectangle());
		r3.add(new Rectangle());
		r4.add(new Rectangle());
		r1.get(count).setX(130);
		r1.get(count).setY(10);
		r1.get(count).setWidth(WIDTH);
		r1.get(count).setHeight(HEIGHT);
		r2.get(count).setX(130);
		r2.get(count).setY(40);
		r2.get(count).setWidth(WIDTH);
		r2.get(count).setHeight(HEIGHT);
		r3.get(count).setX(160);
		r3.get(count).setY(40);
		r3.get(count).setWidth(WIDTH);
		r3.get(count).setHeight(HEIGHT);
		r4.get(count).setX(190);
		r4.get(count).setY(40);
		r4.get(count).setWidth(WIDTH);
		r4.get(count).setHeight(HEIGHT);
		r1.get(count).setStroke(Color.BLACK);
		r1.get(count).setFill(Color.GREEN);
		r2.get(count).setStroke(Color.BLACK);
		r2.get(count).setFill(Color.GREEN);
		r3.get(count).setStroke(Color.BLACK);
		r3.get(count).setFill(Color.GREEN);
		r4.get(count).setStroke(Color.BLACK);
		r4.get(count).setFill(Color.GREEN);
		pane.getChildren().add(r1.get(count));
		pane.getChildren().add(r2.get(count));
		pane.getChildren().add(r3.get(count));
		pane.getChildren().add(r4.get(count));
	}
	
	//creates t shape
	public void tShape(int count){
		r1.add(new Rectangle());
		r2.add(new Rectangle());
		r3.add(new Rectangle());
		r4.add(new Rectangle());
		r1.get(count).setX(130);
		r1.get(count).setY(10);
		r1.get(count).setWidth(WIDTH);
		r1.get(count).setHeight(HEIGHT);
		r2.get(count).setX(160);
		r2.get(count).setY(10);
		r2.get(count).setWidth(WIDTH);
		r2.get(count).setHeight(HEIGHT);
		r3.get(count).setX(190);
		r3.get(count).setY(10);
		r3.get(count).setWidth(WIDTH);
		r3.get(count).setHeight(HEIGHT);
		r4.get(count).setX(160);
		r4.get(count).setY(40);
		r4.get(count).setWidth(WIDTH);
		r4.get(count).setHeight(HEIGHT);
		r1.get(count).setStroke(Color.BLACK);
		r1.get(count).setFill(Color.RED);
		r2.get(count).setStroke(Color.BLACK);
		r2.get(count).setFill(Color.RED);
		r3.get(count).setStroke(Color.BLACK);
		r3.get(count).setFill(Color.RED);
		r4.get(count).setStroke(Color.BLACK);
		r4.get(count).setFill(Color.RED);
		pane.getChildren().add(r1.get(count));
		pane.getChildren().add(r2.get(count));
		pane.getChildren().add(r3.get(count));
		pane.getChildren().add(r4.get(count));
	}
	
	//creates z shape
	public void zShape(int count){
		r1.add(new Rectangle());
		r2.add(new Rectangle());
		r3.add(new Rectangle());
		r4.add(new Rectangle());
		r1.get(count).setX(130);
		r1.get(count).setY(10);
		r1.get(count).setWidth(WIDTH);
		r1.get(count).setHeight(HEIGHT);
		r2.get(count).setX(160);
		r2.get(count).setY(10);
		r2.get(count).setWidth(WIDTH);
		r2.get(count).setHeight(HEIGHT);
		r3.get(count).setX(160);
		r3.get(count).setY(40);
		r3.get(count).setWidth(WIDTH);
		r3.get(count).setHeight(HEIGHT);
		r4.get(count).setX(190);
		r4.get(count).setY(40);
		r4.get(count).setWidth(WIDTH);
		r4.get(count).setHeight(HEIGHT);
		r1.get(count).setStroke(Color.BLACK);
		r1.get(count).setFill(Color.YELLOW);
		r2.get(count).setStroke(Color.BLACK);
		r2.get(count).setFill(Color.YELLOW);
		r3.get(count).setStroke(Color.BLACK);
		r3.get(count).setFill(Color.YELLOW);
		r4.get(count).setStroke(Color.BLACK);
		r4.get(count).setFill(Color.YELLOW);
		pane.getChildren().add(r1.get(count));
		pane.getChildren().add(r2.get(count));
		pane.getChildren().add(r3.get(count));
		pane.getChildren().add(r4.get(count));
	}
	
	
	//creates reverse z shape
	public void reverseZShape(int count){
		r1.add(new Rectangle());
		r2.add(new Rectangle());
		r3.add(new Rectangle());
		r4.add(new Rectangle());
		r1.get(count).setX(190);
		r1.get(count).setY(10);
		r1.get(count).setWidth(WIDTH);
		r1.get(count).setHeight(HEIGHT);
		r2.get(count).setX(160);
		r2.get(count).setY(10);
		r2.get(count).setWidth(WIDTH);
		r2.get(count).setHeight(HEIGHT);
		r3.get(count).setX(160);
		r3.get(count).setY(40);
		r3.get(count).setWidth(WIDTH);
		r3.get(count).setHeight(HEIGHT);
		r4.get(count).setX(130);
		r4.get(count).setY(40);
		r4.get(count).setWidth(WIDTH);
		r4.get(count).setHeight(HEIGHT);
		r1.get(count).setStroke(Color.BLACK);
		r1.get(count).setFill(Color.PURPLE);
		r2.get(count).setStroke(Color.BLACK);
		r2.get(count).setFill(Color.PURPLE);
		r3.get(count).setStroke(Color.BLACK);
		r3.get(count).setFill(Color.PURPLE);
		r4.get(count).setStroke(Color.BLACK);
		r4.get(count).setFill(Color.PURPLE);
		pane.getChildren().add(r1.get(count));
		pane.getChildren().add(r2.get(count));
		pane.getChildren().add(r3.get(count));
		pane.getChildren().add(r4.get(count));
	}
	
	
	//creates reverse l shape
	public void revereLShape(int count) {
		r1.add(new Rectangle());
		r2.add(new Rectangle());
		r3.add(new Rectangle());
		r4.add(new Rectangle());
		r1.get(count).setX(190);
		r1.get(count).setY(10);
		r1.get(count).setWidth(WIDTH);
		r1.get(count).setHeight(HEIGHT);
		r2.get(count).setX(190);
		r2.get(count).setY(40);
		r2.get(count).setWidth(WIDTH);
		r2.get(count).setHeight(HEIGHT);
		r3.get(count).setX(160);
		r3.get(count).setY(40);
		r3.get(count).setWidth(WIDTH);
		r3.get(count).setHeight(HEIGHT);
		r4.get(count).setX(130);
		r4.get(count).setY(40);
		r4.get(count).setWidth(WIDTH);
		r4.get(count).setHeight(HEIGHT);
		r1.get(count).setStroke(Color.BLACK);
		r1.get(count).setFill(Color.DARKBLUE);
		r2.get(count).setStroke(Color.BLACK);
		r2.get(count).setFill(Color.DARKBLUE);
		r3.get(count).setStroke(Color.BLACK);
		r3.get(count).setFill(Color.DARKBLUE);
		r4.get(count).setStroke(Color.BLACK);
		r4.get(count).setFill(Color.DARKBLUE);
		pane.getChildren().add(r1.get(count));
		pane.getChildren().add(r2.get(count));
		pane.getChildren().add(r3.get(count));
		pane.getChildren().add(r4.get(count));
	}
	
}
