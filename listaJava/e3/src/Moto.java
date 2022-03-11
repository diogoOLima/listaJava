import java.util.Scanner;

public class Moto extends Veiculo {
    
    public static void cadastroMoto(Scanner entrada) throws Exception{
        Moto motorcycle = new Moto();
        System.out.println("Informe a placa da moto: ");
        motorcycle.setPlaca(entrada.nextLine());
        motorcycle.setStatusVeiculo('D');
        for (Moto moto : DataBase.motoArrayList) {
            if(moto.getPlaca().equals(motorcycle.getPlaca())){
              throw new Exception("Veiculo ja cadastrado");
            }      
        }
        DataBase.motoArrayList.add(motorcycle);
    }

    public static void listarMotos(){
        for (Moto motorcycle : DataBase.motoArrayList) {
            System.out.printf("%s \n", motorcycle.getPlaca());
        }
    }
}
