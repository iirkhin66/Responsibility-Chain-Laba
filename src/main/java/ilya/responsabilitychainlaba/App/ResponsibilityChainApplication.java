package ilya.responsabilitychainlaba.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ResponsibilityChainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("/ilya/responsabilitychainlaba/window.fxml"));
        final Scene scene = new Scene(loader.load(), 600, 400);

        stage.setScene(scene);
        stage.setTitle("Responsibility Chain Task");
        stage.setResizable(false);
        stage.show();
    }
}
