CREATE DATABASE IF NOT EXISTS `pokedroid`;
	
			CREATE TABLE IF NOT EXISTS pokedroid.Utente (
				uten_id bigint AUTO_INCREMENT,
				uten_mail varchar(254) NOT NULL UNIQUE,
				uten_password varchar(255) NOT NULL,
				PRIMARY KEY (uten_id)
			);
			
			CREATE TABLE IF NOT EXISTS pokedroid.Pokedex (
				poke_id bigint AUTO_INCREMENT,
				poke_completamento int NOT NULL check(poke_completamento >= 0 AND poke_completamento<= 151),
				PRIMARY KEY (poke_id)
			);
			
			CREATE TABLE IF NOT EXISTS pokedroid.`User` (
				user_id bigint AUTO_INCREMENT,
				user_username varchar(50) NOT NULL,
				user_genere bit NOT NULL,
				user_id_pokedex bigint NOT NULL,
				user_codice_amico varchar(15) NOT NULL,
				PRIMARY KEY (user_id),
				FOREIGN KEY (user_id_pokedex) REFERENCES Pokedex(poke_id)
			);
			
			CREATE TABLE IF NOT EXISTS pokedroid.`Tipo` (
				tipo_id int check(tipo_id >= 1 AND tipo_id<= 15),
				tipo VARCHAR(9) NOT NULL,
				PRIMARY KEY (tipo_id)
			);
			
			CREATE TABLE IF NOT EXISTS pokedroid.`Pokemon` (
				poke_id bigint AUTO_INCREMENT,
				poke_tipo int,
				poke_forza int NOT NULL check(poke_forza >= 1 AND poke_forza<= 100),
				poke_grinta int NOT NULL check(poke_grinta >= 1 AND poke_grinta <= 100),
				poke_fortuna int NOT NULL check(poke_fortuna >= 1 AND poke_fortuna <= 100),
				poke_difesa int NOT NULL check(poke_difesa >= 1 AND poke_difesa <= 100),
				poke_astuzia int NOT NULL check(poke_astuzia >= 1 AND poke_astuzia <= 100),
				poke_resistenza int NOT NULL check(poke_resistenza >= 1 AND poke_resistenza <= 100),
				poke_velocita int NOT NULL check(poke_velocita >= 1 AND poke_velocita <= 100),
				poke_codice_attivazione varchar(30) NOT NULL UNIQUE,
				PRIMARY KEY (poke_id),
				FOREIGN KEY (poke_tipo) REFERENCES Tipo(tipo_id)
			);
            
            CREATE TABLE IF NOT EXISTS pokedroid.`Utenza` (
				uten_id bigint AUTO_INCREMENT,
                user_id bigint,
                PRIMARY KEY(uten_id,user_id),
                FOREIGN KEY (uten_id) REFERENCES Utente(uten_id),
                FOREIGN KEY (user_id) REFERENCES `User`(user_id)
            );
            
			CREATE TABLE IF NOT EXISTS pokedroid.`Amicizia` (
				user_id_1 bigint,
                user_id_2 bigint,
                PRIMARY KEY(user_id_1,user_id_2),
                FOREIGN KEY (user_id_1) REFERENCES `User`(user_id),
                FOREIGN KEY (user_id_2) REFERENCES `User`(user_id)
            );
            
            CREATE TABLE IF NOT EXISTS pokedroid.`Avanzamento` (
				pokemon_id bigint,
                pokedex_id bigint,
                PRIMARY KEY(pokemon_id,pokedex_id),
                FOREIGN KEY (pokemon_id) REFERENCES Pokemon(poke_id),
                FOREIGN KEY (pokedex_id) REFERENCES Pokedex(poke_id)
            );