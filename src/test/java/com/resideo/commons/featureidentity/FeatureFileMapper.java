package com.resideo.commons.featureidentity;

/**
 * Utility class for mapping feature file names to project folder paths.
 * Provides configuration for the BDD framework's feature file resolution.
 */
public class FeatureFileMapper {

    private static String projectFolderName;

    public static void setProjectFolderName(String folderName) {
        projectFolderName = folderName;
    }

    public static String getProjectFolderName() {
        return projectFolderName;
    }
}
