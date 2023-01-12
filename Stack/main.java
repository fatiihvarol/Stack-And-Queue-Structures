package deneme;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args)throws Exception   {	
		File file=new File("D:\\fruits.txt");
        Scanner sc=new Scanner(file);
        Stack elements1 = new Stack(5);
        Stack elements2 = new Stack(5);
        Stack fruitStack = new Stack(10);
        Stack temp=new Stack(10);
        Stack temp2=new Stack(10);
        
        Stack temp4=new Stack(10);
        Stack temp5=new Stack(10);
       
        Random rnd = new Random();
      
        while(sc.hasNextLine()){
        
        	fruitStack.push(sc.nextLine());
        	
        	temp2.push(fruitStack.peek());
        	
        	
        	
        	
        }
    
        while(!elements1.isFull()) {
        	
        	while(!temp5.isEmpty()&&!fruitStack.isFull()) {
        		fruitStack.push(temp5.pop());
        	}
        	int y = rnd.nextInt(fruitStack.size());
        	for(int j=1;j<=y;j++) {
        		temp5.push(fruitStack.pop());
        		
        	}
        	temp.push(fruitStack.peek());
        	elements1.push(fruitStack.pop());
        	while(!fruitStack.isEmpty()&&!temp5.isFull()) {
        		temp5.push(fruitStack.pop());
        	}
        
        }
        
   	
   	 Stack newtemp=new Stack(5);
   	 while(!elements2.isFull()){
   		while(!newtemp.isEmpty()&&!temp.isFull()) {
   			temp.push(newtemp.pop());
    	}
    	int y = rnd.nextInt(temp.size());
    	for(int j=1;j<=y;j++) {
    		newtemp.push(temp.pop());
    		
    	}
    	
    	elements2.push(temp.pop());
    	while(!temp.isEmpty()&&!newtemp.isFull()) {
    		newtemp.push(temp.pop());
    	}
   	 }
   	 
 	Stack tempfor1=new Stack(5);
   	Stack tempfor2=new Stack(5);
   	
   	 
   	int scor=0;
   int count=0;
   	
   	//GAME
   	
      while(!elements1.isEmpty()) {
    	  int z=rnd.nextInt(elements1.size());
    	  int y=rnd.nextInt(elements2.size());
    	  System.out.println();
    	  System.out.print("STACK 1: ");
    	  while(!elements1.isEmpty()) {
    	   		 
    	   		 System.out.print(elements1.peek()+" ");
    	   		 tempfor1.push(elements1.pop());
    	   	 }
    	   	 while(!tempfor1.isEmpty()) {
    	   		 elements1.push(tempfor1.pop());
    	   	 }
    	   	 System.out.println();
    	   	 System.out.print("STACK 2: ");
    	   	while(!elements2.isEmpty()) {
    	   		
    	  		 System.out.print(elements2.peek()+" ");
    	  		tempfor2.push(elements2.pop());
    	  	 }
    		 while(!tempfor2.isEmpty()) {
    	   		 elements2.push(tempfor2.pop());
    	   	 }
    		 int k=z+1;
    		 int l=y+1;
    		 
    		 System.out.println("\n\nRandomly generated numbers : "+k+" "+l);
    		 count++;
    	  for(int i=0;i<z;i++) {
    		 tempfor1.push(elements1.pop());
    	  }
    	  
    	  for(int i=0;i<y;i++) {
     		 tempfor2.push(elements2.pop());
     	  }
    	  if (elements1.peek().equals(elements2.peek())) {
    		  scor+=20;
    		  System.out.println("                                                          step: "+count);
    		System.out.print("                                                          score is :"+scor);
    		  elements1.pop();
    		  elements2.pop();
    		 
			
		}
    	  else {
    		  scor=scor-1;
    		  System.out.println("                                                          step: "+count);
    		  System.out.print("                                                        score is :"+scor);
		}
    	  while(!tempfor1.isEmpty()) {
    		  elements1.push(tempfor1.pop());
    	  }
    	  while(!tempfor2.isEmpty()) {
    		  elements2.push(tempfor2.pop());
    	  }
    	 
    	  
      }
      System.out.println("\n ****************************************************************************************************************************************");
   
 System.out.println("          GAME İS OVER \n");
 File file2=new File("D:\\highscoretable.txt");
 Scanner sc2=new Scanner(file2);
 Stack highscorename=new Stack(11);
 Stack highscore=new Stack(11);
 boolean flag=false;
 int counter=0;
 System.out.println("---High Score Table---\n");

 while(sc2.hasNextLine()) {
	 counter++;
	 highscorename.push(sc2.nextLine());
	 highscore.push(sc2.nextLine());
	
int x = Integer.valueOf((String)highscore.peek());

	
	 if ( x< scor&&!flag) {
		String name=(String)highscorename.pop();
		String scoree=(String)highscore.pop();
		 highscore.push(scor);
		 highscorename.push("-You-");
		 highscore.push(scoree);
		 highscorename.push(name);
		flag=true;
	}
	 if (flag&&counter==10) {
		highscore.pop();
		highscorename.pop();
	}
 }
Stack tempscore=new Stack(10);
Stack tempname=new Stack(10);
 while(!highscorename.isEmpty()) {
	 tempscore.push(highscore.pop());
	 tempname.push(highscorename.pop());
 }
 File file3=new File("D:\\highscoretable.txt");
 FileWriter fw=new FileWriter(file3);
 PrintWriter pw = new PrintWriter(fw);
 while(!tempname.isEmpty()) {
	 pw.println(tempname.peek());
	 pw.println(tempscore.peek());
	 System.out.println(tempname.pop()+"  "+tempscore.pop());
	
	
 }
 
 pw.close();
	}
}
