package com.zohan.rsbot.scripts.framework.task;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;

public abstract class Task extends MethodProvider{

	public Task(MethodContext arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public int priority () {
		return 0;
	}
	
	public abstract boolean activate();
	public abstract void action();

}
