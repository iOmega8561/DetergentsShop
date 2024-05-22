use detergents;

insert into ClienteRegistrato values 
("peppebrescia22", "ezpassword", "3909908076", "4444555566667777"),
("andreadipre45", "ezpassword", "3609908076", "4444555566667777"),
("giacomolabriola", "ezpassword", "3509908076", "4444555566667777");

insert into Impiegato values 
("098109823", "ezpassword");

insert into Fattorino values 
("098109823", "3502348076");

insert into Ordine (data, totale, stato, prodotti, cliente, fattorino) values 
("2024-5-21", 34.5, 0, "{products: [\"PuliMax\", \"AntiFaviJ\"]}", "peppebrescia22", "098109823"),
("2024-5-21", 24.5, 0, "{products: [\"PuliMax\", \"AntiFaviJ\"]}", "peppebrescia22", "098109823"),
("2024-5-21", 14.5, 0, "{products: [\"PuliMax\", \"AntiFaviJ\"]}", "peppebrescia22", "098109823"),
("2024-5-21", 64.5, 0, "{products: [\"PuliMax\", \"AntiFaviJ\"]}", "andreadipre45", "098109823"),
("2024-5-21", 44.5, 0, "{products: [\"PuliMax\", \"AntiFaviJ\"]}", "andreadipre45", "098109823");

/*
set @N = 1;

select
    O.cliente as Cliente,
    count(O.id) as NumeroOrdini,
    sum(O.totale) as TotaleSpeso
from
    Ordine O
group by
    O.cliente
having
    count(O.id) >= @N
order by
    NumeroOrdini;
*/