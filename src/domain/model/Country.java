package domain.model;

public class Country {

	private String name;
	private String capital;
	private int numberInhabitants;
	private int votes;

	public Country () {
	}
	
	public Country(String name) {
		this(name, 0, null, 0);
	}

	public Country(String name, int numberInhabitants, String capital, int votes) {
		setName(name);
		setNumberInhabitants(numberInhabitants);
		setCapital(capital);
		vote(votes);
	}

	public void vote() {
		vote(1);
	}

	public void vote(int votes) {
		setVotes(getVotes() + votes);
	}

	@Override
	public boolean equals(Object object) {
		boolean equal = false;
		if (object instanceof Country) {
			Country other = (Country) object;
			equal = this.getName().equals(other.getName());
		}
		return equal;
	}

	@Override
	public String toString() {
		String result = getName() + " (" + getNumberInhabitants()
				+ " inwoners, hoofdstad " + getCapital() + ")";
		return result;
	}

	public int getNumberInhabitants() {
		return numberInhabitants;
	}

	public void setNumberInhabitants(int numberInhabitants) {
		if (numberInhabitants <= 0) {
			throw new IllegalArgumentException("The number of inhabitants must be positive!");
		}
		this.numberInhabitants = numberInhabitants;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name may not be empty!");
		}
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		if (votes <= 0) {
			throw new IllegalArgumentException("The number of votes must be between 0 and 5");
		}
		this.votes = votes;
	}
}
