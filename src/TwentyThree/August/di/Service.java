package TwentyThree.August.di;

public class Service {
    public Interface1 interfaceVar;

    Service(Interface1 interfaceVar2){
        this.interfaceVar = interfaceVar2;
    }
    // 필드
    // 생성자
    // 익명내부클래스
    public String findEgg() {
        return interfaceVar.getEgg();
    }
}
