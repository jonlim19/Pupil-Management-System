package view;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private BorderPane mainPane;
	private Group root;
	private TabPane tp;
	private StudentMain student;
	private ModuleGradeMain modulegrade;
	private TeacherMain teacher;
	private ClassGroupMain classgroup;
	private ClassandGradesMain classngrades;
	public void start(Stage primaryStage) {
		try {
			mainPane = new BorderPane();
			root = new Group();
			tp = new TabPane();
			student = new StudentMain();
			modulegrade = new ModuleGradeMain();
			teacher = new TeacherMain();
			classgroup = new ClassGroupMain();
			classngrades = new ClassandGradesMain();
			tp.getTabs().add(student);
			tp.getTabs().add(modulegrade);
			tp.getTabs().add(teacher);
			tp.getTabs().add(classgroup);
			tp.getTabs().add(classngrades);
			Scene scene = new Scene(root,400,400);
			mainPane.setCenter(tp);
			mainPane.prefHeightProperty().bind(scene.heightProperty());
			mainPane.prefWidthProperty().bind(scene.widthProperty());
			root.getChildren().add(mainPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
