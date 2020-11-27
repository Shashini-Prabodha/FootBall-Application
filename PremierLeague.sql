DROP DATABASE IF EXISTS PremierLeague;
CREATE DATABASE IF NOT EXISTS PremierLeague;
use PremierLeague;

CREATE TABLE footballClub(
	name varchar(50),
    location varchar(100),
    tp int,
	wins int,
	draws int,
	defeats int,
	receivedGoals int,
	scoredGoals int,
	points int,
	playedMatches int ,

	CONSTRAINT PRIMARY KEY(name)
);


CREATE TABLE matchDetails(
	matchID int,
	club1 varchar(50),
    club2 varchar(100),
    scoreClub1 int,
	scoreClub2 int,
	date date,
	CONSTRAINT PRIMARY KEY(matchID,club1,club2,date)

);

