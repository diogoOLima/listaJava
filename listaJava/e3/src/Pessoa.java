import java.util.Scanner;

public class Pessoa{
  private String cpf;
  private String nome;
  private char tipoPessoa;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public char getTipoPessoa() {
    return tipoPessoa;
  }

  public void setTipoPessoa(char tipoPessoa) {
    this.tipoPessoa = tipoPessoa;
  }

  public static void cadastroPessoa(Scanner entrada) throws Exception {
    Pessoa person = new Pessoa();
    System.out.println("Informe o nome da pessoa:");
    person.setNome(entrada.nextLine());
    System.out.println("Informe o cpf");
    person.setCpf(entrada.nextLine());
    System.out.println("É um cliente(C) ou um vendedor(V)?");
    person.setTipoPessoa(entrada.next().toUpperCase().charAt(0));
    if(person.tipoPessoa != 'C' && person.tipoPessoa != 'V'){
      System.out.println("teste2");
      throw new Exception("tipo de pessoa invalido");
    }
    
    if(DataBase.personArrayList.size() == 0){
      System.out.println("cadastrado com sucesso");
      DataBase.personArrayList.add(person);
    }else{
      int tamanhoLista = DataBase.personArrayList.size();
      for (int x = 0 ; x < tamanhoLista ; x++) {
        if(DataBase.personArrayList.get(x).getCpf().equals(person.cpf)){
          if(DataBase.personArrayList.get(x).getTipoPessoa() == person.getTipoPessoa()){
            throw new Exception("cpf ja cadastrado");
          }
        }
      }
      DataBase.personArrayList.add(person);
    }
    listarPessoa(person.getTipoPessoa());
  }

  public static void listarPessoa(char tipoPessoa){
    for (Pessoa person : DataBase.personArrayList)  {
      if(person.getTipoPessoa() == tipoPessoa){
        System.out.printf("%s %s \n", person.getCpf(), person.getNome());
      }
    }

  }

  public static Pessoa buscarPessoa(Pessoa pessoa ) throws Exception{
    int achouPessoa = 0;
    for (Pessoa person : DataBase.personArrayList){
      if(person.getCpf().equals(pessoa.getCpf()) && person.getTipoPessoa() == pessoa.getTipoPessoa() ){
        achouPessoa = 1;
        pessoa.setNome(person.getNome());
      }
    }

    if(achouPessoa == 0){
      throw new Exception("Pessoa nao encontrada");
    }
    
    return pessoa;

  }
}