package com.kodilla.testing.forum.statistics;

import org.junit.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import static org.mockito.Mockito.*;

public class StatisticsForumTestSuite {

    private Statistics statisticsMock;
    private StatisticsForum statisticsForum;

    @Before
    public void beforeTest() {
        statisticsMock = mock(Statistics.class);
        ArrayList<String>listMock = new ArrayList<>();
        for(int i=0; i<10; i++){
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(40);
        statisticsForum = new StatisticsForum();
    }
    @Test
    public void testCalculateAdvStatisticsWithZeroPosts(){

        when(statisticsMock.postsCount()).thenReturn(0);

        statisticsForum.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, statisticsForum.getPostsQty());
        Assert.assertEquals(0, statisticsForum.getPostsAvgPerUser(), 1);
        Assert.assertEquals(0, statisticsForum.getCommentsAvgPerPost(), 1);
    }
    @Test
    public void testCalculateAdvStatisticsWithThousandPosts(){

        when(statisticsMock.postsCount()).thenReturn(1000);

        statisticsForum.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(1000, statisticsForum.getPostsQty());
        Assert.assertEquals(100, statisticsForum.getPostsAvgPerUser(), 1);
        Assert.assertEquals(0.04, statisticsForum.getCommentsAvgPerPost(), 1);
    }
    @Test
    public void testCalculateAdvStatisticsWithZeroComments(){

        when(statisticsMock.commentsCount()).thenReturn(0);

        statisticsForum.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, statisticsForum.getCommentsQty());
        Assert.assertEquals(0, statisticsForum.getCommentsAvgPerUser(),1);
        Assert.assertEquals(0, statisticsForum.getCommentsAvgPerPost(), 1);
    }
    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts(){

        when(statisticsMock.commentsCount()).thenReturn(2);
        when(statisticsMock.postsCount()).thenReturn(10);

        statisticsForum.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(10, statisticsForum.getPostsQty());
        Assert.assertEquals(2, statisticsForum.getCommentsQty());
        Assert.assertEquals(1, statisticsForum.getPostsAvgPerUser(), 1);
        Assert.assertEquals(0.2, statisticsForum.getCommentsAvgPerUser(), 1);
        Assert.assertEquals(0.2, statisticsForum.getCommentsAvgPerPost(), 1);
    }
    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts(){

        statisticsForum.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(20, statisticsForum.getPostsQty());
        Assert.assertEquals(40, statisticsForum.getCommentsQty());
        Assert.assertEquals(2, statisticsForum.getPostsAvgPerUser(), 1);
        Assert.assertEquals(4, statisticsForum.getCommentsAvgPerUser(), 1);
        Assert.assertEquals(2, statisticsForum.getCommentsAvgPerPost(), 1);
    }
    @Test
    public void testCalculateAdvStatisticsWithZeroUsers(){

        ArrayList<String>listMock = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(listMock);

        statisticsForum.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, statisticsForum.getUsersQty());
        Assert.assertEquals(0, statisticsForum.getPostsAvgPerUser(), 1);
        Assert.assertEquals(0, statisticsForum.getCommentsAvgPerUser(), 1);
    }
    @Test
    public void testCalculateAdvStatisticsWithHundredUsers(){

        ArrayList<String> listMock = new ArrayList<>();
        for(int i=0; i<100; i++){
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);

        statisticsForum.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(100, statisticsForum.getUsersQty());
        Assert.assertEquals(0.2, statisticsForum.getPostsAvgPerUser(), 1);
        Assert.assertEquals(0.4, statisticsForum.getCommentsAvgPerUser(), 1);
    }
}