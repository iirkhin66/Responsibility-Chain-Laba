package ilya.responsabilitychainlaba.Controller;

import ilya.responsabilitychainlaba.Realization.ActionChain;
import ilya.responsabilitychainlaba.Realization.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class ResponsibilityChainController {
    @FXML
    private Button box1Button, box2Button, box3Button, box4Button, box5Button, box6Button, box7Button, box8Button;

    @FXML
    private Label infoLabel;

    private Player player;
    private ActionChain actionChain;

    @FXML
    public void initialize() {
        this.initButtons();
        this.player = new Player("Илья Ирхин", 0);
        this.actionChain = new ActionChain(this.player);
        this.updateInfo();
    }

    @FXML
    public void onPay() {
        this.player.addNumber(1);
        this.updateInfo();
    }

    @FXML
    public void onClick() {
        if (!this.player.pay(1)) {
            final Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Недостаточно монет!");
            alert.show();
            return;
        }

        final boolean continueGame = this.actionChain.process();

        this.updateInfo();

        if (!continueGame) {
            final Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Игра завершена! Спасибо за участие)");
            alert.showAndWait();
            System.exit(0);
        }
    }

    private void updateInfo() {
        this.infoLabel.setText(String.format("Игрок: %s\nБаланс: %d\nСыграно раз: %d",
                this.player.getName(), this.player.getBalance(), this.player.getPlays()));
    }

    private void initButtons() {
        this.setBoxImage(this.box1Button);
        this.setBoxImage(this.box2Button);
        this.setBoxImage(this.box3Button);
        this.setBoxImage(this.box4Button);
        this.setBoxImage(this.box5Button);
        this.setBoxImage(this.box6Button);
        this.setBoxImage(this.box7Button);
        this.setBoxImage(this.box8Button);
    }

    private void setBoxImage(final Button button) {
        final Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/box.jpg")));

        final ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        imageView.setPreserveRatio(true);

        button.setGraphic(imageView);
    }
}
