CREATE TABLE "user"
(
	"id" SERIAL NOT NULL,
	"email" VARCHAR(512) NOT NULL,
	"phone" VARCHAR(14) NOT NULL,
	"password" VARCHAR(50) NOT NULL,
	"firstname" VARCHAR(255) NOT NULL,
	"surname" VARCHAR(255) NOT NULL,
	"is_active" BOOLEAN NOT NULL,
	CONSTRAINT pk_user_id PRIMARY KEY("id"),
	CONSTRAINT uk_email UNIQUE ("email"),
	CONSTRAINT uk_phone UNIQUE ("phone")
);

CREATE TABLE "book"
(
	"id" SERIAL NOT NULL,
	"name" VARCHAR(50) NOT NULL,
	"genre" VARCHAR(50) NOT NULL,
	"description" VARCHAR(500) default 'not provided',
	"author" VARCHAR(50) default 'unknown',
	"year" DATE,
    CONSTRAINT pk_book_id PRIMARY KEY ("id")
);

CREATE TABLE "BooksList"
(
	"id" SERIAL NOT NULL,
	"user_id" INTEGER NOT NULL,
	"book_id" INTEGER NOT NULL,
    CONSTRAINT pk_BooksList_id PRIMARY KEY ("id"),
	CONSTRAINT fk_user_id FOREIGN KEY("user_id") 
	REFERENCES "user"("id"),
	CONSTRAINT fk_book_id FOREIGN KEY("book_id") 
	REFERENCES "book"("id")
);

INSERT INTO "user" ("email","password","first_name","surname","phone","is_active")
VALUES('user@gmail.com','123456','First','Sur','+380000000000','true');

INSERT INTO "book" ("name","genre","description","author","year")
VALUES('Test Book','ujas','test','Pukhta','2000');

INSERT INTO "BooksList" ("user_id","book_id")
VALUES('15','7');