create table game
(
    id integer not null,
    createdAt date not null,
    name varchar(255) not null,
    players array,
    primary key(id)
);
create table player
(
    id integer not null,
    name varchar(255) not null,
    image varchar(255),
    account varchar(255),
    primary key(id)
);
create table account
(
    id integer not null,
    player varchar(255) not null,
    amount decimal not null,
    primary key(id)
)
