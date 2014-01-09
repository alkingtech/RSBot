package com.zohan.rsbot.scripts.zohanfisher.task;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Item;

import com.zohan.rsbot.scripts.framework.task.Task;

public class Dropping extends Task{

	private final int [] fishIds = {317, 321, 327, 345, 349, 335, 331};
	
	public Dropping(MethodContext arg0) {
		super(arg0);
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() == 28;
	}

	@Override
	public void action() {
		for(Item i: ctx.backpack.id(fishIds)){
			i.interact("Drop");
			sleep(150, 300);
		}
	}

}
