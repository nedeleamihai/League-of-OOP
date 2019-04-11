
public class Wizard extends Eroi {
       
	    public Wizard(){
	    	
	    }
	    
        public Wizard(int x, int y){
	    	   super(x,y,400,'W',(float)0.2,(float)0.35);
	    }
        
        public int abilitate1(Eroi wizzard, Eroi enemy, char teren){
 	           //float procent = (float)(0.2 + 0.05 * w.getlevel()) * this.AmplificatorDeTeren(w, teren);
        	   float procent = wizzard.getdamage_abilitatea1() * this.AmplificatorDeTeren(wizzard, teren);
 	           
 	           if(enemy.getTip() == 'R'){
 	        	  procent = procent * (float)0.8;
 		       }
 		       
 		       if(enemy.getTip() == 'K'){
 		    	  procent = procent * (float)1.2;
 		       }
 		       
 		       if(enemy.getTip() == 'P'){
 		    	  procent = procent * (float)0.9;
 		       }
 		       
 		       if(enemy.getTip() == 'W'){
 		    	  procent = procent * (float)1.05;
 		       }
 	           
 	           float damage = procent * Math.min((float)0.3 * enemy.getInitialHP(), enemy.getHP());
 	           return Math.round(damage);
        }
        
        public int abilitate2(Eroi wizzard, Eroi enemy, char teren){
        	
        	   if(enemy.getTip() == 'W'){
        		   return 0;
        	   }
        	   
        	   //float procent = Math.min ((float)(0.35 + 0.02 * w.getlevel()), (float)0.7);
        	   float procent = Math.min (wizzard.getdamage_abilitatea2(), (float)0.7);
        	   
        	   procent = procent * this.AmplificatorDeTeren(wizzard, teren);
        	   
        	   if(enemy.getTip() == 'R'){
  	        	  procent = procent * (float)1.2;
  		       }
  		       
  		       if(enemy.getTip() == 'K'){
  		    	  procent = procent * (float)1.4;
  		       }
  		       
  		       if(enemy.getTip() == 'P'){
  		    	  procent = procent * (float)1.3;
  		       }
  		       
  		       float damage_deflect = 0;
  		     
  		       if(enemy.getTip() == 'R' && teren == 'W' && ((Rogue)enemy).getContorBackstab() % 3 == 0){
  		    	    damage_deflect = Math.round((enemy.getdamage_abilitatea1() * (float)1.5 + enemy.getdamage_abilitatea2()) * this.AmplificatorDeTeren(enemy, teren));
  		       }else{
  		            damage_deflect = Math.round((enemy.getdamage_abilitatea1() + enemy.getdamage_abilitatea2()) * this.AmplificatorDeTeren(enemy, teren));
  		       }
  		       float damage = procent * damage_deflect;
        	   return Math.round(damage);
        	   
        }
        
}
