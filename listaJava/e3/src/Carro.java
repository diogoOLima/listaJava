import java.util.Scanner;

public class Carro extends Veiculo{
  private Categoria categoria;

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public static void cadastroCarro(Scanner entrada) throws Exception{
    Carro car = new Carro();
    System.out.println("Informe a placa do carro: ");
    car.setPlaca(entrada.nextLine());
    System.out.println("Informe de qual categoria o carro é:");
    System.out.println("1 - Hatch ");
    System.out.println("2 - Sedan ");
    System.out.println("3 - Caminhonete ");
    System.out.println("4 - SUV ");
    int opcao = entrada.nextInt();
    entrada.nextLine();
    switch (opcao) {
      case 1:
        car.setCategoria(Categoria.HATCH);
      break;
      
      case 2:
        car.setCategoria(Categoria.SEDAN);
      break;
      
      case 3:
        car.setCategoria(Categoria.CAMINHONETE);
      break;
      
      case 4:
        car.setCategoria(Categoria.SUV);
      break;
      
      default:
        throw new Exception("Categoria de carro inválida");
    }
    car.setStatusVeiculo('D');
    for (Carro carro : DataBase.carArrayList) {
      if(carro.getPlaca().equals(car.getPlaca())){
        throw new Exception("Veiculo ja cadastrado");
      }      
    }
    DataBase.carArrayList.add(car);
  }

  public static void listarCarros(){
    for (Carro car : DataBase.carArrayList){
      if(car.getStatusVeiculo() == 'D'){
        System.out.printf("%s %c\n", car.getPlaca(), car.getStatusVeiculo());
      }
    }
  }
}

