public class OverrVsOverl {

    public static void main(String[] args) {
        parent abc = new parent();
    }




}
class parent {
    public void aMethod() {
        System.out.print("Parent");
    }
}

class child extends parent {
    public void aMethod() {
        System.out.print("Child");
    }
}