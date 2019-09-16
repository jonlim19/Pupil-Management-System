package view;

import controller.StudentMainController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StudentMain extends Tab {
	private GridPane grid;
	private VBox text;
	private HBox buttons;
	private VBox names;
	private TextField fname;
	private TextField mname;
	private TextField lname;
	private TextField email;
	private TextField dateofbirth;
	private TextField phonenumber;
	private Button add;
	private Button remove;
	private Button quit;
	private Button listStudentbyName;
	private StudentMainController control;
	private Label output;
	
	public StudentMain() {
		setText("Student");
		control = new StudentMainController();
		output = new Label("To be displayed");
		names = new VBox();
		text = new VBox();
		buttons = new HBox();
		fname = new TextField();
		fname.setPromptText("Please enter the first name of a Student");
		fname.setPrefWidth(50);
		mname = new TextField();
		mname.setPromptText("Please enter the middle name of a Student");
		mname.setPrefWidth(50);
		lname = new TextField();
		lname.setPromptText("Please enter the last name of a Student");
		lname.setPrefWidth(50);
		email = new TextField();
		email.setPromptText("Please enter the email of a Student");
		email.setPrefWidth(50);
		dateofbirth = new TextField();
		dateofbirth.setPromptText("Please enter the date of birth of a Student");
		dateofbirth.setPrefWidth(50);
		phonenumber = new TextField();
		phonenumber.setPromptText("Please enter the phone number of a Student");
		phonenumber.setPrefWidth(50);
		text.getChildren().addAll(email,dateofbirth,phonenumber);
		names.getChildren().addAll(fname,mname,lname);
		add = new Button("Add");
		remove = new Button("Remove");
		listStudentbyName = new Button("List Student");
		
		quit = new Button("Quit Application");

		add.setOnAction(actionEvent -> {
			control.addStudent(fname.getText(),mname.getText() ,lname.getText() ,email.getText() , dateofbirth.getText(), phonenumber.getText());
		});
		
		remove.setOnAction(actionEvent -> {
			control.removeStudent(email.getText());
		});
		listStudentbyName.setOnAction(actionEvent -> {
			output.setText(control.listStudent());
		});
		
		quit.setOnAction(actionEvent -> {
			System.exit(0);
		});
		text.setSpacing(10);
		names.setSpacing(10);
		buttons.setSpacing(10);
		buttons.getChildren().addAll(add,remove,listStudentbyName,quit);
		grid = new GridPane();
		grid.setMinSize(100, 100);
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		grid.add(text, 0, 0);
		grid.add(names, 0, 1);
		grid.add(buttons, 0, 2);
		grid.add(output, 0, 3);
		
		setContent(grid);
	}

}
