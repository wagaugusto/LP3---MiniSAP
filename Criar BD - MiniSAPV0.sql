drop database MiniSAP

create database MiniSAP

go

use MiniSAP

go

create table Locais
(
ID int IDENTITY(1,1) primary key not null,
Nome varchar(50) not null
)

go

create table Equipamentos
(
ID int IDENTITY(1,1) primary key not null,
Nome varchar(50) not null,
LocalID int foreign key references Locais(ID) not null
)

go

create table Especialidades
(
ID int IDENTITY(1,1) primary key not null,
Nome varchar(50) not null
)

go

create table Notas
(
ID int IDENTITY(1,1) primary key not null,
Titulo varchar(50) not null,
Descricao varchar(500) not null,
EquipamentoID int foreign key references Equipamentos(ID) not null
)

go

create table Ordens
(
ID int IDENTITY(1,1) primary key not null,
Titulo varchar(50) not null,
Descricao varchar(500) not null,
NotaID int foreign key references Notas(ID) not null,
EspecialidadeID int foreign key references Especialidades(ID) not null
)

go

insert into Locais
Values
('Laborat�rio'),
('Produ��o'),
('Manuten��o'),
('Administrativo'),
('Refeit�rio')

go

insert into Equipamentos
Values
('Torno', 3),
('Fresadora', 3),
('Furadeira de Bancada', 3),
('Ar condicionado', 4),
('Lumin�ria', 5)

go

insert into Especialidades
Values
('El�trica'),
('Mec�nica'),
('Automa��o'),
('Civil'),
('Zeladoria')

go

insert into Notas
Values
('Equipamento n�o liga','Equipamento n�o esta ligando, aparenta ser falha na alimenta��o', 1),
('Equipamento com fia��o exposta','Cabos do equipamento est�o expostos, risco de choque', 2),
('Equipamento com barulho anormal','Equipamento com barulho acima do normal', 3),
('Ar condicionado n�o gela','Ar condicionado n�o gela', 4),
('Ilumina��o deficiente','Ilumina��o deficiente na �rea do refeit�rio', 5)

go

insert into Ordens
Values
('Testar Alimenta��o','Verificar alimenta��o e QGBT', 1, 1),
('Isolar fia��o','Verificar pontos expostos e isolar ou substituir o cabo', 2, 1),
('Verificar barulho anormal','Executar an�lise de vibra��o do equipamento', 3, 2),
('Recarga de flu�do','Verificar se � necess�rio recarga de g�s', 4, 5),
('Substituir lampadas','Substituir lampadas queimadas', 5, 1)

go