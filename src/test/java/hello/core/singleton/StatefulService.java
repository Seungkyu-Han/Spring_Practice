package hello.core.singleton;

public class StatefulService {

    private int pay;

    public void order(String name, int pay){
        System.out.println("name = " + name + " price = " + pay);
        this.pay = pay;
    }

    public int getPay(){
        return pay;
    }
}
