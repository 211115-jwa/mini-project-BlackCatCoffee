package com.revature.favTeam;
import java.util.ArrayList;
import java.util.List;

import io.javalin.Javalin;

public class Driver {
	public static List<Favorite>favorites;
	
	
	public static void main(String[] args) {
		favorites = new ArrayList<Favorite>();
		 
		
		Javalin app = Javalin.create();
		
		app.start();
		
		app.post("/favteam", ctx -> {
			// information from html page is coming in as "form parameters"
			Favorite fav = new Favorite();
			fav.setPersonName(ctx.formParam("personName"));
			fav.setTeamName(ctx.formParam("teamName"));
			
			favorites.add(fav);
			
			String responseText = "";
			
			// adds name and team to response
			for (int index=0;index < favorites.size();index++) {
				responseText += favorites.get(index).getPersonName() + 
						"'s favorite team is: " + favorites.get(index).getTeamName() + "<br>";	
			}
			
			ctx.html(responseText);
		});
	}
}

