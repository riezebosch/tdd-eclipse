import java.util.Arrays;
import java.util.List;


public class CountryCodeProviderImpl implements CountryCodeProvider {

	@Override
	public List<String> get() {
		return Arrays.asList("NL", "BE");
	}

}
