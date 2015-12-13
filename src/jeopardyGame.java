import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URI;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;
import javafx.scene.effect.*;


public class jeopardyGame extends Application {
private double panewidth = 515;
private double panehieght = 350;


// initiating playerscore
private int pScore=0;
public void setPscore(int scores) {
    this.pScore=pScore;
}
public int getPscore() {
    return pScore;
}

public void start(Stage primaryStage){
	
//attributes of grid pane
GridPane p = new GridPane();
p.setPadding(new Insets(5, 5, 5, 5));
p.add(new Label("      Vocab     "), 0, 1);
p.add(new Label("     JavaFX     "), 1, 1);
p.add(new Label("      Arrays     "), 2, 1);
p.add(new Label(" Math Funct "), 3, 1);
p.add(new Label("      Loops     "), 4, 1);

//first category buttons
final Button bt1Cat1 = new Button("      $100     ");
p.add(bt1Cat1, 0, 3);
final Button bt1Cat2 = new Button("      $100     ");
p.add(bt1Cat2, 1, 3);
final Button bt1Cat3 = new Button("      $100     ");
p.add(bt1Cat3, 2, 3);
final Button bt1Cat4 = new Button("      $100     ");
p.add(bt1Cat4, 3, 3);
final Button bt1Cat5 = new Button("      $100     ");
p.add(bt1Cat5, 4, 3);

//second category buttons
final Button bt2Cat1 = new Button("      $200     ");
p.add(bt2Cat1, 0, 4);
final Button bt2Cat2 = new Button("      $200     ");
p.add(bt2Cat2, 1, 4);
final Button bt2Cat3 = new Button("      $200     ");
p.add(bt2Cat3, 2, 4);
final Button bt2Cat4 = new Button("      $200     ");
p.add(bt2Cat4, 3, 4);
final Button bt2Cat5 = new Button("      $200     ");
p.add(bt2Cat5, 4, 4);

//third category buttons
final Button bt3Cat1 = new Button("      $300     ");
p.add(bt3Cat1, 0, 5);
final Button bt3Cat2 = new Button("      $300     ");
p.add(bt3Cat2, 1, 5);
final Button bt3Cat3 = new Button("      $300     ");
p.add(bt3Cat3, 2, 5);
final Button bt3Cat4 = new Button("      $300     ");
p.add(bt3Cat4, 3, 5); 
final Button bt3Cat5 = new Button("      $300     ");
p.add(bt3Cat5, 4, 5); 

//fourth category buttons 
final Button bt4Cat1 = new Button("      $400     ");
p.add(bt4Cat1, 0, 6);
final Button bt4Cat2 = new Button("      $400     ");
p.add(bt4Cat2, 1, 6);
final Button bt4Cat3 = new Button("      $400     ");
p.add(bt4Cat3, 2, 6);
final Button bt4Cat4 = new Button("      $400     ");
p.add(bt4Cat4, 3, 6);
final Button bt4Cat5 = new Button("      $400     ");
p.add(bt4Cat5, 4, 6);

//Fifth category buttons
final Button bt5Cat1 = new Button("      $500     ");
p.add(bt5Cat1, 0, 7);
final Button bt5Cat2 = new Button("      $500     ");
p.add(bt5Cat2, 1, 7);
final Button bt5Cat3 = new Button("      $500     ");
p.add(bt5Cat3, 2, 7);
final Button bt5Cat4 = new Button("      $500     ");
p.add(bt5Cat4, 3, 7);
final Button bt5Cat5 = new Button("      $500     ");
p.add(bt5Cat5, 4, 7);

//borderpane creation and assignments
final BorderPane pane = new BorderPane();
pane.setTop(p);
p.setStyle("-fx-background-color: black");

//TextAreas in HBOX
HBox hBox = new HBox();
final TextArea textArea = new TextArea();
textArea.setMaxHeight(75);
textArea.setEditable(false);
pane.setCenter(hBox);
final TextArea scoreArea = new TextArea();
scoreArea.setMaxHeight(75);
scoreArea.setEditable(false);
scoreArea.setPrefColumnCount(6);
hBox.getChildren().addAll(textArea, scoreArea);
textArea.setPrefColumnCount(32);
hBox.setStyle("-fx-background-color: black");
hBox.setPrefHeight(40);

//Score
scoreArea.setStyle("-fx-color: blue");
scoreArea.setStyle("-fx-border-color: black");
scoreArea.getStyleClass().add("score");
scoreArea.setText("Score: ");
scoreArea.setMaxWidth(120);

//bottom gridpane
final GridPane gp2 = new GridPane();
pane.setBottom(gp2);
gp2.setStyle("-fx-background-color: black");
gp2.setPadding(new Insets(0, 0, 0, 5));
final Button A1 = new Button("      Submit      ");
gp2.add(A1, 1,1);
A1.setStyle(" -fx-border-color: black");
final TextField tf1 = new TextField();
tf1.setPrefColumnCount(33);
gp2.add(tf1, 0,1);

//Questions

bt1Cat1.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
textArea.setText("What is the Java mechanism for wrapping data?");
A1.setDisable(false);
A1.setStyle(" -fx-border-color: black");
A1.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e){
		String fileName = tf1.getText();
		String answer = "encapsulation";
		if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
		URI u = f.toURI();
		Media media = new Media(u.toString());
		MediaPlayer mp = new MediaPlayer(media);
		mp.play();
		int btScore = 100;
		getPscore();
		pScore = pScore + btScore;
		scoreArea.setText("Score: " + pScore);
		A1.setDisable(true);
		bt1Cat1.setDisable(true);
		}
		
