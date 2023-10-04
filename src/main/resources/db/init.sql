CREATE TYPE country_name AS ENUM ('RU', 'KZ', 'BY', 'KG');

CREATE TABLE IF NOT EXISTS personalities (
	id 		UUID PRIMARY KEY,
	fullname	VARCHAR(128) NOT NULL,
	birthdate	TIMESTAMPTZ,
	country		country_name,
	description	TEXT NOT NULL
);

CREATE TABLE studios (
	id	UUID PRIMARY KEY,
	name	VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS movies (
	id 			UUID PRIMARY KEY,
	name 			VARCHAR(128) NOT NULL,
	release_date 		TIMESTAMPTZ NOT NULL,
	imdb_rating 		INT NOT NULL,
	kinopoisk_id 		INT NOT NULL,
	director_id 		UUID NOT NULL,
	studio_id		UUID NOT NULL,
	CONSTRAINT director_id_fk
		FOREIGN KEY(director_id)
			REFERENCES personalities(id),
	CONSTRAINT studio_id_fk
		FOREIGN KEY(studio_id)
			REFERENCES studios(id)
);

CREATE TABLE IF NOT EXISTS genres (
	id 	UUID PRIMARY KEY,
	name	VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS collections (
	id		UUID PRIMARY KEY,
	name		VARCHAR(128) NOT NULL,
	description	TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS subscriptions (
	id		UUID PRIMARY KEY,
	name		VARCHAR(128) NOT NULL,
	price		INT NOT NULL,
	description	VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
	id			UUID PRIMARY KEY,
	subscription_id		UUID NOT NULL,
	name			VARCHAR(128) NOT NULL,
	email			VARCHAR(128) NOT NULL,
	login			VARCHAR(128) NOT NULL,
	password		VARCHAR(128) NOT NULL,
	phone_number		VARCHAR(20) NOT NULL,
	CONSTRAINT subscription_id_fk
		FOREIGN KEY (subscription_id)
			REFERENCES subscriptions(id)
);

CREATE TABLE IF NOT EXISTS reviews (
	id		UUID PRIMARY KEY,
	text		TEXT NOT NULL,
	rating		INT NOT NULL,
	movie_id	UUID NOT NULL,
	author_id	UUID NOT NULL,
	CONSTRAINT movie_id_fk
		FOREIGN KEY(movie_id)
			REFERENCES movies(id),
	CONSTRAINT author_id
		FOREIGN KEY(author_id)
			REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS movies_actors (
	movie_id 		UUID NOT NULL,
	personality_id		UUID NOT NULL,
	CONSTRAINT movies_actors_pk
		PRIMARY KEY(movie_id, personality_id),
	CONSTRAINT movie_id_fk
		FOREIGN KEY(movie_id)
			REFERENCES movies(id),
	CONSTRAINT personalities_id_fk
		FOREIGN KEY(personality_id)
			REFERENCES personalities(id)
);

CREATE TABLE IF NOT EXISTS movies_avialabilities_by_subscriptions (
	subscription_id UUID NOT NULL,
	movie_id	UUID NOT NULL,
	CONSTRAINT subscription_id_fk
		FOREIGN KEY (subscription_id)
			REFERENCES subscriptions(id),
	CONSTRAINT movie_id_fk
		FOREIGN KEY (movie_id)
			REFERENCES movies(id)
);

CREATE TABLE IF NOT EXISTS movies_genres (
	genre_id	UUID NOT NULL,
	movie_id	UUID NOT NULL,
	CONSTRAINT genre_id_fk
		FOREIGN KEY (genre_id)
			REFERENCES genres(id),
	CONSTRAINT movie_id_fk
		FOREIGN KEY (movie_id)
			REFERENCES movies(id)
);

CREATE TABLE IF NOT EXISTS movies_collections (
	collection_id 	UUID NOT NULL,
	movie_id	UUID NOT NULL,
	CONSTRAINT collection_id_fk
		FOREIGN KEY (collection_id)
			REFERENCES collections(id),
	CONSTRAINT movie_id_fk
		FOREIGN KEY (movie_id)
			REFERENCES movies(id)
);
