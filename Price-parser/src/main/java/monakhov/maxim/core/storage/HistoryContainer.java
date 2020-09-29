package monakhov.maxim.core.storage;


import monakhov.maxim.core.FixedStack;
import monakhov.maxim.core.exceptions.InvalidHistoryDepthException;

import java.nio.file.Path;
import java.util.HashMap;

public class HistoryContainer {

    private int configFilesHistoryDepth;
    private int documentsHistoryDepth;

    private FixedStack<Path> configFilesHistory;
    private FixedStack<Path> documentsHistory;

    //TODO explore the Path class, especially the Path(String) constructor, write documentation, Add methods getLastDocument, getLastConfigFile, addDocument, addConfigFile,
    private static final int configFilesHistoryDepthDefault
            = 10;
    private static final int documentsHistoryDepthDefault
            = 10;
    private static final HashMap<String, String> fieldsDescription
            = new HashMap<>();

    static {
        fieldsDescription.put(
                "configFilesHistoryDepth",
                "configFilesHistoryDepthDefault must be >= 1.");
        fieldsDescription.put(
                "documentsHistoryDepthDefault",
                "documentsHistoryDepthDefault must be >= 1.");
    }


    private boolean isValidConfigFilesHistoryDepth(int historyDepth) {
        return
                historyDepth >= 1;
    }


    private boolean isValidDocumentsHistoryDepth(int historyDepth) {
        return
                historyDepth >= 1;
    }


    public int getConfigFilesHistoryDepth() {
        return configFilesHistoryDepth;
    }


    public void setConfigFilesHistoryDepth(int historyDepth) {

        if ( ! isValidConfigFilesHistoryDepth(historyDepth)) throw new InvalidHistoryDepthException(fieldsDescription.get("configFilesHistoryDepth"));

        this.configFilesHistoryDepth = historyDepth;
    }


    public int getDocumentsHistoryDepth() {
        return documentsHistoryDepth;
    }


    /**
     * Sets the number of documents to keep in history
     *
     * @param documentsHistoryDepth Number of documents to keep in history
     * @throws InvalidHistoryDepthException If configFilesHistoryDepthDefault not >= 1
     */
    public void setDocumentsHistoryDepth(int documentsHistoryDepth) {

        if ( ! isValidDocumentsHistoryDepth(documentsHistoryDepth)) throw new InvalidHistoryDepthException(fieldsDescription.get("documentsHistoryDepthDefault"));

        this.documentsHistoryDepth = documentsHistoryDepth;
    }
}
