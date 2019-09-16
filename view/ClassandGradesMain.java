package view;

import controller.ClassandGradesController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ClassandGradesMain extends Tab{
	private TextField id;
	private TextField email;
	private TextField classcode;
	private TextField modulecode;
	private TextField grade;
	private Button add;
	private Button listStudentsfromClass;
	private Button editmodule;
	private GridPane grid;
	private VBox text;
	private HBox buttons;
	private ClassandGradesController control;
	private Label output;
	public ClassandGradesMain() {
		// TODO Auto-generated constructor stub
		setText("Class and Grades");
		output = new Label();
		control = new ClassandGradesController();
		text = new VBox();
		buttons = new HBox();
		id = new TextField();
		id.setPromptText("Please enter a unique ID");
		id.setPrefWidth(50);
		email = new TextField();
		email.setPromptText("Please enter the email of a Student");
		email.setPrefWidth(50);
		classcode = new TextField();
		classcode.setPromptText("Please enter a class code");
		classcode.setPrefWidth(50);
		modulecode = new TextField();
		modulecode.setPromptText("Please enter module code");
		modulecode.setPrefWidth(50);
		grade = new TextField();
		grade.setPromptText("Please enter a grade");
		grade.setPrefWidth(50);
		text.setSpacing(10);
		text.getChildren().addAll(id,email,classcode,modulecode,grade);
		add = new Button("Add");
		editmodule = new Button("Edit an existing module grade");
		listStudentsfromClass = new Button("List all Students from class");
		add.setOnAction(actionEvent ->{
			control.addtoDatabase(id.getText(), email.getText(), classcode.getText(), modulecode.getText(), grade.getText());
		});
		listStudentsfromClass.setOnAction(actionEvent ->{
			output.setText(control.listStudentsbyClass(classcode.getText()));
		});
		editmodule.setOnAction(actionEvent ->{
			control.editMarks(email.getText(),modulecode.getText(), grade.getText());
		});
		buttons.getChildren().addAll(add,listStudentsfromClass,editmodule);
		buttons.setSpacing(10);
		grid = new GridPane();
		grid.setMinSize(100, 100);
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		grid.add(text, 0, 0);
		grid.add(buttons, 0, 1);
		grid.add(output, 0, 2);
		setContent(grid);
	}

}
