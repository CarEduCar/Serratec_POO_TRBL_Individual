import java.time.LocalDate;

public final class CarroPasseio extends Veiculo{

    public CarroPasseio(String modelo, String placa, String marca, Double valorLocacaoDiaria, Integer anoFabricacao, Double precoFipe) {
        super(modelo, placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);
    }

    @Override
    public Double AlugarVeiculo (Double pesoCarga, Integer dias) {
        return dias * this.valorLocacaoDiaria;
    }

    @Override
    public Double CalcularIPVA(){
        Integer idadeVeiculo = LocalDate.now().getYear() - this.anoFabricacao;

        if(idadeVeiculo > 20) {
            return 0.00;
        }else {
            return 0.04 * this.precoFipe;
        }
    }
}
