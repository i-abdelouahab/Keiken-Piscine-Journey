## Example of how OAuth works with a sign in to LinkedIn using a Google account
![Sign in to LikedIn using your google account](https://blog.waalaxy.com/wp-content/uploads/2021/03/linkedin-sign-in.png "Optional title")

In this example, the actors involved are:

- The user (The resource owner)
- LinkedIn's website (the client)
- Google's authorization server
- Google's API (the resource server)

### The following are the different requests for implementing OAuth in this example:

1. The user clicks on the "Sign in with Google" button on LinkedIn's website.
    * Purpose: Initiate the OAuth flow by redirecting the user to Google's authorization server.
    * Actors involved: The user, LinkedIn's website.
2. LinkedIn's website redirects the user to Google's authorization server with a request to authenticate the user and request authorization to access their Google account data. This is the authorization request.
    * Purpose: Request authentication and authorization from the user.
    * Actors involved: The user, LinkedIn's website, Google's authorization server.
3. Google's authorization server prompts the user to enter their Google credentials and grant permission to LinkedIn to access their Google account data. This is the authorization grant.
    * Purpose: Authenticate the user and obtain their consent to grant access to their data.
    * Actors involved: The user, Google's authorization server.
4. If the user grants permission, Google's authorization server issues an authorization code to LinkedIn's website. This is the authorization code grant.
    * Purpose: Provide a temporary code that can be exchanged for an access token.
    * Actors involved: The user, Google's authorization server, LinkedIn's website.
5. LinkedIn's website exchanges the authorization code for an access token from Google's authorization server. This is the access token grant.
    * Purpose: Obtain an access token that can be used to make requests to the resource server.
    * Actors involved: LinkedIn's website, Google's authorization server.
6. LinkedIn's website can now use the access token to make requests to Google's API on behalf of the user, such as retrieving their Google account information.
    * Purpose: Access protected resources on the resource server.
    * Actors involved: LinkedIn's website, Google's API.