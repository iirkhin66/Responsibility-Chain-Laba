package ilya.responsabilitychainlaba.Realization.Handlers;

import ilya.responsabilitychainlaba.Realization.GameEvent;
import ilya.responsabilitychainlaba.ResponsibilityChain.Handler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public final class LossHandler extends Handler {
    public LossHandler(final Handler next) {
        super(next);
    }

    @Override
    public boolean canHandle(final Integer request) {
        return request == GameEvent.LOSS;
    }

    @Override
    public boolean processRequest(final Integer request) {
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Проигрыш");
        alert.setHeaderText("Монетка потрачена(");

        final ButtonType retry = new ButtonType("Играть дальше", ButtonBar.ButtonData.YES);
        final ButtonType quit = new ButtonType("Завершить", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(retry, quit);

        return alert.showAndWait()
                .map(b -> b.getButtonData() == ButtonBar.ButtonData.YES)
                .orElse(false);
    }
}
