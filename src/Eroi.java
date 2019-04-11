
public class Eroi {
       private int XP;
       private int level;
       private int linie;
       private int coloana;
       private int HP;
       private int initial_HP;
       private char tip;
       private int stun;
       private int damage_runda;
       private int contor_runda;
       private float damage_abilitatea1;
       private float damage_abilitatea2;
       private boolean isDead;
       
       public Eroi(){
    	   
       }
       
       public Eroi(int x, int y, int HP, char tip, float damage1, float damage2){
 	      this.XP = 0;
 	      this.level = 0;
 	      this.linie = x;
 	      this.coloana = y;
 	      this.HP = HP;
 	      this.initial_HP = HP;
 	      this.tip = tip;
 	      this.stun = 0;
 	      this.damage_runda = 0;
 	      this.contor_runda = 0;
 	      this.damage_abilitatea1 = damage1;
 	      this.damage_abilitatea2 = damage2;
 	      this.isDead = false;
       }
       
       public int getXP(){
    	   return XP;
       }
       
       public int getlevel(){
    	   return level;
       }
       
       public int getlinie(){
    	   return linie;
       }
       
       public int getcoloana(){
    	   return coloana;
       }
       
       public int getHP(){
    	   return HP;
       }
       
       public int getInitialHP(){
    	   return initial_HP;
       }
       
       public char getTip(){
    	   return tip;
       }
       
       public boolean getisDead(){
	          return isDead;
       }
       
       public int getstun(){
    	      return stun;
       }
       
       public int getdamage_runda(){
 	          return damage_runda;
       }
       
       public int getcontor_runda(){
	          return contor_runda;
       }
       
       public float getdamage_abilitatea1(){
	          return damage_abilitatea1;
       }
       
       public float getdamage_abilitatea2(){
	          return damage_abilitatea2;
       }
       
       public void setXP(int XP){
    	   this.XP = XP;
       }
       
       public void setlevel(int level){
    	   this.level = level;
       }
       
       public void setlinie(int x){
    	   this.linie = x;
       }
       
       public void setcoloana(int y){
    	   this.coloana = y;
       }
       
       public void setHP(int HP){
    	   this.HP = HP;
       }
       
       public void setInitialHP(int initialHP){
    	   this.initial_HP = initialHP;
       }
       
       public void setstun(int newstun){
    	      this.stun = newstun;
       }
       
       public void setdamage_runda(int dr){
 	          this.damage_runda = dr;
       }
       
       public void setcontor_runda(int cr){
	          this.contor_runda = cr;
       }

       public void setisDead(){
	          this.isDead = true;
       }
       
       public void setdamage_abilitatea1(float damage1){
	          this.damage_abilitatea1 = damage1;
       }
       
       public void setdamage_abilitatea2(float damage2){
	          this.damage_abilitatea2 = damage2;
       }
       
       public float AmplificatorDeTeren(Eroi e,char field){
    	      
    	      if(field == 'V' && e.getTip() == 'P'){
    	    	  return (float) 1.25;
    	      }
    	      
    	      if(field == 'D' && e.getTip() == 'W'){
    	    	  return (float) 1.1;
    	      }
    	      
    	      if(field == 'L' && e.getTip() == 'K'){
    	    	  return (float) 1.15;
    	      }
    	      
    	      if(field == 'W' && e.getTip() == 'R'){
    	    	  return (float) 1.15;
    	      }
    	      
    	      return 1;
       }
       
       public void level_up_util(int initHP, float initDamage1, float initDamage2,
    		                     int plusHP, float plusDamage1, float plusDamage2){

 	          this.setlevel( (this.getXP() - 250)/50 + 1 ); 	          
    	      this.setHP(initHP + this.getlevel() * plusHP);
    	      this.setInitialHP(this.getHP());
    	      this.setdamage_abilitatea1(initDamage1 + this.getlevel() * plusDamage1);
    	      this.setdamage_abilitatea2(initDamage1 + this.getlevel() * plusDamage2);
       }
       
       public void level_up(){
    	      if(this.getXP() >= 250 + this.getlevel() * 50){
    	    	  if(this.getTip() == 'R'){
    				  level_up_util(600,200,40,40,20,10);
    		      }
    	    	  
    	    	  if(this.getTip() == 'K'){
    				  level_up_util(900,200,100,80,30,40);
    		      }
    	    	  
    	    	  if(this.getTip() == 'P'){
    				  level_up_util(500,350,150,50,50,20);
    		      }
    	    	  
    	    	  if(this.getTip() == 'W'){
    				  level_up_util(400,(float)0.2,(float)0.35,30,(float)0.05,(float)0.02);
    		      }
    	      }
       }
       
       public int abilitate1(Eroi w, Eroi enemy, char teren){
    	      return 0;
       }
       
       public int abilitate2(Eroi w, Eroi enemy, char teren){
 	          return 0;
       }
       
       public String toString(){
    	      return this.getTip() + " " + 
    	    		 this.getlevel() + " " +
    	    		 this.getXP() + " " +
    	    		 this.getHP() + " " +
    	    		 this.getlinie() + " " +
    	    		 this.getcoloana();
       }
}
