import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String argv[]){
		   BufferedReader br = null;
		   try{
			   br = new BufferedReader(new FileReader("dense.in"));
			   String thisLine = null;
			   char[] ArrayThisLine;
			   int i,j,n,m,p,r;
			   char[][] GameMAP;
			   
			   String[] Strings = br.readLine().split(" ");
               n = Integer.parseInt(Strings[0]);
               m = Integer.parseInt(Strings[1]);
                          
               GameMAP = new char[n][m];
               
               for(i = 0; i < n; i++){
				   thisLine = br.readLine();
				   ArrayThisLine = thisLine.toCharArray();				   
				   for(j = 0; j < m; j++){					   
					   GameMAP[i][j] = ArrayThisLine[j];					   
				   }
			   }
               
               Strings = br.readLine().split(" ");
               p = Integer.parseInt(Strings[0]);
               
               Eroi heros [] = new Eroi[p];
               
               for(i = 0; i < p; i++){
            	   Strings = br.readLine().split(" ");
            	   String tip = Strings[0];
            	   int x = Integer.parseInt(Strings[1]);
            	   int y = Integer.parseInt(Strings[2]);
            	   
            	   if(tip.equals("P")){
	    			   heros[i] = new Pyromancer(x,y);
	    		   }
	    		   
	    		   if(tip.equals("W")){
	    			   heros[i] = new Wizard(x,y);
	    		   }
	    		   
	    		   if(tip.equals("K")){
	    			   heros[i] = new Knight(x,y);
	    		   }
	    		   
	    		   if(tip.equals("R")){
	    			   heros[i] = new Rogue(x,y);
	    		   }
            	   
               }
               
               Strings = br.readLine().split(" ");
               r = Integer.parseInt(Strings[0]);
               char[][] Runde = new char[r][p];
			   
			   for(i = 0; i < r; i++){
				   thisLine = br.readLine();
				   ArrayThisLine = thisLine.toCharArray();
				   
				   for(j = 0; j < p; j++){
					   Runde[i][j] = ArrayThisLine[j];
				   }
			   }	
			   
			   Game game = new Game(p,r,GameMAP,heros,Runde);
			   
			   game.GameBegin();
			   
			   game.GameEnd("outer.out");
			   
			   
		   }catch (IOException e) {
               e.printStackTrace();
           }
	}
}
