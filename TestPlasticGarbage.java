public class TestPlasticGarbage {

    public static void main(String[] args) {
        TestPlasticGarbage test = new TestPlasticGarbage();
        test.testInstantiatingPlasticGarbage();
        test.testCleanOnPlasticGarbage();
        System.out.println("OK");
    }

    public void testInstantiatingPlasticGarbage() {
        String garbageName = "Empty coke bottle";
        PlasticGarbage plasticGarbage = new PlasticGarbage(garbageName, false);
        assert garbageName.equals(plasticGarbage.getName());
        assert !plasticGarbage.isClean();
    }

    public void testCleanOnPlasticGarbage() {
        PlasticGarbage plasticGarbage = new PlasticGarbage("Plastic garbage", false);
        plasticGarbage.clean();
        assert plasticGarbage.isClean();
    }
}
