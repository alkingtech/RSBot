package com.zohan.rsbot.scripts.zohanfisher.data;

public enum Location {

	DRAYNOR_VILLAGE(new Fish[] { Fish.DRAY_NET, Fish.DRAY_BAIT }),
	BARBARIAN_VILLAGE(new Fish[] { Fish.BARB_FLY, Fish.BARB_BAIT });

	private Fish[] fish;

	Location(Fish[] fish) {
		this.fish = fish;
	}

	public Fish[] getFish() {
		return fish;
	}

	@Override
	public String toString() {
		String name = name().toLowerCase().replace("_", " ");
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;
	}
}
