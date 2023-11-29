CREATE TYPE country_name AS ENUM ('RU', 'KZ', 'BY', 'KG', 'UK', 'CA', 'US');

CREATE TABLE IF NOT EXISTS personalities
(
    id          UUID PRIMARY KEY,
    fullname    VARCHAR(128) NOT NULL,
    birthdate   TIMESTAMPTZ,
    country     country_name,
    description TEXT         NOT NULL
);

CREATE INDEX ON personalities (fullname);

CREATE TABLE studios
(
    id   UUID PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE INDEX ON studios (name);

CREATE TABLE IF NOT EXISTS movies
(
    id           UUID PRIMARY KEY,
    name         VARCHAR(128) NOT NULL,
    release_date TIMESTAMPTZ  NOT NULL,
    imdb_rating  FLOAT,
    kinopoisk_id INT,
    director_id  UUID         NOT NULL,
    studio_id    UUID         NOT NULL,
    local_movie_rating FLOAT DEFAULT 0,
    CONSTRAINT director_id_fk
        FOREIGN KEY (director_id)
            REFERENCES personalities (id),
    CONSTRAINT studio_id_fk
        FOREIGN KEY (studio_id)
            REFERENCES studios (id),
    CONSTRAINT imdb_rating_min_and_max_constraint
        CHECK (imdb_rating >= 0 AND imdb_rating <= 10),
    CONSTRAINT kinopoisk_id_min_constraint
        CHECK (kinopoisk_id >= 0)
);

CREATE OR REPLACE FUNCTION process_movie_rating_by_new_reviews_addition() RETURNS TRIGGER AS $$
    BEGIN
        IF (TG_OP = 'DELETE' OR TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
            UPDATE movies SET local_movie_rating = (SELECT AVG(rating) FROM reviews WHERE movie_id = new.movie_id) WHERE new.movie_id = movies.id;
        END IF;
        RETURN NULL;
    END;
$$ LANGUAGE plpgsql;

CREATE INDEX ON movies (release_date);

CREATE TABLE IF NOT EXISTS genres
(
    id   UUID PRIMARY KEY,
    name VARCHAR(128) NOT NULL
);

CREATE INDEX ON genres (name);

CREATE TABLE IF NOT EXISTS collections
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(128) NOT NULL,
    description TEXT         NOT NULL
);

CREATE TABLE IF NOT EXISTS subscriptions
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(128) NOT NULL,
    price       INT          NOT NULL,
    description VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id              UUID PRIMARY KEY,
    subscription_id UUID         NOT NULL,
    name            VARCHAR(128) NOT NULL,
    email           VARCHAR(128) NOT NULL,
    login           VARCHAR(128) NOT NULL,
    password        VARCHAR(128) NOT NULL,
    phone_number    VARCHAR(20)  NOT NULL,
--     CONSTRAINT email_correctness_constraint
--         CHECK (email ~ '^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$'),
--     CONSTRAINT phone_number_correctness_constraint
--         CHECK (phone_number ~ '^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$'),
    CONSTRAINT subscription_id_fk
        FOREIGN KEY (subscription_id)
            REFERENCES subscriptions (id)
);

CREATE INDEX ON users (login, phone_number);

CREATE TABLE IF NOT EXISTS reviews
(
    id        UUID PRIMARY KEY,
    text      TEXT NOT NULL,
    rating    INT  NOT NULL,
    movie_id  UUID NOT NULL,
    author_id UUID NOT NULL,
    CONSTRAINT movie_id_fk
        FOREIGN KEY (movie_id)
            REFERENCES movies (id),
    CONSTRAINT author_id
        FOREIGN KEY (author_id)
            REFERENCES users (id),
    CONSTRAINT rating_max_and_min_constraint
        CHECK ( rating >= 0 AND rating <= 5 )
);

CREATE TRIGGER movie_rating
    AFTER INSERT OR DELETE OR UPDATE ON reviews
        FOR EACH ROW EXECUTE PROCEDURE process_movie_rating_by_new_reviews_addition();



CREATE TABLE IF NOT EXISTS movies_actors
(
    movie_id       UUID NOT NULL,
    actor_id UUID NOT NULL,
    CONSTRAINT movies_actors_pk
        PRIMARY KEY (movie_id, actor_id),
    CONSTRAINT movie_id_fk
        FOREIGN KEY (movie_id)
            REFERENCES movies (id),
    CONSTRAINT personalities_id_fk
        FOREIGN KEY (actor_id)
            REFERENCES personalities (id)
);

CREATE TABLE IF NOT EXISTS movies_availabilities_by_subscriptions
(
    subscription_id UUID NOT NULL,
    movie_id        UUID NOT NULL,
    CONSTRAINT subscription_id_fk
        FOREIGN KEY (subscription_id)
            REFERENCES subscriptions (id),
    CONSTRAINT movie_id_fk
        FOREIGN KEY (movie_id)
            REFERENCES movies (id)
);

CREATE TABLE IF NOT EXISTS movies_genres
(
    genre_id UUID NOT NULL,
    movie_id UUID NOT NULL,
    CONSTRAINT genre_id_fk
        FOREIGN KEY (genre_id)
            REFERENCES genres (id),
    CONSTRAINT movie_id_fk
        FOREIGN KEY (movie_id)
            REFERENCES movies (id)
);

CREATE TABLE IF NOT EXISTS movies_collections
(
    collection_id UUID NOT NULL,
    movie_id      UUID NOT NULL,
    CONSTRAINT collection_id_fk
        FOREIGN KEY (collection_id)
            REFERENCES collections (id),
    CONSTRAINT movie_id_fk
        FOREIGN KEY (movie_id)
            REFERENCES movies (id)
);
