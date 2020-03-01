/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_lines_counter.domain;

import java.util.ArrayList;

/**
 *
 * @author Alfonso
 */
public class Extension implements KnownExtensions {
    
    private String name;
    private String extension;
    
    public Extension(String name, String extension) {
        this.setName(name);
        this.setExtension(extension);
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public final void setExtension(String extension) {
        this.extension = extension;
    }
    
    @Override
    public String toString() {
        return this.getExtension().toUpperCase() + " - " + this.getName();
    }
    
    public static ArrayList<Extension>getFoundExtensionsInFiles(
            String[] filePaths
    ) {
        ArrayList<Extension> extensions = new ArrayList<>();
        ArrayList<String> extensionsAdded = new ArrayList<>();
        for(String filePath : filePaths) {
            String theExtension = filePath.substring(
                    filePath.lastIndexOf(".") + 1
            ).toLowerCase();
            for(Extension currExt : KNOWN_CODE_EXTENSIONS) {
                if(currExt.getExtension().toLowerCase().equals(theExtension)) {
                    if(!extensionsAdded.contains(theExtension)) {
                        extensions.add(currExt);
                        extensionsAdded.add(theExtension);
                    }
                }
            }
        }
        return extensions;
    }
    
}
