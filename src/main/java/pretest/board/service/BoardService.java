package pretest.board.service;

import java.util.List;

import pretest.board.model.Document;

/**
 * 2015. 12. 28.
 * Copyright by joyhan / HUFS
 * BoardService
 */
public interface BoardService	{
	public int insertDocument(Document document);
	public List<Document> getDocumentList();
	public int deleteDocument(int documentId);
	public Document getDocument(int documentId);
	public int updateDocuemnt(Document document);
}
