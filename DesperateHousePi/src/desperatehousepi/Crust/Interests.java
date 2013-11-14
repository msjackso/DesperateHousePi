package desperatehousepi.Crust;

import java.util.Random;

public class Interests{
	
	public static final int NUM_OF_INTERESTS = 33;
	
	public static final int RANDOM_VAL = -1;
	public static final int MUSIC_VAL = 1;
	public static final int FOOD_VAL = 2;
	public static final int DANCING_VAL = 3;
	public static final int FILM_VAL = 4;
	public static final int COMPUTERS_VAL = 5;
	public static final int GAMING_VAL = 6;
	public static final int SPORTS_VAL = 7;
	public static final int OUTDOORS_VAL = 8;
	public static final int COMPUTERPROGRAMMING_VAL = 9;
	public static final int COOKING_VAL = 10;
	public static final int ART_VAL = 11;
	public static final int HOMEBREWING_VAL = 12;
	public static final int LEGOBUILDING_VAL = 13;
	public static final int MAGIC_VAL = 14;
	public static final int READING_VAL = 15;
	public static final int SKATEBOARDING_VAL = 16;
	public static final int VIDEOGAMING_VAL = 17;
	public static final int WRITING_VAL = 18;
	public static final int BASKETBALL_VAL = 19;
	public static final int GARDENING_VAL = 20;
	public static final int GHOSTHUNTING_VAL = 21;
	public static final int MYCOLOGY_VAL = 22;
	public static final int RUNNING_VAL = 23;
	public static final int SURFING_VAL = 24;
	public static final int SWIMMING_VAL = 25;
	public static final int ROCKSTACKING_VAL = 26;
	public static final int GO_VAL = 27;
	public static final int LODGEDODGEPONG_VAL = 28;
	public static final int BASEBALL_VAL = 29;
	public static final int FISHING_VAL = 30;
	public static final int JUKSKEI_VAL = 31;
	public static final int KARTRACING_VAL = 32;
	public static final int FOOTBALL_VAL = 33;
	
	
	public static Interest getInterest(int val){
		
		
		
		if(val == RANDOM_VAL){
			Random rand = new Random();
			val = rand.nextInt(NUM_OF_INTERESTS);
		}
		
		Interests i = new Interests();
		
		switch(val){
			case 1: return i.new Music();
			case 2: return i.new Food();
			case 3: return i.new Dancing();
			case 4: return i.new Film();
			case 5: return i.new Computers();
			case 6: return i.new Gaming();
			case 7: return i.new Sports();
			case 8: return i.new Outdoors();
			case 9: return i.new ComputerProgramming();
			case 10: return i.new Cooking();
			case 11: return i.new Art();
			case 12: return i.new Homebrewing();
			case 13: return i.new LegoBuilding();
			case 14: return i.new Magic();
			case 15: return i.new Reading();
			case 16: return i.new Skateboarding();
			case 17: return i.new VideoGaming();
			case 18: return i.new Writing();
			case 19: return i.new Basketball();
			case 20: return i.new Gardening();
			case 21: return i.new GhostHunting();
			case 22: return i.new Mycology();
			case 23: return i.new Running();
			case 24: return i.new Surfing();
			case 25: return i.new Swimming();
			case 26: return i.new RockStacking();
			case 27: return i.new Go();
			case 28: return i.new LodgeDodgePong();
			case 29: return i.new Baseball();
			case 30: return i.new Fishing();
			case 31: return i.new Jukskei();
			case 32: return i.new KartRacing();
			case 33: return i.new Football();
		}
		
		return i.new Music();
	}
	
	public class Music extends Interest{
		Music(){
			name = "Music";
			importance = 0;
			description = "played music.";
		}
		
		Music(int n, Crust c){
			name = "Music";
			importance = n;
			description = "played music.";
			crust = c;
		}
	}
	
	public class Food extends Interest{
		Food(){
			name = "Food";
			importance = 0;
			description = "went restauraunteering.";
		}
		
		Food(int n, Crust c){
			name = "Food";
			importance = n;
			description = "went restauraunteering.";
			crust = c;
		}
	}
	
	public class Dancing extends Interest{
		Dancing(){
			name = "Dancing";
			importance = 0;
			description = "is in tune with their body.";
		}
		
		Dancing(int n, Crust c){
			name = "Dancing";
			importance = n;
			description = "is in tune with their body.";
			crust = c;
		}
	}
	
	public class Film extends Interest{
		Film(){
			name = "Film";
			importance = 0;
			description = "went to the cinemas.";
		}
		
		Film(int n, Crust c){
			name = "Film";
			importance = n;
			description = "went to the cinemas.";
			crust = c;
		}
	}
	
