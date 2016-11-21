/**
 * Copyright (c) 2015, Nico Geisler Softwareentwicklung
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: no conditions.
 */
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The interface for parsing.
 *
 * @author Nico Geisler (geislern85@googlemail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface Parser {
    
    /**
     * Returns the parsed content of a source.
     * 
     * @return The parsed content as String.
     * @throws java.io.FileNotFoundException
     */
    public String parsedContent() 
            throws FileNotFoundException, IOException;
    
    /**
     * Returns the parsed content without unicode of a source.
     * 
     * @return The parsed content as String.
     * @throws java.io.FileNotFoundException
     */
    public String parsedContentWithoutUnicode() 
            throws FileNotFoundException, IOException;
    
    /**
     * Saves the given content in defined source.
     * 
     * @param content The content to save as String 
     * @throws java.io.FileNotFoundException 
     */
    public void save(final String content) 
            throws FileNotFoundException, IOException;
}
