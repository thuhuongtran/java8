package vn.edumall.java8.apis.tasks.java8;

public class Practise {
    /**
     * Explain: lambda expression can override a method from interface which has only one method
     * @param args
     */
    public static void main(String[] args) {
        Greeting gr = message ->
                System.out.println("Hello " + message);
        gr.greet("This is it");
    }

    interface Greeting{
         void greet(String msg);

        default void print() {

        }
        static void blow() {

        }
    }
}
