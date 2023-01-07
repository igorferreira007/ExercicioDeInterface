package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate dataVencimento;
	private double valor;
	
	public Parcela(LocalDate dataVencimento, double valor) {
		this.dataVencimento = dataVencimento;
		this.valor = valor;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return dataVencimento.format(fmt) + " - " + String.format("%.2f", valor);
	}
	
	
	
	
}
