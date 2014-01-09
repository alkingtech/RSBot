package com.zohan.rsbot.scripts.zohanfisher.task;

import java.awt.Color;
import java.awt.Graphics;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Npc;
import org.powerbot.script.wrappers.Tile;

import com.zohan.rsbot.scripts.framework.graphics.GraphicsManager;
import com.zohan.rsbot.scripts.framework.graphics.GraphicsTask;
import com.zohan.rsbot.scripts.framework.task.Task;

public class Fishing extends Task implements GraphicsTask {

	private final int spotId;
	private final String interact;
	private Npc fish;

	public Fishing(MethodContext arg0, int spotId, String interact) {
		super(arg0);
		this.spotId = spotId;
		this.interact = interact;
		GraphicsManager.add(this);
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() < 28
				&& ctx.players.local().getAnimation() == -1
				&& !ctx.npcs.select().id(spotId).isEmpty();
	}

	@Override
	public void action() {
		fish = ctx.npcs.nearest().poll();
		if (fish.isOnScreen()){
			if (fish.interact(interact)) {
				sleep(800, 1200);
			}
		} else {
			ctx.movement.stepTowards(fish);
			ctx.camera.turnTo(fish);
		}
	}

	@Override
	public void draw(Graphics g) {
		if (fish == null || !fish.isValid()) {
			return;
		}

		g.setColor(Color.red);
		Tile t = fish.getLocation();
		t.getMatrix(ctx).draw(g, 250);
	}

}
