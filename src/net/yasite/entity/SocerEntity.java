package net.yasite.entity;

import java.io.Serializable;

public class SocerEntity implements Serializable {

	private String rank;
	private String last_rank;
	private String team_id;
	private String club_name;
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getLast_rank() {
		return last_rank;
	}
	public void setLast_rank(String last_rank) {
		this.last_rank = last_rank;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	
	
}