package domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.model.Country;

public class CountryService {
	private Map<String, Country> countries = new HashMap<String, Country>();
	
	public CountryService () {
		addCountry(new Country("Belgie", 11000000, "Brussel", 4));
		addCountry(new Country("Nederland", 20000000, "Amsterdam", 4));
		addCountry(new Country("Frankrijk", 660000000, "Parijs", 5));
	}
	
	public void addCountry(Country country){
		countries.put(country.getName(), country);
	}
	
	public List<Country> getCountries(){
		return new ArrayList<Country>(countries.values());
	}

	public Country getMostPopularCountry() {
		int highestVotes = -1;
		Country mostPopular = null;
		List<Country> countryList = getCountries();
		for(int i = 0; i < countryList.size(); i++){
			if(countryList.get(i).getVotes() > highestVotes){
				mostPopular = countryList.get(i);
				highestVotes = mostPopular.getVotes();
			}
		}
		return mostPopular;
	}

    public Country getCountryWithName(String name) {
		return countries.get(name);
    }
}
