package main.java.de.voidtech.geraldspigot.material;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minecraft_user")
public class MinecraftUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;
	
	@Column
	private String minecraftUUID;
	
	@Column
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
