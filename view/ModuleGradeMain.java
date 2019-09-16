package view;

import controller.ModuleGradeController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ModuleGradeMain extends Tab{
	private GridPane grid;
	private HBox textboxes;
	private HBox buttons;
	private TextField module;
	private TextField modulecode;
	private TextField grade;
	private Button addmodule;
	private ModuleGradeController control;
	public ModuleGradeMain() {
		// TODO Auto-generated constructor stub
		setText("Module-Grade");
		control = new ModuleGradeController();
		grid = new GridPane();
		textboxes = new HBox();
		buttons = new HBox();
		module = new TextField();
		module.setPromptText("Please enter the module name");
		grade = new TextField();
		grade.setPromptText("Add a student through email");
		modulecode = new TextField();
		modulecode.setPromptText("Please enter module code");
		textboxes.getChildren().addAll(modulecode,module,grade);
		
		addmodule = new Button("Add a new module");
		buttons.getChildren().addAll(addmodule);
		addmodule.setOnAction(actionEvent ->{
			control.addModule(modulecode.getText(), module.getText(),grade.getText());
		});
		grid.setMinSize(100, 100);
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		grid.add(textboxes, 0, 0);
		grid.add(buttons, 0, 2);
		
		setContent(grid);
	}

}
