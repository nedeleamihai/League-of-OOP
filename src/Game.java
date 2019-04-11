import java.io.PrintWriter;
//import java.io.File;
import java.io.FileNotFoundException;

public class Game {
    private int p;
    private int r;
    private char[][] Runda;
    private char[][] GameMap;
    private Eroi heros [];
    
    public Game(){
    	
    }
    
    public Game(int p, int r, char[][] GameMap, Eroi[] heros, char[][] Runda){    	
    	this.p = p;
    	this.r = r;
    	this.Runda = Runda;
    	this.GameMap = GameMap;
    	this.heros = heros;
    }
    
    public void VerificaPozitii(){
    	
    	   for(int i = 0; i < p-1; i++){    		   
    		   for(int j = i+1; j < p; j++){
    			   if(heros[i].getlinie() == heros[j].getlinie() &&
    		          heros[i].getcoloana() == heros[j].getcoloana()){
    				   
    				  Lupta(heros[i], heros[j]);
    			   }
        	   }        	   
    	   }
    }
    
    public void Lupta(Eroi erou1, Eroi erou2){
    	
    	   int damage1 = 0;
    	   int damage2 = 0;
    	   
    	   if(erou1.getHP() <= 0 || erou2.getHP() <= 0){
    		   if(erou1.getHP() <= 0){
    			   erou1.setisDead();
    		   }
    		   
    		   if(erou2.getHP() <= 0){
    			   erou2.setisDead();
    		   }
    		   
    	   }else{
    		   
    		   damage1 = erou1.abilitate1(erou1, erou2, GameMap[erou2.getlinie()][erou2.getcoloana()]) + 
    				     erou1.abilitate2(erou1, erou2, GameMap[erou2.getlinie()][erou2.getcoloana()]);
    		   
    		   damage2 = erou2.abilitate1(erou2, erou1, GameMap[erou2.getlinie()][erou2.getcoloana()]) +
    				     erou2.abilitate2(erou2, erou1, GameMap[erou2.getlinie()][erou2.getcoloana()]);
    		   
    		   erou1.setHP(erou1.getHP() - damage2);
    		   erou2.setHP(erou2.getHP() - damage1);
    		   
    		   if(erou1.getHP() <= 0 || erou2.getHP() <= 0){
    			   
        		   if(erou1.getHP() <= 0){
        			   erou1.setisDead();
        			   erou2.setXP(erou2.getXP() + Math.max(0, 200 - (erou2.getlevel() - erou1.getlevel()) * 40) );
        			   erou2.level_up();
        		   }
        		   
        		   if(erou2.getHP() <= 0){
        			   erou2.setisDead();
        			   erou1.setXP(erou1.getXP() + Math.max(0, 200 - (erou1.getlevel() - erou2.getlevel()) * 40) );
        			   erou1.level_up();
        		   }
    		   }
    	   }
    	   
    }
    
    public void GameBegin(){
    	
    	   for(int i = 0; i < r; i++){    		  
    		   for(int j = 0; j < p; j++){
    			   if(heros[j].getTip() == 'R'){
    	 				  ((Rogue)heros[j]).setContorBackstab(i);
    	 		   
    			   }
    			   
    			   if(heros[j].getcontor_runda() > 0){
    			    	 heros[j].setHP(heros[j].getHP() - heros[j].getdamage_runda());
    			    	 heros[j].setcontor_runda(heros[j].getcontor_runda() - 1);
    			   }
    			     
    			   if(heros[j].getstun() > 0){    				  
    				  heros[j].setstun(heros[j].getstun() - 1);    				  
    			   }else{
    				  
    			     if(Runda[i][j] == 'U'){
    				   heros[j].setlinie(heros[j].getlinie() - 1);
    			     }
    			   
    			     if(Runda[i][j] == 'D'){
    				   heros[j].setlinie(heros[j].getlinie() + 1);
    			     }
    			   
    			     if(Runda[i][j] == 'L'){
    				   heros[j].setcoloana(heros[j].getcoloana() - 1);
    			     }
    			   
    			     if(Runda[i][j] == 'R'){
    				   heros[j].setcoloana(heros[j].getcoloana() + 1);
    			     }
    			     
    			  }
    		   }
    		   VerificaPozitii();
    	   }
    }
    
    public void GameEnd(String numefisier){
    	
    	PrintWriter pw= null;
    	
    	try{
    		//File file = new File (numefisier);
		    pw = new PrintWriter(numefisier);
		    
		    for(int j = 0; j < p; j++){
		    	if(heros[j].getHP() <= 0){
			    	heros[j].setisDead();
			    }
	    	    if(heros[j].getisDead()){
	    	    	System.out.println(heros[j].getTip() + " " + "dead");
	    	    	pw.println(heros[j].getTip() + " " + "dead");
	    	    }else{
	    	    	System.out.println(heros[j]);
	    	    	pw.println(heros[j]);
	    	    	
	    	    }
	    	}
		    pw.close();
	    }catch(FileNotFoundException e){
		    
	    }    	
    }
}
