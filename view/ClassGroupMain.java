package view;

import controller.ClassGroupController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ClassGroupMain extends Tab{
	private GridPane grid;
	private VBox text;
	private HBox buttons;
	private TextField classcode;
	private TextField classsub;
	private Button add;
	private Button remove;
	private Button listStudentbyclass;
	private ClassGroupController control;
	private Label output;
	public ClassGroupMain() {
		// TODO Auto-generated constructor stub
		setText("Class-Group");
		output = new Label();
		control = new ClassGroupController();
		classcode = new TextField();
		classcode.setPromptText("Please enter a class code");
		classcode.setPrefWidth(50);
		classsub = new TextField();
		classsub.setPromptText("Please enter class course");
		classsub.setPrefWidth(50);
		add = new Button("Add");
		remove = new Button("Remove");
		listStudentbyclass = new Button("List Students in a class");
		text = new VBox();
		buttons = new HBox();
		text.getChildren().addAll(classcode,classsub);
		text.setSpacing(10);
		buttons.setSpacing(10);
		buttons.getChildren().addAll(add,remove,listStudentbyclass);
		add.setOnAction(actionEvent ->{
			control.createClassGroup(classcode.getText(), classsub.getText());
		});
		remove.setOnAction(actionEvent ->{
			control.removeClassGroup(classcode.getText());
		});
		listStudentbyclass.setOnAction(actionEvent -> {
			output.setText(control.listoutClassGroups());
		});
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
