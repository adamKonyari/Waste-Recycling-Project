public class TestGarbage {

    public static void main(String[] args) {
        TestGarbage test = new TestGarbage();
        test.testInstantiatingGarbage();
        System.out.println("OK");
    }

    public void testInstantiatingGarbage() {
        String garbageName = "Rotten food from the fridge";
        Garbage garbage = new Garbage(garbageName);
        assert garbageName.equals(garbage.getName());
    }
}
