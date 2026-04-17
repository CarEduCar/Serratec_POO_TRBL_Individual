package TRBL_Individual1.TRBL_2;

public class ContaBancaria {

    private static Integer uid = 0;
    private final Conta conta;

    public ContaBancaria(String nome) {
        this.conta = new Conta();
        this.conta.numero = uid;
        this.conta.titular = nome;
        this.conta.saldo = 50.0;
        uid++;
    }

    public Double GetSaldo(){
        return this.conta.saldo;
    }

    public int GetNumero(){
        return this.conta.numero;
    }

    public String GetNome(){
        return this.conta.titular;
    }

    public void SetSaldo(Double valor){
        this.conta.saldo += valor;
    }
}

