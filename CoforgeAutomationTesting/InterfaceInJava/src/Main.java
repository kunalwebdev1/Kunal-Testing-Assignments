interface FirstInterface {
    void myMethod();
}

interface SecondInterface {
    void myOtherMethod();
}

class DemoClass implements FirstInterface, SecondInterface {
    public void myMethod() {
        System.out.println("Enter some text...");
    }
    public void myOtherMethod() {
        System.out.println("Enter some other text...");
    }
}

public class Main {
    public static void main(String[] args) {
        DemoClass myObj = new DemoClass();
        myObj.myMethod();
        myObj.myOtherMethod();
    }
}