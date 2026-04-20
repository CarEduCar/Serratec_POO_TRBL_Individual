import java.util.Date;

public abstract sealed class Veiculo implements Fretavel, Tributavel permits Caminhao, CarroPasseio {

    final protected String modelo;
    final protected String placa;
    final protected String marca;
    protected Double valorLocacaoDiaria;
    final protected Integer anoFabricacao;
    protected Double precoFipe;

    public Veiculo(String modelo, String placa, String marca, Double valorLocacaoDiaria, Integer anoFabricacao, Double precoFipe) {
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.anoFabricacao = anoFabricacao;
        this.precoFipe = precoFipe;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getMarca() {
        return this.marca;
    }

    public Double getValorLocacaoDiaria() {
        return this.valorLocacaoDiaria;
    }

    public Integer getAnoFabricacao() {
        return this.anoFabricacao;
    }

    public Double getPrecoFipe() {
        return this.precoFipe;
    }

    public void setValorLocacaoDiaria(Double valorLocacaoDiaria) {
        this.valorLocacaoDiaria = valorLocacaoDiaria;
    }

    public void setPrecoFipe(Double precoFipe) {
        this.precoFipe = precoFipe;
    }
}
