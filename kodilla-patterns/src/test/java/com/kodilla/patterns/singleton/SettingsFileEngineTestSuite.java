package com.kodilla.patterns.singleton;

import org.junit.*;

public class SettingsFileEngineTestSuite {
    private static SettingsFileEngine settingsFileEngine;

    @BeforeClass
    public static void openSettingsFile() {
        settingsFileEngine.getInstance().open("myapp.settings");
    }

    @AfterClass
    public static void closeSettingsFile() {
        settingsFileEngine.getInstance().close();
    }

    @Test
    public void testGetFileName() {

        String fileName = settingsFileEngine.getInstance().getFileName();
        System.out.println("Opened: " + fileName);

        Assert.assertEquals("myapp.settings", fileName);
    }

    @Test
    public void testLoadSettings() {

        boolean result = settingsFileEngine.getInstance().loadSettings();

        Assert.assertTrue(result);
    }

    @Test
    public void testSaveSettings() {

        boolean result = settingsFileEngine.getInstance().saveSettings();

        Assert.assertTrue(result);
    }
}
