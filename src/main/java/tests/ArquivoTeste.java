package tests;

import auxs.Constantes;
import auxs.Metodos;
import domain.*;
import exceptions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoTeste {

    public static void main(String[] args) {
        Metodos.arqEnergia();
        String arq = "solicitacoes.txt";
        try {
            FileReader arquivoL = new FileReader(Constantes.diretorio + "entrada_" + arq);
            BufferedReader leitura = new BufferedReader(arquivoL);

            FileWriter arquivoE = new FileWriter(Constantes.diretorio + "saida_" + arq);
            BufferedWriter escrita = new BufferedWriter(arquivoE);

            String linha = leitura.readLine();
            String[] campos = null;

            List<Produto> produtos = new ArrayList<Produto>();
            Solicitacao solicitacao = null;

            while (linha != null){
                campos = linha.split(";");

                switch (campos[0]){
                    case "a":
                        try {
                            Acessorio a1 = new Acessorio(campos[1], Integer.parseInt(campos[2]), Float.parseFloat(campos[3]), campos[4],campos[5], campos[6],Integer.parseInt(campos[7]));
                            a1.setEquipamentoAlvo("Monitor Multiparâmetro");
                            System.out.println(a1.toString());
                        } catch (ValorValidoException | NomeInvalidoException e) {
                            System.out.println(("[ERRO] - " + e.getMessage()));
                        }
                        break;
                    case "e":
                        try {
                            Equipamento e1 = new Equipamento(campos[1], Integer.parseInt(campos[2]), campos[3], Integer.parseInt(campos[4]), Float.parseFloat(campos[5]), campos[6], Integer.parseInt(campos[7]), Integer.parseInt(campos[8]), campos[9]);
                            System.out.println(e1.toString());
                        }catch(TensaoInvalidaException |ValorValidoException | AnoInvalidoException | NomeInvalidoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "i":
                        try{
                            Insumo i1 = new Insumo(campos[1], Integer.parseInt(campos[2]), Float.parseFloat(campos[3]), campos[4], campos[5],campos[6],Integer.parseInt(campos[7]));
                            System.out.println(String.format("R$%.2f", i1.calcularValorTotal()));
                            System.out.println(i1.toString());
                        } catch (TipoInsumoException | NomeInvalidoException | ValorValidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "s":
                        try {
                            solicitacao = new Solicitacao(new Requisitante(campos[1], Integer.parseInt(campos[2]), campos[3]), produtos, campos[4]);
                            solicitacao.imprimirSolicitacao();
                            break;
                        }catch (TipoInsumoException | TipoAquisicaoException | SolicitacaoSemProdutoException | SolicitacaoSemRequisitanteException | ValorValidoException| NomeInvalidoException e){
                            System.out.println(e.getMessage());
                        }
                    case "r":
                        try {
                            Requisitante r1 = new Requisitante(campos[1], Integer.parseInt(campos[2]),campos[3]);
                            System.out.println(r1.toString());
                        } catch (ValorValidoException | TipoInsumoException | NomeInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }

                linha = leitura.readLine();
            }
            escrita.write(solicitacao.imprimirSolicitacao());
            escrita.close();
            leitura.close();
            arquivoL.close();
            arquivoE.close();

        } catch (IOException e) {
            System.out.println("[ERRO] - Não foi possível ler o arquivo");
        }
        finally {
            System.out.println("Arquivo de pedido gerado com sucesso!");
        }
    }
}