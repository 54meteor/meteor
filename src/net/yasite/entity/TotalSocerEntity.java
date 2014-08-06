package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class TotalSocerEntity implements Serializable {
	private String round_id;
	private String name;
	private String groups;
	private String rankingsCount;
	private String aggrCount;
	private String matchCount;
	private List<SocerEntity> rankings;
	public String getRound_id() {
		return round_id;
	}
	public void setRound_id(String round_id) {
		this.round_id = round_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public String getRankingsCount() {
		return rankingsCount;
	}
	public void setRankingsCount(String rankingsCount) {
		this.rankingsCount = rankingsCount;
	}
	public String getAggrCount() {
		return aggrCount;
	}
	public void setAggrCount(String aggrCount) {
		this.aggrCount = aggrCount;
	}
	public String getMatchCount() {
		return matchCount;
	}
	public void setMatchCount(String matchCount) {
		this.matchCount = matchCount;
	}
	public List<SocerEntity> getRankings() {
		return rankings;
	}
	public void setRankings(List<SocerEntity> rankings) {
		this.rankings = rankings;
	}
	
}
