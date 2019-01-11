create table IF NOT EXISTS USERS(USERNAME varchar(255),PASSWORD varchar(255), EMAIL varchar(255));
create table IF NOT EXISTS Person(personId integer identity primary key , name varchar(255), password varchar(255), dateOfBirth varchar(255));
INSERT INTO USERS(USERNAME, PASSWORD, EMAIL) VALUES ('用户1', 'secret', 'spring-integration@awesome.com');
INSERT INTO USERS(USERNAME, PASSWORD, EMAIL) VALUES ('用户2', 's3cr3t', 'spring@rocks.com');
INSERT INTO USERS(USERNAME, PASSWORD, EMAIL) VALUES ('用户2', 'bar', 'foo@bar.de');

INSERT INTO Person(NAME, PASSWORD, dateOfBirth) VALUES ('郑州', '1547192266', '2019-01-11 15:37:46');
INSERT INTO Person(NAME, PASSWORD, dateOfBirth) VALUES ('河南', '1547192266', '2019-01-12 15:37:46');
INSERT INTO Person(NAME, PASSWORD, dateOfBirth) VALUES ('洛阳', '1547192266', '2019-01-13 15:37:46');
INSERT INTO Person(NAME, PASSWORD, dateOfBirth) VALUES ('安阳', '1547192266', '2019-01-13 15:37:46');
INSERT INTO Person(NAME, PASSWORD, dateOfBirth) VALUES ('周口', '1547192266', '2019-01-13 15:37:46');
INSERT INTO Person(NAME, PASSWORD, dateOfBirth) VALUES ('郑州', '1547192266', '2019-01-13 15:37:46');