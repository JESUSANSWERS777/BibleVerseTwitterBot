import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;

public class MyBot{

	//if something goes wrong, we might see a TwitterException
	public static void main(String...args) throws TwitterException{

		//access the Twitter API using your twitter4j.properties file
		Twitter twitter = TwitterFactory.getSingleton();

		//send a tweet
		//Status status = twitter.updateStatus("Hello World");

		//print a message so we can know when it is finishes
		//System.out.println("Done.");

		//create a new seartch 
		Query query = new Query("\"bible\"");

		//get the results from search
		QueryResult result = twitter.search(query);

		//itierate over every search result
		for(Status tweet: result.getTweets()){
			//print out tweet
			System.out.println(tweet.getUser().getScreenName() + ":" + tweet.getText());

		}
	}
}