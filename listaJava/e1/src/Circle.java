import java.lang.Math;

public class Circle {
    private double radius = 0;
    private double[] positionXY = new double[2];
    private double area = 0;

    private void setRadius(double radius) throws Exception {
        if(radius > 0){
            this.radius = radius;
        }else{
            throw new Exception("O valor do raio deve ser positivo");
        }
    }

    private void setXAxis(double xAxis) {
        this.positionXY[0] = xAxis;
    }

    private void setYAxis(double yAxis) {
        this.positionXY[1] = yAxis;
    }

    private void setArea() throws Exception {
        this.area = Math.PI * Math.pow(this.getRadius(), 2);   
       
    }

    private double getRadius() {
        return this.radius;
    }

    private double getXAxis() {
        return this.positionXY[0];
    }

    private double getYAxis() {
        return this.positionXY[1];
    }

    private double getArea(){
        return this.area;
    }


    public Circle(double radius, double xAxis, double yAxis) throws Exception {
        this.setRadius(radius);
        this.setXAxis(xAxis);
        this.setYAxis(yAxis);
    }

    public void areaOfCircle() throws Exception {
        this.setArea();
        System.out.printf("A area do circulo é: %.2f ",this.getArea()); 
    }

    public void increaseRadius(double percent) throws Exception{
        this.setArea();
        this.setRadius(this.getRadius() * (1 + percent / 100));
        this.setArea();
        System.out.printf("A area do circulo é: %.2f ",this.getArea());
    }

    public void circunferenceLength(){
        double circunferenceLength = 2 * Math.PI * getRadius();
        System.out.printf("O comprimento da circunferencia é de: %.2f ", circunferenceLength);
    }
}
