/**
 * Copyright (c) 2015, Nico Geisler Softwareentwicklung
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: no conditions.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * An implementation for files of interface {@link Parser}.
 *
 * @author Nico Geisler (geislern85@googlemail.com)
 * @version $Id$
 * @since 0.0.1
 */
public class FileParser implements Parser {
    
    private final File file;

    public FileParser(final File file) {
        this.file = file;
    }

    @Override
    public String parsedContent() 
            throws FileNotFoundException, IOException {
        String output;
        try (final FileInputStream input = new FileInputStream(file)) {
            output = "";
            int data;
            while ((data = input.read()) > 0) {
                output += (char) data;
            }
        }
        return output;
    }

    @Override
    public String parsedContentWithoutUnicode() 
            throws FileNotFoundException, IOException {
        String output;
        try (final FileInputStream input = new FileInputStream(file)) {
            output = "";
            int data;
            while ((data = input.read()) > 0) {
                if (data < 0x80) {
                    output += (char) data;
                }
            }
        }
        return output;
    }

    @Override
    public void save(final String content) throws FileNotFoundException, IOException {
        final FileOutputStream o;
        try {
          o = new FileOutputStream(file);
          for (int i = 0; i < content.length(); i += 1) {
              o.write(content.charAt(i));
          }
          o.close();
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(
                    "An error ocurred while opening the file."
            );
        } catch (IOException ex) {
            throw new IOException(
                    "An error ocurred while writing content to the file."
            , ex);
        }        
    }
}
