public class App {
    public static void main(String[] args) throws Exception {
        try{
            Circle circle1 = new Circle(1, 10, 20);
            circle1.areaOfCircle();
            circle1.increaseRadius(50.0);
            circle1.circunferenceLength();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }  
    }
}
