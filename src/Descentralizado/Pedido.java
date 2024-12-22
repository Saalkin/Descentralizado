package Descentralizado;

import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<LinhaDePedido> linhasDePedido;

    public Double calcularPreco() {
        Double precoFinal = 0.0;

        for (LinhaDePedido linhaDePedido : linhasDePedido) {
            Integer quantidade = linhaDePedido.obterQuantidade();
            Produto produto = linhaDePedido.obterProduto();

            // Obter valor base diretamente no Pedido
            Double valorBase = obterValorBase(quantidade, produto);

            // Calcular valor com desconto no Pedido
            Double valorComDesconto = obterValorComDesconto(valorBase);

            precoFinal += valorComDesconto;
        }

        return precoFinal;
    }

    public Double obterValorBase(Integer quantidade, Produto produto) {
        return produto.obterPrecoBase() * quantidade;
    }

    public Double obterValorComDesconto(Double valorBase) {
        Double percentualDesconto = cliente.obterInformacaoDeDesconto();
        return valorBase - (valorBase * (percentualDesconto / 100));
    }
}
