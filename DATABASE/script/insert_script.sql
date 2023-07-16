USE pokedroid;

-- START insert in table tipo
INSERT INTO tipo(tipo_id,tipo) VALUES(1,"normale");
INSERT INTO tipo(tipo_id,tipo) VALUES(2,"lotta");
INSERT INTO tipo(tipo_id,tipo) VALUES(3,"volante");
INSERT INTO tipo(tipo_id,tipo) VALUES(4,"veleno");
INSERT INTO tipo(tipo_id,tipo) VALUES(5,"terra");
INSERT INTO tipo(tipo_id,tipo) VALUES(6,"roccia");
INSERT INTO tipo(tipo_id,tipo) VALUES(7,"coleottero");
INSERT INTO tipo(tipo_id,tipo) VALUES(8,"spettro");
INSERT INTO tipo(tipo_id,tipo) VALUES(9,"fuoco");
INSERT INTO tipo(tipo_id,tipo) VALUES(10,"acqua");
INSERT INTO tipo(tipo_id,tipo) VALUES(11,"erba");
INSERT INTO tipo(tipo_id,tipo) VALUES(12,"elettro");
INSERT INTO tipo(tipo_id,tipo) VALUES(13,"spico");
INSERT INTO tipo(tipo_id,tipo) VALUES(14,"ghiaccio");
INSERT INTO tipo(tipo_id,tipo) VALUES(15,"drago");
-- END insert in table tipo

-- START insert in table pokemon
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Bulbasaur",11,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Ivysaur",11,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Venusaur",11,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Charmender",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Charmeleon",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Charizard",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Squirtle",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Wartortle",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Blastoise",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());