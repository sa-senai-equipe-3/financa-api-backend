create table if not exists fornecedores
(
    id            serial
        constraint fornecedor_pk
            primary key,
    razao_social  varchar(80) not null,
    nome_fantasia varchar(90) not null,
    cnpj          varchar(18) not null,
    login         varchar(20) not null,
    senha         varchar(10) not null
);

alter table fornecedores
    owner to postgres;

create unique index if not exists fornecedor_cnpj_uindex
    on fornecedores (cnpj);

create unique index if not exists fornecedor_id_uindex
    on fornecedores (id);

create unique index if not exists fornecedor_razao_social_uindex
    on fornecedores (razao_social);

create table if not exists titulos
(
    id              serial
        constraint titulo_pk
            primary key,
    valor           numeric     not null,
    data_vencimento date        not null,
    nome_banco      varchar(20) not null,
    descricao       text        not null,
    fornecedor_id   integer     not null
        constraint titulo_fornecedor_fk
            references fornecedores
);

alter table titulos
    owner to postgres;

create unique index if not exists titulo_id_uindex
    on titulos (id);

create table if not exists usuarios
(
    id            serial
        constraint usuario_pk
            primary key,
    nome_completo varchar(50) not null,
    login         varchar(20) not null,
    senha         varchar(10) not null,
    perfil        varchar(10) not null
);

alter table usuarios
    owner to postgres;

create unique index if not exists usuario_id_uindex
    on usuarios (id);