package com.androiduser.ClimateBot.service;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentByParagraphSplitter;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
public class EmbeddingComponentService {

    private static final Logger LOGGER = Logger.getLogger(EmbeddingComponentService.class.getName());

    @Autowired
    private EmbeddingModel embeddingModel;

    @Autowired
    private EmbeddingStore embeddingStore;

    public void loadDocument() {
        try {

            String documentDir = Paths.get("src", "main", "java", "com", "androiduser", "ClimateBot", "documents").toString();
//            UrlDocumentLoader


            List<Document> documents = FileSystemDocumentLoader.loadDocuments(documentDir, new ApacheTikaDocumentParser());

            if (documents.isEmpty()) {
                LOGGER.warning("No documents found in the specified directory: " + documentDir);
                return;
            }

            LOGGER.info("Loaded " + documents.size() + " document(s) successfully.");


            EmbeddingStoreIngestor embeddingStoreIngestor = EmbeddingStoreIngestor.builder()
                    .documentSplitter(new DocumentByParagraphSplitter(300, 10))
                    .embeddingModel(embeddingModel)
                    .embeddingStore(embeddingStore)
                    .build();


            embeddingStoreIngestor.ingest(documents);
            LOGGER.info("Document embeddings stored successfully.");
        } catch (Exception e) {
            LOGGER.severe("Error loading and processing documents: " + e.getMessage());
        }
    }
}
