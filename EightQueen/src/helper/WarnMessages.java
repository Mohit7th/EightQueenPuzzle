/**
 * Help to handle exceptions in GUI form
 */
package helper;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class WarnMessages {
	public final static int SUCCESS = 1, FAIL = 0;
	static String warnMsg = "";
	static Alert alertDialog = new Alert(AlertType.INFORMATION);
	WarnMessages(){

	}
	static public void  displayAlertMessage(int warnNo){
		switch(warnNo){
			case 0:
				warnMsg = "Sorry, You were close to solution, but not close enough";
				break;
			case 1:
				warnMsg = "Great! You Solved It";
				break;
		}
		alertDialog.setTitle("Your Result");
		alertDialog.setHeaderText("8 Queen Puzzle");
		alertDialog.setContentText(warnMsg);
		alertDialog.showAndWait();
	}
}
