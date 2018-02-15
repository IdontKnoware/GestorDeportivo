
INSERT INTO equipos VALUES (1,'F.C Barcelona','a.jpg'),
						   (2,'R. Madrid C.F','b.jsp'),
						   (3,'A.C Milan','c.jsp'),
						   (4,'RCD Espanyol','d.jsp');


INSERT INTO estados VALUES ('ABIERTO'),
						   ('CERRADO'),
					 	   ('PENDIENTE');


INSERT INTO partidos VALUES (1,1,1,2,0,0,'PENDIENTE'),
							(2,1,3,4,0,0,'PENDIENTE'),
							(3,2,2,3,0,0,'PENDIENTE'),
							(4,2,4,1,0,0,'PENDIENTE'),
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

INSERT INTO lances VALUES (1, 1, 1, 10, 'GOL', 'Golaso');
INSERT INTO lances VALUES (2, 1, 2, 11, 'LESION', 'LESIÓN DE PROSINESKY');
INSERT INTO lances VALUES (3, 1, 2, 90, 'TARJETA_AMARILLA', 'AMARILLA A HIERRO');