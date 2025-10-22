import tweepy

# Replace with your Twitter API credentials
API_KEY = 'your_api_key'
API_SECRET = 'your_api_secret'
ACCESS_TOKEN = 'your_access_token'
ACCESS_TOKEN_SECRET = 'your_access_token_secret'

# Authenticate to Twitter
auth = tweepy.OAuth1UserHandler(API_KEY, API_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET)
api = tweepy.API(auth)

# Text and optional image
text = "Hello, world! 🌍 #MyFirstPost"
image_path = "path/to/image.jpg"  # Optional

# Create the post
try:
    # If posting with image
    media = api.media_upload(image_path)
    tweet = api.update_status(status=text, media_ids=[media.media_id])
    
    # If text only
    # tweet = api.update_status(status=text)
    
    print("✅ Post created successfully:", tweet.id)
except Exception as e:
    print("❌ Error creating post:", e)
