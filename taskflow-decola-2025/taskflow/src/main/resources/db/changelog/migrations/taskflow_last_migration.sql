--liquibase formatted sql
--changeset binoya:202503201200
--comment: Atualizando nomes de tabelas e colunas para TaskFlow

ALTER TABLE CARDS RENAME TO TASKS;
ALTER TABLE BLOCKS RENAME COLUMN card_id TO task_id;

--rollback ALTER TABLE TASKS RENAME TO CARDS;
--rollback ALTER TABLE BLOCKS RENAME COLUMN task_id TO card_id;
