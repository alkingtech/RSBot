package com.zohan.rsbot.scripts.zohanfisher;

import java.awt.Graphics;

import javax.swing.SwingUtilities;

import org.powerbot.script.Manifest;

import com.zohan.rsbot.scripts.framework.BotScript;
import com.zohan.rsbot.scripts.framework.graphics.GraphicsManager;
import com.zohan.rsbot.scripts.framework.task.Task;
import com.zohan.rsbot.scripts.framework.task.TaskManager;
import com.zohan.rsbot.scripts.zohanfisher.data.Fish;
import com.zohan.rsbot.scripts.zohanfisher.data.Location;
import com.zohan.rsbot.scripts.zohanfisher.ui.Gui;

@Manifest(description = "Soon to be F2P AIO Fisher!", name = "Zohan Fisher")
public class ZohanFisher extends BotScript {

	public Location location = Location.DRAYNOR_VILLAGE;
	public Fish fish = Fish.DRAY_NET;

	private boolean guiDone = false;
	private final TaskManager tm = new TaskManager();
	private final GraphicsManager gm = new GraphicsManager();

	@Override
	public void start() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Gui(ctx, ZohanFisher.this);
			}

		});
	}

	@Override
	public int poll() {
		if (!guiDone) {
			return 100;
		}
		Task t = tm.get();
		if (t != null) {
			t.action();
		}
		return 50;
	}

	@Override
	public void repaint(Graphics g) {
		gm.draw(g);
	}

	public void guiReady() {
		guiDone = true;
	}

	public TaskManager taskmanager() {
		return tm;
	}
}
