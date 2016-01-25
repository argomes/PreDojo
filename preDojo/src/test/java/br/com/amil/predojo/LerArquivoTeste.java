package br.com.amil.predojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class LerArquivoTeste {
	BufferedReader br;
	
	@Test
	public void lerArquivoTest(){
		String url = "C:\\Projetos\\Estudos\\ProvaAmil\\preDojo\\log.log";
		FileRead_ arq = new FileRead_();
		this.br = arq.getLerArquivo(url);
		try {
			Assert.assertTrue("Leitura ocorrida com sucesso", br.ready());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void armazenaPartidaTest(){
		String url = "C:\\Projetos\\Estudos\\ProvaAmil\\preDojo\\log.log";
		FileRead_ arq = new FileRead_();
		this.br = arq.getLerArquivo(url);
		List<Rank> rabkGeral = arq.armazenaPartida(br);
		for(Rank rank : rabkGeral){
			System.out.println(rank.getIdPartida() + "," + rank.getUsuario() + "," + rank.getQntassassinatos() + "," + rank.getQntMortes());
		}
		Assert.assertTrue(!rabkGeral.isEmpty());
		
	}
}
