INSERT INTO users (email, login, password, role) VALUES ('Demchenko.sasha@mail.ru', 'Sanek_Gyy', 1234, 'USER');
INSERT INTO users (email, login, password, role) VALUES ('Olchik@mail.ru', 'Olchik', 1234, 'USER');
INSERT INTO accounts ( birthday, first_name, second_name, id_user) VALUES (25, 'Demchenko', 'Aleksandr', 1);
INSERT INTO accounts ( birthday, first_name, second_name, id_user) VALUES (24, 'nIKIFOROVA', 'Olga', 2);

INSERT INTO resumes (id, info) VALUES (1, 'Я бэкендист');
INSERT INTO resumes (id, info) VALUES (2, 'Я фронтендист');
INSERT INTO resumes (id, info) VALUES (3, 'Я дизайнер');

-- INSERT INTO accounts_resumes (business_role, id_account, id_resume) VALUES ('BACKEND', 1 ,1);
-- INSERT INTO accounts_resumes (business_role, id_account, id_resume) VALUES ('DESIGNER', 2 ,3);
-- INSERT INTO accounts_resumes (business_role, id_account, id_resume) VALUES ('FRONTEND', 1 ,2);
