package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * @author Nate Fallowfield
 */

public class Board extends Application{

	final int BOARD_HEIGHT= 20; //Number of horizontal rows in grid
	final int BOARD_WIDTH = 11; //Number of vertical columns in grid
	int[][] board = new int[BOARD_WIDTH][BOARD_HEIGHT]; //creates grid
	int[] curX = new int[4]; //X coordinates for 4 pieces of each block
	int[] curY = new int[4]; //Y coordinates for 4 pieces of each block
	boolean pieceFall = true; //makes piece fall
	int rnd; //random number
	private int counter = 0; //number of shape spawned, index within arraylist
	Timeline timeline; //timer
	private int rotateCount; //number of times piece has been rotated
	int locationY = 0; //Y location of line cleared.
	Stage stage2 = new Stage();
	Stage firstWindow;
	Label score = new Label();
	private int playerScore = 0;
	
	@Override
	public void start(Stage Window)  {
		firstWindow = Window;
	    Button btnClose2 = new Button("Click to Return to Window 1");
	    btnClose2.setOnAction(e ->{stage2.close(); firstWindow.show();});
	    FlowPane flow = new FlowPane();
	    Pane pane = new Pane(); 
	    pane.setPadding(new Insets(10,10,20,20));
	    drawBoard(pane);
	    Pane pane2 = new Pane();
	    flow.getChildren().add(pane);
	    flow.getChildren().add(pane2);
	    pane2.getChildren().add(new Label("Score: "));
	    pane2.getChildren().add(score);
	    score.setTranslateX(50);
	    score.setText(String.valueOf(playerScore));
	    Scene scene = new Scene(flow,450,620);
	    stage2.setTitle("Tetris");
	    stage2.setScene(scene);
	    stage2.show();
	    
	    Shapes shape = new Shapes(pane);
	    drawShape(pane, shape);
	}
	
	//Draws playing area
	public void drawBoard(Pane root){
		Rectangle boardR = new Rectangle(10,10, 302,602);
		boardR.setFill(null);
		boardR.setStroke(Color.BLACK);
		root.getChildren().add(boardR);
	}
	
	//Draw random shape
	public void drawShape(Pane root, Shapes shape){
		rnd = (int)(7*Math.random() + 1); //random number between 1 and 7 to determine shape
		if (rnd == 1){
			curX[0] = 3;
			curX[1] = 4;
			curX[2] = 5;
			curX[3] = 6;
			curY[0] = 0;
			curY[1] = 0;
			curY[2] = 0;
			curY[3] = 0;
			shape.line(counter);
		}else if(rnd == 2){
			curX[0] = 4;
			curX[1] = 5;
			curX[2] = 4;
			curX[3] = 5;
			curY[0] = 0;
			curY[1] = 0;
			curY[2] = 1;
			curY[3] = 1;
			shape.square(counter);
		}else if (rnd == 3){
			curX[0] = 4;
			curX[1] = 4;
			curX[2] = 5;
			curX[3] = 6;
			curY[0] = 0;
			curY[1] = 1;
			curY[2] = 1;
			curY[3] = 1;
			shape.lShape(counter);
		}else if (rnd == 4){
			curX[0] = 4;
			curX[1] = 5;
			curX[2] = 6;
			curX[3] = 5;
			curY[0] = 0;
			curY[1] = 0;
			curY[2] = 0;
			curY[3] = 1;
			shape.tShape(counter);
		}else if (rnd == 5){
			curX[0] = 4;
			curX[1] = 5;
			curX[2] = 5;
			curX[3] = 6;
			curY[0] = 0;
			curY[1] = 0;
			curY[2] = 1;
			curY[3] = 1;
			shape.zShape(counter);
		}else if (rnd == 6){
			curX[0] = 6;
			curX[1] = 5;
			curX[2] = 5;
			curX[3] = 4;
			curY[0] = 0;
			curY[1] = 0;
			curY[2] = 1;
			curY[3] = 1;
			shape.reverseZShape(counter);
		}else if (rnd == 7){
			curX[0] = 6;
			curX[1] = 6;
			curX[2] = 5;
			curX[3] = 4;
			curY[0] = 0;
			curY[1] = 1;
			curY[2] = 1;
			curY[3] = 1;
			shape.revereLShape(counter);
		}
		rotateCount = 0;
		
		
		pieceFall = true;
		timeLine(root, shape);
		
		
	}
	
