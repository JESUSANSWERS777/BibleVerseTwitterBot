//class is set up to search for hashtag verseoftheday and retweet the first one found.
//can alter it to find multiple hashtags or retweet multiple tweets. 
import twitter4j.*;


public class MyBot{

	//if something goes wrong,  might see a TwitterException
	public static void main(String...args) throws TwitterException, InterruptedException{

		//access the Twitter API using your twitter4j.properties file
		Twitter twitter = TwitterFactory.getSingleton();


		//runs forever
		while(true){
		//create a new seartch 
		Query query = new Query("\"#verseoftheday\" || #");

		//get the results from search
		QueryResult result = twitter.search(query);


		//get first tweet from those results
		Status tweetResult = result.getTweets().get(0);

		//retweet status
		twitter.retweetStatus(tweetResult.getId());
		
		System.out.println("Sleeping");

		//go to sleep for 24 hours
		Thread.sleep(24*60*60*1000);
		}



		/*itierate over every search result
		for(Status tweet: result.getTweets()){
			//print out tweet
			System.out.println(tweet.getUser().getScreenName() + ":" + tweet.getText());

		}*/

		//reply to that tweet
		/*StatusUpdate statusUpda = new StatusUpdate(".@" + tweetResult.getUser().getScreenName() 
			+ " nice");
		statusUpdate.inReplyToStatusId(tweetResult.getId());
		Status status = twitter.updateStatus(statusUpdate);*/

		//send a tweet
		//Status status = twitter.updateStatus("Hello World");

		//print a message so we can know when it is finishes
		//System.out.println("Done.");
	}
}

// compiles code from command line
// javac -cp twitter4j-core-4.0.4.jar MyBot.java
//runs code from command line
// java -cp "twitter4j-core-4.0.4.jar;." MyBot
