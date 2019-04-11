
public class Pyromancer extends Eroi {
	
	 public Pyromancer(){
	    	
     }
	    
     public Pyromancer(int x, int y){
	    	   super(x,y,500,'P',350,150);
     }
    
    public int abilitate1(Eroi pyromancer, Eroi enemy, char teren){
    	   float damage = pyromancer.getdamage_abilitatea1();
	       
    	   damage = damage * this.AmplificatorDeTeren(pyromancer, teren);
	       	       	       
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
	      	       
	       return Math.round(damage);
    }
    
    public int abilitate2(Eroi pyromancer, Eroi enemy, char teren){
 	       float damage = pyromancer.getdamage_abilitatea2();
 	       
 	       damage = damage * this.AmplificatorDeTeren(pyromancer, teren);
	       float damage_runda = (50 + pyromancer.getlevel() * 30) * this.AmplificatorDeTeren(pyromancer, teren);
	       damage_runda = Math.round(damage_runda);
	       
 	      if(enemy.getTip() == 'R'){
	    	   damage = damage * (float)0.8;
	    	   damage_runda = damage_runda * (float)0.8;
	       }
	       
	       if(enemy.getTip() == 'K'){
	    	   damage = damage * (float)1.2;
	    	   damage_runda = damage_runda * (float)1.2;
	       }
	       
	       if(enemy.getTip() == 'P'){
	    	   damage = damage * (float)0.9;
	    	   damage_runda = damage_runda * (float)0.9;
	       }
	       
	       if(enemy.getTip() == 'W'){
	    	   damage = damage * (float)1.05;
	    	   damage_runda = damage_runda * (float)1.05;
	       }
	       
	       enemy.setstun(0);
    	   enemy.setcontor_runda(2);
    	   enemy.setdamage_runda(Math.round(damage_runda));
     
	       return Math.round(damage);
    }
}
