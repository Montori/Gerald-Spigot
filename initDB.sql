CREATE TABLE minecraft_user (
	id IDENTITY,
	uuid VARCHAR(55),
	currency BIGINT,
	
	CONSTRAINT pk_minecraft_user_id PRIMARY KEY (id)
);