package org.pac4j.oauth.profile.facebook;


import junit.framework.TestCase;
import org.pac4j.core.util.TestsConstants;

/**
 * This class tests the {@link FacebookPage} class.
 *
 * @author Francois-Guillaume Ribreau
 */
public final class TestFacebookPage extends TestCase implements TestsConstants {

    private static final String NAME = "Bringr";
    private static final String CATEGORY = "Internet/software";
    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    private static final Long ID = 123454448371234L;

    private static final String GOOD_JSON = "{\n" +
            "        \"category\": \"" + CATEGORY + "\",\n" +
            "        \"name\": \"" + NAME + "\",\n" +
            "        \"access_token\": \"" + ACCESS_TOKEN + "\",\n" +
            "        \"perms\": [\n" +
            "        \"ADMINISTER\",\n" +
            "        \"EDIT_PROFILE\",\n" +
            "        \"CREATE_CONTENT\",\n" +
            "        \"MODERATE_CONTENT\",\n" +
            "        \"CREATE_ADS\",\n" +
            "        \"BASIC_ADMIN\"\n" +
            "        ],\n" +
            "        \"id\": \""+ID+"\"\n" +
            "        }";

    public void testNull() {
        final FacebookPage facebookPage = new FacebookPage();
        facebookPage.buildFrom(null);
        assertNull(facebookPage.getName());
        assertNull(facebookPage.getAccessToken());
        assertNull(facebookPage.getCategory());
        assertNull(facebookPage.getId());
    }

    public void testBadJson() {
        final FacebookPage facebookPage = new FacebookPage();
        facebookPage.buildFrom(BAD_JSON);
        assertNull(facebookPage.getName());
        assertNull(facebookPage.getAccessToken());
        assertNull(facebookPage.getCategory());
        assertNull(facebookPage.getId());
    }

    public void testGoodJson() {
        final FacebookPage facebookPage = new FacebookPage();
        facebookPage.buildFrom(GOOD_JSON);
        assertEquals(NAME, facebookPage.getName());
        assertEquals(CATEGORY, facebookPage.getCategory());
        assertEquals(ACCESS_TOKEN, facebookPage.getAccessToken());
        assertEquals(ID, facebookPage.getId());
    }
}
