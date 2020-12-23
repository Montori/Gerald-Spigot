package main.java.de.voidtech.geraldspigot.material;


public class MinecraftUser {
	private long userID;

	private String minecraftUUID;

	private long currency;

	/**
	 * ONLY for the ORM, DO NOT USE
	 */
	@Deprecated
	MinecraftUser() {
	}
	
	public MinecraftUser(String uuid)
	{
		this.minecraftUUID = uuid;
		this.currency = 0L;
	}

	public long getUserID() {
		return userID;
	}

	public String getMinecraftUUID() {
		return minecraftUUID;
	}

	public void setMinecraftUUID(String minecraftUUID) {
		this.minecraftUUID = minecraftUUID;
	}

	public long getCurrency() {
		return currency;
	}

	public void setCurrency(long currency) {
		this.currency = currency;
	}

}
