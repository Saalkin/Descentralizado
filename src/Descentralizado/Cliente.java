package Descentralizado;

public class Cliente {

    private Double percentualDesconto;

    public Double obterInformacaoDeDesconto() {
        return percentualDesconto;
    }

    public Double obterValorBase(Integer quantidade, Produto produto) {
        return produto.obterPrecoBase() * quantidade;
    }
}
