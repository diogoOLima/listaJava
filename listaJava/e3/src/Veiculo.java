public class Veiculo{
  private String placa;
  private char statusVeiculo; //D = Disponivel V = Vendido

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public char getStatusVeiculo() {
    return statusVeiculo;
  }

  public void setStatusVeiculo(char statusVeiculo) {
    this.statusVeiculo = statusVeiculo;
  }

  public static void modifyStatusVeicle(String placa, char tipoVeiculo) throws Exception{
    boolean achouVeiculo = false;
    
    if(tipoVeiculo == 'C'){
      for(int x = 0 ; x < DataBase.carArrayList.size() ; x++ ){
        if(DataBase.carArrayList.get(x).getPlaca().equals(placa)){
          achouVeiculo = true;
          if(DataBase.carArrayList.get(x).getStatusVeiculo() == 'D'){
            DataBase.carArrayList.get(x).setStatusVeiculo('V');
          }else{
            throw new Exception("Carro já vendido");
          }
        }
      }
    }else if(tipoVeiculo == 'M'){
      for(int x = 0 ; x < DataBase.motoArrayList.size() ; x++ ){
        if(DataBase.motoArrayList.get(x).getPlaca().equals(placa)){
          achouVeiculo = true;
          if(DataBase.motoArrayList.get(x).getStatusVeiculo() == 'D'){
            DataBase.motoArrayList.get(x).setStatusVeiculo('V');
          }else{
            throw new Exception("Moto já vendida");
          }
        }
      }
    }
    
    if(!achouVeiculo){
      throw new Exception("Veiculo nao encontrado");
    }
  }
}