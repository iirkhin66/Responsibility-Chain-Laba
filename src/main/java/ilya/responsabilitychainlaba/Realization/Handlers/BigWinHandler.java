package ilya.responsabilitychainlaba.Realization.Handlers;

import ilya.responsabilitychainlaba.Realization.GameEvent;
import ilya.responsabilitychainlaba.Realization.Player;
import ilya.responsabilitychainlaba.ResponsibilityChain.Handler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public final class BigWinHandler extends Handler {
    private final Player player;

    public BigWinHandler(final Handler next, final Player player) {
        super(next);
        this.player = player;
    }

    @Override
    public boolean canHandle(final Integer request) {
        return request == GameEvent.BIG_WIN;
    }

    @Override
    public boolean processRequest(final Integer request) {
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Крупный выигрыш!");
        alert.setHeaderText("5 монет! Забрать или рискнуть?");

        final ButtonType take = new ButtonType("Забрать", ButtonBar.ButtonData.NO);
        final ButtonType risk = new ButtonType("Рискнуть)", ButtonBar.ButtonData.YES);
        alert.getButtonTypes().setAll(risk, take);

        return alert.showAndWait()
                .map(b -> {
                    if (b.getButtonData() == ButtonBar.ButtonData.YES) {
                        if (Math.random() < 0.5) {
                            this.player.addNumber(10);

                            final Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                            alert2.setTitle("Везунчик!");
                            alert2.setHeaderText("Тебе крупно повезло! Ты рискнул и выиграл 10 монет!)");
                            alert2.showAndWait();

                        } else {
                            this.player.addNumber(5);

                            final Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                            alert2.setTitle("Хе-хе-хе)");
                            alert2.setHeaderText("Не повезло) бывает) держи 5 монет");
                            alert2.showAndWait();
                        }
                    }

                    return b.getButtonData() == ButtonBar.ButtonData.YES;
                })
                .orElse(false);
    }
}