	//timer for pieces falling
	public void timeLine(Pane root, Shapes shape){

		timeline = new Timeline(new KeyFrame(
	            Duration.millis(300),
	            ae -> pieceFall(root, shape)));
	    timeline.setCycleCount(1);
	    timeline.play();
	 
	}
	
	//move pieces down  as time passes
	public void pieceFall(Pane root, Shapes shape){
		if(curY[0] == BOARD_HEIGHT -1 || curY[1] == BOARD_HEIGHT -1 || curY[2] == BOARD_HEIGHT-1 || curY[3] == BOARD_HEIGHT-1
				|| board[curX[0]][curY[0] + 1] == 1 || board[curX[1]][curY[1] + 1] == 1 || board[curX[2]][curY[2] + 1] == 1 || board[curX[3]][curY[3] + 1] == 1){
			pieceFall = false;
			board[curX[0]][curY[0]] = 1;
			board[curX[1]][curY[1]] = 1;
			board[curX[2]][curY[2]] = 1;
			board[curX[3]][curY[3]] = 1;
			
			//lose game
			if (curY[0] ==1 || curY[1] ==1 || curY[2] ==1 || curY[3] ==1 ){
				stage2.close();
				firstWindow.show();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Game Over!");

				alert.showAndWait();
			}else{
				clearLine(shape, root);
				counter +=1;
				drawShape(root, shape);
				timeline.stop();
			}
			
		}
		
		if (pieceFall==true){
			shape.r1.get(counter).relocate(curX[0] * 30 + 10, curY[0] * 30 + 40);
			curY[0] +=1;
			
			shape.r2.get(counter).relocate(curX[1] * 30 + 10, curY[1] * 30 + 40);
			curY[1] +=1;
			
			shape.r3.get(counter).relocate(curX[2] * 30 + 10, curY[2] * 30 + 40);
			curY[2] +=1;
			
			shape.r4.get(counter).relocate(curX[3] * 30 + 10, curY[3] * 30 + 40);
			curY[3] +=1;
			shape.r1.get(counter).setOnKeyPressed(e -> {          
		        switch (e.getCode()) {
		        case LEFT: 
		        	if(curX[0] >=1 && curX[1] >=1 && curX[2] >=1 && curX[3] >=1 && pieceFall == true
		        	&& board[curX[0] - 1][curY[0]] < 1 && board[curX[1] - 1][curY[1]] < 1 && board[curX[2] - 1][curY[2]] < 1 && board[curX[3] - 1][curY[3]] < 1){
		        		curX[0] -=1;
		        		curX[1] -=1;
		        		curX[2] -=1;
		        		curX[3] -=1;
		        		shape.r1.get(counter).setX(shape.r1.get(counter).getX() -30);
			        	shape.r2.get(counter).setX(shape.r2.get(counter).getX() -30);
			        	shape.r3.get(counter).setX(shape.r3.get(counter).getX() -30);
			        	shape.r4.get(counter).setX(shape.r4.get(counter).getX() -30);
		        	}
		        	break;
		        case RIGHT:
		        	if(curX[0] <=8 && curX[1] <=8 && curX[2] <=8 && curX[3] <=8 && pieceFall == true
		        	&& board[curX[0] + 1][curY[0]] < 1 && board[curX[1] + 1][curY[1]] < 1 && board[curX[2] + 1][curY[2]] < 1 && board[curX[3] + 1][curY[3]] < 1){
		        		curX[0] += 1;
			        	curX[1] += 1;
			        	curX[2] += 1;
			        	curX[3] += 1;
			        	shape.r1.get(counter).setX(shape.r1.get(counter).getX() +30);
			        	shape.r2.get(counter).setX(shape.r2.get(counter).getX() +30);
			        	shape.r3.get(counter).setX(shape.r3.get(counter).getX() +30);
			        	shape.r4.get(counter).setX(shape.r4.get(counter).getX() +30);
		        	}
		        	
		        	break;
		        
		        case DOWN:
		        	timeline.setRate(10);
		        	break;
		        
		        case UP:
		        	rotateShape(shape);
		        	break;
		        
				default:
					break;
		      }
		    });
		    shape.r1.get(counter).requestFocus(); // shape.r1 is focused to receive key input 
		    timeLine(root, shape);
		}
	}
	
