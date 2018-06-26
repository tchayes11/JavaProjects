package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Chapter16_13<taTable> extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		TextField tfLoanAmt = new TextField();
		TextField tfNumOfYears = new TextField();
		tfLoanAmt.setPrefColumnCount(7);
		tfNumOfYears.setPrefColumnCount(2);
		Label lbLoanAmt = new Label("Loan Amount");
		Label lbNumOfYears = new Label("Number of Years");
		tfNumOfYears.setPadding(new Insets(5, 5, 5, 15));
		Button btShowTable = new Button("Show Table");
		btShowTable.setAlignment(Pos.TOP_RIGHT);

		HBox hbox = new HBox();
		hbox.getChildren().addAll(lbLoanAmt, tfLoanAmt, lbNumOfYears, tfNumOfYears, btShowTable);
		pane.setTop(hbox);
		hbox.setSpacing(10);

		TextArea taTable = new TextArea();
		taTable.setPrefColumnCount(40);
		taTable.setPrefRowCount(20);
		ScrollPane scroll = new ScrollPane(taTable);
		pane.setCenter(scroll);

		Scene scene = new Scene(pane, 425, 250);
		primaryStage.setTitle("Loan Calculations"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		btShowTable.setOnAction(e -> {
			taTable.setText("Interest Rate\tMonthly Payment\tTotal Payment\n");
			double loanAmt = Double.parseDouble(tfLoanAmt.getText());
			double numOfYears = Double.parseDouble(tfNumOfYears.getText());
			
			
			for (double annualIntRate = 5; annualIntRate <= 8; annualIntRate += 0.125) {
				double monthlyIntRate = annualIntRate / 1200;
				double monthlyPayment = loanAmt * monthlyIntRate / (1 - (1/Math.pow(1 + monthlyIntRate, numOfYears * 12)));
				double totalPayment = monthlyPayment * 12 * numOfYears;
			
				String s = String.format("%12.2f\t\t %12.2f\t\t %12.2f \n", annualIntRate, monthlyPayment, totalPayment);
				taTable.setText(taTable.getText() + s);
			
			}});

	}


	

	public static void main(String[] args) {
		launch(args);
	}
}
