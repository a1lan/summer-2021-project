SET character_set_server = utf8mb4;

# DROP DATABASE afa_db;
# CREATE DATABASE afa_db;
# USE afa_db;

CREATE TABLE IF NOT EXISTS user
(
    email varchar(256) not null,
    forename varchar(256) not null,
    date_of_birth date not null,
    profile_pic_link varchar(256),
    ideal_family_size enum('SMALL', 'MEDIUM', 'LARGE'),
    cookie varchar(256),
    primary key (email),
    CONSTRAINT email_at_check check (1 < locate('@', email) AND locate('@', email) < char_length(email))
);

CREATE TABLE IF NOT EXISTS hobby
(
    hobby varchar(256) not null,
    primary key (hobby)
);

CREATE TABLE IF NOT EXISTS personal_descriptor
(
    descriptor varchar(256) not null,
    primary key (descriptor)
);

CREATE TABLE IF NOT EXISTS course
(
    course varchar(256) not null,
    primary key (course)
);

CREATE TABLE IF NOT EXISTS family
(
    name varchar(256) not null,
    primary key (name)
);

CREATE TABLE IF NOT EXISTS user_hobby_relationship
(
    hobby varchar(256) not null,
    user_email varchar(256) not null,
    primary key (hobby, user_email),
    CONSTRAINT hobby_fk foreign key (hobby) references hobby(hobby)
        on delete cascade on update cascade,
    CONSTRAINT user_email_hobby_fk foreign key (user_email) references user(email)
        on delete cascade on update cascade
);

CREATE TABLE IF NOT EXISTS user_descriptor_relationship
(
    descriptor varchar(256) not null,
    user_email varchar(256) not null,
    primary key (descriptor, user_email),
    CONSTRAINT descriptor_fk foreign key (descriptor) references personal_descriptor(descriptor)
        on delete cascade on update cascade,
    CONSTRAINT user_email_descriptor_fk foreign key (user_email) references user(email)
        on delete cascade on update cascade
);

CREATE TABLE IF NOT EXISTS user_course_relationship
(
    course varchar(256) not null,
    user_email varchar(256) not null,
    primary key (course, user_email),
    CONSTRAINT course_fk foreign key (course) references course(course)
        on delete cascade on update cascade,
    CONSTRAINT user_email_course_fk foreign key (user_email) references user(email)
        on delete cascade on update cascade
);

CREATE TABLE IF NOT EXISTS user_family_relationship
(
    family_name varchar(256) not null,
    user_email varchar(256) not null,
    role enum('PARENT', 'CHILD', 'GRANDPARENT', 'UNCLE', 'AUNT', 'COUSIN') not null,
    primary key (family_name, user_email),
    CONSTRAINT family_name_fk foreign key (family_name) references family(name)
        on delete cascade on update cascade,
    CONSTRAINT user_email_family_fk foreign key (user_email) references user(email)
        on delete cascade on update cascade
);