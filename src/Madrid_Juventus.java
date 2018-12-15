/**
 * @(#)Madrid_Juventus.java
 *
 * Madrid_Juventus Applet application
 *
 * @author 
 * @version 1.00 2018/12/14
 */
 
import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.net.*;

public class Madrid_Juventus extends java.applet.Applet {
	
int numClicks;
	Image picture1, picture2, picture3, picture4, picture5,picture6,picture7,
		  picture8,picture9,picture10,picture11,picture12,picture13;
		  	boolean ballmove=false;
	double xb=485;
	double yb=310;
	int xb2=0;
	int yb2=0;
 	
	public void playFans(int r)
	{ 
		AudioClip song = getAudioClip(getDocumentBase(),"Fans.wav"); 
		if(r==0) { song.play(); } 
	}  	
		
	public void playFinalWhistle(int r)
	{ 
		AudioClip song = getAudioClip(getDocumentBase(),"Final Whistle.wav"); 
		if(r==0) { song.play(); } 
	}  
		
	public void playWhistle(int r)
	{ 
		AudioClip song = getAudioClip(getDocumentBase(),"Whistle.wav"); 
		if(r==0) { song.play(); } 
	}  	

	public void init()
	{
		numClicks = 0;
		picture1 = getImage(getDocumentBase(),"ramos.png");
		picture2 = getImage(getDocumentBase(),"marcelo.png");
		picture3 = getImage(getDocumentBase(),"isco.png");
		picture4 = getImage(getDocumentBase(),"james.png");
		picture5 = getImage(getDocumentBase(),"cristiano.png");
		picture6 = getImage(getDocumentBase(),"chiellini.png");
		picture7 = getImage(getDocumentBase(),"alves.png");
		picture8 = getImage(getDocumentBase(),"marchisio.png");
		picture9 = getImage(getDocumentBase(),"higuain.png");
		picture10 = getImage(getDocumentBase(),"dybala.png");
		picture11= getImage(getDocumentBase(),"soccerBall1.png");
		picture12= getImage(getDocumentBase(),"juventus.png");
		picture13= getImage(getDocumentBase(),"realMadrid.png");
	
		
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(picture1,1);
		tracker.addImage(picture2,1);
		tracker.addImage(picture3,1);
		tracker.addImage(picture4,1);
		tracker.addImage(picture5,1);
		tracker.addImage(picture6,1);
		tracker.addImage(picture7,1);
		tracker.addImage(picture8,1);
		tracker.addImage(picture9,1);
		tracker.addImage(picture10,1);
		tracker.addImage(picture11,1);
		tracker.addImage(picture12,1);
		tracker.addImage(picture13,1);
		try
		{
			tracker.waitForAll();
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
	}
	
	public void paint(Graphics g)
	{
		playFans(0);
		switch (numClicks)
		{
			case 0 : intro(g); break;
			case 1 : soccerField(g); playWhistle(0); break;
			default : players(g); break;
		}
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		numClicks++;
		if(numClicks>2) {ballmove=true; xb2=x; yb2=y;}
		repaint();
		return true;
	}
	
	public void intro(Graphics g)
	{
		Expo.setBackground(g,10,174,26);
		Expo.setFont(g,"Algerian",Font.BOLD,70);
		Expo.drawString(g,"UCL FINALE",300,80);
		Expo.setFont(g,"Times Roman",Font.BOLD,50);
		Expo.drawString(g,"How to play:",50,150);
		Expo.setFont(g,"Times Roman",Font.BOLD,40);
		Expo.drawString(g,"Pass the ball by clicking on a teammate.",50,200);
		Expo.drawString(g,"Shoot by double-clicking on the goal.",50,250);
		Expo.drawString(g,"Score 1 goal to win!",50,300);
		g.drawImage(picture12,200,350,this);
		g.drawImage(picture13,500,350,this);
	}
	
	public static void soccerField(Graphics g)
	{
		Expo.setBackground(g,10,174,26);
		Expo.setColor(g,Expo.white);
		Expo.drawRectangle(g,50,35,950,615);	//field outline
		Expo.drawRectangle(g,50,185,185,465);	//left penalty area
		Expo.drawRectangle(g,815,185,950,465);	//right penalty area
		Expo.drawRectangle(g,50,255,115,395);	//left inner rectangle
		Expo.drawRectangle(g,885,255,950,395);	//right inner rectangle
		Expo.drawArc(g,185,325,40,50,0,180);	//left semi-circle
		Expo.drawArc(g,815,325,40,50,180,0);	//right semi-circle
		Expo.drawRectangle(g,50,295,20,355);	//left goal-post
		Expo.drawRectangle(g,950,295,980,355);	//right goal-post
		Expo.fillCircle(g,150,325,3);			//left penalty spot
		Expo.fillCircle(g,850,325,3);			//right penalty spot
		Expo.drawLine(g,500,35,500,615);		//center line
		Expo.fillCircle(g,500,325,3);			//center spot
		Expo.drawCircle(g,500,325,70);			//center circle
		Expo.drawLine(g,50,47,62,35);			//upper left corner
		Expo.drawLine(g,50,603,62,615);			//bottom left corner
		Expo.drawLine(g,938,35,950,47);			//upper right corner
		Expo.drawLine(g,938,615,950,603);		//bottom right corner
	}	
	
	public void players(Graphics g)
	{
		soccerField(g);
		Expo.setFont(g,"Arial",Font.PLAIN,34);
		Expo.drawString(g,"REAL MADRID",635,29);
		Expo.drawString(g,"JUVENTUS",190,29);
		Expo.drawString(g,"Cardiff Stadium",380,647);
	
		drawBall(g,(int)xb,(int)yb);
	
		if((xb>950 && xb<990) && (yb>290 && yb<400))
		{
			Expo.setFont(g,"Arial",Font.PLAIN,34);
			Expo.drawString(g,"1",450,29);
			Expo.drawString(g,"0",530,29);
			playFinalWhistle(0);
			Expo.drawString(g,"Juventus are the CHAMPIONS!",250,140);
		}
		
		if((xb>10 && xb<50) && (yb>290 && yb<400))
		{
			Expo.setFont(g,"Arial",Font.PLAIN,34);
			Expo.drawString(g,"1",540,29);
			Expo.drawString(g,"0",440,29);
			playFinalWhistle(0);
			Expo.drawString(g,"Real Madrid are the CHAMPIONS!",230,140);
		}
		
		g.drawImage(picture1,800,200,70,70,this);	//ramos
		g.drawImage(picture2,800,370,70,70,this);	//marcelo
		g.drawImage(picture3,650,145,70,70,this);	//isco
		g.drawImage(picture4,650,425,70,70,this);	//james
		g.drawImage(picture5,520,280,70,70,this);	//cristiano
		
		g.drawImage(picture6,130,200,70,70,this);	//chiellini
		g.drawImage(picture7,130,370,70,70,this);	//alves
		g.drawImage(picture8,280,280,70,70,this);	//marchisio
		g.drawImage(picture9,410,340,70,70,this);	//higuain
		g.drawImage(picture10,410,210,70,70,this);	//dybala
		
		
		if(ballmove)
		{
			moveBall(g);
		}
		
		
		
		
	}
	
	public void moveBall(Graphics g)
	{
		double dist = Math.sqrt((xb-xb2)*(xb-xb2)+(yb-yb2)*(yb-yb2));
		double xmove = 5*(xb2-xb)/dist;
		double ymove = 5*(yb2-yb)/dist;
		
		while(dist>20)
		{
			Expo.setColor(g,10,174,26);
			Expo.fillCircle(g,(int)(xb+15),(int)(yb+15),19);
			
			
			
			drawBall(g,(int)(xb+xmove),(int)(yb+ymove));
			Expo.delay(50);
			xb=xb+xmove;
			yb=yb+ymove;
			
			dist = Math.sqrt((xb-xb2)*(xb-xb2)+(yb-yb2)*(yb-yb2));
			
			Expo.setColor(g,Expo.white);
			Expo.drawRectangle(g,50,35,950,615);	//field outline
			Expo.drawRectangle(g,50,185,185,465);	//left penalty area
			Expo.drawRectangle(g,815,185,950,465);	//right penalty area
			Expo.drawRectangle(g,50,255,115,395);	//left inner rectangle
			Expo.drawRectangle(g,885,255,950,395);	//right inner rectangle
			Expo.drawArc(g,185,325,40,50,0,180);	//left semi-circle
			Expo.drawArc(g,815,325,40,50,180,0);	//right semi-circle
			Expo.drawRectangle(g,50,295,20,355);	//left goal-post
			Expo.drawRectangle(g,950,295,980,355);	//right goal-post
			//Expo.fillCircle(g,150,325,3);			//left penalty spot
			//Expo.fillCircle(g,850,325,3);			//right penalty spot
			Expo.drawLine(g,500,35,500,615);		//center line
			//Expo.fillCircle(g,500,325,3);			//center spot
			Expo.drawCircle(g,500,325,70);			//center circle
			Expo.drawLine(g,50,47,62,35);			//upper left corner
			Expo.drawLine(g,50,603,62,615);			//bottom left corner
			Expo.drawLine(g,938,35,950,47);			//upper right corner
			Expo.drawLine(g,938,615,950,603);		//bottom right corner
			
		}
		
		g.drawImage(picture1,800,200,70,70,this);	//ramos
		g.drawImage(picture2,800,370,70,70,this);	//marcelo
		g.drawImage(picture3,650,145,70,70,this);	//isco
		g.drawImage(picture4,650,425,70,70,this);	//james
		g.drawImage(picture5,520,280,70,70,this);	//cristiano
		
		g.drawImage(picture6,130,200,70,70,this);	//chiellini
		g.drawImage(picture7,130,370,70,70,this);	//alves
		g.drawImage(picture8,280,280,70,70,this);	//marchisio
		g.drawImage(picture9,410,340,70,70,this);	//higuain
		g.drawImage(picture10,410,210,70,70,this);	//dybala
			
		
	}
	
	public void drawBall(Graphics g, int xball, int yball)
	{
		g.drawImage(picture11,xball,yball,30,30,this);	//soccer ball
	}
}