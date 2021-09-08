--DROP TABLE public.answers;
--DROP TABLE public.questions;

-- Создаем таблицу с вопросами
CREATE TABLE public.questions (
	id BIGSERIAL PRIMARY KEY,
	quest_text varchar not NULL
);

-- Заполняем тестовыми вопросами
insert into public.questions (quest_text) values ('Вопрос № 1');
insert into public.questions (quest_text) values ('Вопрос № 2');
insert into public.questions (quest_text) values ('Вопрос № 3');
insert into public.questions (quest_text) values ('Вопрос № 4');
insert into public.questions (quest_text) values ('Вопрос № 5');

-- Создаем таблицу с ответами. Каждый ответ привязан к своему вопросу
create table public.answers (
	id BIGSERIAL PRIMARY KEY,
	quest_id BIGSERIAL,
	answer_text varchar not null,
	answer_true bool,
	FOREIGN KEY (quest_id) REFERENCES public.questions (Id) ON DELETE CASCADE
);

-- Заполняем тестовыми ответами
insert into public.answers (quest_id, answer_text, answer_true) values (1, 'Ответ 1', false);
insert into public.answers (quest_id, answer_text, answer_true) values (1, 'Ответ 2', false);
insert into public.answers (quest_id, answer_text, answer_true) values (1, 'Ответ 3', true);
insert into public.answers (quest_id, answer_text, answer_true) values (1, 'Ответ 4', false);
insert into public.answers (quest_id, answer_text, answer_true) values (1, 'Ответ 5', false);

insert into public.answers (quest_id, answer_text, answer_true) values (2, 'Ответ 1', false);
insert into public.answers (quest_id, answer_text, answer_true) values (2, 'Ответ 2', true);
insert into public.answers (quest_id, answer_text, answer_true) values (2, 'Ответ 3', false);
insert into public.answers (quest_id, answer_text, answer_true) values (2, 'Ответ 4', false);
insert into public.answers (quest_id, answer_text, answer_true) values (2, 'Ответ 5', false);

insert into public.answers (quest_id, answer_text, answer_true) values (3, 'Ответ 1', false);
insert into public.answers (quest_id, answer_text, answer_true) values (3, 'Ответ 2', true);
insert into public.answers (quest_id, answer_text, answer_true) values (3, 'Ответ 3', false);
insert into public.answers (quest_id, answer_text, answer_true) values (3, 'Ответ 4', false);
insert into public.answers (quest_id, answer_text, answer_true) values (3, 'Ответ 5', false);

insert into public.answers (quest_id, answer_text, answer_true) values (4, 'Ответ 1', false);
insert into public.answers (quest_id, answer_text, answer_true) values (4, 'Ответ 2', false);
insert into public.answers (quest_id, answer_text, answer_true) values (4, 'Ответ 3', false);
insert into public.answers (quest_id, answer_text, answer_true) values (4, 'Ответ 4', false);
insert into public.answers (quest_id, answer_text, answer_true) values (4, 'Ответ 5', true);

insert into public.answers (quest_id, answer_text, answer_true) values (5, 'Ответ 1', true);
insert into public.answers (quest_id, answer_text, answer_true) values (5, 'Ответ 2', false);
insert into public.answers (quest_id, answer_text, answer_true) values (5, 'Ответ 3', false);
insert into public.answers (quest_id, answer_text, answer_true) values (5, 'Ответ 4', false);
insert into public.answers (quest_id, answer_text, answer_true) values (5, 'Ответ 5', false);

-- Выборка соответствия - вопрос-ответ
select q.quest_text
     , a.answer_text
     , a.answer_true
  from public.questions q
     , public.answers   a
 where q.id  = a.quest_id
 order by q.id, a.id;


-- Временная таблица, в которую записываются ответы на вопросы, для итогового подсчета (хотя подсчет можно делать на стороне клиента БД)
--DROP TABLE user_answers
CREATE TEMPORARY TABLE user_answers(id_quest BIGSERIAL, id_answer BIGSERIAL) ON COMMIT DELETE ROWS;