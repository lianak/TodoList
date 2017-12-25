CREATE TABLE public.todolistitem
(
  id SERIAL PRIMARY KEY NOT NULL,
  title VARCHAR(256) NOT NULL,
  completed BOOLEAN NOT NULL
);


INSERT INTO todolistitem (title, completed)
VALUES ('Piplelines diff between effective and applicable', TRUE);

INSERT INTO todolistitem (title, completed)
VALUES ('Piplelines add items to applicable', TRUE);

INSERT INTO todolistitem (title, completed)
VALUES ('Piplelines execute', TRUE);

INSERT INTO todolistitem (title, completed)
VALUES ('Syntax required', FALSE);

INSERT INTO todolistitem (title, completed)
VALUES ('Syntax assemble for envelope', FALSE);
