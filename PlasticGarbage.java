public class PlasticGarbage extends Garbage {

    private boolean isClean;

    public PlasticGarbage(String name, boolean isClean) {
        super(name);
        this.isClean = isClean;
    }

    public boolean isClean() {
        return isClean;
    }

    public void clean() {
        isClean = true;
    }
}
