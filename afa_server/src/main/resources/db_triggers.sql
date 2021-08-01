create trigger if not exists user_max_courses_trigger before insert on user_course_relationship for each row
begin
    if ((select count(user_email)
         from user_course_relationship
         where user_course_relationship.user_email = new.user_email) > 1)
    then
        signal sqlstate '45001' set message_text = 'Maximum courses limit reached';
end if;
end;

create trigger if not exists user_max_descriptor_trigger before insert on user_descriptor_relationship for each row
begin
    if ((select count(user_email)
         from user_descriptor_relationship
         where user_descriptor_relationship.user_email = new.user_email) > 4)
    then
        signal sqlstate '45001' set message_text = 'Maximum descriptor limit reached';
end if;
end;

create trigger if not exists user_max_hobby_trigger before insert on user_hobby_relationship for each row
begin
    if ((select count(user_email)
         from user_hobby_relationship
         where user_hobby_relationship.user_email = new.user_email) > 4)
    then
        signal sqlstate '45001' set message_text = 'Maximum hobbies limit reached';
end if;
end;