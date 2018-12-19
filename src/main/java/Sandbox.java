import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Sandbox extends Application{

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Open a New Window");
        btn.setOnAction((ActionEvent event) -> {
            Label secondLabel = new Label("Hello");

            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(secondLabel);

            Scene secondScene = new Scene(secondaryLayout, 200, 100);

            Stage secondStage = new Stage();
            secondStage.setTitle("New Stage");
            secondStage.setScene(secondScene);

            secondStage.show();

        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("java-buddy.blogspot.com");
        primaryStage.setScene(scene);
        primaryStage.show();

       // primaryStage.setOnCloseRequest(e -> Platform.exit());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
