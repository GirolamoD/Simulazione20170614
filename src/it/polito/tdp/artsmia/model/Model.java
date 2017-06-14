package it.polito.tdp.artsmia.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {
	
	private SimpleDirectedGraph<Exhibition,DefaultEdge> grafo ;
	private Map<Integer,Exhibition> esibizioni ;	
	private ArtsmiaDAO dao ;
	private Exhibition max = null ;

	
	public Model(){
		this.dao = new ArtsmiaDAO() ;
	}
	
	public List<Integer> getYears(){
		return dao.getYears() ;
	}

	public boolean creaGrafo(Integer anno) {
		this.grafo = new SimpleDirectedGraph<>(DefaultEdge.class) ;
		
		this.esibizioni = new HashMap<>() ;
		for(Exhibition e : dao.getExhibitions(anno)){
			this.grafo.addVertex(e);
			this.esibizioni.put(e.getId(), e) ;
		}
		
		System.out.println(grafo.vertexSet().toString());
		
		for(Exhibition e1 : grafo.vertexSet())
			for(Exhibition e2 : grafo.vertexSet()){
				if(e1!=e2 && e1.getBegin().isBefore(e2.getBegin()) && e1.getEnd().isAfter(e2.getBegin())){
					grafo.addEdge(e1, e2) ;
				}
			}
		
		ConnectivityInspector<Exhibition,DefaultEdge> c = new ConnectivityInspector<>(grafo) ;
		return c.isGraphConnected() ;
	}
	
	public Exhibition getMax(){
		for(Exhibition e : this.grafo.vertexSet()){
			if(this.max==null){
				this.max=e ;
			}
			else if(e.getOpere().size()>max.getOpere().size())
				this.max = e ;
			
		}
		
		return this.max;
	}

}
