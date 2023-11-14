INSERT INTO personalities (id, fullname, birthdate, country, description)
VALUES ('909892eb-5001-4f53-bc6b-16db02979b4a', 'Кристиан Бейл', '1974-01-30', 'UK', 'Самый красивый актер в мире'),
       ('909892eb-5001-4f53-bc6b-16db02979b5a', 'Том Холланд', '1996-06-01', 'UK', 'Звезда фильмов MARVEL'),
       ('909892eb-5001-4f53-bc6b-16db02979b6a', 'Киану Ривз', '1964-09-02', 'CA', 'Любимчик публики'),
       ('909892eb-5001-4f53-bc6b-16db02979b7a', 'Сэмюэл Л. Джексон', '1948-12-21', 'US', 'Любимый актер Квентина Тарантино'),
       ('3b1f9eed-ddf8-41ca-b171-e5fd39baab77', 'Квентин Тарантино', '1963-03-27', 'US', 'Самый популярный режиссер современности'),
       ('909892eb-5003-4f53-bc6b-16db02979b4a', 'Джон Траволта', '1954-02-18', 'US', 'Один из самых популярных актеров своего времени. Звезда таких фильмов как "Криминальное чтиво" и "Форест Гамп"'),
       ('13246c61-d24e-4f1b-a9cf-02eac3333446', 'Мэри Хэррон', '1953-01-12', 'CA', '-'),
       ('42dd96f2-aed5-466c-bbc1-de16b3bf4af2', 'Кристофер Нолан', '1970-07-30','UK', '-'),
       ('c080e0ae-2d55-41b2-a2fb-73aa46491f22', 'Чад Стахелски', '1968-09-20', 'US', '-'),
       ('14e61c70-63c1-4970-a5a8-5fb73fec3736', 'Джон Уоттс', '1981-01-06', 'US', '-');


INSERT INTO studios (id, name)
VALUES ('23af34ea-0e75-4fa2-9cd7-db2beec27094', 'Marvel'),
       ('c4061d93-ab75-4c50-981d-3f37d5470982', 'Universal pictures'),
       ('a93dd036-0381-47ff-b8bf-494f633cd570', 'DC Comics'),
       ('84650328-f0f8-4221-85b2-10850f3eb054', 'Lions gate films');


INSERT INTO movies (id, name, release_date, imdb_rating, kinopoisk_id, director_id, studio_id)
VALUES ('9a511806-4a24-4f8e-b690-0a4a80dfc691', 'Американский психопат', '2000-01-21', 7.6, 588, '13246c61-d24e-4f1b-a9cf-02eac3333446', '84650328-f0f8-4221-85b2-10850f3eb054'),
       ('9a511806-4a24-4f8e-b690-0a4a70dfc691', 'Тёмный рыцарь', '2008-07-14', 9.0, 111543, '42dd96f2-aed5-466c-bbc1-de16b3bf4af2', 'a93dd036-0381-47ff-b8bf-494f633cd570'),
       ('e6229578-5f66-4b1e-b14b-bec4e1ea3a3c', 'Криминальное чтиво', '1994-05-21', 8.9, 342, '3b1f9eed-ddf8-41ca-b171-e5fd39baab77', 'c4061d93-ab75-4c50-981d-3f37d5470982'),
       ('5ee7476a-e749-4ca9-a9da-67e95b407ed8', 'Джон Уик', '2014-09-19', 7.4, 762738, 'c080e0ae-2d55-41b2-a2fb-73aa46491f22', '84650328-f0f8-4221-85b2-10850f3eb054'),
       ('6fbee03b-79db-4567-b4db-0af00e4f0be8', 'Человек-паук: Нет пути домой', '2021-12-15', 8.2, 1309570, '14e61c70-63c1-4970-a5a8-5fb73fec3736', '23af34ea-0e75-4fa2-9cd7-db2beec27094');

INSERT INTO genres (id, name)
VALUES ('e39ed6a1-4ec2-4912-a616-f9d131d27492', 'Драма'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27493', 'Криминал'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27494', 'Триллер'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27495', 'Фантастика'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27496', 'Боевик'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27497', 'Приключения'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27498', 'Фентези');

