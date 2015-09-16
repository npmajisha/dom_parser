import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.google.common.base.Joiner;

public class PostsDomParser extends DomParser {

	private static final String TAG_ROW = "row";
	private static final String POST_ID_ATTRIBUTE = "Id";
	private static final String POST_TYPE_ID_ATTRIBUTE = "PostTypeId";
	private static final String POST_TYPE_QUESTION = "1";
	private static final String POST_TYPE_ANSWER = "2";
	private static final String SCORE_ATTRIBUTE = "Score";
	private static final String CREATION_DATE_ATTRIBUTE = "CreationDate";
	private static final String OWNER_USERID_ATTRIBUTE = "OwnerUserId";

	@Override
	protected void extractElements(Document doc) {
		doc.getDocumentElement().normalize();

		NodeList posts = doc.getDocumentElement().getElementsByTagName(TAG_ROW);
		int numberOfPosts = posts.getLength();
		System.out.println("Total Number of Posts = " + numberOfPosts);

		int numberOfQuestionsAnswers = 0;
		for (int i = 0; i < numberOfPosts; i++) {
			Element post = (Element) posts.item(i);
			String postId = post.getAttribute(POST_ID_ATTRIBUTE);
			String postType = post.getAttribute(POST_TYPE_ID_ATTRIBUTE);
			if (postType.equals(POST_TYPE_QUESTION) || postType.equals(POST_TYPE_ANSWER)) {
				System.out.println(Joiner.on("  ").join(postId, postType, post.getAttribute(OWNER_USERID_ATTRIBUTE),
						post.getAttribute(SCORE_ATTRIBUTE), post.getAttribute(CREATION_DATE_ATTRIBUTE)));
				numberOfQuestionsAnswers++;
			}
		}
		System.out.println("Total Number of Questions and Answers = " + numberOfQuestionsAnswers);
	}

}
