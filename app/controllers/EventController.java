package controllers;

import models.Evento;
import models.ListaEvento;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

import dao.BackendDao;

public class EventController extends Controller {
	
	private static BackendDao dao = new BackendDao();
	private ListaEvento lista;// provisional list of events

	@Transactional
	public Result createEvent() {
//		if (lista == null) {
//			lista = new ListaEvento();
//		}
		
		JsonNode json = request().body().asJson();
		// parse the JSON as a JsonNode
		// read the JsonNode as a Person
		Evento evento = Json.fromJson(json, Evento.class);
		System.out.println("Tentando salvar Evento  "+Json.toJson(evento));
		if (evento == null) {
			System.out.println(badRequest("Deu pau"));
			return badRequest("Deu pau");			
		} else {
			//this.lista.createEvent(evento);
			dao.addOneEvento(evento);
			System.out.println(Json.toJson(evento));
			return ok("Evento recebido: " + Json.toJson(evento));
		}

		// System.out.println("Evento POST "+ evento);
		// JsonNode json = Json.parse(evento);
		// Evento e = Json.fromJson(json, Evento.class);
		// String t = evento.toString();
		// System.out.println("Evento Criado: "+t);
		// this.lista.createEvent(e);

	}

	
	public Result listaEventos() {
		if (lista == null) {
			lista = new ListaEvento();
		}
		
		JsonNode eventoJson = Json.toJson(lista.ListEvents());
		System.out.println(eventoJson.toString());
		return ok(eventoJson);
	}
	
	@Transactional
	public Result listaEvento() {
		
		JsonNode json = request().body().asJson();
		double latitude =  Double.parseDouble(json.findParent("latitude").textValue());
		double longitude = Double.parseDouble(json.findParent("longitude").textValue());

		JsonNode eventoJson = Json.toJson(dao.selectSomeEvents(latitude, longitude));
		System.out.println(eventoJson.toString());
		return ok(eventoJson);
	}
}
