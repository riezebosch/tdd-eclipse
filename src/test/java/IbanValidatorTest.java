import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import org.junit.Test;


public class IbanValidatorTest {

	@Test
	public void test() {
		// Arrange
		String iban = "NL78RABO0162136188";
		IbanValidator validator = new IbanValidator();
		
		// Act
		boolean result = validator.validate(iban);
		
		// Assert
		assertThat(result, is(true));
	}
	
	@Test
	public void givenAnIbanNotStartingWithNlWhenValidatingThenValidateShouldReturnFalse() throws Exception {
		String iban = "XX78RABO0162136188";
		IbanValidator validator = new IbanValidator();
		
		// Act
		boolean result = validator.validate(iban);
		
		// Assert
		assertThat(result, is(false));
	}

	@Test
	public void givenAnIbanStartingWithBeWhenValidatingThenValidateShouldReturnTrue() throws Exception {
		String iban = "BE68539007547034";
		IbanValidator validator = new IbanValidator();
		
		// Act
		boolean result = validator.validate(iban);
		
		// Assert
		assertThat(result, is(true));
	}
	
	@Test
	public void givenAMadeUpCountryCodeWhenValidatingWithCustomCountryCodeProviderThenValidateShouldReturnTrue() throws Exception {
		String iban = "..78RABO0162136188";
		CountryCodeProvider provider = new CustomCountryCodeProviderImpl();
		IbanValidator validator = new IbanValidator(provider);
		
		// Act
		boolean result = validator.validate(iban);
		
		// Assert
		assertThat(result, is(true));
	}
	
	@Test(expected=NullPointerException.class)
	public void exampleCodeStillContainingBugsEvenWithCompleteCoverage_givenAnEmptyIbanWhenValidatingThenValidatorShouldReturnFalse() throws Exception {
		assertThat(new IbanValidator().validate(null), is(false));
	}
	
	
	@Test
	public void badExampleThisWillFailInFutureWhenValidatorIsCompleted_GivenAValidLandCodeWhenValidatingThenValidatorShouldReturnTrue() throws Exception {
		String iban = "NL";
		IbanValidator validator = new IbanValidator();
		
		boolean result = validator.validate(iban);
		assertThat(result, is(true));
	}
}
