
INSERT INTO equipos VALUES (1,'F.C Barcelona','a.jpg'),
						   (2,'R. Madrid C.F','b.jsp'),
						   (3,'A.C Milan','c.jsp'),
						   (4,'RCD Espanyol','d.jsp');


INSERT INTO estados VALUES ('ABIERTO'),
						   ('CERRADO'),
					 	   ('PENDIENTE');


INSERT INTO partidos VALUES (1,1,1,2,1,1,'CERRADO'),
							(2,1,3,4,1,0,'CERRADO'),
							(3,2,2,3,0,0,'ABIERTO'),
							(4,2,4,1,0,1,'ABIERTO'),
							(5,3,2,1,0,0,'PENDIENTE'),
							(6,3,4,3,0,0,'PENDIENTE'),
							(7,4,3,2,0,0,'PENDIENTE'),
							(8,4,1,4,0,0,'PENDIENTE'),
							(9,5,3,1,0,0,'PENDIENTE'),
							(10,5,4,2,0,0,'PENDIENTE'),
							(11,6,1,3,0,0,'PENDIENTE'),
							(12,6,2,4,0,0,'PENDIENTE');


INSERT INTO tipos_lance VALUES ('AGRESION'),
							   ('CORNER'),
							   ('FALTA'),
							   ('FALTA_PELIGROSA'),
							   ('GOL'),
							   ('INCIDENCIA'),
							   ('JUGADA'),
							   ('LESION'),
							   ('OCASION'),
							   ('PENALTY'),
							   ('TARJETA_ROJA'),
							   ('TARJETA_AMARILLA');
INSERT INTO lances VALUES (1,1,1,19,'GOL','Golazo de Messi por la escuadra'),
						  (2,1,1,33,'TARJETA_AMARILLA','Mordisco de Luis Suarez'),
						  (3,1,2,80,'PENALTY','Piscinazo de Cristiano'),
						  (4,1,2,80,'GOL','Cristiano Balon de ORO'),
						  (5,2,4,15,'GOL','No se lo creen ni ellos'),
						  (6,2,3,89,'OCASION','Paradon del portero'),
						  (7,3,2,23,'INCIDENCIA','Espontaneo salta al campo'),
						  (8,4,2,80,'LESION','El entrenador se lesiona'),
						  (9,4,4,82,'GOL','La vin que Golazo');
						  