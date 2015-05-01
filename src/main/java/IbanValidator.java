import java.util.Arrays;


public class IbanValidator {
	private CountryCodeProvider provider;
	
	public IbanValidator() {
		this(new CountryCodeProviderImpl());
	}
	
	public IbanValidator(CountryCodeProvider provider) {
		this.provider = provider;
	}

	public boolean validate(String iban) {
		if (isValidCountryCode(iban.substring(0, 2))) {
			return true;
		}
		
		return false;
	}

	private boolean isValidCountryCode(String countryCode) {
		 return provider.get().contains(countryCode);
	}

}
