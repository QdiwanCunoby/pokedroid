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
-- START insert in table pokemon
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Caterpie",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Metapod",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Butterfree",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Weedle",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Kakuna",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Beedrill",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Pidgey",3,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Pidgeotto",3,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Pidgeot",3,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
-- NEW POKEMON INSERT
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Rattata",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Raticate",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Spearow",3,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Fearow",3,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Ekans",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Arbok",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Pikachu",12,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Raichu",12,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Sandshrew",5,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Sandslash",5,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Nidoran♀",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Nidorina",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Nidoqueen",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Nidoran♂",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Nidorino",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Nidoking",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Clefairy",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Clefable",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Vulpix",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Ninetales",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Jigglypuff",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Wigglytuff",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Zubat",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Golbat",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Oddish",11,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Gloom",11,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Vileplume",11,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Paras",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Parasect",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Venonat",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Venomoth",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Diglett",5,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Dugtrio",5,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Meowth",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Persian",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Psyduck",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Golduck",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Mankey",2,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Primeape",2,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Growlithe",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Arcanine",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Poliwag",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Poliwhirl",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Poliwrath",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Abra",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Kadabra",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Alakazam",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Machop",2,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Machoke",2,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Machamp",2,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Bellsprout",11,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Weepinbell",11,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Victreebel",11,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Tentacool",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Tentacruel",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Geodude",6,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Graveler",6,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Golem",6,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Ponyta",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Rapidash",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Slowpoke",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Slowbro",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Magnemite",12,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Magneton",12,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Farfetch'd",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Doduo",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Dodrio",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Seel",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Dewgong",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Grimer",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Muk",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Shellder",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Cloyster",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Gastly",8,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Haunter",8,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Gengar",8,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Onix",6,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Drowzee",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Hypno",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Krabby",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Kingler",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Voltorb",12,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Electrode",12,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Exeggcute",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Exeggutor",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Cubone",5,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Marowak",5,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Hitmonlee",2,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Hitmonchan",2,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Lickitung",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Koffing",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Weezing",4,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Rhyhorn",6,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Rhydon",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Chansey",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Tangela",11,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Kangaskhan",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Horsea",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Seadra",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Goldeen",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Seaking",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Staryu",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Starmie",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Mr. Mime",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Scyther",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Jynx",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Electabuzz",12,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Magmar",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Pinsir",7,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Tauros",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Magikarp",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Gyarados",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Lapras",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Ditto",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Eevee",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Vaporeon",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Jolteon",12,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Flareon",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Porygon",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Omanyte",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Omastar",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Kabuto",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Kabutops",10,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Aerodactyl",3,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Snorlax",1,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Articuno",14,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Zapdos",12,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Moltres",9,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Dratini",15,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Dragonair",15,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Dragonite",15,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Mewtwo",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
INSERT INTO pokemon(poke_nome,poke_tipo,poke_forza,poke_grinta,poke_fortuna,poke_difesa,poke_astuzia,poke_resistenza,poke_velocita,poke_codice_attivazione) 
VALUES("Mew",13,FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),FLOOR(RAND()*(100-1+1)+ 1),
randomPassword());
-- END insert in table pokemon 