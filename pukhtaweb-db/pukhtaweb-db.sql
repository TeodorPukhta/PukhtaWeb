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

CREATE TABLE "bookslist"
(
	"id" SERIAL NOT NULL,
	"user_id" INTEGER NOT NULL,
	"book_id" INTEGER NOT NULL,
	"accept"  BOOLEAN NOT NULL,
    CONSTRAINT pk_bookslist_id PRIMARY KEY ("id"),
	CONSTRAINT fk_user_id FOREIGN KEY("user_id") 
	REFERENCES "user"("id"),
	CONSTRAINT fk_book_id FOREIGN KEY("book_id") 
	REFERENCES "book"("id")
);

CREATE TABLE "comment"
(
	"id" SERIAL NOT NULL,
	"user_id" INTEGER NOT NULL,
	"book_id" INTEGER NOT NULL,
	"comment" VARCHAR(500) default 'not provided',
	"accept"  BOOLEAN NOT NULL,
    CONSTRAINT pk_comment_id PRIMARY KEY ("id"),
	CONSTRAINT fk_user_id FOREIGN KEY("user_id") 
	REFERENCES "user"("id"),
	CONSTRAINT fk_book_id FOREIGN KEY("book_id") 
	REFERENCES "book"("id")
);

"bookslist"
'15','7'





