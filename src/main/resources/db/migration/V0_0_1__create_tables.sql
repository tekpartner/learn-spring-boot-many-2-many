CREATE SEQUENCE book_seq
  START 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  CACHE 1;

CREATE TABLE book
(
  id   BIGINT                NOT NULL,
  name CHARACTER VARYING(50) NOT NULL,
  isbn CHARACTER VARYING(14) NOT NULL,
  CONSTRAINT book_pkey PRIMARY KEY (id),
  CONSTRAINT book_ukey_uuid UNIQUE (isbn)
);

CREATE SEQUENCE publisher_seq
  START 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  CACHE 1;

CREATE TABLE publisher
(
  id          BIGINT NOT NULL,
  name        CHARACTER VARYING(50),
  description CHARACTER VARYING(300),
  CONSTRAINT publisher_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE owner_seq
  START 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  CACHE 1;

CREATE TABLE owner
(
  id          BIGINT NOT NULL,
  name        CHARACTER VARYING(50),
  CONSTRAINT owner_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE book_publisher_seq
  START 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  CACHE 1;

CREATE TABLE book_publisher
(
  id           BIGINT NOT NULL DEFAULT nextval('book_publisher_seq'),
  book_id      BIGINT NOT NULL,
  publisher_id BIGINT NOT NULL,
  CONSTRAINT book_publisher_pkey PRIMARY KEY (id),
  CONSTRAINT book_publisher_join UNIQUE (book_id, publisher_id),
  FOREIGN KEY (book_id) REFERENCES book (id),
  FOREIGN KEY (publisher_id) REFERENCES publisher (id)
);

CREATE SEQUENCE book_owner_seq
  START 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  CACHE 1;

CREATE TABLE book_owner
(
  id           BIGINT NOT NULL DEFAULT nextval('book_owner_seq'),
  book_id      BIGINT NOT NULL,
  owner_id BIGINT NOT NULL,
  CONSTRAINT book_owner_pkey PRIMARY KEY (id),
  CONSTRAINT book_owner_join UNIQUE (book_id, owner_id),
  FOREIGN KEY (book_id) REFERENCES book (id),
  FOREIGN KEY (owner_id) REFERENCES owner (id)
);

INSERT INTO book (id, name, isbn) VALUES (nextval('book_seq'), 'Book 1', '978-0743246261');
INSERT INTO book (id, name, isbn) VALUES (nextval('book_seq'), 'Book 2', '978-0743246262');
INSERT INTO book (id, name, isbn) VALUES (nextval('book_seq'), 'Book 3', '978-0743246263');
INSERT INTO book (id, name, isbn) VALUES (nextval('book_seq'), 'Book 4', '978-0743246264');

INSERT INTO publisher (id, name, description) VALUES (nextval('publisher_seq'), 'Publisher 1', 'Description - 1');
INSERT INTO publisher (id, name, description) VALUES (nextval('publisher_seq'), 'Publisher 2', 'Description - 2');
INSERT INTO publisher (id, name, description) VALUES (nextval('publisher_seq'), 'Publisher 3', 'Description - 3');
INSERT INTO publisher (id, name, description) VALUES (nextval('publisher_seq'), 'Publisher 4', 'Description - 4');

INSERT INTO owner (id, name) VALUES (nextval('owner_seq'), 'Owner 1');
INSERT INTO owner (id, name) VALUES (nextval('owner_seq'), 'Owner 2');
INSERT INTO owner (id, name) VALUES (nextval('owner_seq'), 'Owner 3');
INSERT INTO owner (id, name) VALUES (nextval('owner_seq'), 'Owner 4');

INSERT INTO book_publisher (book_id, publisher_id) VALUES (1, 1);
INSERT INTO book_publisher (book_id, publisher_id) VALUES (1, 2);
INSERT INTO book_publisher (book_id, publisher_id) VALUES (2, 1);
INSERT INTO book_publisher (book_id, publisher_id) VALUES (2, 3);
INSERT INTO book_publisher (book_id, publisher_id) VALUES (2, 4);
INSERT INTO book_publisher (book_id, publisher_id) VALUES (3, 2);
INSERT INTO book_publisher (book_id, publisher_id) VALUES (3, 4);
INSERT INTO book_publisher (book_id, publisher_id) VALUES (4, 1);

INSERT INTO book_owner (book_id, owner_id) VALUES (1, 1);
INSERT INTO book_owner (book_id, owner_id) VALUES (2, 1);
INSERT INTO book_owner (book_id, owner_id) VALUES (2, 2);
INSERT INTO book_owner (book_id, owner_id) VALUES (2, 3);
INSERT INTO book_owner (book_id, owner_id) VALUES (3, 2);
INSERT INTO book_owner (book_id, owner_id) VALUES (4, 3);