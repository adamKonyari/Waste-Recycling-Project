public class TestDustbin {

    public static void main(String[] args) throws DustbinContentException {
        TestDustbin test = new TestDustbin();
        test.testDustbinOutPaperGarbage();
        test.testDustbinOutPlasticGarbage();
        test.testDustbinOutHouseWasteGarbage();
        test.testDustbinOutUnsqueezedPaperGarbage();
        test.testDustbinOutUncleanedPlasticGarbage();
        test.testEmptyContentsOnDustbin();
        /*
        //Uncomment this method. What happens when you try the tests?
        test.testDustbinOutSomethingWhichIsNotAGarbage();
        */
        System.out.println("OK");
    }

    public void testDustbinOutPaperGarbage() throws DustbinContentException {
        PaperGarbage paperGarbage = new PaperGarbage("Paper garbage", true);
        Dustbin dustbin = new Dustbin("red");
        dustbin.throwOutGarbage(paperGarbage);
        assert dustbin.getPaperContent().length == 1;
        assert dustbin.getPlasticContent().length == 0;
        assert dustbin.getHouseWasteContent().length == 0;
    }

    public void testDustbinOutPlasticGarbage() throws DustbinContentException {
        PlasticGarbage plasticGarbage = new PlasticGarbage("Plastic garbage", true);
        Dustbin dustbin = new Dustbin("red");
        dustbin.throwOutGarbage(plasticGarbage);
        assert dustbin.getPaperContent().length == 0;
        assert dustbin.getPlasticContent().length == 1;
        assert dustbin.getHouseWasteContent().length == 0;
    }

    public void testDustbinOutHouseWasteGarbage() throws DustbinContentException {
        Garbage garbage = new Garbage("House waste garbage");
        Dustbin dustbin = new Dustbin("red");
        dustbin.throwOutGarbage(garbage);
        assert dustbin.getPaperContent().length == 0;
        assert dustbin.getPlasticContent().length == 0;
        assert dustbin.getHouseWasteContent().length == 1;
    }

    public void testDustbinOutUnsqueezedPaperGarbage() {
        PaperGarbage paperGarbage = new PaperGarbage("Paper garbage", false);
        Dustbin dustbin = new Dustbin("red");
        boolean threw = false;
        try {
            dustbin.throwOutGarbage(paperGarbage);
        } catch (DustbinContentException ex) {
            threw = true;
        }
        assert threw;
    }

    public void testDustbinOutUncleanedPlasticGarbage() {
        PlasticGarbage plasticGarbage = new PlasticGarbage("Plastic garbage", false);
        Dustbin dustbin = new Dustbin("red");
        boolean threw = false;
        try {
            dustbin.throwOutGarbage(plasticGarbage);
        } catch (DustbinContentException ex) {
            threw = true;
        }
        assert threw;
    }

    public void testEmptyContentsOnDustbin() throws DustbinContentException {
        Garbage[] garbageList = new Garbage[]{
            new PlasticGarbage("Plastic garbage", true),
            new PaperGarbage("Paper garbage", true),
            new Garbage("House waste garbage")
        };

        Dustbin dustbin = new Dustbin("red");
        for (Garbage garbage : garbageList) {
            dustbin.throwOutGarbage(garbage);
        }

        dustbin.emptyContents();

        assert dustbin.getPaperContent().length == 0;
        assert dustbin.getPlasticContent().length == 0;
        assert dustbin.getHouseWasteContent().length == 0;
    }

    /*
    // Uncomment this method.What happens when you try the tests?
    public void testDustbinOutSomethingWhichIsNotAGarbage() {
        String myString = "This is NOT a garbage, right???";
        Dustbin dustbin = new Dustbin("red");
        boolean threw = false;
        try {
            dustbin.throwOutGarbage(myString);
        } catch (DustbinContentException ex) {
            threw = true;
        }
        assert threw;
    }
    */
}
