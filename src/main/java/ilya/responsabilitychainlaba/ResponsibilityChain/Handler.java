package ilya.responsabilitychainlaba.ResponsibilityChain;

public abstract class Handler {
    private final Handler next;

    public Handler(final Handler next) {
        this.next = next;
    }

    public final boolean handleRequest(final Integer request) {
        if (this.canHandle(request)) {
            return this.processRequest(request);
        }

        if (this.next != null) {
            return this.next.handleRequest(request);
        }

        return false;
    }

    public abstract boolean canHandle(final Integer request);

    public abstract boolean processRequest(final Integer request);
}
