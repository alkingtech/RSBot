package com.zohan.rsbot.scripts.framework.graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GraphicsManager {
	
	
	private List<GraphicsTask> graphicsList = new ArrayList<GraphicsTask>();
	private static GraphicsManager gm = null;
	
	public GraphicsManager() {
		gm = this;
	}
	
	public static void add(GraphicsTask... gt){
		for (GraphicsTask g: gt){
			if(!gm.graphicsList.contains(g)){
				gm.graphicsList.add(g);
			}
		}
	}
	
	public static void remove(GraphicsTask... gt){
		for (GraphicsTask g: gt){
			if(gm.graphicsList.contains(g)){
				gm.graphicsList.remove(g);
			}
		}
	}

	public static void removeAll(GraphicsTask... gt){
		gm.graphicsList.clear();
	}
	
	public void draw(Graphics g) {
		for(GraphicsTask gt: graphicsList){
			gt.draw(g);
		}
	}
}
