import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.google.common.base.Joiner;

public class UsersDomParser extends DomParser {

	private static final String TAG_ROW = "row";
	private static final String ACCOUNT_ID_ATTRIBUTE = "AccountId";
	private static final String CREATION_DATE_ATTRIBUTE = "CreationDate";
	private static final String LAST_ACCESS_DATE_ATTRIBUTE = "LastAccessDate";

	@Override
	protected void extractElements(Document doc) {

		doc.getDocumentElement().normalize();

		NodeList users = doc.getDocumentElement().getElementsByTagName(TAG_ROW);

		int numberOfUsers = users.getLength();
		System.out.println("Total Number of Users = " + numberOfUsers);

		int numberOfActiveUsers = 0;

		for (int i = 0; i < numberOfUsers; i++) {
			Element user = (Element) users.item(i);
			String userAccountId = user.getAttribute(ACCOUNT_ID_ATTRIBUTE);
			LocalDateTime creationDate = LocalDateTime.parse(user.getAttribute(CREATION_DATE_ATTRIBUTE));
			LocalDateTime lastAccessDate = LocalDateTime.parse(user.getAttribute(LAST_ACCESS_DATE_ATTRIBUTE));
			Long activeMonths = ChronoUnit.MONTHS.between(creationDate, lastAccessDate);
			if (activeMonths >= 6) {
				System.out.println(Joiner.on("  ").join("User", userAccountId, creationDate, lastAccessDate));
				numberOfActiveUsers++;
			}
		}
		System.out.println("Number of active users = " + numberOfActiveUsers);
	}

}
