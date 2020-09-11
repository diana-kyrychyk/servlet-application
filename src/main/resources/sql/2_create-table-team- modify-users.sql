CREATE TABLE teams (
        id INT NOT NULL AUTO_INCREMENT,
        firstName VARCHAR(100),
        PRIMARY KEY (id)
);


CREATE TABLE users_teams (
        user_id INT,
        team_id INT,
        FOREIGN KEY (user_id) references users(id) on delete cascade,
        FOREIGN KEY (team_id) references teams(id) on delete cascade
);


ALTER TABLE users
ADD login VARCHAR(25);
