
CREATE FUNCTION randomPassword()
RETURNS varchar(128)
BEGIN

SET @chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
SET @charLen = length(@chars);

SET @randomPassword = '';

WHILE length(@randomPassword) < 12
    DO
    SET @randomPassword = concat(@randomPassword, substring(@chars,CEILING(RAND() * @charLen),1));
END WHILE;

RETURN @randomPassword ;
END

