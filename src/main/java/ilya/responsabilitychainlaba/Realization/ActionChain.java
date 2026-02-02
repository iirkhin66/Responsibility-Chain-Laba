package ilya.responsabilitychainlaba.Realization;

import ilya.responsabilitychainlaba.Realization.Handlers.BigLossHandler;
import ilya.responsabilitychainlaba.Realization.Handlers.BigWinHandler;
import ilya.responsabilitychainlaba.Realization.Handlers.LossHandler;
import ilya.responsabilitychainlaba.Realization.Handlers.SmallWinHandler;
import ilya.responsabilitychainlaba.ResponsibilityChain.Handler;

import java.util.Random;

public final class ActionChain {
    private final Handler chain;
    private final Random random = new Random();

    public ActionChain(final Player player) {
        this.chain =
                new BigLossHandler(
                        new BigWinHandler(
                                new SmallWinHandler(
                                        new LossHandler(null),
                                        player
                                ),
                                player
                        ),
                        player
                );
    }

    public boolean process() {
        final int event = 1 + this.random.nextInt(4);
        return this.chain.handleRequest(event);
    }
}
