package org.springframework.roo.addon.fluentapi;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.springframework.roo.model.JavaType;
import org.springframework.roo.shell.CliCommand;
import org.springframework.roo.shell.CliOption;
import org.springframework.roo.shell.CommandMarker;

/**
 * Commands for the FluentApi add-on to be used by the Roo shell.
 * 
 * @since 1.1
 */
@Component // Use these Apache Felix annotations to register your commands class in the Roo container
@Service
public class FluentApiCommands implements CommandMarker { // All command types must implement the CommandMarker interface
    
    /**
     * Get a reference to the FluentApiOperations from the underlying OSGi container
     */
    @Reference private FluentApiOperations operations;
    
    /**
     * This method registers a command with the Roo shell. It also offers a mandatory command attribute.
     * 
     * @param type 
     */
    @CliCommand(value = "fluentapi add", help = "Add fluent API methods to a class")
    public void add(@CliOption(key = "type", mandatory = true, help = "The java type to apply this annotation to") JavaType target) {
        operations.annotateType(target);
    }
    
    /**
     * This method registers a command with the Roo shell. It has no command attribute.
     * 
     */
    @CliCommand(value = "fluentapi all", help = "Add fluent API methods to all classes")
    public void all() {
        operations.annotateAll();
    }
    
}