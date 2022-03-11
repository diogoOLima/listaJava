class Main {
  public static void main(String[] args) {
    Carro fusion = new Carro(1500, 15, 25, 120, 0, 10, 12);//double odometro, double combustivelAtual, double capacidadeTanque, int velocidadeMaxima, int velocidadeAtual, double aceleracaoMedia, double consumoMedio
    fusion.abastecer(4.80, 100);
    fusion.acelerar(12);
    fusion.manterVelocidade(3600);
    fusion.frear(4);
    fusion.manterVelocidade(3600);
  }
}