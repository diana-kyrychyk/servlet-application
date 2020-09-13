ALTER TABLE users_teams add constraint unique_user_id_team_id unique (user_id, team_id);
