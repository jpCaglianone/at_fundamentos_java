package domain;

import exceptions.NomeInvalidoException;
import exceptions.TipoInsumoException;
import exceptions.ValorValidoException;

public class Insumo extends Produto{

    private String tipoInsumo;
    private boolean descartavel;
    private int quantidadeLote;


    public Insumo(String nomeProduto, int quantidade, float valor, String marca,String tipoInsumo, String durabilidade, int quantidadeLote) throws TipoInsumoException,ValorValidoException, NomeInvalidoException {
        super(nomeProduto, quantidade, valor, marca);

    if(!"dependente".equalsIgnoreCase(tipoInsumo) && !"independente".equalsIgnoreCase(tipoInsumo)){
        throw new TipoInsumoException("Só são permitidos os valores DEPENDENTE ou INDEPENDENTE!1");
    }

    if(!"descartável".equalsIgnoreCase(durabilidade) && !"permanente".equalsIgnoreCase(durabilidade)){
        throw new TipoInsumoException("Só são permitidos os valores DESCARTÁVEL ou PERMANENTE");
    }

    if(quantidadeLote <= 0){
        throw new ValorValidoException("A quantidade deve ser maior que 0!");
    }

    this.tipoInsumo = durabilidade;

    this.descartavel = "descartável".equalsIgnoreCase(durabilidade);

    this.quantidadeLote = quantidadeLote;

    }

    public int getQuantidadeLote() {
        return quantidadeLote;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public boolean isDescartavel() {
        return descartavel;
    }

    @Override
    public float calcularValorTotal() {
        float total;
        total = getValor();
        total *= getQuantidadeLote() * super.getQuantidade();
        if(!isDescartavel()){
         total *=1.3;
        }
        return total;
    }
}
