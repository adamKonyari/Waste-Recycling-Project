public class TestPaperGarbage {

    public static void main(String[] args) {
        TestPaperGarbage test = new TestPaperGarbage();
        test.testInstantiatingPaperGarbage();
        test.testSqueezeOnPaperGarbage();
        System.out.println("OK");
    }

    public void testInstantiatingPaperGarbage() {
        String garbageName = "An empty milk carton";
        PaperGarbage paperGarbage = new PaperGarbage(garbageName, false);
        assert garbageName.equals(paperGarbage.getName());
        assert !paperGarbage.isSqueezed();
    }

    public void testSqueezeOnPaperGarbage() {
        PaperGarbage paperGarbage = new PaperGarbage("Paper garbage", false);
        paperGarbage.squeeze();
        assert paperGarbage.isSqueezed();
    }
}
