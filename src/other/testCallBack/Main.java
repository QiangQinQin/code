package other.testCallBack;

/**
 * @author QiangQin
 * * @date 2022/12/4
 */
public class Main {
    public static void main(String[] args) {
        Genius genius = new Genius();
        Person you = new Person(genius);
//        you.ask();

        you.askASyn();
    }
}
