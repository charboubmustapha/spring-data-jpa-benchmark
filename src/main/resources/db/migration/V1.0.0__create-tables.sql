-- role
create table role
(
    id    numeric primary key,
    value varchar(55)
);

-- user
create table users
(
    id         numeric primary key,
    first_name varchar(55),
    last_name  varchar(55),
    role_id    numeric references role (id)

)
