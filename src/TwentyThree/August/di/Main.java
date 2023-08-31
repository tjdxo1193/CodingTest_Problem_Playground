package TwentyThree.August.di;

public class Main {
    public static void main(String[] args) {
        Service service = new Service(new Embodiment());
        Service service2 = new Service(new Embodiment2());
        System.out.println(service.findEgg());
        System.out.println(service2.findEgg());
    }
}
