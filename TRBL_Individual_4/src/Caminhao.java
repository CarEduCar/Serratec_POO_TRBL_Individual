import java.time.LocalDate;

public final class Caminhao extends Veiculo{

    final private Double capacidadeCargaToneladas;

    public Caminhao(String modelo, String placa, String marca, Double valorLocacaoDiaria, Integer anoFabricacao, Double precoFipe, Double carga) {
        super(modelo, placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);
        this.capacidadeCargaToneladas = carga;
    }

    public Double getCapacidadeCargaToneladas() {
        return capacidadeCargaToneladas;
    }

    @Override
    public Double AlugarVeiculo (Double pesoCarga, Integer dias) {
        Double custo = dias * this.valorLocacaoDiaria;

        if (pesoCarga > this.capacidadeCargaToneladas) {
            custo += custo * 0.1;
        }
        return custo;
    }

    @Override
    public Double CalcularIPVA(){
        Integer idadeVeiculo = LocalDate.now().getYear() - this.anoFabricacao;

        if(idadeVeiculo > 20) {
            return 0.00;
        }else {
             return 0.015 * this.precoFipe;
        }
    }
}
