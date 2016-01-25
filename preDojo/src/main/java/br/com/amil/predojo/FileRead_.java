package br.com.amil.predojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRead_ {

	public BufferedReader getLerArquivo(String arquivo) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(arquivo));
			return br;	
		}catch(IOException ioe){
			ioe.printStackTrace();
			return null;
		} 
		
	}
	public List<Rank> armazenaPartida(BufferedReader br){
		List<String> usuAssassinados = new ArrayList<String>();
		List<String> usuAssassinos = new ArrayList<String>();
		List<Rank> rankGeral = new ArrayList<Rank>();
		String idPartida = "";
		try {
			while(br.ready()){
				String linha = br.readLine();
				if (linha.contains("New match")){
					idPartida = linha.substring(linha.indexOf("New match"),linha.indexOf(" has"));
					idPartida = idPartida.replace("New match", "").trim();
				}		
				if (linha.contains("killed")){
					String aux = linha.substring(linha.indexOf(" -"));
					aux = aux.replace("-", "");
					if(!aux.contains("<WORLD>"))
						usuAssassinos.add(aux.substring(0,aux.indexOf("killed")).trim());
					if(aux.contains(" using"))
						aux = aux.substring(aux.indexOf("killed"),aux.indexOf(" using")).trim();
					else
						aux = aux.substring(aux.indexOf("killed"),aux.indexOf(" by ")).trim();
					aux = aux.replace("killed", "").trim();
					usuAssassinados.add(aux);
				}
				
			}
			
			for (int i =0; i < usuAssassinos.size(); i++){
				int totalAss = 0;
				int totalMortes = 0;
				for(int k=0; k < usuAssassinos.size(); k++){
					
					if(usuAssassinos.get(i).toUpperCase().equals(usuAssassinos.get(k).toUpperCase())){
						totalAss++;
					}
				}
				for(int w=0; w < usuAssassinados.size(); w++){
					if(usuAssassinos.get(i).toUpperCase().equals(usuAssassinados.get(w).toUpperCase())){
						totalMortes++;
					}
				}
				boolean addElem = true;
				for(Rank rank : rankGeral){
					if(rank.getUsuario().equals(usuAssassinos.get(i)))
						addElem = false;
						
				}
				if(addElem)
				rankGeral.add(new Rank(usuAssassinos.get(i),totalMortes,totalAss,idPartida));
				
			}
			
			for (int i =0; i < usuAssassinados.size(); i++){
				int totalAss = 0;
				int totalMortes = 0;
				for(int k=0; k < usuAssassinados.size(); k++){
					
					if(usuAssassinados.get(i).toUpperCase().equals(usuAssassinados.get(k).toUpperCase())){
						totalMortes++;
					}
				}
				boolean addElem = true;
				for(Rank rank : rankGeral){
					if(rank.getUsuario().equals(usuAssassinados.get(i)))
						addElem = false;
						
				}
				if(addElem)
					rankGeral.add(new Rank(usuAssassinados.get(i),totalMortes,totalAss,idPartida));
				
			}
			
			
			
			br.close();
			return rankGeral;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
