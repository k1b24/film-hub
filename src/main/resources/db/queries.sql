SELECT DISTINCT m.name, m.imdb_rating FROM movies_collections mc
RIGHT JOIN collections c ON mc.collection_id = c.id
RIGHT JOIN movies m ON mc.movie_id = m.id
WHERE c.name = 'Лучшие боевики';

SELECT DISTINCT m.name, m.imdb_rating FROM movies_availabilities_by_subscriptions ms
RIGHT JOIN subscriptions s ON ms.subscription_id = s.id
RIGHT JOIN movies m ON ms.movie_id = m.id
WHERE s.price < 450;

SELECT u.email FROM users u
LEFT JOIN subscriptions s on u.subscription_id = s.id
WHERE s.name = 'Максимум';

SELECT DISTINCT m.name, m.imdb_rating FROM movies_genres mg
RIGHT JOIN movies m on m.id = mg.movie_id
RIGHT JOIN genres g on mg.genre_id = g.id
WHERE g.name IN ('Триллер', 'Боевик');

SELECT p.fullname FROM personalities p
RIGHT JOIN movies m on p.id = m.director_id
RIGHT JOIN studios s on s.id = m.studio_id
WHERE p.country = 'US' AND s.name IN ('Lions gate films', 'Marvel');

SELECT r.text, r.rating FROM reviews r
RIGHT JOIN movies m on r.movie_id = m.id
WHERE m.name = 'Тёмный рыцарь';



