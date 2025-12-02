/*
 * Copyright (c) 2025 Giuseppe Rocco
 * Copyright (c) 2025 Federica Mosca 
 * Copyright (c) 2025 Vittorio Monfrecola
 * Licensed under the MIT License. See the LICENSE file for details.
 */

use detergents;

create table if not exists ClienteRegistrato(
	nomeUtente varchar(255) primary key,
    password varchar(255) not null,
    nrTelefono varchar(10) unique not null,
    cartaCredito varchar(16) not null
);

create table if not exists Impiegato(
	codice bigint primary key,
    password varchar(255) not null
);

create table if not exists Fattorino(
	codice bigint primary key,
    nrTelefono varchar(10) unique not null
);

create table if not exists Sconto(
	codice varchar(50) primary key,
    percentuale integer not null,
    scadenza date not null
);

create table if not exists Prodotto(
	codice varchar(255) primary key,
    nome varchar(255) not null,
    descrizione varchar(255) not null,
    prezzo float not null,
    quant integer not null
);

create table if not exists Ordine(
	id bigint primary key auto_increment,
    data date not null,
    totale float not null,
    stato int(2) not null,
    prodotti longtext not null,
    cliente varchar(255) not null,
    fattorino bigint not null,
    
    constraint rif_cliente foreign key (cliente) references ClienteRegistrato(nomeUtente),
    constraint rif_fattorino foreign key (fattorino) references Fattorino(codice),
    constraint check_stato check(stato < 3)
);
