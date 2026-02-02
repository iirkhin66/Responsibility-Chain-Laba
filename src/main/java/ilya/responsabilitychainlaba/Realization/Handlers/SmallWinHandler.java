package ilya.responsabilitychainlaba.Realization.Handlers;

import ilya.responsabilitychainlaba.Realization.GameEvent;
import ilya.responsabilitychainlaba.Realization.Player;
import ilya.responsabilitychainlaba.ResponsibilityChain.Handler;
import javafx.scene.control.Alert;

public final class SmallWinHandler extends Handler {
    private final Player player;

    public SmallWinHandler(final Handler next, final Player player) {
        super(next);
        this.player = player;
    }

    @Override
    public boolean canHandle(final Integer request) {
        return request == GameEvent.SMALL_WIN;
    }

    @Override
    public boolean processRequest(final Integer request) {
        this.player.addNumber(1);

        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Вы выиграли!");
        alert.setHeaderText("+ одна монетка.");

        alert.showAndWait();
        return true;
    }
}
