package com.revature.favTeam;

public class Driver {
	static Favorite[] favorites;
	static int currentIndex;
	
	public static void main(String[] args) {
		currentIndex=0;
		favorites = new Favorite[10]; // initializing the pets array
		
		Javalin app = Javalin.create();
		
		app.start();
		
		app.post("/favteam", ctx -> {
			
			Favorite team = new Favorite();
			Favorite.name = ctx.formParam("name");
			Favorite.teamName = ctx.formParam("teamName");
			
			
			favorites[currentIndex] = favorite;
			currentIndex++;
			
			String responseText = "";
			
			for (Favorite eachPet : favorites) {
				System.out.println(eachFavorite);
				if (eachFavorite != null) {
					responseText += eachFavorite.name +"'s favorite team is:"+ eachFavorite.teamName + "<br>";
				}
			}
			
			ctx.html(responseText);
		});
	}
}

