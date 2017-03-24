package game.event;

/**
 * Created by ekanner on 2017-03-23.
 */
public abstract class AbstractPrivilege extends GameElement {
    protected AbstractPrivilege next;
    protected AbstractPrivilege prev;

    public AbstractPrivilege() {}

    public abstract AbstractPrivilege handle(GameElement element);

    public AbstractPrivilege getNext() {
        return next;
    }

    public void execute(GameElement element) { }

    public AbstractPrivilege remove() {
        if(this.prev != null)
            this.prev.next = this.next;
        if(this.next != null)
            this.next.prev = this.prev;
        this.next = null;
        this.prev = null;
        return this;
    }

    public boolean hasNext() {
        if(this.next == null) return false;
        return true;
    }

    public AbstractPrivilege next() {
        return this.next;
    }

    private AbstractPrivilege setNext(AbstractPrivilege nextHandler, AbstractPrivilege prevHandler) {
        if(next == null) {
            this.prev = prevHandler;
            this.next = nextHandler;
            if(this.next != null)
                this.next.setNext(null, this);
        }
        else {
            this.prev = prevHandler;
            next.setNext(nextHandler, this);
        }
        return this;
    }

    public AbstractPrivilege setNext(AbstractPrivilege nextHandler) {
        if(next == null) {
            this.next = nextHandler;
            next.setNext(null, this);
        }
        else
            next.setNext(nextHandler, this);
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.isExecuted();
    }

    public String print() {
        return "prev: " + this.prev + " current: " + this.toString() + " next: " + this.next();
    }
}
