Create database dynamic;

CREATE TABLE person (
pid INT not null primary key AUTO_INCREMENT,
name VARCHAR(20),
surname VARCHAR(40),
email VARCHAR(60),
amount DECIMAL(7,2),
termInMonth DECIMAL(4),
rateDaily DECIMAL(2));


INSERT INTO dynamic.person (pid, name, surname, email, amount,termInMonth, rateDaily) VALUES ('1', 'Ana', 'First', 'ana@first.lt', '5000', '24', '2');
INSERT INTO dynamic.person (pid, name, surname, email, amount, termInMonth, rateDaily) VALUES ('2', 'Bon', 'Second', 'bob@second.lt', '8000', '36', '3');
