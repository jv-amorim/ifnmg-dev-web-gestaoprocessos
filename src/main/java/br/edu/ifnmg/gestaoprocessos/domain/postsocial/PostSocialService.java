package br.edu.ifnmg.gestaoprocessos.domain.postsocial;

import br.edu.ifnmg.gestaoprocessos.domain.post.PostEntity;
import br.edu.ifnmg.gestaoprocessos.domain.postsocial.dtos.RespCreateTweet;
import br.edu.ifnmg.gestaoprocessos.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@Singleton
@Transactional
public class PostSocialService implements PostSocialServiceLocal {

    @Inject
    private PostSocialDaoLocal postSocialDao;

    private String twitterUsername;
    private String twitterConsumerKey;
    private String twitterConsumerSecret;
    private String twitterAccessToken;
    private String twitterAccessSecret;

    @PostConstruct
    public void loadSocialAuth() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext servletContext = (ServletContext) externalContext.getContext();
        twitterUsername = servletContext.getInitParameter("TWITTER_USERNAME");
        twitterConsumerKey = servletContext.getInitParameter("TWITTER_CONSUMER_KEY");
        twitterConsumerSecret = servletContext.getInitParameter("TWITTER_CONSUMER_SECRET");
        twitterAccessToken = servletContext.getInitParameter("TWITTER_ACCESS_TOKEN");
        twitterAccessSecret = servletContext.getInitParameter("TWITTER_ACCESS_SECRET");
    }

    @Override
    public List<PostSocialEntity> publish(PostEntity post) throws Exception {
        try {
            ArrayList<PostSocialEntity> postSocials = new ArrayList<PostSocialEntity>();
            postSocials.add(publishToTwitter(post));
            return postSocials;
        } catch (Exception ex) {
            System.out.println(ex);
            return new ArrayList<PostSocialEntity>();
        }
    }

    private PostSocialEntity publishToTwitter(PostEntity post) throws Exception {
        String url, socialId;

        try {
            socialId = sendRequestToTwitter(post.getTitle());
            url = "https://twitter.com/" + twitterUsername + "/status/" + socialId;
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Exception("Não foi possível realizar a publicação no X.");
        }

        PostSocialEntity postSocial = new PostSocialEntity();
        postSocial.setType(PostSocialPlataform.X_TWITTER);
        postSocial.setUrl(url);
        postSocial.setSocialId(socialId);
        postSocialDao.save(postSocial);

        return postSocial;
    }

    private String sendRequestToTwitter(String text) throws Exception {
        if (text.length() > 280) {
            text = text.substring(0, 279);
        }

        HttpPost request = new HttpPost("https://api.twitter.com/2/tweets");
        request.addHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity("{\"text\":\"" + text + "\"}"));

        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(twitterConsumerKey, twitterConsumerSecret);
        consumer.setTokenWithSecret(twitterAccessToken, twitterAccessSecret);
        consumer.sign(request);

        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        Integer responseCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());

        if (responseCode < 200 || responseCode > 299) {
            throw new Exception(responseBody);
        }

        RespCreateTweet tweet = Utils.fromJson(responseBody, RespCreateTweet.class);
        return tweet.getData().getId();
    }

}
