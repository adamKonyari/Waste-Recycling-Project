import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws DustbinContentException {
        try {

            Garbage milkJug = new PlasticGarbage("plastic milk jug", false);
            Garbage plasticFork = new PlasticGarbage("plastic fork", true);
            Garbage paperTowel = new PaperGarbage("used paper towel", false);
            Garbage cBox = new PaperGarbage("cardboard box", false);
            Garbage bananaPeal = new Garbage("banana peal");
            Garbage dirtySandwich = new Garbage("dirty sandwich");
            Garbage[] rottenTomatoes = new Garbage[3];
            for (int i = 0; i < 3; i++) {
                rottenTomatoes[i] = new Garbage("rotten tomato nr." + (i + 1));
            }


            System.out.println("Waste recycling story v1.0");
            System.out.println("");
            Thread.sleep(1000);

            System.out.println("Dining area @ CC-Cambodia looks like a mess...");
            Thread.sleep(1000);
            System.out.println("There is garbage everywhere.");
            System.out.println("");
            Thread.sleep(1000);
            Dustbin redDustbin = new Dustbin("Red");
            System.out.println("Cleaning lady comes in, and checks if there is anything in the " + redDustbin.getColor() + " dustbin.");
            System.out.println("");
            Thread.sleep(1000);
            redDustbin.displayContents();
            Thread.sleep(1000);
            System.out.println("Of course it is empty. However, a bunch of stuff are lying around.");
            Thread.sleep(1000);
            System.out.println("");
            System.out.println("First of all, she grabs " + rottenTomatoes.length + " rotten tomatoes and throws them into the " + redDustbin.getColor() + " dustbin.");

            for(Garbage i: rottenTomatoes) {
                redDustbin.throwOutGarbage(i);
            }
            Thread.sleep(1000);
            System.out.println("");
            System.out.println("Then she sees a" + milkJug.getName() + " and cleans it.");
            ((PlasticGarbage)milkJug).clean();
            Thread.sleep(1000);
            System.out.println("");
            System.out.println("...And throws it into the " + redDustbin.getColor() + " dustbin");
            redDustbin.throwOutGarbage(milkJug);
            Thread.sleep(1000);
            System.out.println("");
            System.out.println("Next, she grabs the " + plasticFork.getName() + " and throws it out.");
            redDustbin.throwOutGarbage(plasticFork);
            System.out.println("");
            Thread.sleep(1000);
            System.out.println("She opens the fridge, and finds a " + dirtySandwich.getName() + ".");
            System.out.println("");
            Thread.sleep(1000);
            System.out.println("Just get this one to the dustbin too.. Shall we?");
            System.out.println("");
            Thread.sleep(1000);
            redDustbin.throwOutGarbage(dirtySandwich);
            System.out.println("Finally, there is a " + cBox.getName() + " and a" + paperTowel.getName() + ".");
            System.out.println("");
            Thread.sleep(1000);
            System.out.println("The cleaning lady squeezes them both, and throws them into the red dustbin.");
            ((PaperGarbage)cBox).squeeze();
            ((PaperGarbage)paperTowel).squeeze();
            System.out.println("");
            Thread.sleep(1000);
            redDustbin.throwOutGarbage(cBox);
            redDustbin.throwOutGarbage(paperTowel);
            System.out.println("The dining area seems to be clean. Let's see what is now in the dustbin.");
            System.out.println("");
            Thread.sleep(1000);
            redDustbin.displayContents();
            System.out.println("");
            Thread.sleep(1000);

            System.out.println("The last thig to do is to empty the dustbin.");
            System.out.println("");
            Thread.sleep(1000);
            redDustbin.emptyContents();
            redDustbin.displayContents();


        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
}
