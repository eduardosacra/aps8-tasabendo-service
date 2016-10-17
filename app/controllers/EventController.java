package controllers;

import models.Evento;
import models.ListaEvento;
import play.libs.Json;
import play.mvc.*;

import com.fasterxml.jackson.databind.JsonNode;

public class EventController extends Controller {
	private ListaEvento lista;

	public Result createEvent(String evento) {
		if (lista == null) {
			lista = new ListaEvento();
		}
		// TODO Verificar se consegue receber um json
		JsonNode json = Json.parse(evento);
		Evento e = Json.fromJson(json, Evento.class);
		String t = evento.toString();
		System.out.println(t);
		this.lista.createEvent(e);
		return ok("OK");
	}

	public Result listaEvent() {
		if (lista == null) {
			lista = new ListaEvento();
		}

		JsonNode eventoJson = Json.toJson(lista.ListEvents());
		System.out.println(eventoJson.toString());
		return ok(eventoJson);
	}
}
