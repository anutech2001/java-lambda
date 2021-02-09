package com.example.lambda;

import java.util.List;
import java.util.function.IntFunction;

public class MethodReferenceConstructorExample {

    public static void main(String[] args) {
        DocCreator excelCreator = (type, name, numOfPage) -> new ExcelDoc(type, name);
        DocCreator wordCreator = (type, name, numOfPage) -> new WordDoc(type, name, numOfPage);

        Document excelDoc = excelCreator.create("excel", "MyWorkSheet", 0);
        Document wordDoc = wordCreator.create("word", "Documentory", 10);
        // print excel document detail.
        System.out.printf("Excel Document name=%s", excelDoc.getDocName());
        System.out.printf(", type=%s", excelDoc.getDocType());
        System.out.printf(", numOfSheet=%d%n", excelDoc.getNumOfPage());
        // print word ducument detail.
        System.out.printf("Word Document name=%s", wordDoc.getDocName());
        System.out.printf(", type=%s", wordDoc.getDocType());
        System.out.printf(", numOfPage=%d%n", wordDoc.getNumOfPage());

        // DocCreator excelCreator = ExcelDoc::new;
        // DocCreator wordCreator = WordDoc::new;

        // DocBatchCreator d = (x, y) -> new WordDoc[x];
        WordDocBatchCreator d = WordDoc[]::new;

        WordDoc w[] = d.create(5);
        System.out.println("finished" + w);

        // Uses an array constructor reference
        IntFunction<int[][]> TwoDimArrayCreator = int[][]::new;
        int[][] matrix = TwoDimArrayCreator.apply(5); // Creates an int[5][] array
    }

    @FunctionalInterface
    interface DocCreator {
        Document create(String type, String name, int numOfPage);
    }

    @FunctionalInterface
    interface WordDocBatchCreator {
        WordDoc[] create(int num);
    }
}

// Document and Factory
interface Document {
    String getDocName();

    String getDocType();

    default int getNumOfPage() {
        return 0;
    }
}

class ExcelDoc implements Document {
    String name;
    String type;

    ExcelDoc(String type, String name) {
        this.name = name;
        this.type = type;
    }

    public String getDocName() {
        return name;
    }

    public String getDocType() {
        return type;
    }
}

class WordDoc implements Document {
    String name;
    String type;
    int numOfPage;

    public WordDoc(String type, String name, int numOfPage) {
        this.name = name;
        this.type = type;
        this.numOfPage = numOfPage;
    }

    public String getDocName() {
        return name;
    }

    public String getDocType() {
        return type;
    }

    public int getNumOfPage() {
        return numOfPage;
    }
}