	//rotate pieces
	public void rotateShape(Shapes shape){
		shape.r1.get(counter).requestFocus();
		if (rnd == 1){
			switch (rotateCount){
			
			case 0:
				if (curY[0] < BOARD_HEIGHT -2 && curY[1] < BOARD_HEIGHT -2 && curY[2] < BOARD_HEIGHT -2 && curY[3] < BOARD_HEIGHT -2
						&& board[curX[0]][curY[0] + 2] < 1 && board[curX[1]][curY[1] + 2] < 1 && board[curX[2]][curY[2] + 2] < 1 && board[curX[3]][curY[3] + 2] < 1
						&& curY[0] > 1){
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() + 60);
					shape.r2.get(counter).setX(shape.r2.get(counter).getX() + 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
				
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() + 30);
					shape.r3.get(counter).setY(shape.r3.get(counter).getY() - 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 60);
				
					curX[0] += 2;
					curX[1] += 1;
					curX[3] -= 1;
				
					curY[0] += 1;
					curY[2] -= 1;
					curY[3] -= 2;
					rotateCount +=1;
					
				}
				break;
				
			case 1:
				
				if (curX[0] > 1 && curX[1] > 1 && curX[2] > 1 && curX[3] > 1 && curX[0] < BOARD_WIDTH -2 && curX[1] < BOARD_WIDTH -2 && curX[2] < BOARD_WIDTH -2 && curX[3] < BOARD_WIDTH -2
						&& board[curX[0] -1][curY[0]] < 1 && board[curX[1] -1][curY[1]] < 1 && board[curX[2] -1][curY[2]] < 1 && board[curX[3] -1][curY[3]] < 1
						&& board[curX[0] -2][curY[0]] < 1 && board[curX[1] -2][curY[1]] < 1 && board[curX[2] -2][curY[2]] < 1 && board[curX[3] -2][curY[3]] < 1
						&& board[curX[0] +1][curY[0]] < 1 && board[curX[1] +1][curY[1]] < 1 && board[curX[2] +1][curY[2]] < 1 && board[curX[3] +1][curY[3]] < 1){
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() + 30);
					shape.r3.get(counter).setX(shape.r3.get(counter).getX() - 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 60);
					
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() - 60);
					shape.r2.get(counter).setY(shape.r2.get(counter).getY() - 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
					
					curX[0] += 1;
					curX[2] -= 1;
					curX[3] -= 2;
					
					curY[0] -= 2;
					curY[1] -= 1;
					curY[3] += 1;
					rotateCount +=1;
				}
				
				
				
				break;
			
			case 2:
				if (curY[0] < BOARD_HEIGHT -2 && curY[1] < BOARD_HEIGHT -2 && curY[2] < BOARD_HEIGHT -2 && curY[3] < BOARD_HEIGHT -2
						&& board[curX[0]][curY[0] + 2] < 1 && board[curX[1]][curY[1] + 2] < 1 && board[curX[2]][curY[2] + 2] < 1 && board[curX[3]][curY[3] + 2] < 1
						&& board[curX[0]][curY[0] + 1] < 1 && board[curX[1]][curY[1] + 1] < 1 && board[curX[2]][curY[2] + 1] < 1 && board[curX[3]][curY[3] + 1] < 1){
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() - 60);
					shape.r2.get(counter).setX(shape.r2.get(counter).getX() - 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
					
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() - 30);
					shape.r3.get(counter).setY(shape.r3.get(counter).getY() + 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 60);
					
					curX[0] -= 2;
					curX[1] -= 1;
					curX[3] += 1;
					
					curY[0] -= 1;
					curY[2] += 1;
					curY[3] += 2;
					
					rotateCount +=1;
				}
				
