public class Dustbin {

    private String color;
    private PaperGarbage[] paperContent;
    private PaperGarbage[] tempPaperContent;
    private PlasticGarbage[] plasticContent;
    private PlasticGarbage[] tempPlasticContent;
    private Garbage[] houseWasteContent;
    private Garbage[] tempHouseWasteContent;

    private int wasteLen;
    private int paperLen;
    private int plasticLen;
    private int plasticCounter = 1;
    private int paperCounter = 1;
    private int wasteCounter = 1;

    public Dustbin(String color) {
    this.color = color;
    }

    public String getColor() {
        return color;
    }

    public PaperGarbage[] getPaperContent() {
        return paperContent;
    }

    public PlasticGarbage[] getPlasticContent() {
        return plasticContent;
    }

    public Garbage[] getHouseWasteContent() {
        return houseWasteContent;
    }

    void displayContents() throws NullPointerException {
        try {
            System.out.println("");
            System.out.println(color + " Dustbin!");
            System.out.println("");

            if(getHouseWasteContent() == null){
                wasteLen = 0;
            } else {
                wasteLen = getHouseWasteContent().length;
            }
            System.out.println("House waste content: " + wasteLen + "" + " item(s)");
            System.out.println("");
            if(wasteLen > 0) {
                for(Garbage i: getHouseWasteContent()) {
                    System.out.println("    " + i.getName());
                }
            }
            System.out.println("");

            if(getPaperContent() == null){
                paperLen = 0;
            } else {
                paperLen = getPaperContent().length;
            }
            System.out.println("Paper content: " + paperLen + "" + " item(s)");
            System.out.println("");
            if(paperLen > 0) {
                for(PaperGarbage i: getPaperContent()) {
                    System.out.println("    " + i.getName());
                }
            }
            System.out.println("");

            if(plasticContent == null){
                plasticLen = 0;
            } else {
                plasticLen = plasticContent.length;
            }
            System.out.println("Plastic content: " + plasticLen + "" + " item(s)");
            System.out.println("");
            if(plasticLen > 0) {
                for(PlasticGarbage i: plasticContent) {
                    System.out.println("    " + i.getName());
                }
            }
            System.out.println("");

        } catch(NullPointerException ex) {
            System.out.println("Cannot display contents.");
        }
    }

    void throwOutGarbage(Garbage garbage) throws DustbinContentException {

        if(garbage instanceof PlasticGarbage && ((PlasticGarbage)garbage).isClean()) {
            if (plasticContent == null) {
                tempPlasticContent = new PlasticGarbage[1];
            } else {
                tempPlasticContent = new PlasticGarbage[plasticCounter];
                for(int i = 0; i < plasticContent.length; i++) {
                    tempPlasticContent[i] = plasticContent[i];
                }
            }
            tempPlasticContent[plasticCounter - 1] = (PlasticGarbage)garbage;
            plasticCounter++;

        } else if(garbage instanceof PaperGarbage && ((PaperGarbage)garbage).isSqueezed()) {
            if (getPaperContent() == null) {
                tempPaperContent = new PaperGarbage[1];
            } else {
                tempPaperContent = new PaperGarbage[paperCounter];
                for(int i = 0; i < paperContent.length; i++) {
                    tempPaperContent[i] = paperContent[i];
                }
            }
            tempPaperContent[paperCounter - 1] = (PaperGarbage)garbage;
            paperCounter++;

        } else if((!(garbage instanceof PlasticGarbage)) && (!(garbage instanceof PaperGarbage))) {
            if (houseWasteContent == null) {
                tempHouseWasteContent = new Garbage[wasteCounter];
            } else {
                tempHouseWasteContent = new Garbage[wasteCounter];
                for(int i = 0; i < houseWasteContent.length; i++) {
                    tempHouseWasteContent[i] = houseWasteContent[i];
                }
            }
            tempHouseWasteContent[wasteCounter - 1] = garbage;
            wasteCounter++;
            
        } else {
            throw new DustbinContentException();
        }

        houseWasteContent = tempHouseWasteContent;
        plasticContent = tempPlasticContent;
        paperContent = tempPaperContent;
    }

    void emptyContents() {
        plasticContent = null;
        paperContent = null;
        houseWasteContent = null;
    }
}
