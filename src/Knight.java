
public class Knight extends Eroi {

    public Knight(){
    	
    }
    
    public Knight(int x, int y){
    	   super(x,y,900,'K',200,100);
    }
    
    public int abilitate1(Eroi knight, Eroi enemy, char teren){
    	
    	   float HP_limit = Math.min( ((float)0.2 + knight.getlevel() * (float)0.01) * enemy.getInitialHP() , (float)0.4 * enemy.getInitialHP() );
    	
    	   if(enemy.getHP() < HP_limit){
    		   return enemy.getHP();
    	   }
	       
    	   float damage = knight.getdamage_abilitatea1();
	       
 	       damage = damage * this.AmplificatorDeTeren(knight, teren);
	       	       	       
	       if(enemy.getTip() == 'R'){
	    	   damage = damage * (float)1.15;
	       }
	       
	       if(enemy.getTip() == 'P'){
	    	   damage = damage * (float)1.1;
	       }
	       
	       if(enemy.getTip() == 'W'){
	    	   damage = damage * (float)0.8;
	       }
	       
	       return Math.round(damage);
    }
    
    public int abilitate2(Eroi knight, Eroi enemy, char teren){
	       float damage = knight.getdamage_abilitatea2();
	   
	       damage = damage * this.AmplificatorDeTeren(knight, teren);
	       	       	       
	       if(enemy.getTip() == 'R'){
	    	   damage = damage * (float)0.8;
	       }
	       
	       if(enemy.getTip() == 'K'){
	    	   damage = damage * (float)1.2;
	       }
	       
	       if(enemy.getTip() == 'P'){
	    	   damage = damage * (float)0.9;
	       }
	       
	       if(enemy.getTip() == 'W'){
	    	   damage = damage * (float)1.05;
	       }
	       
	       enemy.setstun(1);
 	       enemy.setcontor_runda(0);
 	       enemy.setdamage_runda(0);
	       	       
	       return Math.round(damage);
 }
}
