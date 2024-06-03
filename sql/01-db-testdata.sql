/*
 Copyright (c) 2024 Giuseppe Rocco, Federica Mosca, Vittorio Monfrecola

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
*/

use detergents;

insert into ClienteRegistrato values 
("peppebrescia22", "ezpassword", "3909908076", "4444555566667777"),
("andreadipre45", "ezpassword", "3609908076", "4444555566667777"),
("giacomolabriola", "ezpassword", "3509908076", "4444555566667777");

insert into Impiegato values 
("098109823", "ezpassword");

insert into Fattorino values 
("098109823", "3502348076");

insert into Prodotto values
("GRNGBLN0323", "GreenGoblin", "Pesticida per aracnidi col costume rosso e blu", 5.61, 800),
("UNDSCRCH001", "UnderScorch", "Detergente intimo a base di peperoncino Carolina Reaper", 10.19, 100),
("AFTRSLP0090", "AfterSlap", "Crema lenitiva per da applicare dopo gli schiaffi di Will Smith", 3.99, 300);

insert into Ordine (data, totale, stato, prodotti, cliente, fattorino) values 
("2024-5-21", 11.22, 2, "[{\"prodotto\": \"GRNGBLN0323\", \"quantita\": 2}]", "peppebrescia22", "098109823"),
("2024-5-21", 50.95, 2, "[{\"prodotto\": \"UNDSCRCH001\", \"quantita\": 5}]", "peppebrescia22", "098109823"),
("2024-5-21", 58.93, 2, "[{\"prodotto\": \"AFTRSLP0090\", \"quantita\": 2},{\"prodotto\": \"UNDSCRCH001\", \"quantita\": 5}]", "peppebrescia22", "098109823"),
("2024-5-21", 11.22, 2, "[{\"prodotto\": \"GRNGBLN0323\", \"quantita\": 2}]", "andreadipre45", "098109823"),
("2024-5-21", 7.98, 2, "[{\"prodotto\": \"AFTRSLP0090\", \"quantita\": 2}]", "andreadipre45", "098109823");