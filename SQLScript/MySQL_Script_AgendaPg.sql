CREATE DATABASE db_agenda_pg;
USE db_agenda_pg;

DROP table if exists tb_atividades CASCADE;
DROP table if exists tb_bancos CASCADE;

CREATE TABLE tb_bancos (
  id INT NOT NULL AUTO_INCREMENT,
  tipo varchar(2) not null,
  cod varchar(4) not null,
  nome varchar(20) NOT NULL,
  ag varchar(10) not null,
  titular varchar(20) not null,
  status varchar(15) not null,
  PRIMARY KEY (Id)
);

CREATE TABLE tb_atividades (
  id INTEGER NOT NULL AUTO_INCREMENT,
  st VARCHAR(02) NOT NULL,
  dia_pg INTEGER,
  titular VARCHAR(10) NOT NULL,
  descr VARCHAR(50) NOT NULL,
  valor DOUBLE,
  boleto BOOLEAN,
  comprov_pg BOOLEAN,
  ano_mes_ref DATE NOT NULL,
  data_ult_atualiz DATE, 
  bancos_id INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (bancos_id) REFERENCES tb_bancos (id)
);


INSERT INTO tb_bancos (tipo,cod, nome, ag,titular,status) VALUES 
  ('1','000','Carteira','00000','Jose','Ativo'),
  ('2','001','BBrasil','1234-7','Joao','Ativo'),
  ('2','341','Itau','9887-5','Rita','Ativo');


INSERT INTO tb_atividades (st, dia_pg, titular, descr, valor, boleto, comprov_pg, ano_mes_ref,data_ult_atualiz,bancos_Id) VALUES 
  ('  ',05,'joao','cpfl',555.55,1,0,'2021-05-05','2021-05-01',2),
  ('ag',10,'jose','unimed',155.55,1,0,'2021-05-05','2021-05-01',1),
  ('  ',10,'joao','iptu',425.55,1,1,'2021-05-05','2021-05-01',1),
  ('pg',15,'joao','anacosta',353.55,0,0,'2021-05-05','2021-05-01',3),
  ('  ',05,'jose','imprimir fatura claro',535455,1,1,'2021-05-05','2021-05-01',3),
  ('db',20,'joao','oabprev',553.55,1,0,'2021-05-05','2021-05-02',2),
  ('  ',05,'rute','gps',355.56,0,1,'2021-05-05','2021-05-02',2),
  ('  ',05,'joao','vivo',735.55,1,0,'2021-05-05','2021-05-01',2);