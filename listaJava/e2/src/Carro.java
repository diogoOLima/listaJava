import java.lang.Math;

public class Carro {
    private double odometro;
    private double combustivelAtual;
    private double capacidadeTanque;
    private int velocidadeMaxima;
    private int velocidadeAtual;
    private double aceleracaoMedia;
    private double consumoMedio;

    public Carro(double odometro, double combustivelAtual, double capacidadeTanque, int velocidadeMaxima, int velocidadeAtual, double aceleracaoMedia, double consumoMedio) {
        setOdometro(odometro);
        setCombustivelAtual(combustivelAtual);
        setCapacidadeTanque(capacidadeTanque);
        setVelocidadeMaxima(velocidadeMaxima);
        setVelocidadeAtual(velocidadeAtual);
        setAceleracaoMedia(aceleracaoMedia);
        setConsumoMedio(consumoMedio);
    }

    public void abastecer(double custoLitro, double valorPago) {
        double convertLitro = valorPago / custoLitro;
        double troco = 0;
        if (this.combustivelAtual + convertLitro > this.capacidadeTanque) {
            double combustivelExcedente = this.combustivelAtual + convertLitro - this.capacidadeTanque;
            this.combustivelAtual += convertLitro - combustivelExcedente;
            troco = combustivelExcedente * custoLitro;
        } else {
            this.combustivelAtual += convertLitro;
        }
        System.out.printf("troco %.2f combustivel atual %.2f \n", troco, getCombustivelAtual());
    }

    public void acelerar(int segundos) {
        System.out.println("Acelerando");
        for (int x = 1; x <= segundos; x++) {
            if (this.velocidadeAtual + this.aceleracaoMedia < this.velocidadeMaxima) {
                this.velocidadeAtual += this.aceleracaoMedia;
            } else {
                this.velocidadeAtual = this.velocidadeMaxima;
            }
            this.odometro += (this.velocidadeAtual / 3.6) / 1000;
            this.combustivelAtual -= ((this.velocidadeAtual / 3.6) / 1000) / this.consumoMedio;   
        }
        getInfo();
        
        
    }

    public void manterVelocidade(int segundos) {
        System.out.println("Mantendo velocidade");
        for (int x = 1; x <= segundos; x++) {
            this.odometro += (this.velocidadeAtual / 3.6) / 1000;
            this.combustivelAtual -= ((this.velocidadeAtual / 3.6) / 1000) / this.consumoMedio;
        }
        getInfo();
    }

    public void frear(int segundos) {
        System.out.println("Freando");
        for (int x = 1; x <= segundos; x++) {
            if (this.velocidadeAtual - this.aceleracaoMedia > 0) {
                this.velocidadeAtual -= this.aceleracaoMedia;
            } else {
                this.velocidadeAtual = 0;
            }
            this.odometro += (this.velocidadeAtual / 3.6) / 1000;
            this.combustivelAtual -= ((this.velocidadeAtual / 3.6) / 1000) / this.consumoMedio;
            if(this.combustivelAtual < 0){
                this.combustivelAtual = 0; 
            }
        }
        getInfo();
    }

    public void getInfo(){
        System.out.printf("Velocidade atual %d, Odometro %.2f, combustivel atual %.2f \n", getVelocidadeAtual(), getOdometro(), Math.floor( getCombustivelAtual() * 100) / 100);
    }

    public double getOdometro() {
        return odometro;
    }

    public void setOdometro(double odometro) {
        this.odometro = odometro;
    }

    public double getCombustivelAtual() {
        return combustivelAtual;
    }

    public void setCombustivelAtual(double combustivelAtual) {
        this.combustivelAtual = combustivelAtual;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(int velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public double getAceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setAceleracaoMedia(double aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public double getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    
}
