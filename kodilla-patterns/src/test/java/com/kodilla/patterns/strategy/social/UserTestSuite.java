package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {

        User millenials = new Millenials("Adam");
        User yGeneration = new YGeneration("Ewa");
        User zGeneration = new ZGeneration("Zenek");

        String snapchat = millenials.sharePost();
        String twitter = yGeneration.sharePost();
        String facebook = zGeneration.sharePost();

        Assert.assertEquals("Facebook", facebook);
        Assert.assertEquals("Snapchat", snapchat);
        Assert.assertEquals("Twitter", twitter);
    }

    @Test
    public void testIndividualSharingStrategy() {

        User millenials = new Millenials("Adam");
        millenials.setSocialPublisher(new FacebookPublisher());

        String facebook = millenials.sharePost();

        Assert.assertEquals("Facebook", facebook);
    }
}
