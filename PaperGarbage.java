public class PaperGarbage extends Garbage {

    private boolean isSqueezed;

    public PaperGarbage(String name, boolean isSqueezed) {
        super(name);
        this.isSqueezed = isSqueezed;
    }
    public boolean isSqueezed() {
        return isSqueezed;
    }
    public void squeeze() {
        isSqueezed = true;
    }
}
