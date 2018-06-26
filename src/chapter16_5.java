
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class chapter16_5 extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		TextField tfDecimal = new TextField();
		TextField tfHex = new TextField();
		TextField tfBinary = new TextField();
		Label lbDecimal = new Label("Decimal");
		Label lbHex = new Label("Hex");
		Label lbBinary = new Label("Binary");
		
		
		pane.add(lbDecimal, 0, 0);//Add labels and textfields
		pane.add(tfDecimal, 1, 0);
		tfDecimal.setAlignment(Pos.BOTTOM_RIGHT);
		pane.add(lbHex, 0, 1);
		pane.add(tfHex, 1, 1);
		tfHex.setAlignment(Pos.BOTTOM_RIGHT);
		pane.add(lbBinary, 0, 2);
		pane.add(tfBinary, 1, 2);
		tfBinary.setAlignment(Pos.BOTTOM_RIGHT);
		
		pane.setHgap(5);

		tfDecimal.setOnAction(e -> {

			tfHex.setText(Integer.toHexString(Integer.parseInt(tfDecimal.getText())));
			tfBinary.setText(Integer.toBinaryString(Integer.parseInt(tfDecimal.getText())));
		});
		tfHex.setOnAction(e -> {
			tfDecimal.setText(String.valueOf(Integer.parseInt(tfHex.getText(), 16)));

			tfBinary.setText(Integer.toBinaryString(Integer.parseInt(tfHex.getText(), 16)));

		});
		tfBinary.setOnAction(e -> {
			tfDecimal.setText(String.valueOf(Integer.parseInt(tfBinary.getText(), 2)));

			tfHex.setText(Integer.toHexString(Integer.parseInt(tfBinary.getText(), 2)));

		});

		Scene scene = new Scene(pane, 200, 100);
		primaryStage.setTitle("Calculations"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	public static void main(String[] args) {
		launch(args);
	}
}
