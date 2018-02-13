
DROP TABLE IF EXISTS lances;
DROP TABLE IF EXISTS tipos_lance;
DROP TABLE IF EXISTS partidos;
DROP TABLE IF EXISTS estados;
DROP TABLE IF EXISTS equipos;



CREATE TABLE equipos (
  id int(11) 											NOT NULL,
  nombre 				varchar(100) 	DEFAULT NULL,
  escudo 				varchar(45) 	DEFAULT NULL,
  PRIMARY KEY (id)
) 



CREATE TABLE estados (
  estado 				varchar(45) 					NOT NULL,
  PRIMARY KEY (estado)
) 


CREATE TABLE lances (
  id int(11) 											NOT NULL,
  id_partido 			int(11) 		DEFAULT NULL,
  id_equipo 			int(11) 		DEFAULT NULL,
  minuto 				int(11) 		DEFAULT NULL,
  id_tipo 				varchar(45) 	DEFAULT NULL,
  comentario 			varchar(200) 	DEFAULT NULL,
  PRIMARY KEY (id),
  KEY 'fk_lance_partido_idx' (id_partido),
  KEY 'fk_lance_equipo_idx'  (id_equipo),
  KEY 'fk_lance_tipo_idx'    (id_tipo),
  CONSTRAINT 'fk_lance_equipo' 	FOREIGN KEY (id_equipo)  REFERENCES equipos (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT 'fk_lance_partido' FOREIGN KEY (id_partido) REFERENCES partidos (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT 'fk_lance_tipo' 	FOREIGN KEY (id_tipo) 	 REFERENCES tipos_lance (tipo) ON DELETE NO ACTION ON UPDATE NO ACTION
) 




CREATE TABLE partidos (
  id 					int(11) 						NOT NULL,
  jornada 				varchar(45) 	DEFAULT NULL,
  id_equipo_visitante 	int(11) 		DEFAULT NULL,
  id_equipo_local 		int(11) 		DEFAULT NULL,
  goles_local 			int(11) 		DEFAULT NULL,
  goles_visitante 		int(11) 		DEFAULT NULL,
  id_estado 			varchar(45) 	DEFAULT NULL,
  PRIMARY KEY (id),
  KEY 'fk_partido_equipo_local_idx' (id_equipo_local),
  KEY 'fk_partido_equipo_visitante_idx' (id_equipo_visitante),
  KEY 'fk_partido_estado_idx' (id_estado),
  CONSTRAINT 'fk_partido_equipo_local' 		FOREIGN KEY (id_equipo_local) REFERENCES equipos (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT 'fk_partido_equipo_visitante' 	FOREIGN KEY (id_equipo_visitante) REFERENCES equipos (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT 'fk_partido_estado' 			FOREIGN KEY (id_estado) REFERENCES estados (estado) ON DELETE NO ACTION ON UPDATE NO ACTION
) 



CREATE TABLE tipos_lance (
  tipo 					varchar(45) 					NOT NULL,
  PRIMARY KEY (tipo)
) 
