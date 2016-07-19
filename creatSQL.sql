
drop table deck;

create table deck (
    deck_id     serial         primary key not null,
    deck_name   varchar(32)                not null
);

insert into deck(deck_name) values ('青眼の白龍');
insert into deck(deck_name) values ('ブルーアイズデッキ');
insert into deck(deck_name) values ('真のブルーアイズデッキ');
insert into deck(deck_name) values ('ブルーアイズ');
insert into deck(deck_name) values ('デッキオブブルーアイズ');

