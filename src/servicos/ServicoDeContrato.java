package servicos;

import java.time.LocalDate;

import entidades.Contrato;
import entidades.Parcela;

public class ServicoDeContrato {
	
	private ServicoPagamentoOnline servicoPagamentoOnline;
	
	public ServicoDeContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}

	public void processaContrato(Contrato contrato, int meses) {
		double parcelaBase = contrato.getValorTotal() / meses;
		for (int i = 1; i <= meses; i++) {
			LocalDate dataVencimento = contrato.getData().plusMonths(i);
			double juros = servicoPagamentoOnline.juros(parcelaBase, i);
			double taxa = servicoPagamentoOnline.taxaPagamento(parcelaBase + juros);
			double parcela = parcelaBase + juros + taxa;
			
			contrato.getParcelas().add(new Parcela(dataVencimento, parcela));
		}
	}
}
