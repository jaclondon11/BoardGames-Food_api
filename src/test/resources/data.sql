INSERT INTO Mesa (ID, CODIGO) 
VALUES (1, '01');
INSERT INTO Mesa (ID, CODIGO) 
VALUES (2, '02');
INSERT INTO Mesa (ID, CODIGO) 
VALUES (3, '03');
INSERT INTO Mesa (ID, CODIGO) 
VALUES (4, '04');

INSERT INTO Reserva (
ID,ID_MESA,FECHA_INICIO_RESERVA, FECHA_FIN_RESERVA,CANTIDAD_PERSONAS,TITULAR,JUEGO)
VALUES(1,1,NULL,NULL,'Felipe',4,'Exploding Kittens')