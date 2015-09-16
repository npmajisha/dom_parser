import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class SummaryGenerator {

	public static void main(String[] args) throws ParserConfigurationException {
		final String USER_XML = args[0];
		final String POSTS_XML = args[1];
//		
//		UsersDomParser usersDomParser = new UsersDomParser();
//		Document docUsers = usersDomParser.parseFile(USER_XML);
//		usersDomParser.extractElements(docUsers);
		
		PostsDomParser postsDomParser = new PostsDomParser();
		Document docPosts = postsDomParser.parseFile(POSTS_XML);
		postsDomParser.extractElements(docPosts);

	}

}
