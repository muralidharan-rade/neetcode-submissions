class Twitter {

    Map<Integer, List<TweetPair>> userTweets;
    Map<Integer, List<Integer>> userConnections;
    PriorityQueue<TweetPair> pq;
    int count = 0;

    public Twitter() {
        userTweets = new HashMap<>();
        userConnections = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<TweetPair> tweets = userTweets.get(userId);
        
        if(tweets == null) {
            tweets = new ArrayList<>();
            userTweets.put(userId, tweets);
        }
        
        count++;
        tweets.add(new TweetPair(tweetId, count));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        pq = new PriorityQueue<>(new TweetCompare());

        List<TweetPair> tweets = userTweets.get(userId);
        if(tweets != null) {
        for(TweetPair i : tweets) {
            pq.offer(i);
        }}

        List<Integer> conn = userConnections.get(userId);
        if(conn != null) {
        for(int j : conn) {
            List<TweetPair> userTwee = userTweets.get(j);
            for(TweetPair k : userTwee) {
                pq.offer(k);
            }
        }}

        List<Integer> result = new ArrayList<>();
        int x = 0;
        while(!pq.isEmpty() && x < 10) {
            TweetPair tp = pq.poll();
            result.add(tp.tweetId);
            x++;
        }
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }

        List<Integer> connections = userConnections.get(followerId);
        if(connections == null) {
            connections = new ArrayList<>();
            userConnections.put(followerId, connections);
        }

        if(connections.contains(followeeId)) {
            return;
        }

        connections.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        List<Integer> connections = userConnections.get(followerId);
        connections.remove(new Integer(followeeId));
    }
}

class TweetPair {
    int tweetId;
    int count;

    TweetPair(int t, int c) {
        this.tweetId = t;
        this.count = c;
    }
}

class TweetCompare implements Comparator<TweetPair> {
    public int compare(TweetPair p1, TweetPair p2) {
        if(p1.count == p2.count) {
            return 0;
        } else if(p1.count < p2.count) {
            return 1;
        } else {
            return -1;
        }
    }
}
