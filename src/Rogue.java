
public class Rogue extends Eroi {
	
	private int contor_backstab;

	public Rogue(){
    	
    }
    
    public Rogue(int x, int y){
    	   super(x,y,600,'R',200,40);
    	   this.contor_backstab = 0;
    }
    
    public void setContorBackstab(int c){
    	   this.contor_backstab = c;
    }
    
    public int getContorBackstab(){
 	       return contor_backstab;
    }
    
    public int abilitate1(Eroi rogue, Eroi enemy, char teren){
    	
    	   float damage = rogue.getdamage_abilitatea1();
    	   
    	   damage = damage * this.AmplificatorDeTeren(rogue, teren);
    	   
    	   if(enemy.getTip() == 'R'){
    		   damage = (float)1.2 * damage;
	       }
	       
	       if(enemy.getTip() == 'K'){
	    	   damage = (float)0.9 * damage;
	       }
	       
	       if(enemy.getTip() == 'P'){
	    	   damage = (float)1.25 * damage;
	       }
	       
	       if(enemy.getTip() == 'W'){
	    	   damage = (float)1.25 * damage;
	       }
	       
	       if(getContorBackstab() % 3 == 0 && teren == 'W'){
	    	   damage = (float)1.5 * damage;
	       }
	       
	       return Math.round(damage);
    }
    
    public int abilitate2(Eroi rogue, Eroi enemy, char teren){

    	   float damage = rogue.getdamage_abilitatea2();
           
           damage = damage * this.AmplificatorDeTeren(rogue, teren);
    	       	   
    	   if(enemy.getTip() == 'R'){
    		   damage = (float)0.9 * damage;
	       }
	       
	       if(enemy.getTip() == 'K'){
	    	   damage = (float)0.8 * damage;
	       }
	       
	       if(enemy.getTip() == 'P'){
	    	   damage = (float)1.2 * damage;
	       }
	       
	       if(enemy.getTip() == 'W'){
	    	   damage = (float)1.25 * damage;
	       }
	       	       
	       if(teren == 'W'){
	    	   enemy.setstun(6);
	    	   enemy.setcontor_runda(6);
	       }else{
	    	   enemy.setstun(3);
	    	   enemy.setcontor_runda(3);
	       }
	       
	       enemy.setdamage_runda(Math.round(damage));
	       
	       return Math.round(damage);
    }
}
