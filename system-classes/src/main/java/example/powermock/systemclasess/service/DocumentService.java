package example.powermock.systemclasess.service;

import example.powermock.systemclasess.model.JsonDocument;

import java.util.UUID;

public class DocumentService {
    
    public JsonDocument saveDocument(JsonDocument document){
        UUID uuid = UUID.randomUUID();
        document.setId(uuid.toString());
        return document;
    }
    
}
