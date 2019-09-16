package view;

import controller.TeacherController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TeacherMain extends Tab {
	private GridPane grid;
	private Label output;
	private VBox text;
	private HBox buttons;
	private VBox names;
	private TextField fname;
	private TextField mname;
	private TextField lname;
	private TextField email;
	private TextField phonenumber;
	private TextField qualification;
	private Button add;
	private Button remove;
	private Button submitqualification;
	private Button listteachers;
	private TeacherController control;
	public TeacherMain() {
		// TODO Auto-generated constructor stub
		setText("Teacher");
		output = new Label();
		control = new TeacherController();
		names = new VBox();
		text = new VBox();
		buttons = new HBox();
		fname = new TextField();
		fname.setPromptText("Please enter the first name of a Teacher");
		fname.setPrefWidth(200);
		mname = new TextField();
		mname.setPromptText("Please enter the middle name of a Teacher");
		mname.setPrefWidth(200);
		lname = new TextField();
		lname.setPromptText("Please enter the last name of a Teacher");
		lname.setPrefWidth(200);
		email = new TextField();
		email.setPromptText("Please enter the email of a Teacher");
		email.setPrefWidth(200);
		phonenumber = new TextField();
		phonenumber.setPromptText("Please enter the phone number of a Teacher");
		phonenumber.setPrefWidth(200);
		qualification = new TextField();
		qualification.setPromptText("Please enter qualification of Teacher");
		qualification.setPrefWidth(200);
		text.getChildren().addAll(email,phonenumber,qualification);
		names.getChildren().addAll(fname,mname,lname);
		add = new Button("Add");
		remove = new Button("Remove");
		submitqualification = new Button("Enter qualification");
		listteachers = new Button("List the teachers");
		add.setOnAction(actionEvent -> {
			control.addTeacher(fname.getText(),mname.getText() ,lname.getText(), phonenumber.getText(), qualification.getText(),email.getText());
		});
		remove.setOnAction(actionEvent ->{
			control.removeTeacher(email.getText());
		});
		listteachers.setOnAction(actionEvent ->{
			output.setText(control.listTeachers());
		});
		submitqualification.setOnAction(actionEvent -> {
			control.editQual(qualification.getText(), email.getText());
		});
		text.setSpacing(10);
		buttons.setSpacing(10);
		buttons.getChildren().addAll(add,remove,submitqualification,listteachers);
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
