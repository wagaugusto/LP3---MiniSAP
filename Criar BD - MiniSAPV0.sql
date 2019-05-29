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
('Laboratório'),
('Produção'),
('Manutenção'),
('Administrativo'),
('Refeitório')

go

insert into Equipamentos
Values
('Torno', 3),
('Fresadora', 3),
('Furadeira de Bancada', 3),
('Ar condicionado', 4),
('Luminária', 5)

go

insert into Especialidades
Values
('Elétrica'),
('Mecânica'),
('Automação'),
('Civil'),
('Zeladoria')

go

insert into Notas
Values
('Equipamento não liga','Equipamento não esta ligando, aparenta ser falha na alimentação', 1),
('Equipamento com fiação exposta','Cabos do equipamento estão expostos, risco de choque', 2),
('Equipamento com barulho anormal','Equipamento com barulho acima do normal', 3),
('Ar condicionado não gela','Ar condicionado não gela', 4),
('Iluminação deficiente','Iluminação deficiente na área do refeitório', 5)

go

insert into Ordens
Values
('Testar Alimentação','Verificar alimentação e QGBT', 1, 1),
('Isolar fiação','Verificar pontos expostos e isolar ou substituir o cabo', 2, 1),
('Verificar barulho anormal','Executar análise de vibração do equipamento', 3, 2),
('Recarga de fluído','Verificar se é necessário recarga de gás', 4, 5),
('Substituir lampadas','Substituir lampadas queimadas', 5, 1)

go