package com.revature.favTeam;
import java.util.ArrayList;

import io.javalin.Javalin;

public class Driver {
	public static ArrayList<Favorite>favorites;
	static int currentIndex;
	
	
	public static void main(String[] args) {
		favorites = new ArrayList<Favorite>();
		currentIndex = 0;
		 
		
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
			for (int index=0;index<favorites.size();index++) {
				System.out.println(favorites.get(index).getPersonName());
				System.out.println(favorites.get(index).getTeamName());
				if (favorites.get(index)!= null) {
					responseText += favorites.get(index).getPersonName()+ "'s favorite team is: "+favorites.get(index).getTeamName()+ "<br>";
				}
				
			}
			
			ctx.html(responseText);
		});
	}
}

