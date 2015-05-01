import java.util.Arrays;
import java.util.List;


public class CustomCountryCodeProviderImpl implements CountryCodeProvider {

	@Override
	public List<String> get() {
		return Arrays.asList("..");
	}

}
