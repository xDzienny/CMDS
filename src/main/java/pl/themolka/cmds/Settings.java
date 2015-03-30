/*
 * Copyright 2015 Aleksander.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.themolka.cmds;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.Validate;
import pl.themolka.cmds.command.Commands;
import pl.themolka.cmds.internal.CmdsCommand;

/**
 *
 * @author Aleksander
 */
public class Settings {
    public static final String VERSION = "1.0";
    private static Map<String, String> messages;
    
    public static String getMessage(String id) {
        Validate.notNull(id, "id can not be null");
        return messages.get(id.toLowerCase());
    }
    
    public static void setMessage(String id, String value) {
        Validate.notNull(id, "id can not be null");
        Validate.notNull(value, "value can not be null");
        messages.put(id.toLowerCase(), value);
    }
    
    public static void setMessages(String id, Map<? extends String, ? extends String> values) {
        Validate.notNull(id, "id can not be null");
        Validate.notNull(values, "values can not be null");
        messages.putAll(values);
    }
    
    public static void setup() {
        if (messages != null) {
            return;
        }
        
        messages = new HashMap<>();
        loadMessages();
        
        Commands.register(CmdsCommand.class);
    }
    
    private static void loadMessages() {
        setMessage("console", "You must be player in-game to perform this command.");
        setMessage("internal-error", "Internal server error: see the console for more information.");
        setMessage("not-implemented", "Not implemented in the command executor yet.");
        setMessage("number", "You must specify a decimal (string given).");
        setMessage("permission", "You don't have permission to perform this command.");
    }
}