		else{	File f = new File("bin/wrong.mp3");
		URI u = f.toURI();
		Media media = new Media(u.toString());
		MediaPlayer mp = new MediaPlayer(media);
		mp.play();
		int btScore = -100;
		getPscore();
		pScore = pScore + btScore;
		scoreArea.setText("Score: " + pScore);
		A1.setDisable(true);
		bt1Cat1.setDisable(true);
		}
			}
		});
	}
});


bt2Cat1.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
textArea.setText("A method with no implementation");
A1.setDisable(false);
A1.setStyle(" -fx-border-color: black");
A1.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e){
		String fileName = tf1.getText();
		String answer = "abstract method";
		if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
		URI u = f.toURI();
		Media media = new Media(u.toString());
		MediaPlayer mp = new MediaPlayer(media);
		mp.play();
		int btScore = 200;
		getPscore();
		pScore = pScore + btScore;
		scoreArea.setText("Score: " + pScore);
		A1.setDisable(true);
		bt2Cat1.setDisable(true);
		}
		
		else{	File f = new File("bin/wrong.mp3");
		URI u = f.toURI();
		Media media = new Media(u.toString());
		MediaPlayer mp = new MediaPlayer(media);
		mp.play();
		int btScore = -200;
		getPscore();
		pScore = pScore + btScore;
		scoreArea.setText("Score: " + pScore);
		A1.setDisable(true);
		bt2Cat1.setDisable(true);
		}
			}
		});
	}
});


bt3Cat1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("A data item specified in a\n"
					+ " method call. An argument can be a literal value,\n"
					+ " a variable, or an expression.");
	A1.setDisable(false);
	A1.setStyle(" -fx-border-color: black");
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "argument";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 300;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			A1.setDisable(true);
			bt3Cat1.setDisable(true);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -300;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			A1.setDisable(true);
			bt3Cat1.setDisable(true);
			}
				}
			});
		}
	});


bt4Cat1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("An operator that has two arguments.");
	A1.setDisable(false);
	A1.setStyle(" -fx-border-color: black");
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "binary operater";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 400;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			A1.setDisable(true);
			bt4Cat1.setDisable(true);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -400;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			A1.setDisable(true);
			bt4Cat1.setDisable(true);
			}
				}
			});
		}
	});

bt5Cat1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("A collection of data items,\n"
			+ " all of the same type, in which each item's\n"
			+ " position is uniquely designated by an integer.");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "array";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 500;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			A1.setDisable(true);
			bt5Cat1.setDisable(true);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -500;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			A1.setDisable(true);
			bt5Cat1.setDisable(true);
			}
				}
			});
		}
	});

bt1Cat2.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("What is a GUI?");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "graphical user interface";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 100;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -100;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt2Cat2.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("This pane places nodes in top, bottom, left, right, and center regions.");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "borderpane";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 200;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -200;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt3Cat2.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("Every JavaFX program is defined in a class that extends what?");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "application";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 300;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -300;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt4Cat2.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("A stage is a window for displaying a _______.");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "scene";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 400;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -400;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt5Cat2.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("_______ lays out nodes in the specified cell in a grid.");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "gridpane";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 500;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -500;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt1Cat3.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("What field returns the number of elements in an array?");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "length";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 100;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -100;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt2Cat3.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("ArrayList is a ___ class?");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "generic";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 200;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -200;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt3Cat3.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("When you construct an ArrayList object, it has a size of?");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "zero";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 300;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -300;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt4Cat3.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("Do you have to import the ArrayList class to use it?");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "Yes";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 400;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -400;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt5Cat3.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("_______is a sequence of values of the same type.\n"
			+ " They can hold both primitives and objects.?");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "Array";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 500;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -500;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt1Cat4.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText(" The method returns the value of the first parameter raised"
			+ "\n to the power of the second parameter");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "Math.pow";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 100;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -100;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});

bt2Cat4.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("Method calculates the square root of the parameter given to it.");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "Math.sqrt";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 200;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -200;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});


bt3Cat4.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("Method to use Pi");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "Math.PI";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 300;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -300;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});

bt4Cat4.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("Method returns the largest of two values passed to it as parameter?");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "Math.max";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 400;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -400;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});

bt5Cat4.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("Method returns a random floating point number between 0 and 1");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "Math.random";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 500;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -500;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});

bt1Cat5.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("This type of loop is ideal in situations where the\n"
			+ " exact number of iterations is known.");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "for loop";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 100;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -100;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});

bt2Cat5.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("The while loop and the do loop are equivalent in their expressive\n power; in other words, you can rewrite a while loop using a do loop,\n and vice versa.");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "true";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 200;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -200;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});

bt3Cat5.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("A loop that repeats a specific number of times is known as a _____.");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "counter control loop";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 300;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -300;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});

bt4Cat5.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("In a while loop, when is the Boolean expression tested?");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "before";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 400;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -400;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});

bt5Cat5.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e) {
	textArea.setText("In a do-while loop, when is the Boolean expression tested??");
	A1.setDisable(false);
	A1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent e){
			String fileName = tf1.getText();
			String answer = "after";
			if( fileName.equals (answer)){ 	File f = new File("bin/correct.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = 500;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
			
			else{	File f = new File("bin/wrong.mp3");
			URI u = f.toURI();
			Media media = new Media(u.toString());
			MediaPlayer mp = new MediaPlayer(media);
			mp.play();
			int btScore = -500;
			getPscore();
			pScore = pScore + btScore;
			scoreArea.setText("Score: " + pScore);
			}
				}
			});
		}
	});

//set up scene and stage
Scene scene = new Scene(pane, panewidth, panehieght);
primaryStage.setTitle("Jeopardy"); 
primaryStage.setScene(scene); 
scene.getStylesheets().add("jGame.css");
primaryStage.show(); 
}


public static void main(String[] args) {
launch(args);
}
}