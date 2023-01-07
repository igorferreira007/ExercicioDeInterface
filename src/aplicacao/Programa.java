package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Parcela;
import servicos.ServicoDeContrato;
import servicos.ServicoPaypal;

public class Programa {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com dados do contrato:");
		System.out.print("Numero: ");
		int numero = ler.nextInt();
		ler.nextLine();
		System.out.print("Data (DD/MM/AAAA): ");
		String stringData = ler.nextLine();
		LocalDate data = LocalDate.parse(stringData, fmt);
		System.out.print("Valor do contrato: ");
		double valorTotal = ler.nextDouble();
		ler.nextLine();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print("Entre com o numero de parcelas: ");
		int numParcelas = ler.nextInt();
		ler.nextLine();
		
		ServicoDeContrato servicoDeContrato = new ServicoDeContrato(new ServicoPaypal());
		servicoDeContrato.processaContrato(contrato, numParcelas);
		
		System.out.println("Parcelas: ");
		for (Parcela parcela : contrato.getParcelas()) {
			System.out.println(parcela);
		}

	}

}
