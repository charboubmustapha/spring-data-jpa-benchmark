insert into role values (1, 'employee');
insert into role values (2, 'manager');
insert into role values (3, 'admin');
insert into role values (4, 'superadmin');
---- users
insert into users values(1,'charboub', 'mustapha',1);
insert into users values(2,'messi','lionel',1);
insert into users values(3,'junior','neymar',1);

----- managers

insert into users values(4,'pep', 'guardiola',2);
insert into users values(5,'kürgen','Klopp',2);
insert into users values(6,'carlo','ancelotti',2);
----- managers

insert into users values(7,'james', 'golsing',3);
insert into users values(8,'joshua','bloch',3);
insert into users values(9,'josh','long',3);


insert into users values(10,'su', 'admin',4);
insert into users values(11,'sudo','admin',4);
insert into users values(12,'admin','admin',4);
