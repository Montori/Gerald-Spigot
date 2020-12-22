package main.java.de.voidtech.geraldspigot.material;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "mc_users")
public class MinecraftUser {
	@DatabaseField(generatedId = true)
	private long userID;

	@DatabaseField(canBeNull = false)
	private String minecraftUUID;

	@DatabaseField(defaultValue = "0", canBeNull = false)
	private long currency;

	/**
	 * ONLY for the ORM, DO NOT USE
	 */
	public MinecraftUser() {
	}
	
	public MinecraftUser(String uuid)
	{
		this.minecraftUUID = uuid;
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
