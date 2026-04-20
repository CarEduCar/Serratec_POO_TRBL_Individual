import java.util.Date;

public abstract sealed class Veiculo implements Fretavel, Tributavel permits Caminhao {

    final protected String placa;
    final protected String marca;
    protected Double valorLocacaoDiaria;
    final protected Integer anoFabricacao;
    Double precoFipe;

    public Veiculo(String placa, String marca, Double valorLocacaoDiaria, Integer anoFabricacao, Double precoFipe) {
        this.placa = placa;
        this.marca = marca;
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.anoFabricacao = anoFabricacao;
        this.precoFipe = precoFipe;
    }

}
