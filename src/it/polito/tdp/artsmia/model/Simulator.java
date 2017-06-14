package it.polito.tdp.artsmia.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

public class Simulator {
	
	private int numStudenti ;
	private SimpleDirectedGraph<Exhibition,DefaultEdge> grafo ;

	
	private List<Studente> lista ;
	
	private PriorityQueue<Event> queue ;

	public Simulator(int numStudenti,SimpleDirectedGraph<Exhibition,DefaultEdge> grafo) {
		super();
		this.numStudenti = numStudenti;
		this.lista = new ArrayList<>() ;
		this.queue = new PriorityQueue<Event>() ;
		this.grafo = new SimpleDirectedGraph<>(DefaultEdge.class) ;
	}
	
	public void initialize (){
		Exhibition partenza = null ;
		
		for(Exhibition e : grafo.vertexSet()){
			partenza = e ;
			break ;
		}
		for(int i=0 ; i<this.numStudenti ; i++){
			Studente s = new Studente(partenza) ;
			this.lista.add(s) ;
			this.queue.add(new Event(s)) ;
		}
			
	}
	
	public void run(){
		while(queue.isEmpty()){
			Studente s = queue.poll().getS() ;
			if(s.getProssimo() == null)
				return ;
			for(Integer o : s.getProssimo().getOpere())
				if(!s.getViste().contains(o))
					s.getViste().add(o) ;
			if(grafo.outgoingEdgesOf(s.getProssimo()).size() == 0){
				s.setProssimo(null);
				return ;
			}
			else 
		}
	}
	
	
	
}