INSERT INTO collections (id, name, description)
VALUES ('e39ed6a1-4ec2-4912-a616-f9d131d27591', 'Фильмы с Кристианом Бейлом', '-'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27592', 'Лучшие боевики', '-');

INSERT INTO subscriptions (id, name, price, description)
VALUES ('e49ed6a1-4ec2-4912-a616-f9d131d27498', 'Минимум', '300', 'Минимальная подписка'),
       ('e49ed6a1-4ec2-4912-a616-f9d131d27418', 'Оптимум', '400', 'Оптимальная подписка'),
       ('e49ed6a1-4ec2-4912-a616-f9d131d27428', 'Максимум', '500', 'Максимальная подписка');


INSERT INTO users (id, subscription_id, name, email, login, password, phone_number)
VALUES ('4334b468-6879-4b38-9216-bbf0409e3238', 'e49ed6a1-4ec2-4912-a616-f9d131d27418', 'Бусыгин Дмитрий', 'busygind2@yandex.ru', 'busygind2', '12345', '79123068644'),
       ('4334b468-6879-4b38-9216-bbf0409e3838', 'e49ed6a1-4ec2-4912-a616-f9d131d27428', 'Сущенко Роман', 'rsushe02@yandex.ru', 'rsushe', '12345', '79123068645');

INSERT INTO reviews (id, text, rating, movie_id, author_id)
VALUES ('175f2ef4-27cc-4527-8913-c5ec273db1bd', 'Классный фильм!', 5, '9a511806-4a24-4f8e-b690-0a4a80dfc691', '4334b468-6879-4b38-9216-bbf0409e3238'),
       ('275f2ef4-27cc-4527-8913-c5ec273db1bd', 'Хороший фильм!', 5, '9a511806-4a24-4f8e-b690-0a4a70dfc691', '4334b468-6879-4b38-9216-bbf0409e3238'),
       ('375f2ef4-27cc-4527-8913-c5ec273db1bd', 'Отличный фильм!', 4, 'e6229578-5f66-4b1e-b14b-bec4e1ea3a3c', '4334b468-6879-4b38-9216-bbf0409e3238'),
       ('475f2ef4-27cc-4527-8913-c5ec273db1bd', 'Худший фильм!', 2, '5ee7476a-e749-4ca9-a9da-67e95b407ed8', '4334b468-6879-4b38-9216-bbf0409e3838'),
       ('575f2ef4-27cc-4527-8913-c5ec273db1bd', 'Ошеломительный фильм!', 5, '6fbee03b-79db-4567-b4db-0af00e4f0be8', '4334b468-6879-4b38-9216-bbf0409e3838');

INSERT INTO movies_actors (movie_id, actor_id)
VALUES ('9a511806-4a24-4f8e-b690-0a4a80dfc691', '909892eb-5001-4f53-bc6b-16db02979b4a'),
       ('9a511806-4a24-4f8e-b690-0a4a70dfc691', '909892eb-5001-4f53-bc6b-16db02979b4a'),
       ('e6229578-5f66-4b1e-b14b-bec4e1ea3a3c', '909892eb-5001-4f53-bc6b-16db02979b7a'),
       ('e6229578-5f66-4b1e-b14b-bec4e1ea3a3c', '3b1f9eed-ddf8-41ca-b171-e5fd39baab77'),
       ('e6229578-5f66-4b1e-b14b-bec4e1ea3a3c', '909892eb-5003-4f53-bc6b-16db02979b4a'),
       ('5ee7476a-e749-4ca9-a9da-67e95b407ed8', '909892eb-5001-4f53-bc6b-16db02979b6a'),
       ('6fbee03b-79db-4567-b4db-0af00e4f0be8', '909892eb-5001-4f53-bc6b-16db02979b5a');

INSERT INTO movies_availabilities_by_subscriptions (subscription_id, movie_id)
VALUES ('e49ed6a1-4ec2-4912-a616-f9d131d27428', '9a511806-4a24-4f8e-b690-0a4a80dfc691'),
       ('e49ed6a1-4ec2-4912-a616-f9d131d27428', '9a511806-4a24-4f8e-b690-0a4a70dfc691'),
       ('e49ed6a1-4ec2-4912-a616-f9d131d27428', 'e6229578-5f66-4b1e-b14b-bec4e1ea3a3c'),
       ('e49ed6a1-4ec2-4912-a616-f9d131d27428', '5ee7476a-e749-4ca9-a9da-67e95b407ed8'),
       ('e49ed6a1-4ec2-4912-a616-f9d131d27428', '6fbee03b-79db-4567-b4db-0af00e4f0be8'),
       ('e49ed6a1-4ec2-4912-a616-f9d131d27418', '9a511806-4a24-4f8e-b690-0a4a80dfc691'),
       ('e49ed6a1-4ec2-4912-a616-f9d131d27418', '9a511806-4a24-4f8e-b690-0a4a70dfc691'),
       ('e49ed6a1-4ec2-4912-a616-f9d131d27418', 'e6229578-5f66-4b1e-b14b-bec4e1ea3a3c'),
       ('e49ed6a1-4ec2-4912-a616-f9d131d27498', '6fbee03b-79db-4567-b4db-0af00e4f0be8');

INSERT INTO movies_genres (genre_id, movie_id)
VALUES ('e39ed6a1-4ec2-4912-a616-f9d131d27492', '9a511806-4a24-4f8e-b690-0a4a80dfc691'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27493', '9a511806-4a24-4f8e-b690-0a4a80dfc691'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27493', '9a511806-4a24-4f8e-b690-0a4a70dfc691'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27494', '9a511806-4a24-4f8e-b690-0a4a70dfc691'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27495', '9a511806-4a24-4f8e-b690-0a4a70dfc691'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27492', 'e6229578-5f66-4b1e-b14b-bec4e1ea3a3c'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27493', 'e6229578-5f66-4b1e-b14b-bec4e1ea3a3c'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27494', 'e6229578-5f66-4b1e-b14b-bec4e1ea3a3c'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27493', '5ee7476a-e749-4ca9-a9da-67e95b407ed8'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27494', '5ee7476a-e749-4ca9-a9da-67e95b407ed8'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27496', '5ee7476a-e749-4ca9-a9da-67e95b407ed8'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27495', '6fbee03b-79db-4567-b4db-0af00e4f0be8'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27496', '6fbee03b-79db-4567-b4db-0af00e4f0be8'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27497', '6fbee03b-79db-4567-b4db-0af00e4f0be8'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27498', '6fbee03b-79db-4567-b4db-0af00e4f0be8');

INSERT INTO movies_collections (collection_id, movie_id)
VALUES ('e39ed6a1-4ec2-4912-a616-f9d131d27591', '9a511806-4a24-4f8e-b690-0a4a80dfc691'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27591', '9a511806-4a24-4f8e-b690-0a4a70dfc691'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27592', '9a511806-4a24-4f8e-b690-0a4a70dfc691'),
       ('e39ed6a1-4ec2-4912-a616-f9d131d27592', '5ee7476a-e749-4ca9-a9da-67e95b407ed8');
