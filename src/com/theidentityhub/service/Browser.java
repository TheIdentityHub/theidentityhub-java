/**
 * @author Branislav Bajlovski
 * @date 28.12.2016
 */
package com.theidentityhub.service;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author Branislav Bajlovski
 *
 */
public class Browser extends Stage {

    private final Scene     scene;
    private final WebView   webView;
    private final WebEngine webEngine;
    private String          url;

    public Browser(final String url) {
        this.url = url;
        // Our weiv that display ther page.
        this.webView = new WebView();

        // the engine that manages our pages.
        this.webEngine = this.webView.getEngine();
        this.webEngine.setJavaScriptEnabled(true);
        this.webEngine.load(this.url);

        // our main app layout with 5 regions.
        final BorderPane root = new BorderPane();
        root.setPrefSize(1024, 768);

        root.setCenter(this.webView);

        // Our scene is where all the action in JavaFX happens. A scene holds
        // all Nodes, and its root node is our BorderPane.
        this.scene = new Scene(root);

        // the stage manages the scene.
        this.setTitle("The Identity Hub");
        this.setScene(this.scene);
        this.show();
    }

    public void load(final String url) {
        this.url = url;
        this.webEngine.load(this.url);
    }

    public void reload() {
        this.webEngine.reload();
    }

    /**
     * @return the webEngine
     */
    public WebEngine getWebEngine() {
        return this.webEngine;
    }
}