				break;
				
			case 3:
				if (curX[0] > 1 && curX[1] > 1 && curX[2] > 1 && curX[3] > 1 && curX[0] < BOARD_WIDTH -3 && curX[1] < BOARD_WIDTH -3 && curX[2] < BOARD_WIDTH -3 && curX[3] < BOARD_WIDTH -3
						&& board[curX[0] -1][curY[0]] < 1 && board[curX[1] -1][curY[1]] < 1 && board[curX[2] -1][curY[2]] < 1 && board[curX[3] -1][curY[3]] < 1
						&& board[curX[0] -2][curY[0]] < 1 && board[curX[1] -2][curY[1]] < 1 && board[curX[2] -2][curY[2]] < 1 && board[curX[3] -2][curY[3]] < 1
						&& board[curX[0] +1][curY[0]] < 1 && board[curX[1] +1][curY[1]] < 1 && board[curX[2] +1][curY[2]] < 1 && board[curX[3] +1][curY[3]] < 1
						&& board[curX[0] +2][curY[0]] < 1 && board[curX[1] +2][curY[1]] < 1 && board[curX[2] +2][curY[2]] < 1 && board[curX[3] +2][curY[3]] < 1){
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() - 30);
					shape.r3.get(counter).setX(shape.r3.get(counter).getX() + 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 60);
					
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() + 60);
					shape.r2.get(counter).setY(shape.r2.get(counter).getY() + 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
					
					curX[0] -= 1;
					curX[2] += 1;
					curX[3] += 2;
					
					curY[0] += 2;
					curY[1] += 1;
					curY[3] -= 1;
					
					rotateCount = 0;
				}
				
				break;
			}
		}else if (rnd == 2){
			switch (rotateCount){
			
			case 0:
				
				rotateCount +=1;
				break;
				
			case 1:
				
				rotateCount +=1;
				break;
			
			case 2:
				
				rotateCount +=1;
				break;
				
			case 3:
				
				rotateCount = 0;
				break;
			}
		}else if (rnd == 3){
			switch (rotateCount){
			
			case 0:
				
				if(curY[0] < BOARD_HEIGHT -1  && curY[1] < BOARD_HEIGHT -1  && curY[2] < BOARD_HEIGHT -1 && curY[3] < BOARD_HEIGHT -1
						&& board[curX[0]][curY[0] + 1] < 1 && board[curX[1]][curY[1] + 1] < 1 && board[curX[2]][curY[2] + 1] < 1 && board[curX[3]][curY[3] + 1] < 1){
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() + 60);
					shape.r2.get(counter).setX(shape.r2.get(counter).getX() + 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
					
					shape.r2.get(counter).setY(shape.r2.get(counter).getY() - 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
					
					curX[0] += 2;
					curX[1] += 1;
					curX[3] -= 1;
					
					curY[1] -= 1;
					curY[3] += 1;
					
					rotateCount +=1;
				}
				
				break;
				
			case 1:
				if(curX[1] > 0 && board[curX[1] - 1][curY[1]] < 1 && board[curX[2] - 1][curY[2]] < 1 && board[curX[3] - 1][curY[3]] < 1
						&& board[curX[1] + 1][curY[1]] < 1 && board[curX[2] + 1][curY[2]] < 1 && board[curX[3] + 1][curY[3]] < 1){
					shape.r2.get(counter).setX(shape.r2.get(counter).getX() + 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
					
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() + 60);
					shape.r2.get(counter).setY(shape.r2.get(counter).getY() + 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
					
					curX[1] += 1;
					curX[3] -= 1;
					
					curY[0] += 2;
					curY[1] += 1;
					curY[3] -= 1;
					
					rotateCount +=1;
				}
				
				break;
			
			case 2:
				
				if(board[curX[0] - 1][curY[0]] < 1){
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() - 60);
					shape.r2.get(counter).setX(shape.r2.get(counter).getX() - 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
					
					shape.r2.get(counter).setY(shape.r2.get(counter).getY() + 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
					
					curX[0] -= 2;
					curX[1] -= 1;
					curX[3] += 1;
					
					curY[1] += 1;
					curY[3] -= 1;
					
					rotateCount +=1;
				}
				
				break;
				
			case 3:
				
				if(curX[1] < BOARD_WIDTH - 2 && board[curX[1] + 1][curY[1]] < 1 && board[curX[2] + 1][curY[2]] < 1 && board[curX[3] + 1][curY[3]] < 1) {
					shape.r2.get(counter).setX(shape.r2.get(counter).getX() - 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
					
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() - 60);
					shape.r2.get(counter).setY(shape.r2.get(counter).getY() - 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
					
					curX[1] -= 1;
					curX[3] += 1;
					
					curY[0] -= 2;
					curY[1] -= 1;
					curY[3] += 1;
					
					rotateCount = 0;
				}
				
				break;
			}
		}else if (rnd == 4){
			switch (rotateCount){
			
			case 0:
				
				shape.r1.get(counter).setX(shape.r1.get(counter).getX() + 30);
				shape.r3.get(counter).setX(shape.r3.get(counter).getX() - 30);
				shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
				
				shape.r1.get(counter).setY(shape.r1.get(counter).getY() - 30);
				shape.r3.get(counter).setY(shape.r3.get(counter).getY() + 30);
				shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
				
				curX[0] += 1;
				curX[2] -= 1;
				curX[3] -= 1;
				
				curY[0] -= 1;
				curY[2] += 1;
				curY[3] -= 1;
				
				rotateCount +=1;
				break;
				
			case 1:
				
				if(curX[0]< BOARD_WIDTH -2 && board[curX[0] + 1][curY[0]] < 1 && board[curX[1] + 1][curY[1]] < 1){
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() + 30);
					shape.r3.get(counter).setX(shape.r3.get(counter).getX() - 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
					
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() + 30);
					shape.r3.get(counter).setY(shape.r3.get(counter).getY() - 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
					
					curX[0] += 1;
					curX[2] -= 1;
					curX[3] += 1;
					
					curY[0] += 1;
					curY[2] -= 1;
					curY[3] -= 1;
					
					rotateCount +=1;
				}
				
				break;
			
			case 2:
				
				if (curY[0] < BOARD_HEIGHT - 1 && board[curX[0]][curY[0] + 1] < 1 && board[curX[1]][curY[1] + 1] < 1){
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() - 30);
					shape.r3.get(counter).setX(shape.r3.get(counter).getX() + 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
					
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() + 30);
					shape.r3.get(counter).setY(shape.r3.get(counter).getY() - 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
					
					curX[0] -= 1;
					curX[2] += 1;
					curX[3] += 1;
					
					curY[0] += 1;
					curY[2] -= 1;
					curY[3] += 1;
					
					rotateCount +=1;
				}
				
				break;
				
			case 3:
				
				if (curX[0] > 0 && board[curX[0] - 1][curY[0]] < 1){
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() - 30);
					shape.r3.get(counter).setX(shape.r3.get(counter).getX() + 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
					
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() - 30);
					shape.r3.get(counter).setY(shape.r3.get(counter).getY() + 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
					
					curX[0] -= 1;
					curX[2] += 1;
					curX[3] -= 1;
					
					curY[0] -= 1;
					curY[2] += 1;
					curY[3] += 1;
					
					rotateCount = 0;
				}
				
				break;
			}
		}else if (rnd ==5){
			switch (rotateCount){
			
			case 0:
				
				if(curY[0] < BOARD_HEIGHT -1 && curY[1] < BOARD_HEIGHT -1 && curY[2] < BOARD_HEIGHT -1 && curY[3] < BOARD_HEIGHT -1
						&& board[curX[2]][curY[2] + 1] < 1 && board[curX[3]][curY[3] + 1] < 1){
					
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() + 60);
					shape.r2.get(counter).setX(shape.r2.get(counter).getX() + 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
					
					shape.r2.get(counter).setY(shape.r2.get(counter).getY() + 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
					
					curX[0] += 2;
					curX[1] += 1;
					curX[3] -= 1;
					
					curY[1] += 1;
					curY[3] += 1;
					
					rotateCount +=1;
				}
				
				break;
				
			case 1:
				
				if(curX[2] > 0 && board[curX[2] - 1][curY[2]] < 1 && board[curX[3] - 1][curY[3]] < 1){
					shape.r2.get(counter).setX(shape.r2.get(counter).getX() - 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
					
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() + 60);
					shape.r2.get(counter).setY(shape.r2.get(counter).getY() + 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
					
					curX[1] -= 1;
					curX[3] -= 1;
					
					curY[0] += 2;
					curY[1] += 1;
					curY[3] -= 1;
					
					rotateCount +=1;
				}
				
				break;
			
			case 2:
				
				if (board[curX[1] -1][curY[1]] < 1){
					shape.r1.get(counter).setX(shape.r1.get(counter).getX() - 60);
					shape.r2.get(counter).setX(shape.r2.get(counter).getX() - 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
					
					shape.r2.get(counter).setY(shape.r2.get(counter).getY() - 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
					
					curX[0] -= 2;
					curX[1] -= 1;
					curX[3] += 1;
					
					curY[1] -= 1;
					curY[3] -= 1;
					
					rotateCount +=1;
				}
				
				break;
				
			case 3:
				
				if (curX[3] < BOARD_WIDTH - 2 && board[curX[2] + 1][curY[2]] < 1 && board[curX[3] + 1][curY[3]] < 1) {
					shape.r2.get(counter).setX(shape.r2.get(counter).getX() + 30);
					shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
					
					shape.r1.get(counter).setY(shape.r1.get(counter).getY() - 60);
					shape.r2.get(counter).setY(shape.r2.get(counter).getY() - 30);
					shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
					
					curX[1] += 1;
					curX[3] += 1;
					
					curY[0] -= 2;
					curY[1] -= 1;
					curY[3] += 1;
					
					rotateCount = 0;
				}
				
				break;
			}
		}else if (rnd == 6){
			switch (rotateCount){
				
			case 0:
				
				shape.r2.get(counter).setX(shape.r2.get(counter).getX() + 30);
				shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
				
				shape.r1.get(counter).setY(shape.r1.get(counter).getY() + 60);
				shape.r2.get(counter).setY(shape.r2.get(counter).getY() + 30);
				shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
				
				curX[1] += 1;
				curX[3] += 1;
				
				curY[0] += 2;
				curY[1] += 1;
				curY[3] -= 1;
				
				rotateCount +=1;
				break;
				
			case 1:
				
				shape.r1.get(counter).setX(shape.r1.get(counter).getX() - 60);
				shape.r2.get(counter).setX(shape.r2.get(counter).getX() - 30);
				shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
				
				shape.r2.get(counter).setY(shape.r2.get(counter).getY() + 30);
				shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
				
				curX[0] -= 2;
				curX[1] -= 1;
				curX[3] += 1;
				
				curY[1] += 1;
				curY[3] += 1;
				
				rotateCount +=1;
				break;
				
			case 2:
				
				shape.r2.get(counter).setX(shape.r2.get(counter).getX() - 30);
				shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
				
				shape.r1.get(counter).setY(shape.r1.get(counter).getY() - 60);
				shape.r2.get(counter).setY(shape.r2.get(counter).getY() - 30);
				shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
				
				curX[1] -= 1;
				curX[3] -= 1;
				
				curY[0] -= 2;
				curY[1] -= 1;
				curY[3] += 1;
				
				rotateCount +=1;
				break;
				
			case 3:
				
				shape.r1.get(counter).setX(shape.r1.get(counter).getX() + 60);
				shape.r2.get(counter).setX(shape.r2.get(counter).getX() + 30);
				shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
				
				shape.r2.get(counter).setY(shape.r2.get(counter).getY() - 30);
				shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
				
				curX[0] += 2;
				curX[1] += 1;
				curX[3] -= 1;
				
				curY[1] -= 1;
				curY[3] -= 1;
				
				rotateCount =0;
				break;
			}
		}else if (rnd == 7){
			
			switch (rotateCount){
			
			case 0:
				
				shape.r2.get(counter).setX(shape.r2.get(counter).getX() - 30);
				shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
				
				shape.r1.get(counter).setY(shape.r1.get(counter).getY() + 60);
				shape.r2.get(counter).setY(shape.r2.get(counter).getY() + 30);
				shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
				
				curX[1] -= 1;
				curX[3] += 1;
				
				curY[0] += 2;
				curY[1] += 1;
				curY[3] -= 1;
				
				rotateCount +=1;
				break;
				
			case 1:
				
				shape.r1.get(counter).setX(shape.r1.get(counter).getX() - 60);
				shape.r2.get(counter).setX(shape.r2.get(counter).getX() - 30);
				shape.r4.get(counter).setX(shape.r4.get(counter).getX() + 30);
				
				shape.r2.get(counter).setY(shape.r2.get(counter).getY() - 30);
				shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
				
				curX[0] -= 2;
				curX[1] -= 1;
				curX[3] += 1;
				
				curY[1] -= 1;
				curY[3] += 1;
				
				rotateCount +=1;
				break;
				
			case 2:
				
				shape.r2.get(counter).setX(shape.r2.get(counter).getX() + 30);
				shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
				
				shape.r1.get(counter).setY(shape.r1.get(counter).getY() - 60);
				shape.r2.get(counter).setY(shape.r2.get(counter).getY() - 30);
				shape.r4.get(counter).setY(shape.r4.get(counter).getY() + 30);
			
				curX[1] += 1;
				curX[3] -= 1;
				
				curY[0] -= 2;
				curY[1] -= 1;
				curY[3] += 1;
				
				rotateCount +=1;
				break;
				
			case 3:
				
				shape.r1.get(counter).setX(shape.r1.get(counter).getX() + 60);
				shape.r2.get(counter).setX(shape.r2.get(counter).getX() + 30);
				shape.r4.get(counter).setX(shape.r4.get(counter).getX() - 30);
				
				shape.r2.get(counter).setY(shape.r2.get(counter).getY() + 30);
				shape.r4.get(counter).setY(shape.r4.get(counter).getY() - 30);
				
				curX[0] += 2;
				curX[1] += 1;
				curX[3] -= 1;
				
				curY[1] += 1;
				curY[3] -= 1;
				
				rotateCount = 0;
				break;
				
			}
		}
	}
	
	//removes pieces when line is completed
	public void clearLine(Shapes shape, Pane root){
		
		
		for (int i = 0; i < BOARD_HEIGHT ; i ++){  //cycle through height of grid
			for (int j = 0; j < BOARD_WIDTH ; j ++){ //cycle through grid width
				if (board[j][i] == 0){
					break;
				}else if(j >= 9){
					locationY = (30 * i) + 10;
					
					board[0][i] = 0;
					board[1][i] = 0;
					board[2][i] = 0;
					board[3][i] = 0;
					board[4][i] = 0;
					board[5][i] = 0;
					board[6][i] = 0;
					board[7][i] = 0;
					board[8][i] = 0;
					board[9][i] = 0;
					board[10][i] = 0;
					
					playerScore += 500;
					score.setText(String.valueOf(playerScore));
					for (int k = 0; k < shape.r1.size(); k ++){
						if (shape.r1.get(k).getBoundsInParent().getMinY() == locationY){
							root.getChildren().remove(shape.r1.get(k));
						}else if (shape.r1.get(k).getBoundsInParent().getMinY() < locationY){
							shape.r1.get(k).setY(shape.r1.get(k).getY() + 30);
							for (int u = 0; u < i  ; u++){
								for (int v = 0; v < BOARD_WIDTH; v++){
									if (u < BOARD_HEIGHT -2){
										if (board[v][u] == 1 && board[v][u + 1] == 0 && board[v][u+ 2] == 0){
											board[v][u] = 0;
											board[v][u+1] = 1;
											break;
										}
									}
									if (board[v][u] == 1 && board[v][u + 1] == 0){
										board[v][u] = 0;
										board[v][u + 1] = 1;
									}
								}
							}
						}
					}
					
					for (int l = 0; l < shape.r2.size(); l ++){
						if (shape.r2.get(l).getBoundsInParent().getMinY() == locationY){
							root.getChildren().remove(shape.r2.get(l));
						}else if (shape.r2.get(l).getBoundsInParent().getMinY() < locationY){
							shape.r2.get(l).setY(shape.r2.get(l).getY() + 30);
							for (int a = 0; a < i   ; a++){
								for (int w = 0; w < BOARD_WIDTH; w++){
									if (a < BOARD_HEIGHT -2){
										if (board[w][a] == 1 && board[w][a + 1] == 0 && board[w][a+ 2] == 0){
											board[w][a] = 0;
											board[w][a + 1] = 1;
											break;
										}
									}
									if (board[w][a] == 1 && board[w][a + 1] == 0){
										board[w][a] = 0;
										board[w][a + 1] = 1;
									}
								}
							}
						}
					}
					
					for (int m = 0; m < shape.r3.size(); m ++){
						if (shape.r3.get(m).getBoundsInParent().getMinY() == locationY){
							root.getChildren().remove(shape.r3.get(m));
						}else if (shape.r3.get(m).getBoundsInParent().getMinY() < locationY){
							shape.r3.get(m).setY(shape.r3.get(m).getY() + 30);
							for (int b = 0; b < i  ; b++){
								for (int x = 0; x < BOARD_WIDTH; x++){
									if (b < BOARD_HEIGHT -2){
										if (board[x][b] == 1 && board[x][b + 1] == 0 && board[x][b+ 2] == 0){
											board[x][b] = 0;
											board[x][b + 1] = 1;
											break;
										}
									}
									if (board[x][b] == 1 && board[x][b + 1] == 0){
										board[x][b] = 0;
										board[x][b + 1] = 1;
									}
								}
							}
						}
					}
					
					for (int n = 0; n < shape.r4.size(); n ++){
						if (shape.r4.get(n).getBoundsInParent().getMinY() == locationY){
							root.getChildren().remove(shape.r4.get(n));
						}else if (shape.r4.get(n).getBoundsInParent().getMinY() < locationY){
							shape.r4.get(n).setY(shape.r4.get(n).getY() + 30);
							for (int c = 0; c < i  ; c++){
								for (int y = 0; y < BOARD_WIDTH; y++){
									if (c < BOARD_HEIGHT -2){
										if (board[y][c] == 1 && board[y][c + 1] == 0 && board[y][c+ 2] == 0){
											board[y][c] = 0;
											board[y][c + 1] = 1;
											break;
										}
									}
									if (board[y][c] == 1 && board[y][c + 1] == 0){
										board[y][c] = 0;
										board[y][c + 1] = 1;
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
