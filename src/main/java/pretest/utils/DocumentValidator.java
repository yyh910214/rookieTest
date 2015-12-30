package pretest.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pretest.board.model.Document;

/**
 * 2015. 12. 29. Copyright by joyhan / HUFS DocumentValidator
 */
@Component
public class DocumentValidator implements Validator {
	private static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern;

	public DocumentValidator() {
		pattern = Pattern.compile(emailRegExp);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return Document.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Document document = (Document) target;
		Matcher matcher = pattern.matcher(document.getEmail());
		if (!matcher.matches()) {
			errors.rejectValue("email", "bad");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required");
	}
}
