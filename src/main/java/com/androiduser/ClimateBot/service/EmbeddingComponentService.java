package com.androiduser.ClimateBot.service;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentByWordSplitter;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class EmbeddingComponentService {

    @Autowired
    EmbeddingModel embeddingModel;

    @Autowired
    EmbeddingStore embeddingStore;

    public void loadSingleDocument() {
        String currentDir = System.getProperty("user.dir");
        String fileName = "trial.docx";

//        Document document = loadDocument(currentDir + "/" +fileName, new ApachePdfBoxDocumentParser());


        Document document = FileSystemDocumentLoader.loadDocument(currentDir + "/" + fileName, new ApacheTikaDocumentParser());
//        System.out.print(document);


        EmbeddingStoreIngestor embeddingStoreIngestor = EmbeddingStoreIngestor.builder()
                .documentSplitter(new DocumentByWordSplitter(3000, 100))
                .embeddingModel(embeddingModel)
                .embeddingStore(embeddingStore)
                .build();

        embeddingStoreIngestor.ingest(document);
    }
}