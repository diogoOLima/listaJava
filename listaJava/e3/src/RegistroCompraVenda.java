import java.util.Scanner;

public class RegistroCompraVenda{
  private TipoPagamento tipoPagamento;
  private Pessoa vendedor = new Pessoa();
  private Pessoa cliente = new Pessoa();
  private char tipoRegistro;
  private char tipoVeiculo;


  public TipoPagamento getTipoPagamento() {
    return tipoPagamento;
  }


  public void setTipoPagamento(TipoPagamento tipoPagamento) {
    this.tipoPagamento = tipoPagamento;
  }


  public Pessoa getVendedor() {
    return vendedor;
  }


  public void setVendedor(Pessoa vendedor) {
    this.vendedor = vendedor;
  }


  public Pessoa getCliente() {
    return cliente;
  }


  public void setCliente(Pessoa cliente) {
    this.cliente = cliente;
  }


  public char getTipoRegistro() {
    return tipoRegistro;
  }


  public void setTipoRegistro(char tipoRegistro) {
    this.tipoRegistro = tipoRegistro;
  }


  public char getTipoVeiculo() {
    return tipoVeiculo;
  }


  public void setTipoVeiculo(char tipoVeiculo) {
    this.tipoVeiculo = tipoVeiculo;
  }


  public static void registroCompraVenda(Scanner entrada) throws Exception{
    RegistroCompraVenda registroCV = new RegistroCompraVenda();
    Pessoa.listarPessoa('V');
    System.out.println("Informe o cpf do vendedor");
    registroCV.vendedor.setCpf(entrada.nextLine());
    registroCV.vendedor.setTipoPessoa('V');
    registroCV.setVendedor(Pessoa.buscarPessoa(registroCV.vendedor));

    Pessoa.listarPessoa('C');
    System.out.println("Informe o cpf do cliente");
    registroCV.cliente.setCpf(entrada.nextLine());
    registroCV.cliente.setTipoPessoa('C');
    registroCV.setCliente(Pessoa.buscarPessoa(registroCV.cliente));

    System.out.println("Informe o tipo de pagamento: ");
    System.out.println("1 - Á vista");
    System.out.println("2 - Cartão de crédito");
    System.out.println("3 - Cartão de débito");
    int opcao = entrada.nextInt();
    entrada.nextLine();
    
    switch (opcao) {
      case 1:
        registroCV.setTipoPagamento(TipoPagamento.A_VISTA);
      break;
      
      case 2:
        registroCV.setTipoPagamento(TipoPagamento.CARTAO_CREDITO);
      break;
      
      case 3:
        registroCV.setTipoPagamento(TipoPagamento.CARTAO_DEBITO);
      break;
      
      default:
        throw new Exception("Opcao de pagamento invalida");
    }

    System.out.println("Informe o tipo de veiculo:");
    System.out.println("C - Carro");
    System.out.println("M - Moto");
    registroCV.tipoVeiculo = entrada.nextLine().toUpperCase().charAt(0);
    if(registroCV.tipoVeiculo != 'M' && registroCV.tipoVeiculo != 'C'){
      throw new Exception("Tipo de veiculo inexistente");
    }

    System.out.println("O registro é de uma aquisicao(A) ou de uma venda(V)?");
    registroCV.tipoRegistro = entrada.nextLine().toUpperCase().charAt(0);
    if(registroCV.tipoRegistro != 'A' && registroCV.tipoRegistro != 'V'){
      throw new Exception("Tipo de registro inexistente");
    }
    
    if(registroCV.tipoRegistro ==  'A'){
      if(registroCV.tipoVeiculo == 'M'){
        Moto.cadastroMoto(entrada);
      }else if(registroCV.tipoVeiculo == 'C'){
        Carro.cadastroCarro(entrada);
      }
    }else if(registroCV.tipoRegistro ==  'V'){
      if(registroCV.tipoVeiculo == 'C'){
        Carro.listarCarros();
      }else if(registroCV.tipoVeiculo == 'M'){
        Moto.listarMotos();
      }

      System.out.println("Informe a placa: ");
      String placa = new String();
      placa = entrada.nextLine();
      Veiculo.modifyStatusVeicle(placa, registroCV.tipoVeiculo);
    }
    DataBase.registroCompraVendaArrayList.add(registroCV);
  }
}