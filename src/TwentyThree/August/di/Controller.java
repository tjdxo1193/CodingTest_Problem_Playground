package TwentyThree.August.di;

public class Controller {
    public Interface1 interfaceVar = new Embodiment();
    public String findEgg() {
        return interfaceVar.getEgg();
    }
}