	public class Computers extends Interest{
		Computers(){
			name = "Computers";
			importance = 0;
			description = "did some computing.";
		}
		
		Computers(int n, Crust c){
			name = "Computers";
			importance = n;
			description = "did some computing.";
			crust = c;
		}
	}
	
	public class Gaming extends Interest{
		Gaming(){
			name = "Gaming";
			importance = 0;
			description = "played some serious board games.";
		}
		
		Gaming(int n, Crust c){
			name = "Gaming";
			importance = n;
			description = "played some serious board games.";
			crust = c;
		}
	}
	
	public class Sports extends Interest{
		Sports(){
			name = "Sports";
			importance = 0;
			description = "played a riveting game of cricket.";
		}
		
		Sports(int n, Crust c){
			name = "Sports";
			importance = n;
			description = "played a riveting game of cricket.";
			crust = c;
		}
	}
	
	public class Outdoors extends Interest{
		Outdoors(){
			name = "Outdoors";
			importance = 0;
			description = "went camping.";
		}
		
		Outdoors(int n, Crust c){
			name = "Outdoors";
			importance = n;
			description = "went camping.";
			crust = c;
		}
	}
	public class ComputerProgramming extends Interest{
		ComputerProgramming(){
			name = "ComputerProgramming";
			importance = 0;
			description = "invented Google.";
		}
		
		ComputerProgramming(int n, Crust c){
			name = "ComputerProgramming";
			importance = n;
			description = "invented Google.";
			crust = c;
		}
	}
	public class Cooking extends Interest{
		Cooking(){
			name = "Cooking";
			importance = 0;
			description = "cooked a marvelous 5 star meal.";
		}
		
		Cooking(int n, Crust c){
			name = "Cooking";
			importance = n;
			description = "cooked a marvelous 5 star meal.";
			crust = c;
		}
	}
	public class Art extends Interest{
		Art(){
			name = "Art";
			importance = 0;
			description = "painted a beautiful masterpiece.";
		}
		
		Art(int n, Crust c){
			name = "Art";
			importance = n;
			description = "painted a beautiful masterpiece.";
			crust = c;
		}
	}
	public class Homebrewing extends Interest{
		Homebrewing(){
			name = "Homebrewing";
			importance = 0;
			description = "has aged a fine wine.";
		}
		
		Homebrewing(int n, Crust c){
			name = "Homebrewing";
			importance = n;
			description = "has aged a fine wine.";
			crust = c;
		}
	}
	public class LegoBuilding extends Interest{
		LegoBuilding(){
			name = "LegoBuilding";
			importance = 0;
			description = "built the biggest lego Eifel Tower you have ever seen.";
		}
		
		LegoBuilding(int n, Crust c){
			name = "LegoBuilding";
			importance = n;
			description = "built the biggest lego Eifel Tower you have ever seen.";
			crust = c;
		}
	}
	public class Magic extends Interest{
		Magic(){
			name = "Magic";
			importance = 0;
			description = "pulled a rabbit from their hat.";
		}
		
		Magic(int n, Crust c){
			name = "Magic";
			importance = n;
			description = "pulled a rabbit from their hat.";
			crust = c;
		}
	}
	public class Reading extends Interest{
		Reading(){
			name = "Reading";
			importance = 0;
			description = "took a look, in his book, a reading rainbow.";
		}
		
		Reading(int n, Crust c){
			name = "Reading";
			importance = n;
			description = "took a look, in his book, a reading rainbow.";
			crust = c;
		}
	}
	public class Skateboarding extends Interest{
		Skateboarding(){
			name = "Skateboarding";
			importance = 0;
			description = "did an awesome 360 trick.";
		}
		
		Skateboarding(int n, Crust c){
			name = "Skateboarding";
			importance = n;
			description = "did an awesome 360 trick.";
			crust = c;
		}
	}
	public class VideoGaming extends Interest{
		VideoGaming(){
			name = "VideoGaming";
			importance = 0;
			description = "played a gnarly round of Halo 2.";
		}
		
		VideoGaming(int n, Crust c){
			name = "VideoGaming";
			importance = n;
			description = "played a gnarly round of Halo 2.";
			crust = c;
		}
	}
	public class Writing extends Interest{
		Writing(){
			name = "Writing";
			importance = 0;
			description = "wrote Walden.";
		}
		
		Writing(int n, Crust c){
			name = "Writing";
			importance = n;
			description = "wrote Walden.";
			crust = c;
		}
	}
	public class Basketball extends Interest{
		Basketball(){
			name = "Basketball";
			importance = 0;
			description = "almost made it onto the Chicago Bulls. Tiger Woods watch out!";
		}
		
