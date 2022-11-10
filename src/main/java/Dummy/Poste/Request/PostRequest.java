package model.Post.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PostRequest{

	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	public int getUserId(){
		return userId;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getBody(){
		return body;
	}

	public static class Builder{
		private int userIdBuild;;
		private int idBuild;;
		private String titleBuild;;
		private String bodyBuild;

		public Builder withUserId(int userId) {
			this.userIdBuild = userId;
			return this;
		}

		public Builder withId(int idBuild) {
			this.idBuild = idBuild;
			return this;
		}

		public Builder withTitle(String title) {
			this.titleBuild = title;
			return this;
		}

		public Builder withBody(String body) {
			this.bodyBuild = body;
			return this;
		}


		public Builder postHistory() {
			this.titleBuild="Inicio de guerra en Ucrania";
			this.bodyBuild="La guerra ruso-ucraniana es un conflicto bélico entre la Federación de Rusia y Ucrania, que se encuentra actualmente en curso y que se acrecentó tras el tenso período de la crisis ruso-ucraniana";
			this.idBuild=12;
			this.userIdBuild=200;
			return this;
		}

		public Builder postFitccion() {
			this.titleBuild="Frases en Choque de Reyes – Canción de Hielo y Fuego";
			this.bodyBuild="«Si le cortas la lengua a un hombre no demuestras que estuviera mintiendo, demuestras que no quieres que el mundo oiga lo que pueda decir.» -Tyrion a Cersei\n" +
					"«-Al parecer mi querida hermana me ha confundido con Ned Stark.\n" +
					"– Tengo entendido que era más alto.\n" +
					"-Eso fue antes de que Joff le cortara la cabeza”. -Tyrion y Broon\n" +
					"«-No se trata de qué hacemos, sino de por qué lo hacemos» -Tyrion a Chataya\n" +
					"«-Dormir está muy bien. Y los libros, aún mejor.» -Tyrion a Alayaya\n" +
					"«-La brujería es la salsa que los idiotas vierten sobre el fracaso para ocultar el sabor de su incompetencia.» -Tyrion a Sansa";
			this.idBuild=2;
			this.userIdBuild=9;
			return this;
		}

		public PostRequest build() {
			PostRequest request = new PostRequest();
			request.body = bodyBuild;
			request.id=idBuild;
			request.title=titleBuild;
			request.userId=userIdBuild;
			return request;
		}

	}
}