package models;

import java.util.List;

public class AnalysesDto {

	/**
	 * Liste des analyses
	 */
	private List<Analyse> analyses;

	/**
	 * Getter sur la liste des analyses.
	 * @return List<Analyse>
	 */
	public List<Analyse> getAnalyses() {
		return analyses;
	}

	/**
	 * Setter sur la lsite des analyses.
	 * @param analyses liste des analyses
	 */
	public void setAnalyses(List<Analyse> analyses) {
		this.analyses = analyses;
	}
}