		Basketball(int n, Crust c){
			name = "Basketball";
			importance = n;
			description = "almost made it onto the Chicago Bulls. Tiger Woods watch out!";
			crust = c;
		}
	}
	public class Gardening extends Interest{
		Gardening(){
			name = "Gardening";
			importance = 0;
			description = "trimmed the roses on in their secret garden.";
		}
		
		Gardening(int n, Crust c){
			name = "Gardening";
			importance = n;
			description = "trimmed the roses on in their secret garden.";
			crust = c;
		}
	}
	public class GhostHunting extends Interest{
		GhostHunting(){
			name = "GhostHunting";
			importance = 0;
			description = "who ya gonna call? GHOSTBUSTERS!";
		}
		
		GhostHunting(int n, Crust c){
			name = "GhostHunting";
			importance = n;
			description = "who ya gonna call? GHOSTBUSTERS!";
			crust = c;
		}
	}
	public class Mycology extends Interest{
		Mycology(){
			name = "Mycology";
			importance = 0;
			description = "discovered a new species of mushroom.";
		}
		
		Mycology(int n, Crust c){
			name = "Mycology";
			importance = n;
			description = "discovered a new species of mushroom.";
			crust = c;
		}
	}
	public class Running extends Interest{
		Running(){
			name = "Running";
			importance = 0;
			description = "ran a marathon.";
		}
		
		Running(int n, Crust c){
			name = "Running";
			importance = n;
			description = "ran a marathon.";
			crust = c;
		}
	}
	public class Surfing extends Interest{
		Surfing(){
			name = "Surfing";
			importance = 0;
			description = "rode a tubular wave breh.";
		}
		
		Surfing(int n, Crust c){
			name = "Surfing";
			importance = n;
			description = "rode a tubular wave breh.";
			crust = c;
		}
	}
	public class Swimming extends Interest{
		Swimming(){
			name = "Swimming";
			importance = 0;
			description = "...Michael Phelps.";
		}
		
		Swimming(int n, Crust c){
			name = "Swimming";
			importance = n;
			description = "...Michael Phelps.";
			crust = c;
		}
	}
	public class RockStacking extends Interest{
		RockStacking(){
			name = "RockStacking";
			importance = 0;
			description = "stacked some rocks. Someone, somewhere is gonna think it was an alien.";
		}
		
		RockStacking(int n, Crust c){
			name = "RockStacking";
			importance = n;
			description = "stacked some rocks. Someone, somewhere is gonna think it was an alien.";
			crust = c;
		}
	}
	public class Go extends Interest{
		Go(){
			name = "Go";
			importance = 0;
			description = "played a most exquisite game of Go.";
		}
		
		Go(int n, Crust c){
			name = "Go";
			importance = n;
			description = "played a most exquisite game of Go.";
			crust = c;
		}
	}
	public class LodgeDodgePong extends Interest{
		LodgeDodgePong(){
			name = "LodgeDodgePong";
			importance = 0;
			description = "pegged your buddy with a ping pong ball.";
		}
		
		LodgeDodgePong(int n, Crust c){
			name = "LodgeDodgePong";
			importance = n;
			description = "pegged your buddy with a ping pong ball.";
			crust = c;
		}
	}
	public class Baseball extends Interest{
		Baseball(){
			name = "Baseball";
			importance = 0;
			description = "watched the most exciting game of baseball ever. GO SHAQ GO!";
		}
		
		Baseball(int n, Crust c){
			name = "Baseball";
			importance = n;
			description = "watched the most exciting game of baseball ever. GO SHAQ GO!";
			crust = c;
		}
	}
	public class Fishing extends Interest{
		Fishing(){
			name = "Fishing";
			importance = 0;
			description = "went fishing, but didn't catch anything.";
		}
		
		Fishing(int n, Crust c){
			name = "Fishing";
			importance = n;
			description = "went fishing, but didn't catch anything.";
			crust = c;
		}
	}
	public class Jukskei extends Interest{
		Jukskei(){
			name = "Jukskei";
			importance = 0;
			description = "played Jukskei, whatever that is.";
		}
		
		Jukskei(int n, Crust c){
			name = "Jukskei";
			importance = n;
			description = "played Jukskei, whatever that is.";
			crust = c;
		}
	}
	public class KartRacing extends Interest{
		KartRacing(){
			name = "KartRacing";
			importance = 0;
			description = "was disqualified for throwing banana peels.";
		}
		
		KartRacing(int n, Crust c){
			name = "KartRacing";
			importance = n;
			description = "was disqualified for throwing banana peels.";
			crust = c;
		}
	}
	public class Football extends Interest{
		Football(){
			name = "Football";
			importance = 0;
			description = "scored a GOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOAL!!!!!";
		}
		
		Football(int n, Crust c){
			name = "Football";
			importance = n;
			description = "scored a GOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOAL!!!!!";
			crust = c;
		}
	}
}
