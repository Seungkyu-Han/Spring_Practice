package hello.core.singleton;

public class SingletonService {

    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();


    //2. public 으로 객체가 필요하면 해당 메서드로 받아갈 수 있도록 만든다.
    public static SingletonService getInstance(){
        return instance;
    }

    //3. 생성자를 private 으로 만들어서 생성할 수 없도록 막는다.
    private SingletonService(){
    }

    public void printMethod(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
