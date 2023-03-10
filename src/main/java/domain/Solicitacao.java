package domain;

import auxs.Metodos;
import exceptions.SolicitacaoSemProdutoException;
import exceptions.SolicitacaoSemRequisitanteException;
import exceptions.TipoAquisicaoException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Solicitacao {
    private float valorSolicitacao;
    private int idSolicitacao;
    private LocalDateTime dataSolicitacao;
    private boolean tipoAquisicao; //true = compra , false - aluguel
    private Requisitante requisitante;
    private List<Produto> produtos;

    public Solicitacao (Requisitante requisitante, List<Produto> produtos, String tipoAquisicao) throws SolicitacaoSemProdutoException, SolicitacaoSemRequisitanteException, TipoAquisicaoException {
        if (produtos == null){
            throw new SolicitacaoSemProdutoException("Não é possível solicitar um pedido sem produto!");
        }
        if (requisitante == null){
            throw new SolicitacaoSemRequisitanteException("Não é possível solicitar um pedido sem produto!");
        }
        if ( !"A".equalsIgnoreCase(tipoAquisicao) && !"C".equalsIgnoreCase(tipoAquisicao) ) {
            throw new TipoAquisicaoException("Digite A para aluguel ou C para compra !");
        }

        this.requisitante = requisitante;
        this.produtos = produtos;
        this.dataSolicitacao = LocalDateTime.now();
        if (tipoAquisicao == "A") {
            this.tipoAquisicao = false;
        }else {
            this.tipoAquisicao = true;
        }

       Metodos.setId();

    }

    @Override
    public String toString(){
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm");
        return String.format("%s;%d;%s",
                            requisitante.getNomeRequisitante(),
                            this.dataSolicitacao.format(formatoData),
                            this.tipoAquisicao?"Compra":"Aluguel");
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public boolean isTipoAquisicao() {
        return tipoAquisicao;
    }

    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public float getValorSolicitacao() {
        return valorSolicitacao;
    }

    public String imprimirSolicitacao(){

        StringBuilder descricaoSolicitacao = new StringBuilder();

        this.idSolicitacao = Metodos.getId();

        descricaoSolicitacao.append(String.format("O numero do pedido é %s  \n", this.getIdSolicitacao()));
        descricaoSolicitacao.append(String.format("O nome do requisitante do pedido é %s \n", this.requisitante.getNomeRequisitante()));
        descricaoSolicitacao.append(String.format("O requisitante se trata de um(a) %s de dominio %s \n", this.requisitante.dominioRequisitante(), this.requisitante.isOrgaoPublico()?"Público":"Privado"));
        descricaoSolicitacao.append(String.format("A data da solicitação foi %s \n", this.getDataSolicitacao()));
        descricaoSolicitacao.append(String.format("Segue abaixo os produtos solicitados e acompanhado do valor unitário, quantidade e subtotal \n"));

        for(Produto p : produtos){
            descricaoSolicitacao.append(String.format("Nome do produto: %s | " , p.getNomeProduto()));
            descricaoSolicitacao.append(String.format("Valor unitário: R$%.2f | " , p.getValor()));
            descricaoSolicitacao.append(String.format("Quantidade solicitada: %s | ", p.getQuantidade()));
            descricaoSolicitacao.append(String.format("O valor subtotal é de R$%.2f", p.getValor() * p.getQuantidade()));
            descricaoSolicitacao.append("\n");
        }
        descricaoSolicitacao.append(String.format("Para equipamentos usados temos desconto de 55%% | "));
        descricaoSolicitacao.append(String.format("Para orgãos públicos é acrescido uma taxa de 20%%  |"));
        descricaoSolicitacao.append(String.format("Para acessórios que acompanham equipamento, o valor sai no subtotal, porém não é considerado no valor total  "));
        descricaoSolicitacao.append("\n");
        this.valorSolicitacao = calculoTotalSolicitacao();
        descricaoSolicitacao.append(String.format("O total da solicitação foi de R$%.2f" , this.getValorSolicitacao()));

        return String.valueOf(descricaoSolicitacao);
    }


    public float calculoTotalSolicitacao(){
        float total = 0;

        for (Produto p: produtos){
            total += (p.calcularValorTotal());
        }
        if (requisitante.isOrgaoPublico()){
            total *= 1.1;
        }
        //calcular desconto?

        return total;
    }
}
