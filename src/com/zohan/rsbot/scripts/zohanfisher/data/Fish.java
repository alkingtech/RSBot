package com.zohan.rsbot.scripts.zohanfisher.data;

public enum Fish {
	BARB_FLY (328, "Trout/Salmon", "Lure"),
	BARB_BAIT (328, "Pike", "Bait"),
	DRAY_NET (327, "Shrimp/Anchovies", "Net"),
	DRAY_BAIT (327, "Sardine/Herring", "Bait");
	
	private final int id;
	private final String name;
	private final String interact;
	
	Fish (final int id, final String name, final String interact) {
		this.id = id;
		this.name = name;
		this.interact = interact;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getInteract() {
		return interact;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
