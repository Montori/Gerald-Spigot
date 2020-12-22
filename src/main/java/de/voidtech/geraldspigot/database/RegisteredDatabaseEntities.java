package main.java.de.voidtech.geraldspigot.database;

import main.java.de.voidtech.geraldspigot.material.MinecraftUser;

public enum RegisteredDatabaseEntities {
	MinecraftUser(MinecraftUser.class),;

	private Class<?> entityClass;

	private RegisteredDatabaseEntities(Class<?> entityClass) {
		this.entityClass = entityClass;
	}
	
	public Class<?> getEntityClass() {
		return this.entityClass;
	}
}
