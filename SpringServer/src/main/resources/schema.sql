create or replace table user
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

create or replace table hobby
(
    hobby varchar(256) not null,
    primary key (hobby)
);

create or replace table personal_descriptor
(
    descriptor varchar(256) not null,
    primary key (descriptor)
);

create or replace table course
(
    course varchar(256) not null,
    primary key (course)
);

create or replace table family
(
    name varchar(256) not null,
    primary key (name)
);

create or replace table user_hobby_relationship
(
    hobby varchar(256) not null,
    user_email varchar(256) not null,
    primary key (hobby, user_email),
    CONSTRAINT hobby_fk foreign key (hobby) references hobby(hobby)
        on delete cascade on update cascade,
    CONSTRAINT user_email_hobby_fk foreign key (user_email) references user(email)
        on delete cascade on update cascade
);

create or replace table user_descriptor_relationship
(
    descriptor varchar(256) not null,
    user_email varchar(256) not null,
    primary key (descriptor, user_email),
    CONSTRAINT descriptor_fk foreign key (descriptor) references personal_descriptor(descriptor)
        on delete cascade on update cascade,
    CONSTRAINT user_email_descriptor_fk foreign key (user_email) references user(email)
        on delete cascade on update cascade
);

create or replace table user_course_relationship
(
    course varchar(256) not null,
    user_email varchar(256) not null,
    primary key (course, user_email),
    CONSTRAINT course_fk foreign key (course) references course(course)
        on delete cascade on update cascade,
    CONSTRAINT user_email_course_fk foreign key (user_email) references user(email)
        on delete cascade on update cascade
);

create or replace table user_family_relationship
(
    family_name varchar(256) not null,
    user_email varchar(256) not null,
    role enum('parent', 'child', 'grandparent', 'uncle', 'aunt', 'cousin') not null,
    primary key (family_name, user_email),
    CONSTRAINT family_name_fk foreign key (family_name) references family(name)
        on delete cascade on update cascade,
    CONSTRAINT user_email_family_fk foreign key (user_email) references user(email)
        on delete cascade on update cascade
);

create or replace view view_simple_user as
select email, forename, profile_pic_link
from user
order by email asc;

create or replace view view_families as
select f.family_name, f.role, u.email, u.forename, u.profile_pic_link
from user as u
         INNER JOIN user_family_relationship as f on u.email = f.user_email
order by f.family_name asc;

create or replace trigger user_max_courses_trigger before insert on user_course_relationship for each row
begin
    if ((select count(user_email)
         from user_course_relationship
         where user_course_relationship.user_email = new.user_email) > 1)
    then
        signal sqlstate '45001' set message_text = 'Maximum courses limit reached';
end if;
end;

create or replace trigger user_max_descriptor_trigger before insert on user_descriptor_relationship for each row
begin
    if ((select count(user_email)
         from user_descriptor_relationship
         where user_descriptor_relationship.user_email = new.user_email) > 4)
    then
        signal sqlstate '45001' set message_text = 'Maximum descriptor limit reached';
end if;
end;

create or replace trigger user_max_hobby_trigger before insert on user_hobby_relationship for each row
begin
    if ((select count(user_email)
         from user_hobby_relationship
         where user_hobby_relationship.user_email = new.user_email) > 4)
    then
        signal sqlstate '45001' set message_text = 'Maximum hobbies limit reached';
end if;
end;