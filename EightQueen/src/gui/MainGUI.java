/**
 * @author Mohit Uniyal
 *	8 queen puzzle is a game, in which we have to arrange 8 queens on a chess board in a particular order that, 
 *  no queen can attack any other queen
 */
package gui;

import helper.WarnMessages;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainGUI extends Application implements EventHandler<ActionEvent> {

	// ....................All possible solutions for 8 queen (8*8) chess
	// board...............
	private String solStringArr[] = {
			"Q...........Q..........Q.....Q....Q...........Q..Q.........Q....",
			"Q............Q.........Q..Q...........Q....Q.....Q..........Q...",
			"Q.............Q....Q.........Q.........Q.Q..........Q.....Q.....",
			"Q.............Q.....Q..........Q.Q.........Q.........Q....Q.....",
			".Q.........Q.........Q.........Q..Q.....Q.............Q.....Q...",
			".Q..........Q.........Q.Q.........Q............Q.....Q.....Q....",
			".Q..........Q.........Q....Q....Q..............Q.....Q....Q.....",
			".Q...........Q..Q.............Q....Q...........Q..Q.........Q...",
			".Q...........Q.........Q..Q.....Q..........Q..........Q.....Q...",
			".Q............Q...Q..........Q.........Q....Q...Q..........Q....",
			".Q............Q.....Q..........QQ..........Q.........Q....Q.....",
			".Q.............Q.....Q..Q.........Q.........Q.........Q....Q....",
			"..Q.....Q.............Q.....Q..........Q.Q.........Q.........Q..",
			"..Q.........Q....Q.............QQ.............Q....Q.........Q..",
			"..Q.........Q....Q.............Q.....Q.....Q..........Q.Q.......",
			"..Q.........Q.........Q.Q..........Q.....Q.............Q.....Q..",
			"..Q.........Q..........Q...Q....Q.............Q..Q...........Q..",
			"..Q..........Q...Q..........Q..........QQ.............Q....Q....",
			"..Q..........Q...Q............Q.Q..........Q...........Q....Q...",
			"..Q..........Q...Q............Q.....Q...Q..............Q...Q....",
			"..Q..........Q.....Q....Q..............Q....Q.........Q..Q......",
			"..Q..........Q.....Q.....Q.............Q....Q.........Q.Q.......",
			"..Q..........Q.........QQ..........Q..........Q.....Q....Q......",
			"..Q..........Q.........QQ...........Q.........Q..Q.........Q....",
			"..Q..........Q.........Q.Q.........Q....Q.............Q.....Q...",
			"..Q...........Q..Q.............Q....Q...Q..........Q.........Q..",
			"..Q...........Q..Q.............Q.....Q.....Q....Q...........Q...",
			"..Q............Q...Q..........Q.Q............Q...Q..........Q...",
			"...Q....Q...........Q..........Q.Q............Q...Q..........Q..",
			"...Q....Q...........Q..........Q.....Q....Q...........Q..Q......",
			"...Q.....Q..........Q..........Q.....Q..Q.........Q...........Q.",
			"...Q.....Q............Q...Q..........Q.........QQ...........Q...",
			"...Q.....Q............Q...Q..........Q.........Q....Q...Q.......",
			"...Q.....Q............Q.....Q...Q..............Q.....Q....Q.....",
			"...Q.....Q.............Q....Q.........Q.Q.........Q..........Q..",
			"...Q.....Q.............Q.....Q..Q.........Q.........Q.........Q.",
			"...Q.........Q..Q...........Q....Q.............Q..Q...........Q.",
			"...Q.........Q.........Q.Q............Q.Q.........Q.........Q...",
			"...Q.........Q.........Q..Q.....Q.............Q.....Q....Q......",
			"...Q..........Q.Q..............Q....Q....Q...........Q....Q.....",
			"...Q..........Q...Q............Q.Q..........Q...Q............Q..",
			"...Q..........Q.....Q....Q...........Q..Q.........Q............Q",
			"...Q..........Q.....Q.....Q.....Q............Q.........Q.Q......",
			"...Q...........QQ.........Q..........Q...Q............Q.....Q...",
			"...Q...........QQ...........Q.........Q..Q...........Q....Q.....",
			"...Q...........Q....Q.....Q.....Q.............Q..Q...........Q..",
			"....Q...Q..........Q.........Q.........Q.Q............Q...Q.....",
			"....Q...Q..............Q...Q.....Q............Q...Q..........Q..",
			"....Q...Q..............Q.....Q....Q...........Q..Q.........Q....",
			"....Q....Q.........Q.........Q.........Q..Q.....Q.............Q.",
			"....Q....Q.........Q..........Q...Q............Q.....Q..Q.......",
			"....Q....Q...........Q..Q.............Q....Q...........Q..Q.....",
			"....Q....Q.............QQ..........Q..........Q...Q..........Q..",
			"....Q.....Q.....Q............Q.........Q.Q.........Q..........Q.",
			"....Q.....Q.....Q.............Q..Q.............Q.....Q.....Q....",
			"....Q.....Q............Q...Q..........Q.Q............Q...Q......",
			"....Q.........Q.Q.........Q............Q.....Q.....Q.....Q......",
			"....Q.........Q.Q..........Q.....Q.............Q.....Q....Q.....",
			"....Q.........Q..Q.........Q...........QQ.........Q..........Q..",
			"....Q.........Q..Q...........Q....Q.....Q..........Q...........Q",
			"....Q.........Q..Q...........Q....Q.....Q..............Q...Q....",
			"....Q.........Q....Q....Q.........Q............Q.....Q...Q......",
			"....Q..........Q...Q....Q.........Q..........Q...Q............Q.",
			"....Q..........Q...Q....Q.............Q..Q...........Q....Q.....",
			".....Q..Q...........Q....Q.............Q..Q...........Q....Q....",
			".....Q...Q............Q.Q.........Q.........Q..........Q...Q....",
			".....Q...Q............Q.Q..........Q...........Q....Q.....Q.....",
			".....Q....Q.....Q.............Q.....Q..........Q.Q.........Q....",
			".....Q....Q.....Q..............Q...Q.....Q............Q.....Q...",
			".....Q....Q.....Q..............Q....Q....Q.........Q..........Q.",
			".....Q....Q.........Q.........Q.Q..........Q.....Q.............Q",
			".....Q....Q.........Q..........QQ..........Q.....Q............Q.",
			".....Q....Q...........Q..Q.........Q...........QQ...........Q...",
			".....Q....Q...........Q..Q.............Q....Q...Q..........Q....",
			".....Q....Q...........Q....Q....Q..............Q.Q..........Q...",
			".....Q.....Q....Q...........Q..........Q.Q............Q...Q.....",
			".....Q.....Q.....Q.............Q....Q.........Q.Q.........Q.....",
			".....Q.....Q..........Q.Q.........Q.........Q....Q.............Q",
			".....Q.....Q..........Q.Q..............Q.Q..........Q.....Q.....",
			".....Q.........Q.Q.........Q....Q.............Q.....Q.....Q.....",
			"......Q.Q.........Q............Q.....Q.....Q.....Q..........Q...",
			"......Q..Q.........Q....Q..............Q....Q.....Q..........Q..",
			"......Q..Q...........Q....Q.....Q..........Q...........Q....Q...",
			"......Q...Q.....Q............Q.........Q....Q....Q.........Q....",
			"......Q...Q............Q.Q..........Q...Q............Q.....Q....",
			"......Q....Q.....Q..........Q..........QQ.........Q..........Q..",
			"......Q....Q.....Q.............Q.....Q..Q.........Q.........Q...",
			"......Q.....Q.....Q.....Q............Q.........Q.Q.........Q....",
			".......Q.Q.........Q....Q.............Q.....Q.....Q..........Q..",
			".......Q.Q..........Q.....Q.....Q.............Q....Q.........Q..",
			".......Q..Q.....Q............Q...Q..........Q.........Q....Q....",
			".......Q...Q....Q.........Q..........Q...Q............Q.....Q..."

	};

	// .........................................................................

	GridPane grids;
	Button checkResult, resetBoardBtn;
	Label warningMsgLbl;
	// queen image that will be displayed in each square tile, when user clicks
	// on it
	Image queenImg = new Image("./res/queen.png");
	// stores the reference of 8 queens, so that user can be restricted to only
	// 8 queens
	ImageView[] queenImgView = new ImageView[8];

	public MainGUI() {
		warningMsgLbl = new Label("");
		for (int i = 0; i < 8; i++) {
			queenImgView[i] = new ImageView(queenImg);
			// resizing image so that it doses not exceed given button size
			queenImgView[i].setFitHeight(40);
			queenImgView[i].setFitWidth(40);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage mainStage) throws Exception {

		mainStage.setTitle("8 Queen By : Mohit Uniyal");

		// Adding Tabs to provide solution
		TabPane tabsPane = new TabPane();
		Tab gameTab = new Tab("Game");
		Tab helpTab = new Tab("Help");

		// modifying tabs properties
		gameTab.setClosable(false);
		helpTab.setClosable(false);
		tabsPane.getTabs().addAll(gameTab, helpTab);

		addInfoToHelpTab(helpTab);
		
		//applying css
		gameTab.setStyle("-fx-background-color: blue; -fx-font: 20px \"Serif\"; ");
		helpTab.setStyle("-fx-background-color: blue; -fx-font: 20px \"Serif\"; ");

		// all the contents like chess board, label and button will be added to
		// this main layout
		BorderPane rootPaneBp = new BorderPane();
		Scene mainScene = new Scene(tabsPane, 500, 550);
		gameTab.setContent(rootPaneBp);
		// center grid that will be displayed like a chess board
		grids = new GridPane();
		grids.setPadding(new Insets(5, 0, 5, 5));
		grids.setHgap(5);
		grids.setVgap(5);

		// adding all buttons (chess board tiles) to the main GridPane
		addImagesToGrids();

		// this VBox will hold the title and the MenuBar of the game
		VBox gameNameHbox = new VBox();
		Label gameNameLbl = new Label("8 Queen Puzzle");
		gameNameHbox.getChildren().add(gameNameLbl);

		// changing game name label properties
		gameNameHbox.setAlignment(Pos.CENTER);
		gameNameLbl.setStyle("-fx-font: 30px \"Serif\";"
				+ "-fx-text-fill: white");

		// complete chess board will be displayed on the center of the window
		grids.setAlignment(Pos.CENTER);

		// HBox for two buttons i.e Reset Board and check Result
		HBox buttonHbox = new HBox(5);
		checkResult = new Button("Check");
		resetBoardBtn = new Button("Reset");

		buttonHbox.getChildren().addAll(warningMsgLbl, resetBoardBtn,
				checkResult);
		// applying CSS to the components
		warningMsgLbl.setStyle("-fx-text-fill: red; -fx-font-size: 15pt;");
		
		
		// handling button event
		checkResult.setOnAction(this);
		resetBoardBtn.setOnAction(this);

		buttonHbox.setAlignment(Pos.BOTTOM_RIGHT);
		buttonHbox.setPadding(new Insets(8, 30, 10, 0));
		checkResult.setStyle("-fx-font-size: 12pt; -fx-background-color: #c3c4c4, linear-gradient(#d6d6d6 50%, white 100%), radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);"
				+ "-fx-background-radius: 30; -fx-background-insets: 0,1,1; -fx-text-fill: black; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 3, 0.0, 0, 1);");

		resetBoardBtn.setStyle("-fx-font-size: 12pt; -fx-background-color: #c3c4c4, linear-gradient(#d6d6d6 50%, white 100%), radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);"
				+ "-fx-background-radius: 30; -fx-background-insets: 0,1,1; -fx-text-fill: black; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 3, 0.0, 0, 1);");


		// setting background color for all the components
		gameNameHbox.setStyle("-fx-background-color: slateblue");
		grids.setStyle("-fx-background-color: slateblue");
		buttonHbox.setStyle("-fx-background-color: slateblue");

		// adding border pane contents
		rootPaneBp.setTop(gameNameHbox);
		rootPaneBp.setCenter(grids);
		rootPaneBp.setBottom(buttonHbox);
		// displaying main stage
		mainStage.setScene(mainScene);
		mainStage.setResizable(false);
		mainStage.show();
	}

	
	//providing help tab for user
	private void addInfoToHelpTab(Tab helpTab) {
		BorderPane helpBp = new BorderPane();
		
		Label helpHeadLbl = new Label();
		helpHeadLbl.setText("How To Play");
		
		Label helpBodyLbl = new Label();
		helpBodyLbl.setText("Rules\n\n1: Place 8 queens on the chess board.\n2: All queens must be arranged in a order, that no 2 queens can attack each other."
				+ "\n3: Queen can attack in any direction horizontally, vertically and diagonally. \n4: On Mouse click, one queen will be placed on the board."
				+ "\n5: Clicking on the same queen will remove queen from chess board.\n6: All 8 queens must be placed before clicking on \'check\' Button.\n"
				+ "6: There are 92 solution to this puzzle.\n7: Image below is one of the solution.\n\n");
		
		
		//vbox to wrap two helpLabels 
		VBox helpLblVb = new VBox();
		helpLblVb.setPadding(new Insets(0,0,0,20));
		helpLblVb.getChildren().addAll(helpHeadLbl,helpBodyLbl);
		
		//below help instruction, this image will be displayed  
		ImageView solutionImg = new ImageView(new Image("./res/solution.jpg"));
		HBox solImgHb = new HBox(); 
		solutionImg.setFitHeight(280);
		solutionImg.setFitWidth(480);
		
		solImgHb.getChildren().add(solutionImg);
		solImgHb.setAlignment(Pos.CENTER);
		
		//to wrap image and labels 
		VBox helpLblImgVb = new VBox();
		//applying CSS to all components
		helpLblImgVb.setStyle("-fx-background-color: slateblue");
		helpHeadLbl.setStyle("-fx-text-fill: white; -fx-font-size: 20pt");
		helpBodyLbl.setStyle("-fx-text-fill: white; -fx-font-size: 10pt"); 
		
		helpLblImgVb.getChildren().addAll(helpLblVb, solImgHb);
		helpBp.setCenter(helpLblImgVb);
		helpTab.setContent(helpBp);
	}
	
	// method to create different imageVeiw object and display them to the grids
	// in GridPane


	private Button all64Btn[][];

	private void addImagesToGrids() {
		// this flag will be used to alternatively identify chess board tiles so
		// that a different color can be assigned to it
		boolean ODDEVENFLAG = false;
		String color = "black";
		int buttonIndex = 0;
		// all 64 button reference will be stored int the array of buttons
		all64Btn = new Button[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				// Alternately changing image that will be displayed on the
				// button
				if (ODDEVENFLAG) {
					ODDEVENFLAG = false;
					color = "white";
				} else {
					ODDEVENFLAG = true;
					color = "black";
				}

				// setting button properties
				all64Btn[i][j] = new Button();

				all64Btn[i][j].setPadding(Insets.EMPTY);
				all64Btn[i][j].setId("btn" + "_" + buttonIndex);

				all64Btn[i][j].setPrefHeight(50);
				all64Btn[i][j].setPrefWidth(50);

				all64Btn[i][j].setStyle("-fx-background-color: " + color);

				// finally adding button to the gridPane
				grids.add(all64Btn[i][j], i, j);
				buttonIndex++;
				// setting action listener that will be called when button is
				// pressed
				all64Btn[i][j].setOnAction(this);
			}
			// again creating alternative change in the displayed images
			ODDEVENFLAG = (ODDEVENFLAG) ? false : true;
		}
	}

	// holds the information about imageview references that are used or available
	private int[] usedImgViewRef = { 0, 0, 0, 0, 0, 0, 0, 0 };
	// holds the information about used button reference
	private Button[] pressedBtnArr = new Button[8];
	private int totalQueenPlaced = 0;

	// handling button events
	public void handle(ActionEvent ae) {
		Button pressedBtn = (Button) ae.getSource();
		if (pressedBtn != checkResult && pressedBtn != resetBoardBtn) {
			int i = 0, j = 0;
			// checking for available index that can be used
			while (i < 8 && usedImgViewRef[i] != 0)
				i++;

			if ((pressedBtn.getGraphic() == null) && (i < 8)) {
				// when the button is empty adding a queen to it and also saving
				// that button reference
				pressedBtnArr[i] = pressedBtn;
				pressedBtn.setGraphic(queenImgView[i]);
				// turning image view reference to used mode i.e 1
				usedImgViewRef[i] = 1;
				totalQueenPlaced++;
			} else {
				// checking for button press, when all queens are used and still
				// pressing an empty button
				if (pressedBtn.getGraphic() != null) {
					warningMsgLbl.setText("");
					// looking for reference button that will be holding
					// the current button reference
					while (pressedBtnArr[j] != pressedBtn)
						j++;
					// making that image view reference usable 
					usedImgViewRef[j] = 0;
					pressedBtn.setGraphic(null);
					pressedBtn.setEffect(null);
					totalQueenPlaced--;
				} else {
					warningMsgLbl.setText("*all 8 queens are already in use");
				}
			}
		} else if (pressedBtn.getText().equals("Check")) {
			// checking for the solution i.e puzzle is solved or not
			if (totalQueenPlaced == 8) {
				// System.out.println(btn.getId());
				String solString = getSolString();
				boolean correctSol = rightSolution(solString);

				// applying glow effect when solution is inncorrect
				for (Button btn : pressedBtnArr) {
					if (correctSol)
						btn.setEffect(new InnerShadow(30, Color.YELLOW));
					else
						btn.setEffect(new InnerShadow(30, Color.RED));
				}
				// displaying messages according to result
				if (correctSol) {
					System.out.println("Success");
					// calling a method of helper package class WarnMessages
					WarnMessages.displayAlertMessage(WarnMessages.SUCCESS);
				} else {
					WarnMessages.displayAlertMessage(WarnMessages.FAIL);
				}
			} else {
				warningMsgLbl.setText("*you have to place 8 queens first");
			}

		} else {
			//when reset button is pressed
			int i = 0;
			totalQueenPlaced = 0;
			for (Button btn : pressedBtnArr) {
				if(btn!=null){
					btn.setGraphic(null);
					btn.setEffect(null);
					pressedBtnArr[i] = null;
					usedImgViewRef[i] = 0;
				}
				i++;
			}
		}
	}

	private int indx;

	String getSolString() {
		boolean checkFirst = true;
		String solString = "";
		indx = -1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (checkFirst)
					indx++;
				if (all64Btn[j][i].getGraphic() != null) {
					solString += "Q";
					checkFirst = false;
				} else
					solString += ".";
			}
		}
		System.out.println(solString + "fisrt : " + indx);
		return solString;
	}

	boolean rightSolution(String solString) {
		int start = 0, end = 3;
		//checking for only those solution where first row queen is placed
		switch (indx) {
		case 1:
			start = 4;
			end = 11;
			break;
		case 2:
			start = 12;
			end = 27;
			break;
		case 3:
			start = 28;
			end = 45;
			break;
		case 4:
			start = 46;
			end = 63;
			break;
		case 5:
			start = 64;
			end = 79;
			break;
		case 6:
			start = 80;
			end = 87;
			break;
		case 7:
			start = 88;
			end = 91;
			break;
		}

		for (int i = start; i < end; i++) {
			if (solString.equalsIgnoreCase(solStringArr[i])) {
				return true;
			}
		}
		return false;
	}
}
