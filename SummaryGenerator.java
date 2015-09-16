import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class SummaryGenerator {

	public static void main(String[] args) throws ParserConfigurationException {
		final String USER_XML = args[0];
		final String POSTS_XML = args[1];
		
		UsersDomParser userDomParser = new UsersDomParser();
		Document doc = userDomParser.parseFile(USER_XML);
		userDomParser.extractElements(doc);

	}

}
