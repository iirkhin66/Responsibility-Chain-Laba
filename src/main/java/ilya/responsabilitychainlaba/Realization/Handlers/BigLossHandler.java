package ilya.responsabilitychainlaba.Realization.Handlers;

import ilya.responsabilitychainlaba.Realization.GameEvent;
import ilya.responsabilitychainlaba.Realization.Player;
import ilya.responsabilitychainlaba.ResponsibilityChain.Handler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public final class BigLossHandler extends Handler {
    private final Player player;

    public BigLossHandler(final Handler next, final Player player) {
        super(next);
        this.player = player;
    }

    @Override
    public boolean canHandle(final Integer request) {
        return request == GameEvent.BIG_LOSS;
    }

    @Override
    public boolean processRequest(final Integer request) {
        this.player.addNumber(-5);

        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Крупный проигрыш!)))");
        alert.setHeaderText("Минус 5 монет))");

        final ButtonType retry = new ButtonType("Играть дальше", ButtonBar.ButtonData.YES);
        final ButtonType quit = new ButtonType("Завершить", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(retry, quit);

        return alert.showAndWait()
                .map(b -> b.getButtonData() == ButtonBar.ButtonData.YES)
                .orElse(false);
    }
}
