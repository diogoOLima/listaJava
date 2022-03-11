import java.util.Scanner;

class App {
  public static void main(String[] args) {
    int opcao = 0;
    Scanner entrada = new Scanner(System.in);

    System.out.println("Bem-vindo a revenda pino da parafuseta");
    do{
      try {
        opcao = menu(opcao, entrada);
      } catch (Exception e) {
        System.out.println("aconteceu exceção");
        System.out.println(e.getMessage());
        e.printStackTrace();
      }
    }while(opcao != 7);
    entrada.close();
  }

  private static int menu(int opcao, Scanner entrada) throws Exception {
    System.out.println("Informe a opção desejada: \n");
    System.out.println("1-Cadastrar uma pessoa\n");
    System.out.println("2-Cadastrar um carro\n");
    System.out.println("3-Cadastrar uma moto\n");
    System.out.println("4-Registar uma venda\n");
    System.out.println("6-Sair do menu\n");
    opcao = entrada.nextInt();
    entrada.nextLine();
    switch (opcao) {
      case 1:
        Pessoa.cadastroPessoa(entrada);
        break;
      case 2:
        Carro.cadastroCarro(entrada);
        break;
      case 3:
        Moto.cadastroMoto(entrada);
        break;
      case 4:
        RegistroCompraVenda.registroCompraVenda(entrada);
        break;
    }
    return opcao;
  }
}
