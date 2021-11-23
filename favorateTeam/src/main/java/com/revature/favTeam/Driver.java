package com.revature.favTeam;

import io.javalin.Javalin;

public class Driver {
	static Favorite[] favorites;
	static int currentIndex;
	
	public static void main(String[] args) {
		currentIndex=0;
		favorites = new Favorite[10];
		
		Javalin app = Javalin.create();
		
		app.start();
		
		app.post("/favteam", ctx -> {
			
			Favorite team = new Favorite();
			team.name = ctx.formParam("name");
			team.teamName = ctx.formParam("teamName");
			
			
			favorites[currentIndex] = team;
			currentIndex++;
			
			String responseText = "";
			
			for (Favorite eachFavorite : favorites) {
				System.out.println(eachFavorite);
				if (eachFavorite != null) {
					responseText += eachFavorite.name +"'s favorite team is:"+ eachFavorite.teamName + "<br>";
				}
			}
			
			ctx.html(responseText);
		});
	}
}

