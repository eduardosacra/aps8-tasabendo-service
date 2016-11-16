package models;
import java.util.ArrayList;
import java.util.List;

//Class that simulates a database
public class ListaEvento {
	List <Evento> events;	
	

public ListaEvento(){
		events = new ArrayList<Evento>();
		
		Evento evento1 = new Evento();
		evento1.setCategoria("Enchente");
		evento1.setLongitude(-23.472730);//-23.472730, -46.749973
		evento1.setLatitude(-46.749973);
		//evento1.setFoto("/imagens/foto1");
		events.add(evento1);
		
		Evento evento2 = new Evento();
		evento2.setCategoria("Incendio");
		evento2.setLongitude(-23.473940);//-23.473940, -46.751572
		evento2.setLatitude(-46.751572);
		//evento2.setFoto("/imagens/foto2");
		events.add(evento2);
		
		Evento evento3 = new Evento();
		evento3.setCategoria("Desmatamento");
		evento3.setLongitude(-23.473317);//-23.473317, -46.750202
		evento3.setLatitude(-46.750202);
		//evento3.setFoto("/imagens/foto3");
		events.add(evento3);
	}
	
	public void createEvent(Evento evento) {
		this.events.add(evento);
	}
	
	public void deletaEvent(Evento evento) {
		this.events.remove(evento);
	}
	public List<Evento> ListEvents(){
		return this.events;
	}
	public boolean deletaEvento(Evento evento){
		if(this.events.contains(evento)){
			this.events.remove(evento);
			return true;
		}else{
			return false;
		}
	}
}
